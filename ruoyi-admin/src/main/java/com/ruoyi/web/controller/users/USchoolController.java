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
import com.ruoyi.users.domain.USchool;
import com.ruoyi.users.service.IUSchoolService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户学校Controller
 * 
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/users/school")
public class USchoolController extends BaseController
{
    @Autowired
    private IUSchoolService uSchoolService;

    /**
     * 查询用户学校列表
     */
    @PreAuthorize("@ss.hasPermi('users:school:list')")
    @GetMapping("/list")
    public TableDataInfo list(USchool uSchool)
    {
        startPage();
        List<USchool> list = uSchoolService.selectUSchoolList(uSchool);
        if (list!=null && list.size() > 0) {
            for (USchool s: list) {
                if (s.getQrCode()==null){
                    uSchoolService.schoolQRCodePress(s.getId());
                }
            }
        }
        return getDataTable(list);
    }

    /**
     * 导出用户学校列表
     */
    @PreAuthorize("@ss.hasPermi('users:school:export')")
    @Log(title = "用户学校", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, USchool uSchool)
    {
        List<USchool> list = uSchoolService.selectUSchoolList(uSchool);
        ExcelUtil<USchool> util = new ExcelUtil<USchool>(USchool.class);
        util.exportExcel(response, list, "用户学校数据");
    }

    /**
     * 获取用户学校详细信息
     */
    @PreAuthorize("@ss.hasPermi('users:school:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(uSchoolService.selectUSchoolById(id));
    }

    @GetMapping("schoolQRCode")
    public USchool schoolQRCode(Long schoolId){
        return uSchoolService.schoolQRCodePress(schoolId);
    }
    /**
     * 新增用户学校
     */
    @PreAuthorize("@ss.hasPermi('users:school:add')")
    @Log(title = "用户学校", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody USchool uSchool)
    {
        return toAjax(uSchoolService.insertUSchool(uSchool));
    }

    /**
     * 修改用户学校
     */
    @PreAuthorize("@ss.hasPermi('users:school:edit')")
    @Log(title = "用户学校", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody USchool uSchool)
    {
        return toAjax(uSchoolService.updateUSchool(uSchool));
    }

    /**
     * 删除用户学校
     */
    @PreAuthorize("@ss.hasPermi('users:school:remove')")
    @Log(title = "用户学校", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(uSchoolService.deleteUSchoolByIds(ids));
    }
}
