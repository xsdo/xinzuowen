package com.ruoyi.tasks.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.tasks.mapper.AuthTasklogMapper;
import com.ruoyi.tasks.domain.AuthTasklog;
import com.ruoyi.tasks.service.IAuthTasklogService;

/**
 * 认证用户记录Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class AuthTasklogServiceImpl implements IAuthTasklogService 
{
    @Autowired
    private AuthTasklogMapper authTasklogMapper;

    /**
     * 查询认证用户记录
     * 
     * @param id 认证用户记录主键
     * @return 认证用户记录
     */
    @Override
    public AuthTasklog selectAuthTasklogById(Long id)
    {
        return authTasklogMapper.selectAuthTasklogById(id);
    }

    /**
     * 查询认证用户记录列表
     * 
     * @param authTasklog 认证用户记录
     * @return 认证用户记录
     */
    @Override
    public List<AuthTasklog> selectAuthTasklogList(AuthTasklog authTasklog)
    {
        return authTasklogMapper.selectAuthTasklogList(authTasklog);
    }

    /**
     * 新增认证用户记录
     * 
     * @param authTasklog 认证用户记录
     * @return 结果
     */
    @Override
    public int insertAuthTasklog(AuthTasklog authTasklog)
    {
        authTasklog.setCreateTime(DateUtils.getNowDate());
        return authTasklogMapper.insertAuthTasklog(authTasklog);
    }

    /**
     * 修改认证用户记录
     * 
     * @param authTasklog 认证用户记录
     * @return 结果
     */
    @Override
    public int updateAuthTasklog(AuthTasklog authTasklog)
    {
        authTasklog.setUpdateTime(DateUtils.getNowDate());
        return authTasklogMapper.updateAuthTasklog(authTasklog);
    }

    /**
     * 批量删除认证用户记录
     * 
     * @param ids 需要删除的认证用户记录主键
     * @return 结果
     */
    @Override
    public int deleteAuthTasklogByIds(Long[] ids)
    {
        return authTasklogMapper.deleteAuthTasklogByIds(ids);
    }

    /**
     * 删除认证用户记录信息
     * 
     * @param id 认证用户记录主键
     * @return 结果
     */
    @Override
    public int deleteAuthTasklogById(Long id)
    {
        return authTasklogMapper.deleteAuthTasklogById(id);
    }
}
