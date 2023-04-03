package com.ruoyi.resources.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.CDiscussMapper;
import com.ruoyi.resources.domain.CDiscuss;
import com.ruoyi.resources.service.ICDiscussService;

/**
 * 评论Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class CDiscussServiceImpl implements ICDiscussService 
{
    @Autowired
    private CDiscussMapper cDiscussMapper;

    /**
     * 查询评论
     * 
     * @param id 评论主键
     * @return 评论
     */
    @Override
    public CDiscuss selectCDiscussById(Long id)
    {
        return cDiscussMapper.selectCDiscussById(id);
    }

    /**
     * 查询评论列表
     * 
     * @param cDiscuss 评论
     * @return 评论
     */
    @Override
    public List<CDiscuss> selectCDiscussList(CDiscuss cDiscuss)
    {
        return cDiscussMapper.selectCDiscussList(cDiscuss);
    }

    /**
     * 新增评论
     * 
     * @param cDiscuss 评论
     * @return 结果
     */
    @Override
    public int insertCDiscuss(CDiscuss cDiscuss)
    {
        cDiscuss.setCreateTime(DateUtils.getNowDate());
        return cDiscussMapper.insertCDiscuss(cDiscuss);
    }

    /**
     * 修改评论
     * 
     * @param cDiscuss 评论
     * @return 结果
     */
    @Override
    public int updateCDiscuss(CDiscuss cDiscuss)
    {
        cDiscuss.setUpdateTime(DateUtils.getNowDate());
        return cDiscussMapper.updateCDiscuss(cDiscuss);
    }

    /**
     * 批量删除评论
     * 
     * @param ids 需要删除的评论主键
     * @return 结果
     */
    @Override
    public int deleteCDiscussByIds(Long[] ids)
    {
        return cDiscussMapper.deleteCDiscussByIds(ids);
    }

    /**
     * 删除评论信息
     * 
     * @param id 评论主键
     * @return 结果
     */
    @Override
    public int deleteCDiscussById(Long id)
    {
        return cDiscussMapper.deleteCDiscussById(id);
    }
}
