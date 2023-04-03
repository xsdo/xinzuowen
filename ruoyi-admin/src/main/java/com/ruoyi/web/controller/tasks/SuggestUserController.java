package com.ruoyi.web.controller.tasks;

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
import com.ruoyi.tasks.domain.SuggestUser;
import com.ruoyi.tasks.service.ISuggestUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 推荐用户Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/tasks/suggestuser")
public class SuggestUserController extends BaseController
{
    @Autowired
    private ISuggestUserService suggestUserService;

    /**
     * 查询推荐用户列表
     */
    @PreAuthorize("@ss.hasPermi('tasks:suggestuser:list')")
    @GetMapping("/list")
    public TableDataInfo list(SuggestUser suggestUser)
    {
        startPage();
        List<SuggestUser> list = suggestUserService.selectSuggestUserList(suggestUser);
        return getDataTable(list);
    }

    /**
     * 导出推荐用户列表
     */
    @PreAuthorize("@ss.hasPermi('tasks:suggestuser:export')")
    @Log(title = "推荐用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SuggestUser suggestUser)
    {
        List<SuggestUser> list = suggestUserService.selectSuggestUserList(suggestUser);
        ExcelUtil<SuggestUser> util = new ExcelUtil<SuggestUser>(SuggestUser.class);
        util.exportExcel(response, list, "推荐用户数据");
    }

    /**
     * 获取推荐用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('tasks:suggestuser:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(suggestUserService.selectSuggestUserById(id));
    }

    /**
     * 新增推荐用户
     */
    @PreAuthorize("@ss.hasPermi('tasks:suggestuser:add')")
    @Log(title = "推荐用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SuggestUser suggestUser)
    {
        return toAjax(suggestUserService.insertSuggestUser(suggestUser));
    }

    /**
     * 修改推荐用户
     */
    @PreAuthorize("@ss.hasPermi('tasks:suggestuser:edit')")
    @Log(title = "推荐用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SuggestUser suggestUser)
    {
        return toAjax(suggestUserService.updateSuggestUser(suggestUser));
    }

    /**
     * 删除推荐用户
     */
    @PreAuthorize("@ss.hasPermi('tasks:suggestuser:remove')")
    @Log(title = "推荐用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(suggestUserService.deleteSuggestUserByIds(ids));
    }
}
