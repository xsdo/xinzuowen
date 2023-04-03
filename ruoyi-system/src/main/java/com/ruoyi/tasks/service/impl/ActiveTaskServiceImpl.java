package com.ruoyi.tasks.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.tasks.mapper.ActiveTaskMapper;
import com.ruoyi.tasks.domain.ActiveTask;
import com.ruoyi.tasks.service.IActiveTaskService;

/**
 * 活动任务Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class ActiveTaskServiceImpl implements IActiveTaskService 
{
    @Autowired
    private ActiveTaskMapper activeTaskMapper;

    /**
     * 查询活动任务
     * 
     * @param id 活动任务主键
     * @return 活动任务
     */
    @Override
    public ActiveTask selectActiveTaskById(Long id)
    {
        return activeTaskMapper.selectActiveTaskById(id);
    }

    /**
     * 查询活动任务列表
     * 
     * @param activeTask 活动任务
     * @return 活动任务
     */
    @Override
    public List<ActiveTask> selectActiveTaskList(ActiveTask activeTask)
    {
        return activeTaskMapper.selectActiveTaskList(activeTask);
    }

    /**
     * 新增活动任务
     * 
     * @param activeTask 活动任务
     * @return 结果
     */
    @Override
    public int insertActiveTask(ActiveTask activeTask)
    {
        activeTask.setCreateTime(DateUtils.getNowDate());
        return activeTaskMapper.insertActiveTask(activeTask);
    }

    /**
     * 修改活动任务
     * 
     * @param activeTask 活动任务
     * @return 结果
     */
    @Override
    public int updateActiveTask(ActiveTask activeTask)
    {
        activeTask.setUpdateTime(DateUtils.getNowDate());
        return activeTaskMapper.updateActiveTask(activeTask);
    }

    /**
     * 批量删除活动任务
     * 
     * @param ids 需要删除的活动任务主键
     * @return 结果
     */
    @Override
    public int deleteActiveTaskByIds(Long[] ids)
    {
        return activeTaskMapper.deleteActiveTaskByIds(ids);
    }

    /**
     * 删除活动任务信息
     * 
     * @param id 活动任务主键
     * @return 结果
     */
    @Override
    public int deleteActiveTaskById(Long id)
    {
        return activeTaskMapper.deleteActiveTaskById(id);
    }
}
