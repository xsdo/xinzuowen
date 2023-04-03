package com.ruoyi.users.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.users.domain.XzwUser;

/**
 * 用户Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_USERS)//切换数据源
public interface XzwUserMapper
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
     * 删除用户
     *
     * @param id 用户主键
     * @return 结果
     */
    public int deleteXzwUserById(Long id);

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXzwUserByIds(Long[] ids);
}
