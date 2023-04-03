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
import com.ruoyi.resources.domain.CCollect;
import com.ruoyi.resources.service.ICCollectService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 收藏Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/resources/collect")
public class CCollectController extends BaseController
{
    @Autowired
    private ICCollectService cCollectService;

    /**
     * 查询收藏列表
     */
    @PreAuthorize("@ss.hasPermi('resources:collect:list')")
    @GetMapping("/list")
    public TableDataInfo list(CCollect cCollect)
    {
        startPage();
        List<CCollect> list = cCollectService.selectCCollectList(cCollect);
        return getDataTable(list);
    }

    /**
     * 导出收藏列表
     */
    @PreAuthorize("@ss.hasPermi('resources:collect:export')")
    @Log(title = "收藏", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CCollect cCollect)
    {
        List<CCollect> list = cCollectService.selectCCollectList(cCollect);
        ExcelUtil<CCollect> util = new ExcelUtil<CCollect>(CCollect.class);
        util.exportExcel(response, list, "收藏数据");
    }

    /**
     * 获取收藏详细信息
     */
    @PreAuthorize("@ss.hasPermi('resources:collect:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cCollectService.selectCCollectById(id));
    }

    /**
     * 新增收藏
     */
    @PreAuthorize("@ss.hasPermi('resources:collect:add')")
    @Log(title = "收藏", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CCollect cCollect)
    {
        return toAjax(cCollectService.insertCCollect(cCollect));
    }

    /**
     * 修改收藏
     */
    @PreAuthorize("@ss.hasPermi('resources:collect:edit')")
    @Log(title = "收藏", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CCollect cCollect)
    {
        return toAjax(cCollectService.updateCCollect(cCollect));
    }

    /**
     * 删除收藏
     */
    @PreAuthorize("@ss.hasPermi('resources:collect:remove')")
    @Log(title = "收藏", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cCollectService.deleteCCollectByIds(ids));
    }
}
