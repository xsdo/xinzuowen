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
import com.ruoyi.resources.domain.DGoodsentence;
import com.ruoyi.resources.service.IDGoodsentenceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 部编好句Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/resources/goodsentence")
public class DGoodsentenceController extends BaseController
{
    @Autowired
    private IDGoodsentenceService dGoodsentenceService;

    /**
     * 查询部编好句列表
     */
    @PreAuthorize("@ss.hasPermi('resources:goodsentence:list')")
    @GetMapping("/list")
    public TableDataInfo list(DGoodsentence dGoodsentence)
    {
        startPage();
        List<DGoodsentence> list = dGoodsentenceService.selectDGoodsentenceList(dGoodsentence);
        return getDataTable(list);
    }

    /**
     * 导出部编好句列表
     */
    @PreAuthorize("@ss.hasPermi('resources:goodsentence:export')")
    @Log(title = "部编好句", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DGoodsentence dGoodsentence)
    {
        List<DGoodsentence> list = dGoodsentenceService.selectDGoodsentenceList(dGoodsentence);
        ExcelUtil<DGoodsentence> util = new ExcelUtil<DGoodsentence>(DGoodsentence.class);
        util.exportExcel(response, list, "部编好句数据");
    }

    /**
     * 获取部编好句详细信息
     */
    @PreAuthorize("@ss.hasPermi('resources:goodsentence:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(dGoodsentenceService.selectDGoodsentenceById(id));
    }

    /**
     * 新增部编好句
     */
    @PreAuthorize("@ss.hasPermi('resources:goodsentence:add')")
    @Log(title = "部编好句", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DGoodsentence dGoodsentence)
    {
        return toAjax(dGoodsentenceService.insertDGoodsentence(dGoodsentence));
    }

    /**
     * 修改部编好句
     */
    @PreAuthorize("@ss.hasPermi('resources:goodsentence:edit')")
    @Log(title = "部编好句", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DGoodsentence dGoodsentence)
    {
        return toAjax(dGoodsentenceService.updateDGoodsentence(dGoodsentence));
    }

    /**
     * 删除部编好句
     */
    @PreAuthorize("@ss.hasPermi('resources:goodsentence:remove')")
    @Log(title = "部编好句", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dGoodsentenceService.deleteDGoodsentenceByIds(ids));
    }
}
