package com.ruoyi.tasks.service;

import java.util.List;
import com.ruoyi.tasks.domain.SuggestUser;

/**
 * 推荐用户Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface ISuggestUserService 
{
    /**
     * 查询推荐用户
     * 
     * @param id 推荐用户主键
     * @return 推荐用户
     */
    public SuggestUser selectSuggestUserById(Long id);

    /**
     * 查询推荐用户列表
     * 
     * @param suggestUser 推荐用户
     * @return 推荐用户集合
     */
    public List<SuggestUser> selectSuggestUserList(SuggestUser suggestUser);

    /**
     * 新增推荐用户
     * 
     * @param suggestUser 推荐用户
     * @return 结果
     */
    public int insertSuggestUser(SuggestUser suggestUser);

    /**
     * 修改推荐用户
     * 
     * @param suggestUser 推荐用户
     * @return 结果
     */
    public int updateSuggestUser(SuggestUser suggestUser);

    /**
     * 批量删除推荐用户
     * 
     * @param ids 需要删除的推荐用户主键集合
     * @return 结果
     */
    public int deleteSuggestUserByIds(Long[] ids);

    /**
     * 删除推荐用户信息
     * 
     * @param id 推荐用户主键
     * @return 结果
     */
    public int deleteSuggestUserById(Long id);
}
