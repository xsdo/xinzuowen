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
import com.ruoyi.resources.domain.CCollectlog;
import com.ruoyi.resources.service.ICCollectlogService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 收藏夹文件Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/resources/collectlog")
public class CCollectlogController extends BaseController
{
    @Autowired
    private ICCollectlogService cCollectlogService;

    /**
     * 查询收藏夹文件列表
     */
    @PreAuthorize("@ss.hasPermi('resources:collectlog:list')")
    @GetMapping("/list")
    public TableDataInfo list(CCollectlog cCollectlog)
    {
        startPage();
        List<CCollectlog> list = cCollectlogService.selectCCollectlogList(cCollectlog);
        return getDataTable(list);
    }

    /**
     * 导出收藏夹文件列表
     */
    @PreAuthorize("@ss.hasPermi('resources:collectlog:export')")
    @Log(title = "收藏夹文件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CCollectlog cCollectlog)
    {
        List<CCollectlog> list = cCollectlogService.selectCCollectlogList(cCollectlog);
        ExcelUtil<CCollectlog> util = new ExcelUtil<CCollectlog>(CCollectlog.class);
        util.exportExcel(response, list, "收藏夹文件数据");
    }

    /**
     * 获取收藏夹文件详细信息
     */
    @PreAuthorize("@ss.hasPermi('resources:collectlog:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cCollectlogService.selectCCollectlogById(id));
    }

    /**
     * 新增收藏夹文件
     */
    @PreAuthorize("@ss.hasPermi('resources:collectlog:add')")
    @Log(title = "收藏夹文件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CCollectlog cCollectlog)
    {
        return toAjax(cCollectlogService.insertCCollectlog(cCollectlog));
    }

    /**
     * 修改收藏夹文件
     */
    @PreAuthorize("@ss.hasPermi('resources:collectlog:edit')")
    @Log(title = "收藏夹文件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CCollectlog cCollectlog)
    {
        return toAjax(cCollectlogService.updateCCollectlog(cCollectlog));
    }

    /**
     * 删除收藏夹文件
     */
    @PreAuthorize("@ss.hasPermi('resources:collectlog:remove')")
    @Log(title = "收藏夹文件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cCollectlogService.deleteCCollectlogByIds(ids));
    }
}
