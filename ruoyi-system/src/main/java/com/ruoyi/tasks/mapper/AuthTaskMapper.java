package com.ruoyi.tasks.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.tasks.domain.AuthTask;

/**
 * 认证任务Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_TASKS)//切换数据源
public interface AuthTaskMapper
{
    /**
     * 查询认证任务
     *
     * @param id 认证任务主键
     * @return 认证任务
     */
    public AuthTask selectAuthTaskById(Long id);

    /**
     * 查询认证任务列表
     *
     * @param authTask 认证任务
     * @return 认证任务集合
     */
    public List<AuthTask> selectAuthTaskList(AuthTask authTask);

    /**
     * 新增认证任务
     *
     * @param authTask 认证任务
     * @return 结果
     */
    public int insertAuthTask(AuthTask authTask);

    /**
     * 修改认证任务
     *
     * @param authTask 认证任务
     * @return 结果
     */
    public int updateAuthTask(AuthTask authTask);

    /**
     * 删除认证任务
     *
     * @param id 认证任务主键
     * @return 结果
     */
    public int deleteAuthTaskById(Long id);

    /**
     * 批量删除认证任务
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAuthTaskByIds(Long[] ids);
}
