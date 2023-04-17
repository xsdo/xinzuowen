package com.ruoyi.resources.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.ReadEnrollMapper;
import com.ruoyi.resources.domain.ReadEnroll;
import com.ruoyi.resources.service.IReadEnrollService;

/**
 * 活动报名Service业务层处理
 * 
 * @author xqq
 * @date 2023-04-17
 */
@Service
public class ReadEnrollServiceImpl implements IReadEnrollService 
{
    @Autowired
    private ReadEnrollMapper readEnrollMapper;

    /**
     * 查询活动报名
     * 
     * @param id 活动报名主键
     * @return 活动报名
     */
    @Override
    public ReadEnroll selectReadEnrollById(Long id)
    {
        return readEnrollMapper.selectReadEnrollById(id);
    }

    /**
     * 查询活动报名列表
     * 
     * @param readEnroll 活动报名
     * @return 活动报名
     */
    @Override
    public List<ReadEnroll> selectReadEnrollList(ReadEnroll readEnroll)
    {
        return readEnrollMapper.selectReadEnrollList(readEnroll);
    }

    /**
     * 新增活动报名
     * 
     * @param readEnroll 活动报名
     * @return 结果
     */
    @Override
    public int insertReadEnroll(ReadEnroll readEnroll)
    {
        readEnroll.setCreateTime(DateUtils.getNowDate());
        return readEnrollMapper.insertReadEnroll(readEnroll);
    }

    /**
     * 修改活动报名
     * 
     * @param readEnroll 活动报名
     * @return 结果
     */
    @Override
    public int updateReadEnroll(ReadEnroll readEnroll)
    {
        readEnroll.setUpdateTime(DateUtils.getNowDate());
        return readEnrollMapper.updateReadEnroll(readEnroll);
    }

    /**
     * 批量删除活动报名
     * 
     * @param ids 需要删除的活动报名主键
     * @return 结果
     */
    @Override
    public int deleteReadEnrollByIds(Long[] ids)
    {
        return readEnrollMapper.deleteReadEnrollByIds(ids);
    }

    /**
     * 删除活动报名信息
     * 
     * @param id 活动报名主键
     * @return 结果
     */
    @Override
    public int deleteReadEnrollById(Long id)
    {
        return readEnrollMapper.deleteReadEnrollById(id);
    }
}
