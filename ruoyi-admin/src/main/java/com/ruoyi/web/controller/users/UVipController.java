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
import com.ruoyi.users.domain.UVip;
import com.ruoyi.users.service.IUVipService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户会员Controller
 * 
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/users/vip")
public class UVipController extends BaseController
{
    @Autowired
    private IUVipService uVipService;

    /**
     * 查询用户会员列表
     */
    @PreAuthorize("@ss.hasPermi('users:vip:list')")
    @GetMapping("/list")
    public TableDataInfo list(UVip uVip)
    {
        startPage();
        List<UVip> list = uVipService.selectUVipList(uVip);
        return getDataTable(list);
    }

    /**
     * 导出用户会员列表
     */
    @PreAuthorize("@ss.hasPermi('users:vip:export')")
    @Log(title = "用户会员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UVip uVip)
    {
        List<UVip> list = uVipService.selectUVipList(uVip);
        ExcelUtil<UVip> util = new ExcelUtil<UVip>(UVip.class);
        util.exportExcel(response, list, "用户会员数据");
    }

    /**
     * 获取用户会员详细信息
     */
    @PreAuthorize("@ss.hasPermi('users:vip:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(uVipService.selectUVipById(id));
    }

    /**
     * 新增用户会员
     */
    @PreAuthorize("@ss.hasPermi('users:vip:add')")
    @Log(title = "用户会员", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UVip uVip)
    {
        return toAjax(uVipService.insertUVip(uVip));
    }

    /**
     * 修改用户会员
     */
    @PreAuthorize("@ss.hasPermi('users:vip:edit')")
    @Log(title = "用户会员", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UVip uVip)
    {
        return toAjax(uVipService.updateUVip(uVip));
    }

    /**
     * 删除用户会员
     */
    @PreAuthorize("@ss.hasPermi('users:vip:remove')")
    @Log(title = "用户会员", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(uVipService.deleteUVipByIds(ids));
    }
}
