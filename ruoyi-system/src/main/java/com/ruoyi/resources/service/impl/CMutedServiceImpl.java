package com.ruoyi.resources.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.CMutedMapper;
import com.ruoyi.resources.domain.CMuted;
import com.ruoyi.resources.service.ICMutedService;

/**
 * 禁言Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class CMutedServiceImpl implements ICMutedService 
{
    @Autowired
    private CMutedMapper cMutedMapper;

    /**
     * 查询禁言
     * 
     * @param id 禁言主键
     * @return 禁言
     */
    @Override
    public CMuted selectCMutedById(Long id)
    {
        return cMutedMapper.selectCMutedById(id);
    }

    /**
     * 查询禁言列表
     * 
     * @param cMuted 禁言
     * @return 禁言
     */
    @Override
    public List<CMuted> selectCMutedList(CMuted cMuted)
    {
        return cMutedMapper.selectCMutedList(cMuted);
    }

    /**
     * 新增禁言
     * 
     * @param cMuted 禁言
     * @return 结果
     */
    @Override
    public int insertCMuted(CMuted cMuted)
    {
        cMuted.setCreateTime(DateUtils.getNowDate());
        return cMutedMapper.insertCMuted(cMuted);
    }

    /**
     * 修改禁言
     * 
     * @param cMuted 禁言
     * @return 结果
     */
    @Override
    public int updateCMuted(CMuted cMuted)
    {
        cMuted.setUpdateTime(DateUtils.getNowDate());
        return cMutedMapper.updateCMuted(cMuted);
    }

    /**
     * 批量删除禁言
     * 
     * @param ids 需要删除的禁言主键
     * @return 结果
     */
    @Override
    public int deleteCMutedByIds(Long[] ids)
    {
        return cMutedMapper.deleteCMutedByIds(ids);
    }

    /**
     * 删除禁言信息
     * 
     * @param id 禁言主键
     * @return 结果
     */
    @Override
    public int deleteCMutedById(Long id)
    {
        return cMutedMapper.deleteCMutedById(id);
    }
}
