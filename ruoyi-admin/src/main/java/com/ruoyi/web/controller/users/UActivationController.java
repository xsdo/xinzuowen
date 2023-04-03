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
import com.ruoyi.users.domain.UActivation;
import com.ruoyi.users.service.IUActivationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 激活码Controller
 * 
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/users/activation")
public class UActivationController extends BaseController
{
    @Autowired
    private IUActivationService uActivationService;

    /**
     * 查询激活码列表
     */
    @PreAuthorize("@ss.hasPermi('users:activation:list')")
    @GetMapping("/list")
    public TableDataInfo list(UActivation uActivation)
    {
        startPage();
        List<UActivation> list = uActivationService.selectUActivationList(uActivation);
        return getDataTable(list);
    }

    /**
     * 导出激活码列表
     */
    @PreAuthorize("@ss.hasPermi('users:activation:export')")
    @Log(title = "激活码", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UActivation uActivation)
    {
        List<UActivation> list = uActivationService.selectUActivationList(uActivation);
        ExcelUtil<UActivation> util = new ExcelUtil<UActivation>(UActivation.class);
        util.exportExcel(response, list, "激活码数据");
    }

    /**
     * 获取激活码详细信息
     */
    @PreAuthorize("@ss.hasPermi('users:activation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(uActivationService.selectUActivationById(id));
    }

    /**
     * 新增激活码
     */
    @PreAuthorize("@ss.hasPermi('users:activation:add')")
    @Log(title = "激活码", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UActivation uActivation)
    {
        return toAjax(uActivationService.insertUActivation(uActivation));
    }

    /**
     * 修改激活码
     */
    @PreAuthorize("@ss.hasPermi('users:activation:edit')")
    @Log(title = "激活码", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UActivation uActivation)
    {
        return toAjax(uActivationService.updateUActivation(uActivation));
    }

    /**
     * 删除激活码
     */
    @PreAuthorize("@ss.hasPermi('users:activation:remove')")
    @Log(title = "激活码", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(uActivationService.deleteUActivationByIds(ids));
    }
}
