package com.ruoyi.tasks.service;

import java.util.List;
import com.ruoyi.tasks.domain.ReadTask;

/**
 * 阅读任务Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface IReadTaskService 
{
    /**
     * 查询阅读任务
     * 
     * @param id 阅读任务主键
     * @return 阅读任务
     */
    public ReadTask selectReadTaskById(Long id);

    /**
     * 查询阅读任务列表
     * 
     * @param readTask 阅读任务
     * @return 阅读任务集合
     */
    public List<ReadTask> selectReadTaskList(ReadTask readTask);

    /**
     * 新增阅读任务
     * 
     * @param readTask 阅读任务
     * @return 结果
     */
    public int insertReadTask(ReadTask readTask);

    /**
     * 修改阅读任务
     * 
     * @param readTask 阅读任务
     * @return 结果
     */
    public int updateReadTask(ReadTask readTask);

    /**
     * 批量删除阅读任务
     * 
     * @param ids 需要删除的阅读任务主键集合
     * @return 结果
     */
    public int deleteReadTaskByIds(Long[] ids);

    /**
     * 删除阅读任务信息
     * 
     * @param id 阅读任务主键
     * @return 结果
     */
    public int deleteReadTaskById(Long id);
}
