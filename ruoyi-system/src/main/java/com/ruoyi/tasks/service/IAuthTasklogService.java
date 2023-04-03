package com.ruoyi.tasks.service;

import java.util.List;
import com.ruoyi.tasks.domain.AuthTasklog;

/**
 * 认证用户记录Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface IAuthTasklogService 
{
    /**
     * 查询认证用户记录
     * 
     * @param id 认证用户记录主键
     * @return 认证用户记录
     */
    public AuthTasklog selectAuthTasklogById(Long id);

    /**
     * 查询认证用户记录列表
     * 
     * @param authTasklog 认证用户记录
     * @return 认证用户记录集合
     */
    public List<AuthTasklog> selectAuthTasklogList(AuthTasklog authTasklog);

    /**
     * 新增认证用户记录
     * 
     * @param authTasklog 认证用户记录
     * @return 结果
     */
    public int insertAuthTasklog(AuthTasklog authTasklog);

    /**
     * 修改认证用户记录
     * 
     * @param authTasklog 认证用户记录
     * @return 结果
     */
    public int updateAuthTasklog(AuthTasklog authTasklog);

    /**
     * 批量删除认证用户记录
     * 
     * @param ids 需要删除的认证用户记录主键集合
     * @return 结果
     */
    public int deleteAuthTasklogByIds(Long[] ids);

    /**
     * 删除认证用户记录信息
     * 
     * @param id 认证用户记录主键
     * @return 结果
     */
    public int deleteAuthTasklogById(Long id);
}
