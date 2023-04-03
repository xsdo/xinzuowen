package com.ruoyi.tasks.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.tasks.domain.RotationTask;

/**
 * 轮播图Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_TASKS)//切换数据源
public interface RotationTaskMapper
{
    /**
     * 查询轮播图
     *
     * @param id 轮播图主键
     * @return 轮播图
     */
    public RotationTask selectRotationTaskById(Long id);

    /**
     * 查询轮播图列表
     *
     * @param rotationTask 轮播图
     * @return 轮播图集合
     */
    public List<RotationTask> selectRotationTaskList(RotationTask rotationTask);

    /**
     * 新增轮播图
     *
     * @param rotationTask 轮播图
     * @return 结果
     */
    public int insertRotationTask(RotationTask rotationTask);

    /**
     * 修改轮播图
     *
     * @param rotationTask 轮播图
     * @return 结果
     */
    public int updateRotationTask(RotationTask rotationTask);

    /**
     * 删除轮播图
     *
     * @param id 轮播图主键
     * @return 结果
     */
    public int deleteRotationTaskById(Long id);

    /**
     * 批量删除轮播图
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRotationTaskByIds(Long[] ids);
}
