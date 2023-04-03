package com.ruoyi.resources.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.resources.domain.Images;

/**
 * 随机图Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_RESOURCES)//切换数据源
public interface ImagesMapper
{
    /**
     * 查询随机图
     *
     * @param id 随机图主键
     * @return 随机图
     */
    public Images selectImagesById(Long id);

    /**
     * 查询随机图列表
     *
     * @param images 随机图
     * @return 随机图集合
     */
    public List<Images> selectImagesList(Images images);

    /**
     * 新增随机图
     *
     * @param images 随机图
     * @return 结果
     */
    public int insertImages(Images images);

    /**
     * 修改随机图
     *
     * @param images 随机图
     * @return 结果
     */
    public int updateImages(Images images);

    /**
     * 删除随机图
     *
     * @param id 随机图主键
     * @return 结果
     */
    public int deleteImagesById(Long id);

    /**
     * 批量删除随机图
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteImagesByIds(Long[] ids);
}
