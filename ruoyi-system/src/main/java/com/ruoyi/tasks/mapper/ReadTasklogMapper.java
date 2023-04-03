package com.ruoyi.tasks.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.tasks.domain.ReadTasklog;

/**
 * 阅读任务记录Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_TASKS)//切换数据源
public interface ReadTasklogMapper
{
    /**
     * 查询阅读任务记录
     *
     * @param id 阅读任务记录主键
     * @return 阅读任务记录
     */
    public ReadTasklog selectReadTasklogById(Long id);

    /**
     * 查询阅读任务记录列表
     *
     * @param readTasklog 阅读任务记录
     * @return 阅读任务记录集合
     */
    public List<ReadTasklog> selectReadTasklogList(ReadTasklog readTasklog);

    /**
     * 新增阅读任务记录
     *
     * @param readTasklog 阅读任务记录
     * @return 结果
     */
    public int insertReadTasklog(ReadTasklog readTasklog);

    /**
     * 修改阅读任务记录
     *
     * @param readTasklog 阅读任务记录
     * @return 结果
     */
    public int updateReadTasklog(ReadTasklog readTasklog);

    /**
     * 删除阅读任务记录
     *
     * @param id 阅读任务记录主键
     * @return 结果
     */
    public int deleteReadTasklogById(Long id);

    /**
     * 批量删除阅读任务记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReadTasklogByIds(Long[] ids);
}
