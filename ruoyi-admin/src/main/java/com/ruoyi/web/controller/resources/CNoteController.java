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
import com.ruoyi.resources.domain.CNote;
import com.ruoyi.resources.service.ICNoteService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 笔记Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/resources/note")
public class CNoteController extends BaseController
{
    @Autowired
    private ICNoteService cNoteService;

    /**
     * 查询笔记列表
     */
    @PreAuthorize("@ss.hasPermi('resources:note:list')")
    @GetMapping("/list")
    public TableDataInfo list(CNote cNote)
    {
        startPage();
        List<CNote> list = cNoteService.selectCNoteList(cNote);
        return getDataTable(list);
    }

    /**
     * 导出笔记列表
     */
    @PreAuthorize("@ss.hasPermi('resources:note:export')")
    @Log(title = "笔记", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CNote cNote)
    {
        List<CNote> list = cNoteService.selectCNoteList(cNote);
        ExcelUtil<CNote> util = new ExcelUtil<CNote>(CNote.class);
        util.exportExcel(response, list, "笔记数据");
    }

    /**
     * 获取笔记详细信息
     */
    @PreAuthorize("@ss.hasPermi('resources:note:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cNoteService.selectCNoteById(id));
    }

    /**
     * 新增笔记
     */
    @PreAuthorize("@ss.hasPermi('resources:note:add')")
    @Log(title = "笔记", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CNote cNote)
    {
        return toAjax(cNoteService.insertCNote(cNote));
    }

    /**
     * 修改笔记
     */
    @PreAuthorize("@ss.hasPermi('resources:note:edit')")
    @Log(title = "笔记", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CNote cNote)
    {
        return toAjax(cNoteService.updateCNote(cNote));
    }

    /**
     * 删除笔记
     */
    @PreAuthorize("@ss.hasPermi('resources:note:remove')")
    @Log(title = "笔记", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cNoteService.deleteCNoteByIds(ids));
    }
}
