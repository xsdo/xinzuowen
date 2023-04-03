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
import com.ruoyi.tasks.domain.RotationTask;
import com.ruoyi.tasks.service.IRotationTaskService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 轮播图Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/tasks/rotationtask")
public class RotationTaskController extends BaseController
{
    @Autowired
    private IRotationTaskService rotationTaskService;

    /**
     * 查询轮播图列表
     */
    @PreAuthorize("@ss.hasPermi('tasks:rotationtask:list')")
    @GetMapping("/list")
    public TableDataInfo list(RotationTask rotationTask)
    {
        startPage();
        List<RotationTask> list = rotationTaskService.selectRotationTaskList(rotationTask);
        return getDataTable(list);
    }

    /**
     * 导出轮播图列表
     */
    @PreAuthorize("@ss.hasPermi('tasks:rotationtask:export')")
    @Log(title = "轮播图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RotationTask rotationTask)
    {
        List<RotationTask> list = rotationTaskService.selectRotationTaskList(rotationTask);
        ExcelUtil<RotationTask> util = new ExcelUtil<RotationTask>(RotationTask.class);
        util.exportExcel(response, list, "轮播图数据");
    }

    /**
     * 获取轮播图详细信息
     */
    @PreAuthorize("@ss.hasPermi('tasks:rotationtask:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rotationTaskService.selectRotationTaskById(id));
    }

    /**
     * 新增轮播图
     */
    @PreAuthorize("@ss.hasPermi('tasks:rotationtask:add')")
    @Log(title = "轮播图", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RotationTask rotationTask)
    {
        return toAjax(rotationTaskService.insertRotationTask(rotationTask));
    }

    /**
     * 修改轮播图
     */
    @PreAuthorize("@ss.hasPermi('tasks:rotationtask:edit')")
    @Log(title = "轮播图", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RotationTask rotationTask)
    {
        return toAjax(rotationTaskService.updateRotationTask(rotationTask));
    }

    /**
     * 删除轮播图
     */
    @PreAuthorize("@ss.hasPermi('tasks:rotationtask:remove')")
    @Log(title = "轮播图", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(rotationTaskService.deleteRotationTaskByIds(ids));
    }
}
