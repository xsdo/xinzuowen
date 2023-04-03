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
import com.ruoyi.users.domain.UQuestion;
import com.ruoyi.users.service.IUQuestionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 问题反馈Controller
 * 
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/users/question")
public class UQuestionController extends BaseController
{
    @Autowired
    private IUQuestionService uQuestionService;

    /**
     * 查询问题反馈列表
     */
    @PreAuthorize("@ss.hasPermi('users:question:list')")
    @GetMapping("/list")
    public TableDataInfo list(UQuestion uQuestion)
    {
        startPage();
        List<UQuestion> list = uQuestionService.selectUQuestionList(uQuestion);
        return getDataTable(list);
    }

    /**
     * 导出问题反馈列表
     */
    @PreAuthorize("@ss.hasPermi('users:question:export')")
    @Log(title = "问题反馈", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UQuestion uQuestion)
    {
        List<UQuestion> list = uQuestionService.selectUQuestionList(uQuestion);
        ExcelUtil<UQuestion> util = new ExcelUtil<UQuestion>(UQuestion.class);
        util.exportExcel(response, list, "问题反馈数据");
    }

    /**
     * 获取问题反馈详细信息
     */
    @PreAuthorize("@ss.hasPermi('users:question:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(uQuestionService.selectUQuestionById(id));
    }

    /**
     * 新增问题反馈
     */
    @PreAuthorize("@ss.hasPermi('users:question:add')")
    @Log(title = "问题反馈", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UQuestion uQuestion)
    {
        return toAjax(uQuestionService.insertUQuestion(uQuestion));
    }

    /**
     * 修改问题反馈
     */
    @PreAuthorize("@ss.hasPermi('users:question:edit')")
    @Log(title = "问题反馈", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UQuestion uQuestion)
    {
        return toAjax(uQuestionService.updateUQuestion(uQuestion));
    }

    /**
     * 删除问题反馈
     */
    @PreAuthorize("@ss.hasPermi('users:question:remove')")
    @Log(title = "问题反馈", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(uQuestionService.deleteUQuestionByIds(ids));
    }
}
