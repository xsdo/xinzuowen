package com.ruoyi.tasks.service;

import java.util.List;
import com.ruoyi.tasks.domain.ActiveTask;

/**
 * 活动任务Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface IActiveTaskService 
{
    /**
     * 查询活动任务
     * 
     * @param id 活动任务主键
     * @return 活动任务
     */
    public ActiveTask selectActiveTaskById(Long id);

    /**
     * 查询活动任务列表
     * 
     * @param activeTask 活动任务
     * @return 活动任务集合
     */
    public List<ActiveTask> selectActiveTaskList(ActiveTask activeTask);

    /**
     * 新增活动任务
     * 
     * @param activeTask 活动任务
     * @return 结果
     */
    public int insertActiveTask(ActiveTask activeTask);

    /**
     * 修改活动任务
     * 
     * @param activeTask 活动任务
     * @return 结果
     */
    public int updateActiveTask(ActiveTask activeTask);

    /**
     * 批量删除活动任务
     * 
     * @param ids 需要删除的活动任务主键集合
     * @return 结果
     */
    public int deleteActiveTaskByIds(Long[] ids);

    /**
     * 删除活动任务信息
     * 
     * @param id 活动任务主键
     * @return 结果
     */
    public int deleteActiveTaskById(Long id);
}
