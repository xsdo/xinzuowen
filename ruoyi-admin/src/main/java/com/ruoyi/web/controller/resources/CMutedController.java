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
import com.ruoyi.resources.domain.CMuted;
import com.ruoyi.resources.service.ICMutedService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 禁言Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/resources/muted")
public class CMutedController extends BaseController
{
    @Autowired
    private ICMutedService cMutedService;

    /**
     * 查询禁言列表
     */
    @PreAuthorize("@ss.hasPermi('resources:muted:list')")
    @GetMapping("/list")
    public TableDataInfo list(CMuted cMuted)
    {
        startPage();
        List<CMuted> list = cMutedService.selectCMutedList(cMuted);
        return getDataTable(list);
    }

    /**
     * 导出禁言列表
     */
    @PreAuthorize("@ss.hasPermi('resources:muted:export')")
    @Log(title = "禁言", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CMuted cMuted)
    {
        List<CMuted> list = cMutedService.selectCMutedList(cMuted);
        ExcelUtil<CMuted> util = new ExcelUtil<CMuted>(CMuted.class);
        util.exportExcel(response, list, "禁言数据");
    }

    /**
     * 获取禁言详细信息
     */
    @PreAuthorize("@ss.hasPermi('resources:muted:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cMutedService.selectCMutedById(id));
    }

    /**
     * 新增禁言
     */
    @PreAuthorize("@ss.hasPermi('resources:muted:add')")
    @Log(title = "禁言", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CMuted cMuted)
    {
        return toAjax(cMutedService.insertCMuted(cMuted));
    }

    /**
     * 修改禁言
     */
    @PreAuthorize("@ss.hasPermi('resources:muted:edit')")
    @Log(title = "禁言", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CMuted cMuted)
    {
        return toAjax(cMutedService.updateCMuted(cMuted));
    }

    /**
     * 删除禁言
     */
    @PreAuthorize("@ss.hasPermi('resources:muted:remove')")
    @Log(title = "禁言", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cMutedService.deleteCMutedByIds(ids));
    }
}
