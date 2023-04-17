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
import com.ruoyi.resources.domain.ReadContest;
import com.ruoyi.resources.service.IReadContestService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 活动参赛Controller
 * 
 * @author xqq
 * @date 2023-04-17
 */
@RestController
@RequestMapping("/resources/contest")
public class ReadContestController extends BaseController
{
    @Autowired
    private IReadContestService readContestService;

    /**
     * 查询活动参赛列表
     */
    @PreAuthorize("@ss.hasPermi('resources:contest:list')")
    @GetMapping("/list")
    public TableDataInfo list(ReadContest readContest)
    {
        startPage();
        List<ReadContest> list = readContestService.selectReadContestList(readContest);
        return getDataTable(list);
    }

    /**
     * 导出活动参赛列表
     */
    @PreAuthorize("@ss.hasPermi('resources:contest:export')")
    @Log(title = "活动参赛", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ReadContest readContest)
    {
        List<ReadContest> list = readContestService.selectReadContestList(readContest);
        ExcelUtil<ReadContest> util = new ExcelUtil<ReadContest>(ReadContest.class);
        util.exportExcel(response, list, "活动参赛数据");
    }

    /**
     * 获取活动参赛详细信息
     */
    @PreAuthorize("@ss.hasPermi('resources:contest:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(readContestService.selectReadContestById(id));
    }

    /**
     * 新增活动参赛
     */
    @PreAuthorize("@ss.hasPermi('resources:contest:add')")
    @Log(title = "活动参赛", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ReadContest readContest)
    {
        return toAjax(readContestService.insertReadContest(readContest));
    }

    /**
     * 修改活动参赛
     */
    @PreAuthorize("@ss.hasPermi('resources:contest:edit')")
    @Log(title = "活动参赛", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ReadContest readContest)
    {
        return toAjax(readContestService.updateReadContest(readContest));
    }

    /**
     * 删除活动参赛
     */
    @PreAuthorize("@ss.hasPermi('resources:contest:remove')")
    @Log(title = "活动参赛", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(readContestService.deleteReadContestByIds(ids));
    }
}
