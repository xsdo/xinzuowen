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
import com.ruoyi.resources.domain.ReadEssay;
import com.ruoyi.resources.service.IReadEssayService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 阅读文章Controller
 * 
 * @author xqq
 * @date 2023-04-17
 */
@RestController
@RequestMapping("/resources/essay")
public class ReadEssayController extends BaseController
{
    @Autowired
    private IReadEssayService readEssayService;

    /**
     * 查询阅读文章列表
     */
    @PreAuthorize("@ss.hasPermi('resources:essay:list')")
    @GetMapping("/list")
    public TableDataInfo list(ReadEssay readEssay)
    {
        startPage();
        List<ReadEssay> list = readEssayService.selectReadEssayList(readEssay);
        return getDataTable(list);
    }

    /**
     * 导出阅读文章列表
     */
    @PreAuthorize("@ss.hasPermi('resources:essay:export')")
    @Log(title = "阅读文章", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReadEssay readEssay)
    {
        List<ReadEssay> list = readEssayService.selectReadEssayList(readEssay);
        ExcelUtil<ReadEssay> util = new ExcelUtil<ReadEssay>(ReadEssay.class);
        util.exportExcel(response, list, "阅读文章数据");
    }

    /**
     * 获取阅读文章详细信息
     */
    @PreAuthorize("@ss.hasPermi('resources:essay:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(readEssayService.selectReadEssayById(id));
    }

    /**
     * 新增阅读文章
     */
    @PreAuthorize("@ss.hasPermi('resources:essay:add')")
    @Log(title = "阅读文章", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReadEssay readEssay)
    {
        return toAjax(readEssayService.insertReadEssay(readEssay));
    }

    /**
     * 修改阅读文章
     */
    @PreAuthorize("@ss.hasPermi('resources:essay:edit')")
    @Log(title = "阅读文章", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReadEssay readEssay)
    {
        return toAjax(readEssayService.updateReadEssay(readEssay));
    }

    /**
     * 删除阅读文章
     */
    @PreAuthorize("@ss.hasPermi('resources:essay:remove')")
    @Log(title = "阅读文章", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(readEssayService.deleteReadEssayByIds(ids));
    }
}
