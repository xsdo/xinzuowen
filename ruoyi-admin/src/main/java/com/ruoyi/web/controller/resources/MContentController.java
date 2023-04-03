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
import com.ruoyi.resources.domain.MContent;
import com.ruoyi.resources.service.IMContentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 杂志内容Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/resources/content")
public class MContentController extends BaseController
{
    @Autowired
    private IMContentService mContentService;

    /**
     * 查询杂志内容列表
     */
    @PreAuthorize("@ss.hasPermi('resources:content:list')")
    @GetMapping("/list")
    public TableDataInfo list(MContent mContent)
    {
        startPage();
        List<MContent> list = mContentService.selectMContentList(mContent);
        return getDataTable(list);
    }

    /**
     * 导出杂志内容列表
     */
    @PreAuthorize("@ss.hasPermi('resources:content:export')")
    @Log(title = "杂志内容", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MContent mContent)
    {
        List<MContent> list = mContentService.selectMContentList(mContent);
        ExcelUtil<MContent> util = new ExcelUtil<MContent>(MContent.class);
        util.exportExcel(response, list, "杂志内容数据");
    }

    /**
     * 获取杂志内容详细信息
     */
    @PreAuthorize("@ss.hasPermi('resources:content:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(mContentService.selectMContentById(id));
    }

    /**
     * 新增杂志内容
     */
    @PreAuthorize("@ss.hasPermi('resources:content:add')")
    @Log(title = "杂志内容", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MContent mContent)
    {
        return toAjax(mContentService.insertMContent(mContent));
    }

    /**
     * 修改杂志内容
     */
    @PreAuthorize("@ss.hasPermi('resources:content:edit')")
    @Log(title = "杂志内容", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MContent mContent)
    {
        return toAjax(mContentService.updateMContent(mContent));
    }

    /**
     * 删除杂志内容
     */
    @PreAuthorize("@ss.hasPermi('resources:content:remove')")
    @Log(title = "杂志内容", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(mContentService.deleteMContentByIds(ids));
    }
}
