package com.ruoyi.users.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.users.domain.UAddress;

/**
 * 用户地址Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_USERS)//切换数据源
public interface UAddressMapper
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
     * 删除用户地址
     *
     * @param id 用户地址主键
     * @return 结果
     */
    public int deleteUAddressById(Long id);

    /**
     * 批量删除用户地址
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUAddressByIds(Long[] ids);
}
