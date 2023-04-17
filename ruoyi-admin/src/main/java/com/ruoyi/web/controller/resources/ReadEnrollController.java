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
import com.ruoyi.resources.domain.ReadEnroll;
import com.ruoyi.resources.service.IReadEnrollService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 活动报名Controller
 * 
 * @author xqq
 * @date 2023-04-17
 */
@RestController
@RequestMapping("/resources/enroll")
public class ReadEnrollController extends BaseController
{
    @Autowired
    private IReadEnrollService readEnrollService;

    /**
     * 查询活动报名列表
     */
    @PreAuthorize("@ss.hasPermi('resources:enroll:list')")
    @GetMapping("/list")
    public TableDataInfo list(ReadEnroll readEnroll)
    {
        startPage();
        List<ReadEnroll> list = readEnrollService.selectReadEnrollList(readEnroll);
        return getDataTable(list);
    }

    /**
     * 导出活动报名列表
     */
    @PreAuthorize("@ss.hasPermi('resources:enroll:export')")
    @Log(title = "活动报名", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReadEnroll readEnroll)
    {
        List<ReadEnroll> list = readEnrollService.selectReadEnrollList(readEnroll);
        ExcelUtil<ReadEnroll> util = new ExcelUtil<ReadEnroll>(ReadEnroll.class);
        util.exportExcel(response, list, "活动报名数据");
    }

    /**
     * 获取活动报名详细信息
     */
    @PreAuthorize("@ss.hasPermi('resources:enroll:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(readEnrollService.selectReadEnrollById(id));
    }

    /**
     * 新增活动报名
     */
    @PreAuthorize("@ss.hasPermi('resources:enroll:add')")
    @Log(title = "活动报名", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReadEnroll readEnroll)
    {
        return toAjax(readEnrollService.insertReadEnroll(readEnroll));
    }

    /**
     * 修改活动报名
     */
    @PreAuthorize("@ss.hasPermi('resources:enroll:edit')")
    @Log(title = "活动报名", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReadEnroll readEnroll)
    {
        return toAjax(readEnrollService.updateReadEnroll(readEnroll));
    }

    /**
     * 删除活动报名
     */
    @PreAuthorize("@ss.hasPermi('resources:enroll:remove')")
    @Log(title = "活动报名", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(readEnrollService.deleteReadEnrollByIds(ids));
    }
}
