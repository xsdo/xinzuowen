package com.ruoyi.tasks.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.tasks.domain.SuggestTask;

/**
 * 推荐作文Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_TASKS)//切换数据源
public interface SuggestTaskMapper
{
    /**
     * 查询推荐作文
     *
     * @param id 推荐作文主键
     * @return 推荐作文
     */
    public SuggestTask selectSuggestTaskById(Long id);

    /**
     * 查询推荐作文列表
     *
     * @param suggestTask 推荐作文
     * @return 推荐作文集合
     */
    public List<SuggestTask> selectSuggestTaskList(SuggestTask suggestTask);

    /**
     * 新增推荐作文
     *
     * @param suggestTask 推荐作文
     * @return 结果
     */
    public int insertSuggestTask(SuggestTask suggestTask);

    /**
     * 修改推荐作文
     *
     * @param suggestTask 推荐作文
     * @return 结果
     */
    public int updateSuggestTask(SuggestTask suggestTask);

    /**
     * 删除推荐作文
     *
     * @param id 推荐作文主键
     * @return 结果
     */
    public int deleteSuggestTaskById(Long id);

    /**
     * 批量删除推荐作文
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSuggestTaskByIds(Long[] ids);
}
