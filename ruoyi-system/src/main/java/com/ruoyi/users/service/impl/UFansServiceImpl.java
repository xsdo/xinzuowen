package com.ruoyi.users.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.users.mapper.UFansMapper;
import com.ruoyi.users.domain.UFans;
import com.ruoyi.users.service.IUFansService;

/**
 * 用户粉丝Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class UFansServiceImpl implements IUFansService 
{
    @Autowired
    private UFansMapper uFansMapper;

    /**
     * 查询用户粉丝
     * 
     * @param id 用户粉丝主键
     * @return 用户粉丝
     */
    @Override
    public UFans selectUFansById(Long id)
    {
        return uFansMapper.selectUFansById(id);
    }

    /**
     * 查询用户粉丝列表
     * 
     * @param uFans 用户粉丝
     * @return 用户粉丝
     */
    @Override
    public List<UFans> selectUFansList(UFans uFans)
    {
        return uFansMapper.selectUFansList(uFans);
    }

    /**
     * 新增用户粉丝
     * 
     * @param uFans 用户粉丝
     * @return 结果
     */
    @Override
    public int insertUFans(UFans uFans)
    {
        uFans.setCreateTime(DateUtils.getNowDate());
        return uFansMapper.insertUFans(uFans);
    }

    /**
     * 修改用户粉丝
     * 
     * @param uFans 用户粉丝
     * @return 结果
     */
    @Override
    public int updateUFans(UFans uFans)
    {
        uFans.setUpdateTime(DateUtils.getNowDate());
        return uFansMapper.updateUFans(uFans);
    }

    /**
     * 批量删除用户粉丝
     * 
     * @param ids 需要删除的用户粉丝主键
     * @return 结果
     */
    @Override
    public int deleteUFansByIds(Long[] ids)
    {
        return uFansMapper.deleteUFansByIds(ids);
    }

    /**
     * 删除用户粉丝信息
     * 
     * @param id 用户粉丝主键
     * @return 结果
     */
    @Override
    public int deleteUFansById(Long id)
    {
        return uFansMapper.deleteUFansById(id);
    }
}
