package com.ruoyi.tasks.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.tasks.mapper.SuggestTaskMapper;
import com.ruoyi.tasks.domain.SuggestTask;
import com.ruoyi.tasks.service.ISuggestTaskService;

/**
 * 推荐作文Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class SuggestTaskServiceImpl implements ISuggestTaskService 
{
    @Autowired
    private SuggestTaskMapper suggestTaskMapper;

    /**
     * 查询推荐作文
     * 
     * @param id 推荐作文主键
     * @return 推荐作文
     */
    @Override
    public SuggestTask selectSuggestTaskById(Long id)
    {
        return suggestTaskMapper.selectSuggestTaskById(id);
    }

    /**
     * 查询推荐作文列表
     * 
     * @param suggestTask 推荐作文
     * @return 推荐作文
     */
    @Override
    public List<SuggestTask> selectSuggestTaskList(SuggestTask suggestTask)
    {
        return suggestTaskMapper.selectSuggestTaskList(suggestTask);
    }

    /**
     * 新增推荐作文
     * 
     * @param suggestTask 推荐作文
     * @return 结果
     */
    @Override
    public int insertSuggestTask(SuggestTask suggestTask)
    {
        suggestTask.setCreateTime(DateUtils.getNowDate());
        return suggestTaskMapper.insertSuggestTask(suggestTask);
    }

    /**
     * 修改推荐作文
     * 
     * @param suggestTask 推荐作文
     * @return 结果
     */
    @Override
    public int updateSuggestTask(SuggestTask suggestTask)
    {
        suggestTask.setUpdateTime(DateUtils.getNowDate());
        return suggestTaskMapper.updateSuggestTask(suggestTask);
    }

    /**
     * 批量删除推荐作文
     * 
     * @param ids 需要删除的推荐作文主键
     * @return 结果
     */
    @Override
    public int deleteSuggestTaskByIds(Long[] ids)
    {
        return suggestTaskMapper.deleteSuggestTaskByIds(ids);
    }

    /**
     * 删除推荐作文信息
     * 
     * @param id 推荐作文主键
     * @return 结果
     */
    @Override
    public int deleteSuggestTaskById(Long id)
    {
        return suggestTaskMapper.deleteSuggestTaskById(id);
    }
}
