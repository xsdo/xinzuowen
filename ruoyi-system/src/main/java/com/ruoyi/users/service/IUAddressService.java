package com.ruoyi.users.service;

import java.util.List;
import com.ruoyi.users.domain.UAddress;

/**
 * 用户地址Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface IUAddressService 
{
    /**
     * 查询用户地址
     * 
     * @param id 用户地址主键
     * @return 用户地址
     */
    public UAddress selectUAddressById(Long id);

    /**
     * 查询用户地址列表
     * 
     * @param uAddress 用户地址
     * @return 用户地址集合
     */
    public List<UAddress> selectUAddressList(UAddress uAddress);

    /**
     * 新增用户地址
     * 
     * @param uAddress 用户地址
     * @return 结果
     */
    public int insertUAddress(UAddress uAddress);

    /**
     * 修改用户地址
     * 
     * @param uAddress 用户地址
     * @return 结果
     */
    public int updateUAddress(UAddress uAddress);

    /**
     * 批量删除用户地址
     * 
     * @param ids 需要删除的用户地址主键集合
     * @return 结果
     */
    public int deleteUAddressByIds(Long[] ids);

    /**
     * 删除用户地址信息
     * 
     * @param id 用户地址主键
     * @return 结果
     */
    public int deleteUAddressById(Long id);
}
