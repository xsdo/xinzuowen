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
import com.ruoyi.resources.domain.Composition;
import com.ruoyi.resources.service.ICompositionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 作文Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/resources/composition")
public class CompositionController extends BaseController
{
    @Autowired
    private ICompositionService compositionService;

    /**
     * 查询作文列表
     */
    @PreAuthorize("@ss.hasPermi('resources:composition:list')")
    @GetMapping("/list")
    public TableDataInfo list(Composition composition)
    {
        startPage();
        List<Composition> list = compositionService.selectCompositionList(composition);
        return getDataTable(list);
    }

    /**
     * 导出作文列表
     */
    @PreAuthorize("@ss.hasPermi('resources:composition:export')")
    @Log(title = "作文", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Composition composition)
    {
        List<Composition> list = compositionService.selectCompositionList(composition);
        ExcelUtil<Composition> util = new ExcelUtil<Composition>(Composition.class);
        util.exportExcel(response, list, "作文数据");
    }

    /**
     * 获取作文详细信息
     */
    @PreAuthorize("@ss.hasPermi('resources:composition:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(compositionService.selectCompositionById(id));
    }

    /**
     * 新增作文
     */
    @PreAuthorize("@ss.hasPermi('resources:composition:add')")
    @Log(title = "作文", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Composition composition)
    {
        return toAjax(compositionService.insertComposition(composition));
    }

    /**
     * 修改作文
     */
    @PreAuthorize("@ss.hasPermi('resources:composition:edit')")
    @Log(title = "作文", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Composition composition)
    {
        return toAjax(compositionService.updateComposition(composition));
    }

    /**
     * 删除作文
     */
    @PreAuthorize("@ss.hasPermi('resources:composition:remove')")
    @Log(title = "作文", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(compositionService.deleteCompositionByIds(ids));
    }
}
