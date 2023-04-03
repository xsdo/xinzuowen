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
import com.ruoyi.tasks.domain.AuthTask;
import com.ruoyi.tasks.service.IAuthTaskService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 认证任务Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/tasks/authtask")
public class AuthTaskController extends BaseController
{
    @Autowired
    private IAuthTaskService authTaskService;

    /**
     * 查询认证任务列表
     */
    @PreAuthorize("@ss.hasPermi('tasks:authtask:list')")
    @GetMapping("/list")
    public TableDataInfo list(AuthTask authTask)
    {
        startPage();
        List<AuthTask> list = authTaskService.selectAuthTaskList(authTask);
        return getDataTable(list);
    }

    /**
     * 导出认证任务列表
     */
    @PreAuthorize("@ss.hasPermi('tasks:authtask:export')")
    @Log(title = "认证任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AuthTask authTask)
    {
        List<AuthTask> list = authTaskService.selectAuthTaskList(authTask);
        ExcelUtil<AuthTask> util = new ExcelUtil<AuthTask>(AuthTask.class);
        util.exportExcel(response, list, "认证任务数据");
    }

    /**
     * 获取认证任务详细信息
     */
    @PreAuthorize("@ss.hasPermi('tasks:authtask:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(authTaskService.selectAuthTaskById(id));
    }

    /**
     * 新增认证任务
     */
    @PreAuthorize("@ss.hasPermi('tasks:authtask:add')")
    @Log(title = "认证任务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AuthTask authTask)
    {
        return toAjax(authTaskService.insertAuthTask(authTask));
    }

    /**
     * 修改认证任务
     */
    @PreAuthorize("@ss.hasPermi('tasks:authtask:edit')")
    @Log(title = "认证任务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AuthTask authTask)
    {
        return toAjax(authTaskService.updateAuthTask(authTask));
    }

    /**
     * 删除认证任务
     */
    @PreAuthorize("@ss.hasPermi('tasks:authtask:remove')")
    @Log(title = "认证任务", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(authTaskService.deleteAuthTaskByIds(ids));
    }
}
