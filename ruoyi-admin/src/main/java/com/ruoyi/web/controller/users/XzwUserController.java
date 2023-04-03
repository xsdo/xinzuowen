package com.ruoyi.users.controller;

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
import com.ruoyi.users.domain.XzwUser;
import com.ruoyi.users.service.IXzwUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户Controller
 * 
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/users/user")
public class XzwUserController extends BaseController
{
    @Autowired
    private IXzwUserService xzwUserService;

    /**
     * 查询用户列表
     */
    @PreAuthorize("@ss.hasPermi('users:user:list')")
    @GetMapping("/list")
    public TableDataInfo list(XzwUser xzwUser)
    {
        startPage();
        List<XzwUser> list = xzwUserService.selectXzwUserList(xzwUser);
        return getDataTable(list);
    }

    /**
     * 导出用户列表
     */
    @PreAuthorize("@ss.hasPermi('users:user:export')")
    @Log(title = "用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, XzwUser xzwUser)
    {
        List<XzwUser> list = xzwUserService.selectXzwUserList(xzwUser);
        ExcelUtil<XzwUser> util = new ExcelUtil<XzwUser>(XzwUser.class);
        util.exportExcel(response, list, "用户数据");
    }

    /**
     * 获取用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('users:user:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(xzwUserService.selectXzwUserById(id));
    }

    /**
     * 新增用户
     */
    @PreAuthorize("@ss.hasPermi('users:user:add')")
    @Log(title = "用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody XzwUser xzwUser)
    {
        return toAjax(xzwUserService.insertXzwUser(xzwUser));
    }

    /**
     * 修改用户
     */
    @PreAuthorize("@ss.hasPermi('users:user:edit')")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody XzwUser xzwUser)
    {
        return toAjax(xzwUserService.updateXzwUser(xzwUser));
    }

    /**
     * 删除用户
     */
    @PreAuthorize("@ss.hasPermi('users:user:remove')")
    @Log(title = "用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(xzwUserService.deleteXzwUserByIds(ids));
    }
}
