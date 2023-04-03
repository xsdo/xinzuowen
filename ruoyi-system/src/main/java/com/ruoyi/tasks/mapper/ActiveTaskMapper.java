package com.ruoyi.tasks.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.tasks.domain.ActiveTask;

/**
 * 活动任务Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_TASKS)//切换数据源
public interface ActiveTaskMapper
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
     * 删除活动任务
     *
     * @param id 活动任务主键
     * @return 结果
     */
    public int deleteActiveTaskById(Long id);

    /**
     * 批量删除活动任务
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteActiveTaskByIds(Long[] ids);
}
