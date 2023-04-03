package com.ruoyi.users.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.users.mapper.UAddressMapper;
import com.ruoyi.users.domain.UAddress;
import com.ruoyi.users.service.IUAddressService;

/**
 * 用户地址Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class UAddressServiceImpl implements IUAddressService 
{
    @Autowired
    private UAddressMapper uAddressMapper;

    /**
     * 查询用户地址
     * 
     * @param id 用户地址主键
     * @return 用户地址
     */
    @Override
    public UAddress selectUAddressById(Long id)
    {
        return uAddressMapper.selectUAddressById(id);
    }

    /**
     * 查询用户地址列表
     * 
     * @param uAddress 用户地址
     * @return 用户地址
     */
    @Override
    public List<UAddress> selectUAddressList(UAddress uAddress)
    {
        return uAddressMapper.selectUAddressList(uAddress);
    }

    /**
     * 新增用户地址
     * 
     * @param uAddress 用户地址
     * @return 结果
     */
    @Override
    public int insertUAddress(UAddress uAddress)
    {
        uAddress.setCreateTime(DateUtils.getNowDate());
        return uAddressMapper.insertUAddress(uAddress);
    }

    /**
     * 修改用户地址
     * 
     * @param uAddress 用户地址
     * @return 结果
     */
    @Override
    public int updateUAddress(UAddress uAddress)
    {
        uAddress.setUpdateTime(DateUtils.getNowDate());
        return uAddressMapper.updateUAddress(uAddress);
    }

    /**
     * 批量删除用户地址
     * 
     * @param ids 需要删除的用户地址主键
     * @return 结果
     */
    @Override
    public int deleteUAddressByIds(Long[] ids)
    {
        return uAddressMapper.deleteUAddressByIds(ids);
    }

    /**
     * 删除用户地址信息
     * 
     * @param id 用户地址主键
     * @return 结果
     */
    @Override
    public int deleteUAddressById(Long id)
    {
        return uAddressMapper.deleteUAddressById(id);
    }
}
