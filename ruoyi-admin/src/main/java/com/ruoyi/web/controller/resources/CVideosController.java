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
import com.ruoyi.resources.domain.CVideos;
import com.ruoyi.resources.service.ICVideosService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 视频Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/resources/videos")
public class CVideosController extends BaseController
{
    @Autowired
    private ICVideosService cVideosService;

    /**
     * 查询视频列表
     */
    @PreAuthorize("@ss.hasPermi('resources:videos:list')")
    @GetMapping("/list")
    public TableDataInfo list(CVideos cVideos)
    {
        startPage();
        List<CVideos> list = cVideosService.selectCVideosList(cVideos);
        return getDataTable(list);
    }

    /**
     * 导出视频列表
     */
    @PreAuthorize("@ss.hasPermi('resources:videos:export')")
    @Log(title = "视频", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CVideos cVideos)
    {
        List<CVideos> list = cVideosService.selectCVideosList(cVideos);
        ExcelUtil<CVideos> util = new ExcelUtil<CVideos>(CVideos.class);
        util.exportExcel(response, list, "视频数据");
    }

    /**
     * 获取视频详细信息
     */
    @PreAuthorize("@ss.hasPermi('resources:videos:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cVideosService.selectCVideosById(id));
    }

    /**
     * 新增视频
     */
    @PreAuthorize("@ss.hasPermi('resources:videos:add')")
    @Log(title = "视频", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CVideos cVideos)
    {
        return toAjax(cVideosService.insertCVideos(cVideos));
    }

    /**
     * 修改视频
     */
    @PreAuthorize("@ss.hasPermi('resources:videos:edit')")
    @Log(title = "视频", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CVideos cVideos)
    {
        return toAjax(cVideosService.updateCVideos(cVideos));
    }

    /**
     * 删除视频
     */
    @PreAuthorize("@ss.hasPermi('resources:videos:remove')")
    @Log(title = "视频", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cVideosService.deleteCVideosByIds(ids));
    }
}
