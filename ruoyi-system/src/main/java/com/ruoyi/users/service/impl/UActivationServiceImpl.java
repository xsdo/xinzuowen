package com.ruoyi.users.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.users.mapper.UActivationMapper;
import com.ruoyi.users.domain.UActivation;
import com.ruoyi.users.service.IUActivationService;

/**
 * 激活码Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class UActivationServiceImpl implements IUActivationService 
{
    @Autowired
    private UActivationMapper uActivationMapper;

    /**
     * 查询激活码
     * 
     * @param id 激活码主键
     * @return 激活码
     */
    @Override
    public UActivation selectUActivationById(Long id)
    {
        return uActivationMapper.selectUActivationById(id);
    }

    /**
     * 查询激活码列表
     * 
     * @param uActivation 激活码
     * @return 激活码
     */
    @Override
    public List<UActivation> selectUActivationList(UActivation uActivation)
    {
        return uActivationMapper.selectUActivationList(uActivation);
    }

    /**
     * 新增激活码
     * 
     * @param uActivation 激活码
     * @return 结果
     */
    @Override
    public int insertUActivation(UActivation uActivation)
    {
        uActivation.setCreateTime(DateUtils.getNowDate());
        return uActivationMapper.insertUActivation(uActivation);
    }

    /**
     * 修改激活码
     * 
     * @param uActivation 激活码
     * @return 结果
     */
    @Override
    public int updateUActivation(UActivation uActivation)
    {
        uActivation.setUpdateTime(DateUtils.getNowDate());
        return uActivationMapper.updateUActivation(uActivation);
    }

    /**
     * 批量删除激活码
     * 
     * @param ids 需要删除的激活码主键
     * @return 结果
     */
    @Override
    public int deleteUActivationByIds(Long[] ids)
    {
        return uActivationMapper.deleteUActivationByIds(ids);
    }

    /**
     * 删除激活码信息
     * 
     * @param id 激活码主键
     * @return 结果
     */
    @Override
    public int deleteUActivationById(Long id)
    {
        return uActivationMapper.deleteUActivationById(id);
    }
}
