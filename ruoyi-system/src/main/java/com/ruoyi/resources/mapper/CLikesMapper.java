package com.ruoyi.resources.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.resources.domain.CLikes;

/**
 * 用户点赞Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_RESOURCES)//切换数据源
public interface CLikesMapper
{
    /**
     * 查询用户点赞
     *
     * @param id 用户点赞主键
     * @return 用户点赞
     */
    public CLikes selectCLikesById(Long id);

    /**
     * 查询用户点赞列表
     *
     * @param cLikes 用户点赞
     * @return 用户点赞集合
     */
    public List<CLikes> selectCLikesList(CLikes cLikes);

    /**
     * 新增用户点赞
     *
     * @param cLikes 用户点赞
     * @return 结果
     */
    public int insertCLikes(CLikes cLikes);

    /**
     * 修改用户点赞
     *
     * @param cLikes 用户点赞
     * @return 结果
     */
    public int updateCLikes(CLikes cLikes);

    /**
     * 删除用户点赞
     *
     * @param id 用户点赞主键
     * @return 结果
     */
    public int deleteCLikesById(Long id);

    /**
     * 批量删除用户点赞
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCLikesByIds(Long[] ids);
}
