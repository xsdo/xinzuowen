package com.ruoyi.resources.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.CSubmitMapper;
import com.ruoyi.resources.domain.CSubmit;
import com.ruoyi.resources.service.ICSubmitService;

/**
 * 投稿Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class CSubmitServiceImpl implements ICSubmitService 
{
    @Autowired
    private CSubmitMapper cSubmitMapper;

    /**
     * 查询投稿
     * 
     * @param id 投稿主键
     * @return 投稿
     */
    @Override
    public CSubmit selectCSubmitById(Long id)
    {
        return cSubmitMapper.selectCSubmitById(id);
    }

    /**
     * 查询投稿列表
     * 
     * @param cSubmit 投稿
     * @return 投稿
     */
    @Override
    public List<CSubmit> selectCSubmitList(CSubmit cSubmit)
    {
        return cSubmitMapper.selectCSubmitList(cSubmit);
    }

    /**
     * 新增投稿
     * 
     * @param cSubmit 投稿
     * @return 结果
     */
    @Override
    public int insertCSubmit(CSubmit cSubmit)
    {
        cSubmit.setCreateTime(DateUtils.getNowDate());
        return cSubmitMapper.insertCSubmit(cSubmit);
    }

    /**
     * 修改投稿
     * 
     * @param cSubmit 投稿
     * @return 结果
     */
    @Override
    public int updateCSubmit(CSubmit cSubmit)
    {
        cSubmit.setUpdateTime(DateUtils.getNowDate());
        return cSubmitMapper.updateCSubmit(cSubmit);
    }

    /**
     * 批量删除投稿
     * 
     * @param ids 需要删除的投稿主键
     * @return 结果
     */
    @Override
    public int deleteCSubmitByIds(Long[] ids)
    {
        return cSubmitMapper.deleteCSubmitByIds(ids);
    }

    /**
     * 删除投稿信息
     * 
     * @param id 投稿主键
     * @return 结果
     */
    @Override
    public int deleteCSubmitById(Long id)
    {
        return cSubmitMapper.deleteCSubmitById(id);
    }
}
