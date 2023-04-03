package com.ruoyi.users.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.users.mapper.UAttributeMapper;
import com.ruoyi.users.domain.UAttribute;
import com.ruoyi.users.service.IUAttributeService;

/**
 * 用户属性Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class UAttributeServiceImpl implements IUAttributeService 
{
    @Autowired
    private UAttributeMapper uAttributeMapper;

    /**
     * 查询用户属性
     * 
     * @param id 用户属性主键
     * @return 用户属性
     */
    @Override
    public UAttribute selectUAttributeById(Long id)
    {
        return uAttributeMapper.selectUAttributeById(id);
    }

    /**
     * 查询用户属性列表
     * 
     * @param uAttribute 用户属性
     * @return 用户属性
     */
    @Override
    public List<UAttribute> selectUAttributeList(UAttribute uAttribute)
    {
        return uAttributeMapper.selectUAttributeList(uAttribute);
    }

    /**
     * 新增用户属性
     * 
     * @param uAttribute 用户属性
     * @return 结果
     */
    @Override
    public int insertUAttribute(UAttribute uAttribute)
    {
        uAttribute.setCreateTime(DateUtils.getNowDate());
        return uAttributeMapper.insertUAttribute(uAttribute);
    }

    /**
     * 修改用户属性
     * 
     * @param uAttribute 用户属性
     * @return 结果
     */
    @Override
    public int updateUAttribute(UAttribute uAttribute)
    {
        uAttribute.setUpdateTime(DateUtils.getNowDate());
        return uAttributeMapper.updateUAttribute(uAttribute);
    }

    /**
     * 批量删除用户属性
     * 
     * @param ids 需要删除的用户属性主键
     * @return 结果
     */
    @Override
    public int deleteUAttributeByIds(Long[] ids)
    {
        return uAttributeMapper.deleteUAttributeByIds(ids);
    }

    /**
     * 删除用户属性信息
     * 
     * @param id 用户属性主键
     * @return 结果
     */
    @Override
    public int deleteUAttributeById(Long id)
    {
        return uAttributeMapper.deleteUAttributeById(id);
    }
}
