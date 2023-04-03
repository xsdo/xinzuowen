package com.ruoyi.tasks.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.tasks.mapper.SuggestUserMapper;
import com.ruoyi.tasks.domain.SuggestUser;
import com.ruoyi.tasks.service.ISuggestUserService;

/**
 * 推荐用户Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class SuggestUserServiceImpl implements ISuggestUserService 
{
    @Autowired
    private SuggestUserMapper suggestUserMapper;

    /**
     * 查询推荐用户
     * 
     * @param id 推荐用户主键
     * @return 推荐用户
     */
    @Override
    public SuggestUser selectSuggestUserById(Long id)
    {
        return suggestUserMapper.selectSuggestUserById(id);
    }

    /**
     * 查询推荐用户列表
     * 
     * @param suggestUser 推荐用户
     * @return 推荐用户
     */
    @Override
    public List<SuggestUser> selectSuggestUserList(SuggestUser suggestUser)
    {
        return suggestUserMapper.selectSuggestUserList(suggestUser);
    }

    /**
     * 新增推荐用户
     * 
     * @param suggestUser 推荐用户
     * @return 结果
     */
    @Override
    public int insertSuggestUser(SuggestUser suggestUser)
    {
        suggestUser.setCreateTime(DateUtils.getNowDate());
        return suggestUserMapper.insertSuggestUser(suggestUser);
    }

    /**
     * 修改推荐用户
     * 
     * @param suggestUser 推荐用户
     * @return 结果
     */
    @Override
    public int updateSuggestUser(SuggestUser suggestUser)
    {
        suggestUser.setUpdateTime(DateUtils.getNowDate());
        return suggestUserMapper.updateSuggestUser(suggestUser);
    }

    /**
     * 批量删除推荐用户
     * 
     * @param ids 需要删除的推荐用户主键
     * @return 结果
     */
    @Override
    public int deleteSuggestUserByIds(Long[] ids)
    {
        return suggestUserMapper.deleteSuggestUserByIds(ids);
    }

    /**
     * 删除推荐用户信息
     * 
     * @param id 推荐用户主键
     * @return 结果
     */
    @Override
    public int deleteSuggestUserById(Long id)
    {
        return suggestUserMapper.deleteSuggestUserById(id);
    }
}
