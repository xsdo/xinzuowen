package com.ruoyi.resources.service;

import java.util.List;
import com.ruoyi.resources.domain.CDiscuss;

/**
 * 评论Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface ICDiscussService 
{
    /**
     * 查询评论
     * 
     * @param id 评论主键
     * @return 评论
     */
    public CDiscuss selectCDiscussById(Long id);

    /**
     * 查询评论列表
     * 
     * @param cDiscuss 评论
     * @return 评论集合
     */
    public List<CDiscuss> selectCDiscussList(CDiscuss cDiscuss);

    /**
     * 新增评论
     * 
     * @param cDiscuss 评论
     * @return 结果
     */
    public int insertCDiscuss(CDiscuss cDiscuss);

    /**
     * 修改评论
     * 
     * @param cDiscuss 评论
     * @return 结果
     */
    public int updateCDiscuss(CDiscuss cDiscuss);

    /**
     * 批量删除评论
     * 
     * @param ids 需要删除的评论主键集合
     * @return 结果
     */
    public int deleteCDiscussByIds(Long[] ids);

    /**
     * 删除评论信息
     * 
     * @param id 评论主键
     * @return 结果
     */
    public int deleteCDiscussById(Long id);
}
