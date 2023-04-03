package com.ruoyi.resources.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.resources.domain.CVideos;

/**
 * 视频Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_RESOURCES)//切换数据源
public interface CVideosMapper
{
    /**
     * 查询视频
     *
     * @param id 视频主键
     * @return 视频
     */
    public CVideos selectCVideosById(Long id);

    /**
     * 查询视频列表
     *
     * @param cVideos 视频
     * @return 视频集合
     */
    public List<CVideos> selectCVideosList(CVideos cVideos);

    /**
     * 新增视频
     *
     * @param cVideos 视频
     * @return 结果
     */
    public int insertCVideos(CVideos cVideos);

    /**
     * 修改视频
     *
     * @param cVideos 视频
     * @return 结果
     */
    public int updateCVideos(CVideos cVideos);

    /**
     * 删除视频
     *
     * @param id 视频主键
     * @return 结果
     */
    public int deleteCVideosById(Long id);

    /**
     * 批量删除视频
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCVideosByIds(Long[] ids);
}
