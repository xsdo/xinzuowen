package com.ruoyi.resources.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.ImagesMapper;
import com.ruoyi.resources.domain.Images;
import com.ruoyi.resources.service.IImagesService;

/**
 * 随机图Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class ImagesServiceImpl implements IImagesService 
{
    @Autowired
    private ImagesMapper imagesMapper;

    /**
     * 查询随机图
     * 
     * @param id 随机图主键
     * @return 随机图
     */
    @Override
    public Images selectImagesById(Long id)
    {
        return imagesMapper.selectImagesById(id);
    }

    /**
     * 查询随机图列表
     * 
     * @param images 随机图
     * @return 随机图
     */
    @Override
    public List<Images> selectImagesList(Images images)
    {
        return imagesMapper.selectImagesList(images);
    }

    /**
     * 新增随机图
     * 
     * @param images 随机图
     * @return 结果
     */
    @Override
    public int insertImages(Images images)
    {
        return imagesMapper.insertImages(images);
    }

    /**
     * 修改随机图
     * 
     * @param images 随机图
     * @return 结果
     */
    @Override
    public int updateImages(Images images)
    {
        return imagesMapper.updateImages(images);
    }

    /**
     * 批量删除随机图
     * 
     * @param ids 需要删除的随机图主键
     * @return 结果
     */
    @Override
    public int deleteImagesByIds(Long[] ids)
    {
        return imagesMapper.deleteImagesByIds(ids);
    }

    /**
     * 删除随机图信息
     * 
     * @param id 随机图主键
     * @return 结果
     */
    @Override
    public int deleteImagesById(Long id)
    {
        return imagesMapper.deleteImagesById(id);
    }
}
