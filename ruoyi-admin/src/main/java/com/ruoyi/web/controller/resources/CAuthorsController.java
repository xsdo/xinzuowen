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
import com.ruoyi.resources.domain.CAuthors;
import com.ruoyi.resources.service.ICAuthorsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 作者Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/resources/authors")
public class CAuthorsController extends BaseController
{
    @Autowired
    private ICAuthorsService cAuthorsService;

    /**
     * 查询作者列表
     */
    @PreAuthorize("@ss.hasPermi('resources:authors:list')")
    @GetMapping("/list")
    public TableDataInfo list(CAuthors cAuthors)
    {
        startPage();
        List<CAuthors> list = cAuthorsService.selectCAuthorsList(cAuthors);
        return getDataTable(list);
    }

    /**
     * 导出作者列表
     */
    @PreAuthorize("@ss.hasPermi('resources:authors:export')")
    @Log(title = "作者", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CAuthors cAuthors)
    {
        List<CAuthors> list = cAuthorsService.selectCAuthorsList(cAuthors);
        ExcelUtil<CAuthors> util = new ExcelUtil<CAuthors>(CAuthors.class);
        util.exportExcel(response, list, "作者数据");
    }

    /**
     * 获取作者详细信息
     */
    @PreAuthorize("@ss.hasPermi('resources:authors:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cAuthorsService.selectCAuthorsById(id));
    }

    /**
     * 新增作者
     */
    @PreAuthorize("@ss.hasPermi('resources:authors:add')")
    @Log(title = "作者", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CAuthors cAuthors)
    {
        return toAjax(cAuthorsService.insertCAuthors(cAuthors));
    }

    /**
     * 修改作者
     */
    @PreAuthorize("@ss.hasPermi('resources:authors:edit')")
    @Log(title = "作者", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CAuthors cAuthors)
    {
        return toAjax(cAuthorsService.updateCAuthors(cAuthors));
    }

    /**
     * 删除作者
     */
    @PreAuthorize("@ss.hasPermi('resources:authors:remove')")
    @Log(title = "作者", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cAuthorsService.deleteCAuthorsByIds(ids));
    }
}
