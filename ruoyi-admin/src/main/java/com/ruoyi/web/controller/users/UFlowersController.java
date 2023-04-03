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
import com.ruoyi.users.domain.UFlowers;
import com.ruoyi.users.service.IUFlowersService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 鲜花Controller
 * 
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/users/flowers")
public class UFlowersController extends BaseController
{
    @Autowired
    private IUFlowersService uFlowersService;

    /**
     * 查询鲜花列表
     */
    @PreAuthorize("@ss.hasPermi('users:flowers:list')")
    @GetMapping("/list")
    public TableDataInfo list(UFlowers uFlowers)
    {
        startPage();
        List<UFlowers> list = uFlowersService.selectUFlowersList(uFlowers);
        return getDataTable(list);
    }

    /**
     * 导出鲜花列表
     */
    @PreAuthorize("@ss.hasPermi('users:flowers:export')")
    @Log(title = "鲜花", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UFlowers uFlowers)
    {
        List<UFlowers> list = uFlowersService.selectUFlowersList(uFlowers);
        ExcelUtil<UFlowers> util = new ExcelUtil<UFlowers>(UFlowers.class);
        util.exportExcel(response, list, "鲜花数据");
    }

    /**
     * 获取鲜花详细信息
     */
    @PreAuthorize("@ss.hasPermi('users:flowers:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(uFlowersService.selectUFlowersById(id));
    }

    /**
     * 新增鲜花
     */
    @PreAuthorize("@ss.hasPermi('users:flowers:add')")
    @Log(title = "鲜花", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UFlowers uFlowers)
    {
        return toAjax(uFlowersService.insertUFlowers(uFlowers));
    }

    /**
     * 修改鲜花
     */
    @PreAuthorize("@ss.hasPermi('users:flowers:edit')")
    @Log(title = "鲜花", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UFlowers uFlowers)
    {
        return toAjax(uFlowersService.updateUFlowers(uFlowers));
    }

    /**
     * 删除鲜花
     */
    @PreAuthorize("@ss.hasPermi('users:flowers:remove')")
    @Log(title = "鲜花", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(uFlowersService.deleteUFlowersByIds(ids));
    }
}
