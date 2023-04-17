package com.ruoyi.resources.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.ReadContestMapper;
import com.ruoyi.resources.domain.ReadContest;
import com.ruoyi.resources.service.IReadContestService;

/**
 * 活动参赛Service业务层处理
 * 
 * @author xqq
 * @date 2023-04-17
 */
@Service
public class ReadContestServiceImpl implements IReadContestService 
{
    @Autowired
    private ReadContestMapper readContestMapper;

    /**
     * 查询活动参赛
     * 
     * @param id 活动参赛主键
     * @return 活动参赛
     */
    @Override
    public ReadContest selectReadContestById(Long id)
    {
        return readContestMapper.selectReadContestById(id);
    }

    /**
     * 查询活动参赛列表
     * 
     * @param readContest 活动参赛
     * @return 活动参赛
     */
    @Override
    public List<ReadContest> selectReadContestList(ReadContest readContest)
    {
        return readContestMapper.selectReadContestList(readContest);
    }

    /**
     * 新增活动参赛
     * 
     * @param readContest 活动参赛
     * @return 结果
     */
    @Override
    public int insertReadContest(ReadContest readContest)
    {
        readContest.setCreateTime(DateUtils.getNowDate());
        return readContestMapper.insertReadContest(readContest);
    }

    /**
     * 修改活动参赛
     * 
     * @param readContest 活动参赛
     * @return 结果
     */
    @Override
    public int updateReadContest(ReadContest readContest)
    {
        readContest.setUpdateTime(DateUtils.getNowDate());
        return readContestMapper.updateReadContest(readContest);
    }

    /**
     * 批量删除活动参赛
     * 
     * @param ids 需要删除的活动参赛主键
     * @return 结果
     */
    @Override
    public int deleteReadContestByIds(Long[] ids)
    {
        return readContestMapper.deleteReadContestByIds(ids);
    }

    /**
     * 删除活动参赛信息
     * 
     * @param id 活动参赛主键
     * @return 结果
     */
    @Override
    public int deleteReadContestById(Long id)
    {
        return readContestMapper.deleteReadContestById(id);
    }
}
