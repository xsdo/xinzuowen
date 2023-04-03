package com.ruoyi.web.controller.tasks;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.tasks.domain.ReadTask;
import com.ruoyi.tasks.service.IReadTaskService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 阅读任务Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/tasks/readtask")
public class ReadTaskController extends BaseController
{
    @Autowired
    private IReadTaskService readTaskService;

    /**
     * 查询阅读任务列表
     */
    @PreAuthorize("@ss.hasPermi('tasks:readtask:list')")
    @GetMapping("/list")
    public TableDataInfo list(ReadTask readTask)
    {
        startPage();
        List<ReadTask> list = readTaskService.selectReadTaskList(readTask);
        return getDataTable(list);
    }

    /**
     * 导出阅读任务列表
     */
    @PreAuthorize("@ss.hasPermi('tasks:readtask:export')")
    @Log(title = "阅读任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReadTask readTask)
    {
        List<ReadTask> list = readTaskService.selectReadTaskList(readTask);
        ExcelUtil<ReadTask> util = new ExcelUtil<ReadTask>(ReadTask.class);
        util.exportExcel(response, list, "阅读任务数据");
    }

    /**
     * 获取阅读任务详细信息
     */
    @PreAuthorize("@ss.hasPermi('tasks:readtask:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(readTaskService.selectReadTaskById(id));
    }

    /**
     * 新增阅读任务
     */
    @PreAuthorize("@ss.hasPermi('tasks:readtask:add')")
    @Log(title = "阅读任务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReadTask readTask)
    {
        return toAjax(readTaskService.insertReadTask(readTask));
    }

    /**
     * 修改阅读任务
     */
    @PreAuthorize("@ss.hasPermi('tasks:readtask:edit')")
    @Log(title = "阅读任务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReadTask readTask)
    {
        return toAjax(readTaskService.updateReadTask(readTask));
    }

    /**
     * 删除阅读任务
     */
    @PreAuthorize("@ss.hasPermi('tasks:readtask:remove')")
    @Log(title = "阅读任务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(readTaskService.deleteReadTaskByIds(ids));
    }
}
