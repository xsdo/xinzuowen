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
import com.ruoyi.resources.domain.ReadBook;
import com.ruoyi.resources.service.IReadBookService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 阅读图书Controller
 * 
 * @author xqq
 * @date 2023-04-17
 */
@RestController
@RequestMapping("/resources/book")
public class ReadBookController extends BaseController
{
    @Autowired
    private IReadBookService readBookService;

    /**
     * 查询阅读图书列表
     */
    @PreAuthorize("@ss.hasPermi('resources:book:list')")
    @GetMapping("/list")
    public TableDataInfo list(ReadBook readBook)
    {
        startPage();
        List<ReadBook> list = readBookService.selectReadBookList(readBook);
        return getDataTable(list);
    }

    /**
     * 导出阅读图书列表
     */
    @PreAuthorize("@ss.hasPermi('resources:book:export')")
    @Log(title = "阅读图书", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReadBook readBook)
    {
        List<ReadBook> list = readBookService.selectReadBookList(readBook);
        ExcelUtil<ReadBook> util = new ExcelUtil<ReadBook>(ReadBook.class);
        util.exportExcel(response, list, "阅读图书数据");
    }

    /**
     * 获取阅读图书详细信息
     */
    @PreAuthorize("@ss.hasPermi('resources:book:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(readBookService.selectReadBookById(id));
    }

    /**
     * 新增阅读图书
     */
    @PreAuthorize("@ss.hasPermi('resources:book:add')")
    @Log(title = "阅读图书", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReadBook readBook)
    {
        return toAjax(readBookService.insertReadBook(readBook));
    }

    /**
     * 修改阅读图书
     */
    @PreAuthorize("@ss.hasPermi('resources:book:edit')")
    @Log(title = "阅读图书", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReadBook readBook)
    {
        return toAjax(readBookService.updateReadBook(readBook));
    }

    /**
     * 删除阅读图书
     */
    @PreAuthorize("@ss.hasPermi('resources:book:remove')")
    @Log(title = "阅读图书", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(readBookService.deleteReadBookByIds(ids));
    }
}
