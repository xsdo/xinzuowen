package com.ruoyi.users.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.users.mapper.UFlowersMapper;
import com.ruoyi.users.domain.UFlowers;
import com.ruoyi.users.service.IUFlowersService;

/**
 * 鲜花Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class UFlowersServiceImpl implements IUFlowersService 
{
    @Autowired
    private UFlowersMapper uFlowersMapper;

    /**
     * 查询鲜花
     * 
     * @param id 鲜花主键
     * @return 鲜花
     */
    @Override
    public UFlowers selectUFlowersById(Long id)
    {
        return uFlowersMapper.selectUFlowersById(id);
    }

    /**
     * 查询鲜花列表
     * 
     * @param uFlowers 鲜花
     * @return 鲜花
     */
    @Override
    public List<UFlowers> selectUFlowersList(UFlowers uFlowers)
    {
        return uFlowersMapper.selectUFlowersList(uFlowers);
    }

    /**
     * 新增鲜花
     * 
     * @param uFlowers 鲜花
     * @return 结果
     */
    @Override
    public int insertUFlowers(UFlowers uFlowers)
    {
        uFlowers.setCreateTime(DateUtils.getNowDate());
        return uFlowersMapper.insertUFlowers(uFlowers);
    }

    /**
     * 修改鲜花
     * 
     * @param uFlowers 鲜花
     * @return 结果
     */
    @Override
    public int updateUFlowers(UFlowers uFlowers)
    {
        uFlowers.setUpdateTime(DateUtils.getNowDate());
        return uFlowersMapper.updateUFlowers(uFlowers);
    }

    /**
     * 批量删除鲜花
     * 
     * @param ids 需要删除的鲜花主键
     * @return 结果
     */
    @Override
    public int deleteUFlowersByIds(Long[] ids)
    {
        return uFlowersMapper.deleteUFlowersByIds(ids);
    }

    /**
     * 删除鲜花信息
     * 
     * @param id 鲜花主键
     * @return 结果
     */
    @Override
    public int deleteUFlowersById(Long id)
    {
        return uFlowersMapper.deleteUFlowersById(id);
    }
}
