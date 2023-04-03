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
import com.ruoyi.users.domain.USigndetail;
import com.ruoyi.users.service.IUSigndetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 签到明细Controller
 * 
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/users/signdetail")
public class USigndetailController extends BaseController
{
    @Autowired
    private IUSigndetailService uSigndetailService;

    /**
     * 查询签到明细列表
     */
    @PreAuthorize("@ss.hasPermi('users:signdetail:list')")
    @GetMapping("/list")
    public TableDataInfo list(USigndetail uSigndetail)
    {
        startPage();
        List<USigndetail> list = uSigndetailService.selectUSigndetailList(uSigndetail);
        return getDataTable(list);
    }

    /**
     * 导出签到明细列表
     */
    @PreAuthorize("@ss.hasPermi('users:signdetail:export')")
    @Log(title = "签到明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, USigndetail uSigndetail)
    {
        List<USigndetail> list = uSigndetailService.selectUSigndetailList(uSigndetail);
        ExcelUtil<USigndetail> util = new ExcelUtil<USigndetail>(USigndetail.class);
        util.exportExcel(response, list, "签到明细数据");
    }

    /**
     * 获取签到明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('users:signdetail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(uSigndetailService.selectUSigndetailById(id));
    }

    /**
     * 新增签到明细
     */
    @PreAuthorize("@ss.hasPermi('users:signdetail:add')")
    @Log(title = "签到明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody USigndetail uSigndetail)
    {
        return toAjax(uSigndetailService.insertUSigndetail(uSigndetail));
    }

    /**
     * 修改签到明细
     */
    @PreAuthorize("@ss.hasPermi('users:signdetail:edit')")
    @Log(title = "签到明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody USigndetail uSigndetail)
    {
        return toAjax(uSigndetailService.updateUSigndetail(uSigndetail));
    }

    /**
     * 删除签到明细
     */
    @PreAuthorize("@ss.hasPermi('users:signdetail:remove')")
    @Log(title = "签到明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(uSigndetailService.deleteUSigndetailByIds(ids));
    }
}
