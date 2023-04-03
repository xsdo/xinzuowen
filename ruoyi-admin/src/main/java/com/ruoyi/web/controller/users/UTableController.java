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
import com.ruoyi.users.domain.UTable;
import com.ruoyi.users.service.IUTableService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户标签Controller
 * 
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/users/table")
public class UTableController extends BaseController
{
    @Autowired
    private IUTableService uTableService;

    /**
     * 查询用户标签列表
     */
    @PreAuthorize("@ss.hasPermi('users:table:list')")
    @GetMapping("/list")
    public TableDataInfo list(UTable uTable)
    {
        startPage();
        List<UTable> list = uTableService.selectUTableList(uTable);
        return getDataTable(list);
    }

    /**
     * 导出用户标签列表
     */
    @PreAuthorize("@ss.hasPermi('users:table:export')")
    @Log(title = "用户标签", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UTable uTable)
    {
        List<UTable> list = uTableService.selectUTableList(uTable);
        ExcelUtil<UTable> util = new ExcelUtil<UTable>(UTable.class);
        util.exportExcel(response, list, "用户标签数据");
    }

    /**
     * 获取用户标签详细信息
     */
    @PreAuthorize("@ss.hasPermi('users:table:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(uTableService.selectUTableById(id));
    }

    /**
     * 新增用户标签
     */
    @PreAuthorize("@ss.hasPermi('users:table:add')")
    @Log(title = "用户标签", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UTable uTable)
    {
        return toAjax(uTableService.insertUTable(uTable));
    }

    /**
     * 修改用户标签
     */
    @PreAuthorize("@ss.hasPermi('users:table:edit')")
    @Log(title = "用户标签", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UTable uTable)
    {
        return toAjax(uTableService.updateUTable(uTable));
    }

    /**
     * 删除用户标签
     */
    @PreAuthorize("@ss.hasPermi('users:table:remove')")
    @Log(title = "用户标签", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(uTableService.deleteUTableByIds(ids));
    }
}
