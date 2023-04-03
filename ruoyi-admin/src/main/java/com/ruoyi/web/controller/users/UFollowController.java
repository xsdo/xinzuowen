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
import com.ruoyi.users.domain.UFollow;
import com.ruoyi.users.service.IUFollowService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户关注Controller
 * 
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/users/follow")
public class UFollowController extends BaseController
{
    @Autowired
    private IUFollowService uFollowService;

    /**
     * 查询用户关注列表
     */
    @PreAuthorize("@ss.hasPermi('users:follow:list')")
    @GetMapping("/list")
    public TableDataInfo list(UFollow uFollow)
    {
        startPage();
        List<UFollow> list = uFollowService.selectUFollowList(uFollow);
        return getDataTable(list);
    }

    /**
     * 导出用户关注列表
     */
    @PreAuthorize("@ss.hasPermi('users:follow:export')")
    @Log(title = "用户关注", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UFollow uFollow)
    {
        List<UFollow> list = uFollowService.selectUFollowList(uFollow);
        ExcelUtil<UFollow> util = new ExcelUtil<UFollow>(UFollow.class);
        util.exportExcel(response, list, "用户关注数据");
    }

    /**
     * 获取用户关注详细信息
     */
    @PreAuthorize("@ss.hasPermi('users:follow:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(uFollowService.selectUFollowById(id));
    }

    /**
     * 新增用户关注
     */
    @PreAuthorize("@ss.hasPermi('users:follow:add')")
    @Log(title = "用户关注", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UFollow uFollow)
    {
        return toAjax(uFollowService.insertUFollow(uFollow));
    }

    /**
     * 修改用户关注
     */
    @PreAuthorize("@ss.hasPermi('users:follow:edit')")
    @Log(title = "用户关注", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UFollow uFollow)
    {
        return toAjax(uFollowService.updateUFollow(uFollow));
    }

    /**
     * 删除用户关注
     */
    @PreAuthorize("@ss.hasPermi('users:follow:remove')")
    @Log(title = "用户关注", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(uFollowService.deleteUFollowByIds(ids));
    }
}
