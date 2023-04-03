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
import com.ruoyi.resources.domain.CRecitation;
import com.ruoyi.resources.service.ICRecitationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 朗读者Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/resources/recitation")
public class CRecitationController extends BaseController
{
    @Autowired
    private ICRecitationService cRecitationService;

    /**
     * 查询朗读者列表
     */
    @PreAuthorize("@ss.hasPermi('resources:recitation:list')")
    @GetMapping("/list")
    public TableDataInfo list(CRecitation cRecitation)
    {
        startPage();
        List<CRecitation> list = cRecitationService.selectCRecitationList(cRecitation);
        return getDataTable(list);
    }

    /**
     * 导出朗读者列表
     */
    @PreAuthorize("@ss.hasPermi('resources:recitation:export')")
    @Log(title = "朗读者", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CRecitation cRecitation)
    {
        List<CRecitation> list = cRecitationService.selectCRecitationList(cRecitation);
        ExcelUtil<CRecitation> util = new ExcelUtil<CRecitation>(CRecitation.class);
        util.exportExcel(response, list, "朗读者数据");
    }

    /**
     * 获取朗读者详细信息
     */
    @PreAuthorize("@ss.hasPermi('resources:recitation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cRecitationService.selectCRecitationById(id));
    }

    /**
     * 新增朗读者
     */
    @PreAuthorize("@ss.hasPermi('resources:recitation:add')")
    @Log(title = "朗读者", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CRecitation cRecitation)
    {
        return toAjax(cRecitationService.insertCRecitation(cRecitation));
    }

    /**
     * 修改朗读者
     */
    @PreAuthorize("@ss.hasPermi('resources:recitation:edit')")
    @Log(title = "朗读者", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CRecitation cRecitation)
    {
        return toAjax(cRecitationService.updateCRecitation(cRecitation));
    }

    /**
     * 删除朗读者
     */
    @PreAuthorize("@ss.hasPermi('resources:recitation:remove')")
    @Log(title = "朗读者", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cRecitationService.deleteCRecitationByIds(ids));
    }
}
