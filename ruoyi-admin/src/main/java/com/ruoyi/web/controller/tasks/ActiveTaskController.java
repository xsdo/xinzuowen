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
import com.ruoyi.tasks.domain.ActiveTask;
import com.ruoyi.tasks.service.IActiveTaskService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 活动任务Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/tasks/activetask")
public class ActiveTaskController extends BaseController
{
    @Autowired
    private IActiveTaskService activeTaskService;

    /**
     * 查询活动任务列表
     */
    @PreAuthorize("@ss.hasPermi('tasks:activetask:list')")
    @GetMapping("/list")
    public TableDataInfo list(ActiveTask activeTask)
    {
        startPage();
        List<ActiveTask> list = activeTaskService.selectActiveTaskList(activeTask);
        return getDataTable(list);
    }

    /**
     * 导出活动任务列表
     */
    @PreAuthorize("@ss.hasPermi('tasks:activetask:export')")
    @Log(title = "活动任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ActiveTask activeTask)
    {
        List<ActiveTask> list = activeTaskService.selectActiveTaskList(activeTask);
        ExcelUtil<ActiveTask> util = new ExcelUtil<ActiveTask>(ActiveTask.class);
        util.exportExcel(response, list, "活动任务数据");
    }

    /**
     * 获取活动任务详细信息
     */
    @PreAuthorize("@ss.hasPermi('tasks:activetask:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(activeTaskService.selectActiveTaskById(id));
    }

    /**
     * 新增活动任务
     */
    @PreAuthorize("@ss.hasPermi('tasks:activetask:add')")
    @Log(title = "活动任务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ActiveTask activeTask)
    {
        return toAjax(activeTaskService.insertActiveTask(activeTask));
    }

    /**
     * 修改活动任务
     */
    @PreAuthorize("@ss.hasPermi('tasks:activetask:edit')")
    @Log(title = "活动任务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ActiveTask activeTask)
    {
        return toAjax(activeTaskService.updateActiveTask(activeTask));
    }

    /**
     * 删除活动任务
     */
    @PreAuthorize("@ss.hasPermi('tasks:activetask:remove')")
    @Log(title = "活动任务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(activeTaskService.deleteActiveTaskByIds(ids));
    }
}
