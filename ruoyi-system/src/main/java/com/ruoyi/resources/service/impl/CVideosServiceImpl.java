package com.ruoyi.resources.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.CVideosMapper;
import com.ruoyi.resources.domain.CVideos;
import com.ruoyi.resources.service.ICVideosService;

/**
 * 视频Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class CVideosServiceImpl implements ICVideosService 
{
    @Autowired
    private CVideosMapper cVideosMapper;

    /**
     * 查询视频
     * 
     * @param id 视频主键
     * @return 视频
     */
    @Override
    public CVideos selectCVideosById(Long id)
    {
        return cVideosMapper.selectCVideosById(id);
    }

    /**
     * 查询视频列表
     * 
     * @param cVideos 视频
     * @return 视频
     */
    @Override
    public List<CVideos> selectCVideosList(CVideos cVideos)
    {
        return cVideosMapper.selectCVideosList(cVideos);
    }

    /**
     * 新增视频
     * 
     * @param cVideos 视频
     * @return 结果
     */
    @Override
    public int insertCVideos(CVideos cVideos)
    {
        cVideos.setCreateTime(DateUtils.getNowDate());
        return cVideosMapper.insertCVideos(cVideos);
    }

    /**
     * 修改视频
     * 
     * @param cVideos 视频
     * @return 结果
     */
    @Override
    public int updateCVideos(CVideos cVideos)
    {
        cVideos.setUpdateTime(DateUtils.getNowDate());
        return cVideosMapper.updateCVideos(cVideos);
    }

    /**
     * 批量删除视频
     * 
     * @param ids 需要删除的视频主键
     * @return 结果
     */
    @Override
    public int deleteCVideosByIds(Long[] ids)
    {
        return cVideosMapper.deleteCVideosByIds(ids);
    }

    /**
     * 删除视频信息
     * 
     * @param id 视频主键
     * @return 结果
     */
    @Override
    public int deleteCVideosById(Long id)
    {
        return cVideosMapper.deleteCVideosById(id);
    }
}
