package com.ruoyi.tasks.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.tasks.mapper.ReadTaskMapper;
import com.ruoyi.tasks.domain.ReadTask;
import com.ruoyi.tasks.service.IReadTaskService;

/**
 * 阅读任务Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class ReadTaskServiceImpl implements IReadTaskService 
{
    @Autowired
    private ReadTaskMapper readTaskMapper;

    /**
     * 查询阅读任务
     * 
     * @param id 阅读任务主键
     * @return 阅读任务
     */
    @Override
    public ReadTask selectReadTaskById(Long id)
    {
        return readTaskMapper.selectReadTaskById(id);
    }

    /**
     * 查询阅读任务列表
     * 
     * @param readTask 阅读任务
     * @return 阅读任务
     */
    @Override
    public List<ReadTask> selectReadTaskList(ReadTask readTask)
    {
        return readTaskMapper.selectReadTaskList(readTask);
    }

    /**
     * 新增阅读任务
     * 
     * @param readTask 阅读任务
     * @return 结果
     */
    @Override
    public int insertReadTask(ReadTask readTask)
    {
        readTask.setCreateTime(DateUtils.getNowDate());
        return readTaskMapper.insertReadTask(readTask);
    }

    /**
     * 修改阅读任务
     * 
     * @param readTask 阅读任务
     * @return 结果
     */
    @Override
    public int updateReadTask(ReadTask readTask)
    {
        readTask.setUpdateTime(DateUtils.getNowDate());
        return readTaskMapper.updateReadTask(readTask);
    }

    /**
     * 批量删除阅读任务
     * 
     * @param ids 需要删除的阅读任务主键
     * @return 结果
     */
    @Override
    public int deleteReadTaskByIds(Long[] ids)
    {
        return readTaskMapper.deleteReadTaskByIds(ids);
    }

    /**
     * 删除阅读任务信息
     * 
     * @param id 阅读任务主键
     * @return 结果
     */
    @Override
    public int deleteReadTaskById(Long id)
    {
        return readTaskMapper.deleteReadTaskById(id);
    }
}
