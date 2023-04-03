package com.ruoyi.users.service;

import java.util.List;
import com.ruoyi.users.domain.XzwUser;

/**
 * 用户Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface IXzwUserService 
{
    /**
     * 查询用户
     * 
     * @param id 用户主键
     * @return 用户
     */
    public XzwUser selectXzwUserById(Long id);

    /**
     * 查询用户列表
     * 
     * @param xzwUser 用户
     * @return 用户集合
     */
    public List<XzwUser> selectXzwUserList(XzwUser xzwUser);

    /**
     * 新增用户
     * 
     * @param xzwUser 用户
     * @return 结果
     */
    public int insertXzwUser(XzwUser xzwUser);

    /**
     * 修改用户
     * 
     * @param xzwUser 用户
     * @return 结果
     */
    public int updateXzwUser(XzwUser xzwUser);

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的用户主键集合
     * @return 结果
     */
    public int deleteXzwUserByIds(Long[] ids);

    /**
     * 删除用户信息
     * 
     * @param id 用户主键
     * @return 结果
     */
    public int deleteXzwUserById(Long id);
}
