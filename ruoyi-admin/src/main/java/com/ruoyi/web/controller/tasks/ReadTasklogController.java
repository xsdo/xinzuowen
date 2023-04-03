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
import com.ruoyi.tasks.domain.ReadTasklog;
import com.ruoyi.tasks.service.IReadTasklogService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 阅读任务记录Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/tasks/readtasklog")
public class ReadTasklogController extends BaseController
{
    @Autowired
    private IReadTasklogService readTasklogService;

    /**
     * 查询阅读任务记录列表
     */
    @PreAuthorize("@ss.hasPermi('tasks:readtasklog:list')")
    @GetMapping("/list")
    public TableDataInfo list(ReadTasklog readTasklog)
    {
        startPage();
        List<ReadTasklog> list = readTasklogService.selectReadTasklogList(readTasklog);
        return getDataTable(list);
    }

    /**
     * 导出阅读任务记录列表
     */
    @PreAuthorize("@ss.hasPermi('tasks:readtasklog:export')")
    @Log(title = "阅读任务记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReadTasklog readTasklog)
    {
        List<ReadTasklog> list = readTasklogService.selectReadTasklogList(readTasklog);
        ExcelUtil<ReadTasklog> util = new ExcelUtil<ReadTasklog>(ReadTasklog.class);
        util.exportExcel(response, list, "阅读任务记录数据");
    }

    /**
     * 获取阅读任务记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('tasks:readtasklog:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(readTasklogService.selectReadTasklogById(id));
    }

    /**
     * 新增阅读任务记录
     */
    @PreAuthorize("@ss.hasPermi('tasks:readtasklog:add')")
    @Log(title = "阅读任务记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReadTasklog readTasklog)
    {
        return toAjax(readTasklogService.insertReadTasklog(readTasklog));
    }

    /**
     * 修改阅读任务记录
     */
    @PreAuthorize("@ss.hasPermi('tasks:readtasklog:edit')")
    @Log(title = "阅读任务记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReadTasklog readTasklog)
    {
        return toAjax(readTasklogService.updateReadTasklog(readTasklog));
    }

    /**
     * 删除阅读任务记录
     */
    @PreAuthorize("@ss.hasPermi('tasks:readtasklog:remove')")
    @Log(title = "阅读任务记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(readTasklogService.deleteReadTasklogByIds(ids));
    }
}
