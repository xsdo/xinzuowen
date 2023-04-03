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
import com.ruoyi.users.domain.UAttribute;
import com.ruoyi.users.service.IUAttributeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户属性Controller
 * 
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/users/attribute")
public class UAttributeController extends BaseController
{
    @Autowired
    private IUAttributeService uAttributeService;

    /**
     * 查询用户属性列表
     */
    @PreAuthorize("@ss.hasPermi('users:attribute:list')")
    @GetMapping("/list")
    public TableDataInfo list(UAttribute uAttribute)
    {
        startPage();
        List<UAttribute> list = uAttributeService.selectUAttributeList(uAttribute);
        return getDataTable(list);
    }

    /**
     * 导出用户属性列表
     */
    @PreAuthorize("@ss.hasPermi('users:attribute:export')")
    @Log(title = "用户属性", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UAttribute uAttribute)
    {
        List<UAttribute> list = uAttributeService.selectUAttributeList(uAttribute);
        ExcelUtil<UAttribute> util = new ExcelUtil<UAttribute>(UAttribute.class);
        util.exportExcel(response, list, "用户属性数据");
    }

    /**
     * 获取用户属性详细信息
     */
    @PreAuthorize("@ss.hasPermi('users:attribute:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(uAttributeService.selectUAttributeById(id));
    }

    /**
     * 新增用户属性
     */
    @PreAuthorize("@ss.hasPermi('users:attribute:add')")
    @Log(title = "用户属性", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UAttribute uAttribute)
    {
        return toAjax(uAttributeService.insertUAttribute(uAttribute));
    }

    /**
     * 修改用户属性
     */
    @PreAuthorize("@ss.hasPermi('users:attribute:edit')")
    @Log(title = "用户属性", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UAttribute uAttribute)
    {
        return toAjax(uAttributeService.updateUAttribute(uAttribute));
    }

    /**
     * 删除用户属性
     */
    @PreAuthorize("@ss.hasPermi('users:attribute:remove')")
    @Log(title = "用户属性", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(uAttributeService.deleteUAttributeByIds(ids));
    }
}
