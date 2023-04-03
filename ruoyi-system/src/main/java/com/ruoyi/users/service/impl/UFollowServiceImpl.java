package com.ruoyi.users.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.users.mapper.UFollowMapper;
import com.ruoyi.users.domain.UFollow;
import com.ruoyi.users.service.IUFollowService;

/**
 * 用户关注Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class UFollowServiceImpl implements IUFollowService 
{
    @Autowired
    private UFollowMapper uFollowMapper;

    /**
     * 查询用户关注
     * 
     * @param id 用户关注主键
     * @return 用户关注
     */
    @Override
    public UFollow selectUFollowById(Long id)
    {
        return uFollowMapper.selectUFollowById(id);
    }

    /**
     * 查询用户关注列表
     * 
     * @param uFollow 用户关注
     * @return 用户关注
     */
    @Override
    public List<UFollow> selectUFollowList(UFollow uFollow)
    {
        return uFollowMapper.selectUFollowList(uFollow);
    }

    /**
     * 新增用户关注
     * 
     * @param uFollow 用户关注
     * @return 结果
     */
    @Override
    public int insertUFollow(UFollow uFollow)
    {
        uFollow.setCreateTime(DateUtils.getNowDate());
        return uFollowMapper.insertUFollow(uFollow);
    }

    /**
     * 修改用户关注
     * 
     * @param uFollow 用户关注
     * @return 结果
     */
    @Override
    public int updateUFollow(UFollow uFollow)
    {
        uFollow.setUpdateTime(DateUtils.getNowDate());
        return uFollowMapper.updateUFollow(uFollow);
    }

    /**
     * 批量删除用户关注
     * 
     * @param ids 需要删除的用户关注主键
     * @return 结果
     */
    @Override
    public int deleteUFollowByIds(Long[] ids)
    {
        return uFollowMapper.deleteUFollowByIds(ids);
    }

    /**
     * 删除用户关注信息
     * 
     * @param id 用户关注主键
     * @return 结果
     */
    @Override
    public int deleteUFollowById(Long id)
    {
        return uFollowMapper.deleteUFollowById(id);
    }
}
