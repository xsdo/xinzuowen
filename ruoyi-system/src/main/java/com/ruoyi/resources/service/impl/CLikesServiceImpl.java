package com.ruoyi.resources.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.CLikesMapper;
import com.ruoyi.resources.domain.CLikes;
import com.ruoyi.resources.service.ICLikesService;

/**
 * 用户点赞Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class CLikesServiceImpl implements ICLikesService 
{
    @Autowired
    private CLikesMapper cLikesMapper;

    /**
     * 查询用户点赞
     * 
     * @param id 用户点赞主键
     * @return 用户点赞
     */
    @Override
    public CLikes selectCLikesById(Long id)
    {
        return cLikesMapper.selectCLikesById(id);
    }

    /**
     * 查询用户点赞列表
     * 
     * @param cLikes 用户点赞
     * @return 用户点赞
     */
    @Override
    public List<CLikes> selectCLikesList(CLikes cLikes)
    {
        return cLikesMapper.selectCLikesList(cLikes);
    }

    /**
     * 新增用户点赞
     * 
     * @param cLikes 用户点赞
     * @return 结果
     */
    @Override
    public int insertCLikes(CLikes cLikes)
    {
        cLikes.setCreateTime(DateUtils.getNowDate());
        return cLikesMapper.insertCLikes(cLikes);
    }

    /**
     * 修改用户点赞
     * 
     * @param cLikes 用户点赞
     * @return 结果
     */
    @Override
    public int updateCLikes(CLikes cLikes)
    {
        cLikes.setUpdateTime(DateUtils.getNowDate());
        return cLikesMapper.updateCLikes(cLikes);
    }

    /**
     * 批量删除用户点赞
     * 
     * @param ids 需要删除的用户点赞主键
     * @return 结果
     */
    @Override
    public int deleteCLikesByIds(Long[] ids)
    {
        return cLikesMapper.deleteCLikesByIds(ids);
    }

    /**
     * 删除用户点赞信息
     * 
     * @param id 用户点赞主键
     * @return 结果
     */
    @Override
    public int deleteCLikesById(Long id)
    {
        return cLikesMapper.deleteCLikesById(id);
    }
}
