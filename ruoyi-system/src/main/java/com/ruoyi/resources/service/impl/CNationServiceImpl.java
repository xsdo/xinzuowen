package com.ruoyi.resources.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.CNationMapper;
import com.ruoyi.resources.domain.CNation;
import com.ruoyi.resources.service.ICNationService;

/**
 * 全国作文Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class CNationServiceImpl implements ICNationService 
{
    @Autowired
    private CNationMapper cNationMapper;

    /**
     * 查询全国作文
     * 
     * @param id 全国作文主键
     * @return 全国作文
     */
    @Override
    public CNation selectCNationById(Long id)
    {
        return cNationMapper.selectCNationById(id);
    }

    /**
     * 查询全国作文列表
     * 
     * @param cNation 全国作文
     * @return 全国作文
     */
    @Override
    public List<CNation> selectCNationList(CNation cNation)
    {
        return cNationMapper.selectCNationList(cNation);
    }

    /**
     * 新增全国作文
     * 
     * @param cNation 全国作文
     * @return 结果
     */
    @Override
    public int insertCNation(CNation cNation)
    {
        cNation.setCreateTime(DateUtils.getNowDate());
        return cNationMapper.insertCNation(cNation);
    }

    /**
     * 修改全国作文
     * 
     * @param cNation 全国作文
     * @return 结果
     */
    @Override
    public int updateCNation(CNation cNation)
    {
        cNation.setUpdateTime(DateUtils.getNowDate());
        return cNationMapper.updateCNation(cNation);
    }

    /**
     * 批量删除全国作文
     * 
     * @param ids 需要删除的全国作文主键
     * @return 结果
     */
    @Override
    public int deleteCNationByIds(Long[] ids)
    {
        return cNationMapper.deleteCNationByIds(ids);
    }

    /**
     * 删除全国作文信息
     * 
     * @param id 全国作文主键
     * @return 结果
     */
    @Override
    public int deleteCNationById(Long id)
    {
        return cNationMapper.deleteCNationById(id);
    }
}
