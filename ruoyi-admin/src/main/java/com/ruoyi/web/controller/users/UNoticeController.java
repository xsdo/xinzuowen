package com.ruoyi.users.controller;

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
import com.ruoyi.users.domain.UNotice;
import com.ruoyi.users.service.IUNoticeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 消息通知Controller
 * 
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/users/notice")
public class UNoticeController extends BaseController
{
    @Autowired
    private IUNoticeService uNoticeService;

    /**
     * 查询消息通知列表
     */
    @PreAuthorize("@ss.hasPermi('users:notice:list')")
    @GetMapping("/list")
    public TableDataInfo list(UNotice uNotice)
    {
        startPage();
        List<UNotice> list = uNoticeService.selectUNoticeList(uNotice);
        return getDataTable(list);
    }

    /**
     * 导出消息通知列表
     */
    @PreAuthorize("@ss.hasPermi('users:notice:export')")
    @Log(title = "消息通知", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UNotice uNotice)
    {
        List<UNotice> list = uNoticeService.selectUNoticeList(uNotice);
        ExcelUtil<UNotice> util = new ExcelUtil<UNotice>(UNotice.class);
        util.exportExcel(response, list, "消息通知数据");
    }

    /**
     * 获取消息通知详细信息
     */
    @PreAuthorize("@ss.hasPermi('users:notice:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(uNoticeService.selectUNoticeById(id));
    }

    /**
     * 新增消息通知
     */
    @PreAuthorize("@ss.hasPermi('users:notice:add')")
    @Log(title = "消息通知", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UNotice uNotice)
    {
        return toAjax(uNoticeService.insertUNotice(uNotice));
    }

    /**
     * 修改消息通知
     */
    @PreAuthorize("@ss.hasPermi('users:notice:edit')")
    @Log(title = "消息通知", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UNotice uNotice)
    {
        return toAjax(uNoticeService.updateUNotice(uNotice));
    }

    /**
     * 删除消息通知
     */
    @PreAuthorize("@ss.hasPermi('users:notice:remove')")
    @Log(title = "消息通知", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(uNoticeService.deleteUNoticeByIds(ids));
    }
}
