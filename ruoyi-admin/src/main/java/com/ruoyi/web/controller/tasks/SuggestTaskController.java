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
import com.ruoyi.tasks.domain.SuggestTask;
import com.ruoyi.tasks.service.ISuggestTaskService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 推荐作文Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/tasks/suggesttask")
public class SuggestTaskController extends BaseController
{
    @Autowired
    private ISuggestTaskService suggestTaskService;

    /**
     * 查询推荐作文列表
     */
    @PreAuthorize("@ss.hasPermi('tasks:suggesttask:list')")
    @GetMapping("/list")
    public TableDataInfo list(SuggestTask suggestTask)
    {
        startPage();
        List<SuggestTask> list = suggestTaskService.selectSuggestTaskList(suggestTask);
        return getDataTable(list);
    }

    /**
     * 导出推荐作文列表
     */
    @PreAuthorize("@ss.hasPermi('tasks:suggesttask:export')")
    @Log(title = "推荐作文", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SuggestTask suggestTask)
    {
        List<SuggestTask> list = suggestTaskService.selectSuggestTaskList(suggestTask);
        ExcelUtil<SuggestTask> util = new ExcelUtil<SuggestTask>(SuggestTask.class);
        util.exportExcel(response, list, "推荐作文数据");
    }

    /**
     * 获取推荐作文详细信息
     */
    @PreAuthorize("@ss.hasPermi('tasks:suggesttask:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(suggestTaskService.selectSuggestTaskById(id));
    }

    /**
     * 新增推荐作文
     */
    @PreAuthorize("@ss.hasPermi('tasks:suggesttask:add')")
    @Log(title = "推荐作文", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SuggestTask suggestTask)
    {
        return toAjax(suggestTaskService.insertSuggestTask(suggestTask));
    }

    /**
     * 修改推荐作文
     */
    @PreAuthorize("@ss.hasPermi('tasks:suggesttask:edit')")
    @Log(title = "推荐作文", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SuggestTask suggestTask)
    {
        return toAjax(suggestTaskService.updateSuggestTask(suggestTask));
    }

    /**
     * 删除推荐作文
     */
    @PreAuthorize("@ss.hasPermi('tasks:suggesttask:remove')")
    @Log(title = "推荐作文", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(suggestTaskService.deleteSuggestTaskByIds(ids));
    }
}
