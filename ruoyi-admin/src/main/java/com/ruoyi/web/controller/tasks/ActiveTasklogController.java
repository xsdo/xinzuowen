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
import com.ruoyi.tasks.domain.ActiveTasklog;
import com.ruoyi.tasks.service.IActiveTasklogService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 活动用户记录Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/tasks/activetasklog")
public class ActiveTasklogController extends BaseController
{
    @Autowired
    private IActiveTasklogService activeTasklogService;

    /**
     * 查询活动用户记录列表
     */
    @PreAuthorize("@ss.hasPermi('tasks:activetasklog:list')")
    @GetMapping("/list")
    public TableDataInfo list(ActiveTasklog activeTasklog)
    {
        startPage();
        List<ActiveTasklog> list = activeTasklogService.selectActiveTasklogList(activeTasklog);
        return getDataTable(list);
    }

    /**
     * 导出活动用户记录列表
     */
    @PreAuthorize("@ss.hasPermi('tasks:activetasklog:export')")
    @Log(title = "活动用户记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ActiveTasklog activeTasklog)
    {
        List<ActiveTasklog> list = activeTasklogService.selectActiveTasklogList(activeTasklog);
        ExcelUtil<ActiveTasklog> util = new ExcelUtil<ActiveTasklog>(ActiveTasklog.class);
        util.exportExcel(response, list, "活动用户记录数据");
    }

    /**
     * 获取活动用户记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('tasks:activetasklog:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(activeTasklogService.selectActiveTasklogById(id));
    }

    /**
     * 新增活动用户记录
     */
    @PreAuthorize("@ss.hasPermi('tasks:activetasklog:add')")
    @Log(title = "活动用户记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ActiveTasklog activeTasklog)
    {
        return toAjax(activeTasklogService.insertActiveTasklog(activeTasklog));
    }

    /**
     * 修改活动用户记录
     */
    @PreAuthorize("@ss.hasPermi('tasks:activetasklog:edit')")
    @Log(title = "活动用户记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ActiveTasklog activeTasklog)
    {
        return toAjax(activeTasklogService.updateActiveTasklog(activeTasklog));
    }

    /**
     * 删除活动用户记录
     */
    @PreAuthorize("@ss.hasPermi('tasks:activetasklog:remove')")
    @Log(title = "活动用户记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(activeTasklogService.deleteActiveTasklogByIds(ids));
    }
}
