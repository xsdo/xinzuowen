package com.ruoyi.tasks.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.tasks.mapper.ReadTasklogMapper;
import com.ruoyi.tasks.domain.ReadTasklog;
import com.ruoyi.tasks.service.IReadTasklogService;

/**
 * 阅读任务记录Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class ReadTasklogServiceImpl implements IReadTasklogService 
{
    @Autowired
    private ReadTasklogMapper readTasklogMapper;

    /**
     * 查询阅读任务记录
     * 
     * @param id 阅读任务记录主键
     * @return 阅读任务记录
     */
    @Override
    public ReadTasklog selectReadTasklogById(Long id)
    {
        return readTasklogMapper.selectReadTasklogById(id);
    }

    /**
     * 查询阅读任务记录列表
     * 
     * @param readTasklog 阅读任务记录
     * @return 阅读任务记录
     */
    @Override
    public List<ReadTasklog> selectReadTasklogList(ReadTasklog readTasklog)
    {
        return readTasklogMapper.selectReadTasklogList(readTasklog);
    }

    /**
     * 新增阅读任务记录
     * 
     * @param readTasklog 阅读任务记录
     * @return 结果
     */
    @Override
    public int insertReadTasklog(ReadTasklog readTasklog)
    {
        readTasklog.setCreateTime(DateUtils.getNowDate());
        return readTasklogMapper.insertReadTasklog(readTasklog);
    }

    /**
     * 修改阅读任务记录
     * 
     * @param readTasklog 阅读任务记录
     * @return 结果
     */
    @Override
    public int updateReadTasklog(ReadTasklog readTasklog)
    {
        readTasklog.setUpdateTime(DateUtils.getNowDate());
        return readTasklogMapper.updateReadTasklog(readTasklog);
    }

    /**
     * 批量删除阅读任务记录
     * 
     * @param ids 需要删除的阅读任务记录主键
     * @return 结果
     */
    @Override
    public int deleteReadTasklogByIds(Long[] ids)
    {
        return readTasklogMapper.deleteReadTasklogByIds(ids);
    }

    /**
     * 删除阅读任务记录信息
     * 
     * @param id 阅读任务记录主键
     * @return 结果
     */
    @Override
    public int deleteReadTasklogById(Long id)
    {
        return readTasklogMapper.deleteReadTasklogById(id);
    }
}
