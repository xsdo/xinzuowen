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
import com.ruoyi.resources.domain.DGoodwords;
import com.ruoyi.resources.service.IDGoodwordsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 部编好词Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/resources/goodwords")
public class DGoodwordsController extends BaseController
{
    @Autowired
    private IDGoodwordsService dGoodwordsService;

    /**
     * 查询部编好词列表
     */
    @PreAuthorize("@ss.hasPermi('resources:goodwords:list')")
    @GetMapping("/list")
    public TableDataInfo list(DGoodwords dGoodwords)
    {
        startPage();
        List<DGoodwords> list = dGoodwordsService.selectDGoodwordsList(dGoodwords);
        return getDataTable(list);
    }

    /**
     * 导出部编好词列表
     */
    @PreAuthorize("@ss.hasPermi('resources:goodwords:export')")
    @Log(title = "部编好词", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DGoodwords dGoodwords)
    {
        List<DGoodwords> list = dGoodwordsService.selectDGoodwordsList(dGoodwords);
        ExcelUtil<DGoodwords> util = new ExcelUtil<DGoodwords>(DGoodwords.class);
        util.exportExcel(response, list, "部编好词数据");
    }

    /**
     * 获取部编好词详细信息
     */
    @PreAuthorize("@ss.hasPermi('resources:goodwords:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(dGoodwordsService.selectDGoodwordsById(id));
    }

    /**
     * 新增部编好词
     */
    @PreAuthorize("@ss.hasPermi('resources:goodwords:add')")
    @Log(title = "部编好词", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DGoodwords dGoodwords)
    {
        return toAjax(dGoodwordsService.insertDGoodwords(dGoodwords));
    }

    /**
     * 修改部编好词
     */
    @PreAuthorize("@ss.hasPermi('resources:goodwords:edit')")
    @Log(title = "部编好词", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DGoodwords dGoodwords)
    {
        return toAjax(dGoodwordsService.updateDGoodwords(dGoodwords));
    }

    /**
     * 删除部编好词
     */
    @PreAuthorize("@ss.hasPermi('resources:goodwords:remove')")
    @Log(title = "部编好词", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dGoodwordsService.deleteDGoodwordsByIds(ids));
    }
}
