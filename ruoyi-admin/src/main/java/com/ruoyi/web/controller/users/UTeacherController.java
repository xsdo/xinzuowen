package com.ruoyi.users.controller;

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
import com.ruoyi.users.domain.UTeacher;
import com.ruoyi.users.service.IUTeacherService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教师班级Controller
 * 
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/users/teacher")
public class UTeacherController extends BaseController
{
    @Autowired
    private IUTeacherService uTeacherService;

    /**
     * 查询教师班级列表
     */
    @PreAuthorize("@ss.hasPermi('users:teacher:list')")
    @GetMapping("/list")
    public TableDataInfo list(UTeacher uTeacher)
    {
        startPage();
        List<UTeacher> list = uTeacherService.selectUTeacherList(uTeacher);
        return getDataTable(list);
    }

    /**
     * 导出教师班级列表
     */
    @PreAuthorize("@ss.hasPermi('users:teacher:export')")
    @Log(title = "教师班级", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UTeacher uTeacher)
    {
        List<UTeacher> list = uTeacherService.selectUTeacherList(uTeacher);
        ExcelUtil<UTeacher> util = new ExcelUtil<UTeacher>(UTeacher.class);
        util.exportExcel(response, list, "教师班级数据");
    }

    /**
     * 获取教师班级详细信息
     */
    @PreAuthorize("@ss.hasPermi('users:teacher:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(uTeacherService.selectUTeacherById(id));
    }

    @GetMapping("teacherQRCode")
    public UTeacher teacherQRCode(Long teacherId){
        return uTeacherService.teacherQRCodePress(teacherId);
    }
    /**
     * 新增教师班级
     */
    @PreAuthorize("@ss.hasPermi('users:teacher:add')")
    @Log(title = "教师班级", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UTeacher uTeacher)
    {
        return toAjax(uTeacherService.insertUTeacher(uTeacher));
    }

    /**
     * 修改教师班级
     */
    @PreAuthorize("@ss.hasPermi('users:teacher:edit')")
    @Log(title = "教师班级", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UTeacher uTeacher)
    {
        return toAjax(uTeacherService.updateUTeacher(uTeacher));
    }

    /**
     * 删除教师班级
     */
    @PreAuthorize("@ss.hasPermi('users:teacher:remove')")
    @Log(title = "教师班级", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(uTeacherService.deleteUTeacherByIds(ids));
    }
}
