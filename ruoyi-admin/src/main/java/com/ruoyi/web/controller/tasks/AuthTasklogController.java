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
import com.ruoyi.tasks.domain.AuthTasklog;
import com.ruoyi.tasks.service.IAuthTasklogService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 认证用户记录Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/tasks/authtasklog")
public class AuthTasklogController extends BaseController
{
    @Autowired
    private IAuthTasklogService authTasklogService;

    /**
     * 查询认证用户记录列表
     */
    @PreAuthorize("@ss.hasPermi('tasks:authtasklog:list')")
    @GetMapping("/list")
    public TableDataInfo list(AuthTasklog authTasklog)
    {
        startPage();
        List<AuthTasklog> list = authTasklogService.selectAuthTasklogList(authTasklog);
        return getDataTable(list);
    }

    /**
     * 导出认证用户记录列表
     */
    @PreAuthorize("@ss.hasPermi('tasks:authtasklog:export')")
    @Log(title = "认证用户记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AuthTasklog authTasklog)
    {
        List<AuthTasklog> list = authTasklogService.selectAuthTasklogList(authTasklog);
        ExcelUtil<AuthTasklog> util = new ExcelUtil<AuthTasklog>(AuthTasklog.class);
        util.exportExcel(response, list, "认证用户记录数据");
    }

    /**
     * 获取认证用户记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('tasks:authtasklog:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(authTasklogService.selectAuthTasklogById(id));
    }

    /**
     * 新增认证用户记录
     */
    @PreAuthorize("@ss.hasPermi('tasks:authtasklog:add')")
    @Log(title = "认证用户记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AuthTasklog authTasklog)
    {
        return toAjax(authTasklogService.insertAuthTasklog(authTasklog));
    }

    /**
     * 修改认证用户记录
     */
    @PreAuthorize("@ss.hasPermi('tasks:authtasklog:edit')")
    @Log(title = "认证用户记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AuthTasklog authTasklog)
    {
        return toAjax(authTasklogService.updateAuthTasklog(authTasklog));
    }

    /**
     * 删除认证用户记录
     */
    @PreAuthorize("@ss.hasPermi('tasks:authtasklog:remove')")
    @Log(title = "认证用户记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(authTasklogService.deleteAuthTasklogByIds(ids));
    }
}
