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
import com.ruoyi.users.domain.UFans;
import com.ruoyi.users.service.IUFansService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户粉丝Controller
 * 
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/users/fans")
public class UFansController extends BaseController
{
    @Autowired
    private IUFansService uFansService;

    /**
     * 查询用户粉丝列表
     */
    @PreAuthorize("@ss.hasPermi('users:fans:list')")
    @GetMapping("/list")
    public TableDataInfo list(UFans uFans)
    {
        startPage();
        List<UFans> list = uFansService.selectUFansList(uFans);
        return getDataTable(list);
    }

    /**
     * 导出用户粉丝列表
     */
    @PreAuthorize("@ss.hasPermi('users:fans:export')")
    @Log(title = "用户粉丝", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UFans uFans)
    {
        List<UFans> list = uFansService.selectUFansList(uFans);
        ExcelUtil<UFans> util = new ExcelUtil<UFans>(UFans.class);
        util.exportExcel(response, list, "用户粉丝数据");
    }

    /**
     * 获取用户粉丝详细信息
     */
    @PreAuthorize("@ss.hasPermi('users:fans:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(uFansService.selectUFansById(id));
    }

    /**
     * 新增用户粉丝
     */
    @PreAuthorize("@ss.hasPermi('users:fans:add')")
    @Log(title = "用户粉丝", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UFans uFans)
    {
        return toAjax(uFansService.insertUFans(uFans));
    }

    /**
     * 修改用户粉丝
     */
    @PreAuthorize("@ss.hasPermi('users:fans:edit')")
    @Log(title = "用户粉丝", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UFans uFans)
    {
        return toAjax(uFansService.updateUFans(uFans));
    }

    /**
     * 删除用户粉丝
     */
    @PreAuthorize("@ss.hasPermi('users:fans:remove')")
    @Log(title = "用户粉丝", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(uFansService.deleteUFansByIds(ids));
    }
}
