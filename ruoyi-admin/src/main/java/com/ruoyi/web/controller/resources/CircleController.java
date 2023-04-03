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
import com.ruoyi.resources.domain.Circle;
import com.ruoyi.resources.service.ICircleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 圈子Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/resources/circle")
public class CircleController extends BaseController
{
    @Autowired
    private ICircleService circleService;

    /**
     * 查询圈子列表
     */
    @PreAuthorize("@ss.hasPermi('resources:circle:list')")
    @GetMapping("/list")
    public TableDataInfo list(Circle circle)
    {
        startPage();
        List<Circle> list = circleService.selectCircleList(circle);
        return getDataTable(list);
    }

    /**
     * 导出圈子列表
     */
    @PreAuthorize("@ss.hasPermi('resources:circle:export')")
    @Log(title = "圈子", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Circle circle)
    {
        List<Circle> list = circleService.selectCircleList(circle);
        ExcelUtil<Circle> util = new ExcelUtil<Circle>(Circle.class);
        util.exportExcel(response, list, "圈子数据");
    }

    /**
     * 获取圈子详细信息
     */
    @PreAuthorize("@ss.hasPermi('resources:circle:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(circleService.selectCircleById(id));
    }

    /**
     * 新增圈子
     */
    @PreAuthorize("@ss.hasPermi('resources:circle:add')")
    @Log(title = "圈子", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Circle circle)
    {
        return toAjax(circleService.insertCircle(circle));
    }

    /**
     * 修改圈子
     */
    @PreAuthorize("@ss.hasPermi('resources:circle:edit')")
    @Log(title = "圈子", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Circle circle)
    {
        return toAjax(circleService.updateCircle(circle));
    }

    /**
     * 删除圈子
     */
    @PreAuthorize("@ss.hasPermi('resources:circle:remove')")
    @Log(title = "圈子", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(circleService.deleteCircleByIds(ids));
    }
}
