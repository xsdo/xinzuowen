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
import com.ruoyi.resources.domain.CNation;
import com.ruoyi.resources.service.ICNationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 全国作文Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/resources/nation")
public class CNationController extends BaseController
{
    @Autowired
    private ICNationService cNationService;

    /**
     * 查询全国作文列表
     */
    @PreAuthorize("@ss.hasPermi('resources:nation:list')")
    @GetMapping("/list")
    public TableDataInfo list(CNation cNation)
    {
        startPage();
        List<CNation> list = cNationService.selectCNationList(cNation);
        return getDataTable(list);
    }

    /**
     * 导出全国作文列表
     */
    @PreAuthorize("@ss.hasPermi('resources:nation:export')")
    @Log(title = "全国作文", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CNation cNation)
    {
        List<CNation> list = cNationService.selectCNationList(cNation);
        ExcelUtil<CNation> util = new ExcelUtil<CNation>(CNation.class);
        util.exportExcel(response, list, "全国作文数据");
    }

    /**
     * 获取全国作文详细信息
     */
    @PreAuthorize("@ss.hasPermi('resources:nation:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cNationService.selectCNationById(id));
    }

    /**
     * 新增全国作文
     */
    @PreAuthorize("@ss.hasPermi('resources:nation:add')")
    @Log(title = "全国作文", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CNation cNation)
    {
        return toAjax(cNationService.insertCNation(cNation));
    }

    /**
     * 修改全国作文
     */
    @PreAuthorize("@ss.hasPermi('resources:nation:edit')")
    @Log(title = "全国作文", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CNation cNation)
    {
        return toAjax(cNationService.updateCNation(cNation));
    }

    /**
     * 删除全国作文
     */
    @PreAuthorize("@ss.hasPermi('resources:nation:remove')")
    @Log(title = "全国作文", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cNationService.deleteCNationByIds(ids));
    }
}
