package com.ruoyi.tasks.service;

import java.util.List;
import com.ruoyi.tasks.domain.ActiveTasklog;

/**
 * 活动用户记录Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface IActiveTasklogService 
{
    /**
     * 查询活动用户记录
     * 
     * @param id 活动用户记录主键
     * @return 活动用户记录
     */
    public ActiveTasklog selectActiveTasklogById(Long id);

    /**
     * 查询活动用户记录列表
     * 
     * @param activeTasklog 活动用户记录
     * @return 活动用户记录集合
     */
    public List<ActiveTasklog> selectActiveTasklogList(ActiveTasklog activeTasklog);

    /**
     * 新增活动用户记录
     * 
     * @param activeTasklog 活动用户记录
     * @return 结果
     */
    public int insertActiveTasklog(ActiveTasklog activeTasklog);

    /**
     * 修改活动用户记录
     * 
     * @param activeTasklog 活动用户记录
     * @return 结果
     */
    public int updateActiveTasklog(ActiveTasklog activeTasklog);

    /**
     * 批量删除活动用户记录
     * 
     * @param ids 需要删除的活动用户记录主键集合
     * @return 结果
     */
    public int deleteActiveTasklogByIds(Long[] ids);

    /**
     * 删除活动用户记录信息
     * 
     * @param id 活动用户记录主键
     * @return 结果
     */
    public int deleteActiveTasklogById(Long id);
}
