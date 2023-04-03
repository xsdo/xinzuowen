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
import com.ruoyi.resources.domain.CDiscuss;
import com.ruoyi.resources.service.ICDiscussService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 评论Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/resources/discuss")
public class CDiscussController extends BaseController
{
    @Autowired
    private ICDiscussService cDiscussService;

    /**
     * 查询评论列表
     */
    @PreAuthorize("@ss.hasPermi('resources:discuss:list')")
    @GetMapping("/list")
    public TableDataInfo list(CDiscuss cDiscuss)
    {
        startPage();
        List<CDiscuss> list = cDiscussService.selectCDiscussList(cDiscuss);
        return getDataTable(list);
    }

    /**
     * 导出评论列表
     */
    @PreAuthorize("@ss.hasPermi('resources:discuss:export')")
    @Log(title = "评论", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CDiscuss cDiscuss)
    {
        List<CDiscuss> list = cDiscussService.selectCDiscussList(cDiscuss);
        ExcelUtil<CDiscuss> util = new ExcelUtil<CDiscuss>(CDiscuss.class);
        util.exportExcel(response, list, "评论数据");
    }

    /**
     * 获取评论详细信息
     */
    @PreAuthorize("@ss.hasPermi('resources:discuss:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cDiscussService.selectCDiscussById(id));
    }

    /**
     * 新增评论
     */
    @PreAuthorize("@ss.hasPermi('resources:discuss:add')")
    @Log(title = "评论", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CDiscuss cDiscuss)
    {
        return toAjax(cDiscussService.insertCDiscuss(cDiscuss));
    }

    /**
     * 修改评论
     */
    @PreAuthorize("@ss.hasPermi('resources:discuss:edit')")
    @Log(title = "评论", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CDiscuss cDiscuss)
    {
        return toAjax(cDiscussService.updateCDiscuss(cDiscuss));
    }

    /**
     * 删除评论
     */
    @PreAuthorize("@ss.hasPermi('resources:discuss:remove')")
    @Log(title = "评论", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cDiscussService.deleteCDiscussByIds(ids));
    }
}
