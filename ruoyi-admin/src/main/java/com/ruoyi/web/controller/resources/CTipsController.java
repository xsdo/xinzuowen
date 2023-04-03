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
import com.ruoyi.resources.domain.CTips;
import com.ruoyi.resources.service.ICTipsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 举报Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/resources/tips")
public class CTipsController extends BaseController
{
    @Autowired
    private ICTipsService cTipsService;

    /**
     * 查询举报列表
     */
    @PreAuthorize("@ss.hasPermi('resources:tips:list')")
    @GetMapping("/list")
    public TableDataInfo list(CTips cTips)
    {
        startPage();
        List<CTips> list = cTipsService.selectCTipsList(cTips);
        return getDataTable(list);
    }

    /**
     * 导出举报列表
     */
    @PreAuthorize("@ss.hasPermi('resources:tips:export')")
    @Log(title = "举报", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CTips cTips)
    {
        List<CTips> list = cTipsService.selectCTipsList(cTips);
        ExcelUtil<CTips> util = new ExcelUtil<CTips>(CTips.class);
        util.exportExcel(response, list, "举报数据");
    }

    /**
     * 获取举报详细信息
     */
    @PreAuthorize("@ss.hasPermi('resources:tips:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cTipsService.selectCTipsById(id));
    }

    /**
     * 新增举报
     */
    @PreAuthorize("@ss.hasPermi('resources:tips:add')")
    @Log(title = "举报", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CTips cTips)
    {
        return toAjax(cTipsService.insertCTips(cTips));
    }

    /**
     * 修改举报
     */
    @PreAuthorize("@ss.hasPermi('resources:tips:edit')")
    @Log(title = "举报", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CTips cTips)
    {
        return toAjax(cTipsService.updateCTips(cTips));
    }

    /**
     * 删除举报
     */
    @PreAuthorize("@ss.hasPermi('resources:tips:remove')")
    @Log(title = "举报", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cTipsService.deleteCTipsByIds(ids));
    }
}
