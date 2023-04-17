package com.ruoyi.resources.mapper;

import java.util.List;
import com.ruoyi.resources.domain.ReadContest;

/**
 * 活动参赛Mapper接口
 * 
 * @author xqq
 * @date 2023-04-17
 */
public interface ReadContestMapper 
{
    /**
     * 查询活动参赛
     * 
     * @param id 活动参赛主键
     * @return 活动参赛
     */
    public ReadContest selectReadContestById(Long id);

    /**
     * 查询活动参赛列表
     * 
     * @param readContest 活动参赛
     * @return 活动参赛集合
     */
    public List<ReadContest> selectReadContestList(ReadContest readContest);

    /**
     * 新增活动参赛
     * 
     * @param readContest 活动参赛
     * @return 结果
     */
    public int insertReadContest(ReadContest readContest);

    /**
     * 修改活动参赛
     * 
     * @param readContest 活动参赛
     * @return 结果
     */
    public int updateReadContest(ReadContest readContest);

    /**
     * 删除活动参赛
     * 
     * @param id 活动参赛主键
     * @return 结果
     */
    public int deleteReadContestById(Long id);

    /**
     * 批量删除活动参赛
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReadContestByIds(Long[] ids);
}
