package com.ruoyi.users.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.users.mapper.UCharglogMapper;
import com.ruoyi.users.domain.UCharglog;
import com.ruoyi.users.service.IUCharglogService;

/**
 * 充值记录Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class UCharglogServiceImpl implements IUCharglogService 
{
    @Autowired
    private UCharglogMapper uCharglogMapper;

    /**
     * 查询充值记录
     * 
     * @param id 充值记录主键
     * @return 充值记录
     */
    @Override
    public UCharglog selectUCharglogById(Long id)
    {
        return uCharglogMapper.selectUCharglogById(id);
    }

    /**
     * 查询充值记录列表
     * 
     * @param uCharglog 充值记录
     * @return 充值记录
     */
    @Override
    public List<UCharglog> selectUCharglogList(UCharglog uCharglog)
    {
        return uCharglogMapper.selectUCharglogList(uCharglog);
    }

    /**
     * 新增充值记录
     * 
     * @param uCharglog 充值记录
     * @return 结果
     */
    @Override
    public int insertUCharglog(UCharglog uCharglog)
    {
        uCharglog.setCreateTime(DateUtils.getNowDate());
        return uCharglogMapper.insertUCharglog(uCharglog);
    }

    /**
     * 修改充值记录
     * 
     * @param uCharglog 充值记录
     * @return 结果
     */
    @Override
    public int updateUCharglog(UCharglog uCharglog)
    {
        uCharglog.setUpdateTime(DateUtils.getNowDate());
        return uCharglogMapper.updateUCharglog(uCharglog);
    }

    /**
     * 批量删除充值记录
     * 
     * @param ids 需要删除的充值记录主键
     * @return 结果
     */
    @Override
    public int deleteUCharglogByIds(Long[] ids)
    {
        return uCharglogMapper.deleteUCharglogByIds(ids);
    }

    /**
     * 删除充值记录信息
     * 
     * @param id 充值记录主键
     * @return 结果
     */
    @Override
    public int deleteUCharglogById(Long id)
    {
        return uCharglogMapper.deleteUCharglogById(id);
    }
}
