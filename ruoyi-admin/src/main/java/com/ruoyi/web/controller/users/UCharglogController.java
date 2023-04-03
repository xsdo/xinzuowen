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
import com.ruoyi.users.domain.UCharglog;
import com.ruoyi.users.service.IUCharglogService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 充值记录Controller
 * 
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/users/charglog")
public class UCharglogController extends BaseController
{
    @Autowired
    private IUCharglogService uCharglogService;

    /**
     * 查询充值记录列表
     */
    @PreAuthorize("@ss.hasPermi('users:charglog:list')")
    @GetMapping("/list")
    public TableDataInfo list(UCharglog uCharglog)
    {
        startPage();
        List<UCharglog> list = uCharglogService.selectUCharglogList(uCharglog);
        return getDataTable(list);
    }

    /**
     * 导出充值记录列表
     */
    @PreAuthorize("@ss.hasPermi('users:charglog:export')")
    @Log(title = "充值记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UCharglog uCharglog)
    {
        List<UCharglog> list = uCharglogService.selectUCharglogList(uCharglog);
        ExcelUtil<UCharglog> util = new ExcelUtil<UCharglog>(UCharglog.class);
        util.exportExcel(response, list, "充值记录数据");
    }

    /**
     * 获取充值记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('users:charglog:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(uCharglogService.selectUCharglogById(id));
    }

    /**
     * 新增充值记录
     */
    @PreAuthorize("@ss.hasPermi('users:charglog:add')")
    @Log(title = "充值记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UCharglog uCharglog)
    {
        return toAjax(uCharglogService.insertUCharglog(uCharglog));
    }

    /**
     * 修改充值记录
     */
    @PreAuthorize("@ss.hasPermi('users:charglog:edit')")
    @Log(title = "充值记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UCharglog uCharglog)
    {
        return toAjax(uCharglogService.updateUCharglog(uCharglog));
    }

    /**
     * 删除充值记录
     */
    @PreAuthorize("@ss.hasPermi('users:charglog:remove')")
    @Log(title = "充值记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(uCharglogService.deleteUCharglogByIds(ids));
    }
}
