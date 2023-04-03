package com.ruoyi.tasks.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.tasks.mapper.AuthTaskMapper;
import com.ruoyi.tasks.domain.AuthTask;
import com.ruoyi.tasks.service.IAuthTaskService;

/**
 * 认证任务Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class AuthTaskServiceImpl implements IAuthTaskService 
{
    @Autowired
    private AuthTaskMapper authTaskMapper;

    /**
     * 查询认证任务
     * 
     * @param id 认证任务主键
     * @return 认证任务
     */
    @Override
    public AuthTask selectAuthTaskById(Long id)
    {
        return authTaskMapper.selectAuthTaskById(id);
    }

    /**
     * 查询认证任务列表
     * 
     * @param authTask 认证任务
     * @return 认证任务
     */
    @Override
    public List<AuthTask> selectAuthTaskList(AuthTask authTask)
    {
        return authTaskMapper.selectAuthTaskList(authTask);
    }

    /**
     * 新增认证任务
     * 
     * @param authTask 认证任务
     * @return 结果
     */
    @Override
    public int insertAuthTask(AuthTask authTask)
    {
        authTask.setCreateTime(DateUtils.getNowDate());
        return authTaskMapper.insertAuthTask(authTask);
    }

    /**
     * 修改认证任务
     * 
     * @param authTask 认证任务
     * @return 结果
     */
    @Override
    public int updateAuthTask(AuthTask authTask)
    {
        authTask.setUpdateTime(DateUtils.getNowDate());
        return authTaskMapper.updateAuthTask(authTask);
    }

    /**
     * 批量删除认证任务
     * 
     * @param ids 需要删除的认证任务主键
     * @return 结果
     */
    @Override
    public int deleteAuthTaskByIds(Long[] ids)
    {
        return authTaskMapper.deleteAuthTaskByIds(ids);
    }

    /**
     * 删除认证任务信息
     * 
     * @param id 认证任务主键
     * @return 结果
     */
    @Override
    public int deleteAuthTaskById(Long id)
    {
        return authTaskMapper.deleteAuthTaskById(id);
    }
}
