package com.ruoyi.tasks.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.tasks.domain.ReadTask;

/**
 * 阅读任务Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_TASKS)//切换数据源
public interface ReadTaskMapper
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
     * 删除阅读任务
     *
     * @param id 阅读任务主键
     * @return 结果
     */
    public int deleteReadTaskById(Long id);

    /**
     * 批量删除阅读任务
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReadTaskByIds(Long[] ids);
}
