package com.ruoyi.users.service;

import java.util.List;
import com.ruoyi.users.domain.UAttribute;

/**
 * 用户属性Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface IUAttributeService 
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
     * 批量删除用户属性
     * 
     * @param ids 需要删除的用户属性主键集合
     * @return 结果
     */
    public int deleteUAttributeByIds(Long[] ids);

    /**
     * 删除用户属性信息
     * 
     * @param id 用户属性主键
     * @return 结果
     */
    public int deleteUAttributeById(Long id);
}
