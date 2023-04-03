package com.ruoyi.users.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.users.mapper.XzwUserMapper;
import com.ruoyi.users.domain.XzwUser;
import com.ruoyi.users.service.IXzwUserService;

/**
 * 用户Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class XzwUserServiceImpl implements IXzwUserService 
{
    @Autowired
    private XzwUserMapper xzwUserMapper;

    /**
     * 查询用户
     * 
     * @param id 用户主键
     * @return 用户
     */
    @Override
    public XzwUser selectXzwUserById(Long id)
    {
        return xzwUserMapper.selectXzwUserById(id);
    }

    /**
     * 查询用户列表
     * 
     * @param xzwUser 用户
     * @return 用户
     */
    @Override
    public List<XzwUser> selectXzwUserList(XzwUser xzwUser)
    {
        return xzwUserMapper.selectXzwUserList(xzwUser);
    }

    /**
     * 新增用户
     * 
     * @param xzwUser 用户
     * @return 结果
     */
    @Override
    public int insertXzwUser(XzwUser xzwUser)
    {
        xzwUser.setCreateTime(DateUtils.getNowDate());
        return xzwUserMapper.insertXzwUser(xzwUser);
    }

    /**
     * 修改用户
     * 
     * @param xzwUser 用户
     * @return 结果
     */
    @Override
    public int updateXzwUser(XzwUser xzwUser)
    {
        xzwUser.setUpdateTime(DateUtils.getNowDate());
        return xzwUserMapper.updateXzwUser(xzwUser);
    }

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的用户主键
     * @return 结果
     */
    @Override
    public int deleteXzwUserByIds(Long[] ids)
    {
        return xzwUserMapper.deleteXzwUserByIds(ids);
    }

    /**
     * 删除用户信息
     * 
     * @param id 用户主键
     * @return 结果
     */
    @Override
    public int deleteXzwUserById(Long id)
    {
        return xzwUserMapper.deleteXzwUserById(id);
    }
}
