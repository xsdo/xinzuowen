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
import com.ruoyi.resources.domain.Images;
import com.ruoyi.resources.service.IImagesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 随机图Controller
 *
 * @author xqq
 * @date 2023-03-27
 */
@RestController
@RequestMapping("/resources/images")
public class ImagesController extends BaseController
{
    @Autowired
    private IImagesService imagesService;

    /**
     * 查询随机图列表
     */
    @PreAuthorize("@ss.hasPermi('resources:images:list')")
    @GetMapping("/list")
    public TableDataInfo list(Images images)
    {
        startPage();
        List<Images> list = imagesService.selectImagesList(images);
        return getDataTable(list);
    }

    /**
     * 导出随机图列表
     */
    @PreAuthorize("@ss.hasPermi('resources:images:export')")
    @Log(title = "随机图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Images images)
    {
        List<Images> list = imagesService.selectImagesList(images);
        ExcelUtil<Images> util = new ExcelUtil<Images>(Images.class);
        util.exportExcel(response, list, "随机图数据");
    }

    /**
     * 获取随机图详细信息
     */
    @PreAuthorize("@ss.hasPermi('resources:images:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(imagesService.selectImagesById(id));
    }

    /**
     * 新增随机图
     */
    @PreAuthorize("@ss.hasPermi('resources:images:add')")
    @Log(title = "随机图", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Images images)
    {
        return toAjax(imagesService.insertImages(images));
    }

    /**
     * 修改随机图
     */
    @PreAuthorize("@ss.hasPermi('resources:images:edit')")
    @Log(title = "随机图", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Images images)
    {
        return toAjax(imagesService.updateImages(images));
    }

    /**
     * 删除随机图
     */
    @PreAuthorize("@ss.hasPermi('resources:images:remove')")
    @Log(title = "随机图", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(imagesService.deleteImagesByIds(ids));
    }
}
