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
import com.ruoyi.resources.domain.CVoice;
import com.ruoyi.resources.service.ICVoiceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 音频Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/resources/voice")
public class CVoiceController extends BaseController
{
    @Autowired
    private ICVoiceService cVoiceService;

    /**
     * 查询音频列表
     */
    @PreAuthorize("@ss.hasPermi('resources:voice:list')")
    @GetMapping("/list")
    public TableDataInfo list(CVoice cVoice)
    {
        startPage();
        List<CVoice> list = cVoiceService.selectCVoiceList(cVoice);
        return getDataTable(list);
    }

    /**
     * 导出音频列表
     */
    @PreAuthorize("@ss.hasPermi('resources:voice:export')")
    @Log(title = "音频", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CVoice cVoice)
    {
        List<CVoice> list = cVoiceService.selectCVoiceList(cVoice);
        ExcelUtil<CVoice> util = new ExcelUtil<CVoice>(CVoice.class);
        util.exportExcel(response, list, "音频数据");
    }

    /**
     * 获取音频详细信息
     */
    @PreAuthorize("@ss.hasPermi('resources:voice:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cVoiceService.selectCVoiceById(id));
    }

    /**
     * 新增音频
     */
    @PreAuthorize("@ss.hasPermi('resources:voice:add')")
    @Log(title = "音频", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CVoice cVoice)
    {
        return toAjax(cVoiceService.insertCVoice(cVoice));
    }

    /**
     * 修改音频
     */
    @PreAuthorize("@ss.hasPermi('resources:voice:edit')")
    @Log(title = "音频", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CVoice cVoice)
    {
        return toAjax(cVoiceService.updateCVoice(cVoice));
    }

    /**
     * 删除音频
     */
    @PreAuthorize("@ss.hasPermi('resources:voice:remove')")
    @Log(title = "音频", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cVoiceService.deleteCVoiceByIds(ids));
    }
}
