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
import com.ruoyi.resources.domain.CSchool;
import com.ruoyi.resources.service.ICSchoolService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 校园作文Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/resources/school")
public class CSchoolController extends BaseController
{
    @Autowired
    private ICSchoolService cSchoolService;

    /**
     * 查询校园作文列表
     */
    @PreAuthorize("@ss.hasPermi('resources:school:list')")
    @GetMapping("/list")
    public TableDataInfo list(CSchool cSchool)
    {
        startPage();
        List<CSchool> list = cSchoolService.selectCSchoolList(cSchool);
        return getDataTable(list);
    }

    /**
     * 导出校园作文列表
     */
    @PreAuthorize("@ss.hasPermi('resources:school:export')")
    @Log(title = "校园作文", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CSchool cSchool)
    {
        List<CSchool> list = cSchoolService.selectCSchoolList(cSchool);
        ExcelUtil<CSchool> util = new ExcelUtil<CSchool>(CSchool.class);
        util.exportExcel(response, list, "校园作文数据");
    }

    /**
     * 获取校园作文详细信息
     */
    @PreAuthorize("@ss.hasPermi('resources:school:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cSchoolService.selectCSchoolById(id));
    }

    /**
     * 新增校园作文
     */
    @PreAuthorize("@ss.hasPermi('resources:school:add')")
    @Log(title = "校园作文", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CSchool cSchool)
    {
        return toAjax(cSchoolService.insertCSchool(cSchool));
    }

    /**
     * 修改校园作文
     */
    @PreAuthorize("@ss.hasPermi('resources:school:edit')")
    @Log(title = "校园作文", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CSchool cSchool)
    {
        return toAjax(cSchoolService.updateCSchool(cSchool));
    }

    /**
     * 删除校园作文
     */
    @PreAuthorize("@ss.hasPermi('resources:school:remove')")
    @Log(title = "校园作文", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cSchoolService.deleteCSchoolByIds(ids));
    }
}
