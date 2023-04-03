package com.ruoyi.tasks.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.tasks.mapper.RotationTaskMapper;
import com.ruoyi.tasks.domain.RotationTask;
import com.ruoyi.tasks.service.IRotationTaskService;

/**
 * 轮播图Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class RotationTaskServiceImpl implements IRotationTaskService 
{
    @Autowired
    private RotationTaskMapper rotationTaskMapper;

    /**
     * 查询轮播图
     * 
     * @param id 轮播图主键
     * @return 轮播图
     */
    @Override
    public RotationTask selectRotationTaskById(Long id)
    {
        return rotationTaskMapper.selectRotationTaskById(id);
    }

    /**
     * 查询轮播图列表
     * 
     * @param rotationTask 轮播图
     * @return 轮播图
     */
    @Override
    public List<RotationTask> selectRotationTaskList(RotationTask rotationTask)
    {
        return rotationTaskMapper.selectRotationTaskList(rotationTask);
    }

    /**
     * 新增轮播图
     * 
     * @param rotationTask 轮播图
     * @return 结果
     */
    @Override
    public int insertRotationTask(RotationTask rotationTask)
    {
        rotationTask.setCreateTime(DateUtils.getNowDate());
        return rotationTaskMapper.insertRotationTask(rotationTask);
    }

    /**
     * 修改轮播图
     * 
     * @param rotationTask 轮播图
     * @return 结果
     */
    @Override
    public int updateRotationTask(RotationTask rotationTask)
    {
        rotationTask.setUpdateTime(DateUtils.getNowDate());
        return rotationTaskMapper.updateRotationTask(rotationTask);
    }

    /**
     * 批量删除轮播图
     * 
     * @param ids 需要删除的轮播图主键
     * @return 结果
     */
    @Override
    public int deleteRotationTaskByIds(Long[] ids)
    {
        return rotationTaskMapper.deleteRotationTaskByIds(ids);
    }

    /**
     * 删除轮播图信息
     * 
     * @param id 轮播图主键
     * @return 结果
     */
    @Override
    public int deleteRotationTaskById(Long id)
    {
        return rotationTaskMapper.deleteRotationTaskById(id);
    }
}
