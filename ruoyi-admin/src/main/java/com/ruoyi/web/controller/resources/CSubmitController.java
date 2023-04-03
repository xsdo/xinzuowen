package com.ruoyi.web.controller.resources;

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
import com.ruoyi.resources.domain.CSubmit;
import com.ruoyi.resources.service.ICSubmitService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 投稿Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/resources/submit")
public class CSubmitController extends BaseController
{
    @Autowired
    private ICSubmitService cSubmitService;

    /**
     * 查询投稿列表
     */
    @PreAuthorize("@ss.hasPermi('resources:submit:list')")
    @GetMapping("/list")
    public TableDataInfo list(CSubmit cSubmit)
    {
        startPage();
        List<CSubmit> list = cSubmitService.selectCSubmitList(cSubmit);
        return getDataTable(list);
    }

    /**
     * 导出投稿列表
     */
    @PreAuthorize("@ss.hasPermi('resources:submit:export')")
    @Log(title = "投稿", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CSubmit cSubmit)
    {
        List<CSubmit> list = cSubmitService.selectCSubmitList(cSubmit);
        ExcelUtil<CSubmit> util = new ExcelUtil<CSubmit>(CSubmit.class);
        util.exportExcel(response, list, "投稿数据");
    }

    /**
     * 获取投稿详细信息
     */
    @PreAuthorize("@ss.hasPermi('resources:submit:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cSubmitService.selectCSubmitById(id));
    }

    /**
     * 新增投稿
     */
    @PreAuthorize("@ss.hasPermi('resources:submit:add')")
    @Log(title = "投稿", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CSubmit cSubmit)
    {
        return toAjax(cSubmitService.insertCSubmit(cSubmit));
    }

    /**
     * 修改投稿
     */
    @PreAuthorize("@ss.hasPermi('resources:submit:edit')")
    @Log(title = "投稿", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CSubmit cSubmit)
    {
        return toAjax(cSubmitService.updateCSubmit(cSubmit));
    }

    /**
     * 删除投稿
     */
    @PreAuthorize("@ss.hasPermi('resources:submit:remove')")
    @Log(title = "投稿", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cSubmitService.deleteCSubmitByIds(ids));
    }
}
