package com.ruoyi.users.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.users.domain.UAttribute;

/**
 * 用户属性Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_USERS)//切换数据源
public interface UAttributeMapper
{
    /**
     * 查询用户属性
     *
     * @param id 用户属性主键
     * @return 用户属性
     */
    public UAttribute selectUAttributeById(Long id);

    /**
     * 查询用户属性列表
     *
     * @param uAttribute 用户属性
     * @return 用户属性集合
     */
    public List<UAttribute> selectUAttributeList(UAttribute uAttribute);

    /**
     * 新增用户属性
     *
     * @param uAttribute 用户属性
     * @return 结果
     */
    public int insertUAttribute(UAttribute uAttribute);

    /**
     * 修改用户属性
     *
     * @param uAttribute 用户属性
     * @return 结果
     */
    public int updateUAttribute(UAttribute uAttribute);

    /**
     * 删除用户属性
     *
     * @param id 用户属性主键
     * @return 结果
     */
    public int deleteUAttributeById(Long id);

    /**
     * 批量删除用户属性
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUAttributeByIds(Long[] ids);
}
