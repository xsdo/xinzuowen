package com.ruoyi.tasks.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.tasks.mapper.ActiveTasklogMapper;
import com.ruoyi.tasks.domain.ActiveTasklog;
import com.ruoyi.tasks.service.IActiveTasklogService;

/**
 * 活动用户记录Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class ActiveTasklogServiceImpl implements IActiveTasklogService 
{
    @Autowired
    private ActiveTasklogMapper activeTasklogMapper;

    /**
     * 查询活动用户记录
     * 
     * @param id 活动用户记录主键
     * @return 活动用户记录
     */
    @Override
    public ActiveTasklog selectActiveTasklogById(Long id)
    {
        return activeTasklogMapper.selectActiveTasklogById(id);
    }

    /**
     * 查询活动用户记录列表
     * 
     * @param activeTasklog 活动用户记录
     * @return 活动用户记录
     */
    @Override
    public List<ActiveTasklog> selectActiveTasklogList(ActiveTasklog activeTasklog)
    {
        return activeTasklogMapper.selectActiveTasklogList(activeTasklog);
    }

    /**
     * 新增活动用户记录
     * 
     * @param activeTasklog 活动用户记录
     * @return 结果
     */
    @Override
    public int insertActiveTasklog(ActiveTasklog activeTasklog)
    {
        activeTasklog.setCreateTime(DateUtils.getNowDate());
        return activeTasklogMapper.insertActiveTasklog(activeTasklog);
    }

    /**
     * 修改活动用户记录
     * 
     * @param activeTasklog 活动用户记录
     * @return 结果
     */
    @Override
    public int updateActiveTasklog(ActiveTasklog activeTasklog)
    {
        activeTasklog.setUpdateTime(DateUtils.getNowDate());
        return activeTasklogMapper.updateActiveTasklog(activeTasklog);
    }

    /**
     * 批量删除活动用户记录
     * 
     * @param ids 需要删除的活动用户记录主键
     * @return 结果
     */
    @Override
    public int deleteActiveTasklogByIds(Long[] ids)
    {
        return activeTasklogMapper.deleteActiveTasklogByIds(ids);
    }

    /**
     * 删除活动用户记录信息
     * 
     * @param id 活动用户记录主键
     * @return 结果
     */
    @Override
    public int deleteActiveTasklogById(Long id)
    {
        return activeTasklogMapper.deleteActiveTasklogById(id);
    }
}
