package com.ruoyi.resources.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.resources.domain.CDiscuss;

/**
 * 评论Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_RESOURCES)//切换数据源
public interface CDiscussMapper
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
     * 删除评论
     *
     * @param id 评论主键
     * @return 结果
     */
    public int deleteCDiscussById(Long id);

    /**
     * 批量删除评论
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCDiscussByIds(Long[] ids);
}
