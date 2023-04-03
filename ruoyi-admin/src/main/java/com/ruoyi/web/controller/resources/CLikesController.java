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
import com.ruoyi.resources.domain.CLikes;
import com.ruoyi.resources.service.ICLikesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户点赞Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/resources/likes")
public class CLikesController extends BaseController
{
    @Autowired
    private ICLikesService cLikesService;

    /**
     * 查询用户点赞列表
     */
    @PreAuthorize("@ss.hasPermi('resources:likes:list')")
    @GetMapping("/list")
    public TableDataInfo list(CLikes cLikes)
    {
        startPage();
        List<CLikes> list = cLikesService.selectCLikesList(cLikes);
        return getDataTable(list);
    }

    /**
     * 导出用户点赞列表
     */
    @PreAuthorize("@ss.hasPermi('resources:likes:export')")
    @Log(title = "用户点赞", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CLikes cLikes)
    {
        List<CLikes> list = cLikesService.selectCLikesList(cLikes);
        ExcelUtil<CLikes> util = new ExcelUtil<CLikes>(CLikes.class);
        util.exportExcel(response, list, "用户点赞数据");
    }

    /**
     * 获取用户点赞详细信息
     */
    @PreAuthorize("@ss.hasPermi('resources:likes:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(cLikesService.selectCLikesById(id));
    }

    /**
     * 新增用户点赞
     */
    @PreAuthorize("@ss.hasPermi('resources:likes:add')")
    @Log(title = "用户点赞", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CLikes cLikes)
    {
        return toAjax(cLikesService.insertCLikes(cLikes));
    }

    /**
     * 修改用户点赞
     */
    @PreAuthorize("@ss.hasPermi('resources:likes:edit')")
    @Log(title = "用户点赞", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CLikes cLikes)
    {
        return toAjax(cLikesService.updateCLikes(cLikes));
    }

    /**
     * 删除用户点赞
     */
    @PreAuthorize("@ss.hasPermi('resources:likes:remove')")
    @Log(title = "用户点赞", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(cLikesService.deleteCLikesByIds(ids));
    }
}
