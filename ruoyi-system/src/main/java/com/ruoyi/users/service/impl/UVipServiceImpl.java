package com.ruoyi.users.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.users.mapper.UVipMapper;
import com.ruoyi.users.domain.UVip;
import com.ruoyi.users.service.IUVipService;

/**
 * 用户会员Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class UVipServiceImpl implements IUVipService 
{
    @Autowired
    private UVipMapper uVipMapper;

    /**
     * 查询用户会员
     * 
     * @param id 用户会员主键
     * @return 用户会员
     */
    @Override
    public UVip selectUVipById(Long id)
    {
        return uVipMapper.selectUVipById(id);
    }

    /**
     * 查询用户会员列表
     * 
     * @param uVip 用户会员
     * @return 用户会员
     */
    @Override
    public List<UVip> selectUVipList(UVip uVip)
    {
        return uVipMapper.selectUVipList(uVip);
    }

    /**
     * 新增用户会员
     * 
     * @param uVip 用户会员
     * @return 结果
     */
    @Override
    public int insertUVip(UVip uVip)
    {
        uVip.setCreateTime(DateUtils.getNowDate());
        return uVipMapper.insertUVip(uVip);
    }

    /**
     * 修改用户会员
     * 
     * @param uVip 用户会员
     * @return 结果
     */
    @Override
    public int updateUVip(UVip uVip)
    {
        uVip.setUpdateTime(DateUtils.getNowDate());
        return uVipMapper.updateUVip(uVip);
    }

    /**
     * 批量删除用户会员
     * 
     * @param ids 需要删除的用户会员主键
     * @return 结果
     */
    @Override
    public int deleteUVipByIds(Long[] ids)
    {
        return uVipMapper.deleteUVipByIds(ids);
    }

    /**
     * 删除用户会员信息
     * 
     * @param id 用户会员主键
     * @return 结果
     */
    @Override
    public int deleteUVipById(Long id)
    {
        return uVipMapper.deleteUVipById(id);
    }
}
