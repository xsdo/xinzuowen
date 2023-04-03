package com.ruoyi.resources.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.CReadlogMapper;
import com.ruoyi.resources.domain.CReadlog;
import com.ruoyi.resources.service.ICReadlogService;

/**
 * 阅读记录Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class CReadlogServiceImpl implements ICReadlogService 
{
    @Autowired
    private CReadlogMapper cReadlogMapper;

    /**
     * 查询阅读记录
     * 
     * @param id 阅读记录主键
     * @return 阅读记录
     */
    @Override
    public CReadlog selectCReadlogById(Long id)
    {
        return cReadlogMapper.selectCReadlogById(id);
    }

    /**
     * 查询阅读记录列表
     * 
     * @param cReadlog 阅读记录
     * @return 阅读记录
     */
    @Override
    public List<CReadlog> selectCReadlogList(CReadlog cReadlog)
    {
        return cReadlogMapper.selectCReadlogList(cReadlog);
    }

    /**
     * 新增阅读记录
     * 
     * @param cReadlog 阅读记录
     * @return 结果
     */
    @Override
    public int insertCReadlog(CReadlog cReadlog)
    {
        cReadlog.setCreateTime(DateUtils.getNowDate());
        return cReadlogMapper.insertCReadlog(cReadlog);
    }

    /**
     * 修改阅读记录
     * 
     * @param cReadlog 阅读记录
     * @return 结果
     */
    @Override
    public int updateCReadlog(CReadlog cReadlog)
    {
        cReadlog.setUpdateTime(DateUtils.getNowDate());
        return cReadlogMapper.updateCReadlog(cReadlog);
    }

    /**
     * 批量删除阅读记录
     * 
     * @param ids 需要删除的阅读记录主键
     * @return 结果
     */
    @Override
    public int deleteCReadlogByIds(Long[] ids)
    {
        return cReadlogMapper.deleteCReadlogByIds(ids);
    }

    /**
     * 删除阅读记录信息
     * 
     * @param id 阅读记录主键
     * @return 结果
     */
    @Override
    public int deleteCReadlogById(Long id)
    {
        return cReadlogMapper.deleteCReadlogById(id);
    }
}
