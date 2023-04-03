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
import com.ruoyi.users.domain.UBinding;
import com.ruoyi.users.service.IUBindingService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 绑定班级Controller
 * 
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/users/binding")
public class UBindingController extends BaseController
{
    @Autowired
    private IUBindingService uBindingService;

    /**
     * 查询绑定班级列表
     */
    @PreAuthorize("@ss.hasPermi('users:binding:list')")
    @GetMapping("/list")
    public TableDataInfo list(UBinding uBinding)
    {
        startPage();
        List<UBinding> list = uBindingService.selectUBindingList(uBinding);
        return getDataTable(list);
    }

    /**
     * 导出绑定班级列表
     */
    @PreAuthorize("@ss.hasPermi('users:binding:export')")
    @Log(title = "绑定班级", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UBinding uBinding)
    {
        List<UBinding> list = uBindingService.selectUBindingList(uBinding);
        ExcelUtil<UBinding> util = new ExcelUtil<UBinding>(UBinding.class);
        util.exportExcel(response, list, "绑定班级数据");
    }

    /**
     * 获取绑定班级详细信息
     */
    @PreAuthorize("@ss.hasPermi('users:binding:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(uBindingService.selectUBindingById(id));
    }

    /**
     * 新增绑定班级
     */
    @PreAuthorize("@ss.hasPermi('users:binding:add')")
    @Log(title = "绑定班级", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UBinding uBinding)
    {
        return toAjax(uBindingService.insertUBinding(uBinding));
    }

    /**
     * 修改绑定班级
     */
    @PreAuthorize("@ss.hasPermi('users:binding:edit')")
    @Log(title = "绑定班级", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UBinding uBinding)
    {
        return toAjax(uBindingService.updateUBinding(uBinding));
    }

    /**
     * 删除绑定班级
     */
    @PreAuthorize("@ss.hasPermi('users:binding:remove')")
    @Log(title = "绑定班级", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(uBindingService.deleteUBindingByIds(ids));
    }
}
