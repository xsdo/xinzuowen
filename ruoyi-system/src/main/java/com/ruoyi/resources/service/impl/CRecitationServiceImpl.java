package com.ruoyi.resources.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.CRecitationMapper;
import com.ruoyi.resources.domain.CRecitation;
import com.ruoyi.resources.service.ICRecitationService;

/**
 * 朗读者Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class CRecitationServiceImpl implements ICRecitationService 
{
    @Autowired
    private CRecitationMapper cRecitationMapper;

    /**
     * 查询朗读者
     * 
     * @param id 朗读者主键
     * @return 朗读者
     */
    @Override
    public CRecitation selectCRecitationById(Long id)
    {
        return cRecitationMapper.selectCRecitationById(id);
    }

    /**
     * 查询朗读者列表
     * 
     * @param cRecitation 朗读者
     * @return 朗读者
     */
    @Override
    public List<CRecitation> selectCRecitationList(CRecitation cRecitation)
    {
        return cRecitationMapper.selectCRecitationList(cRecitation);
    }

    /**
     * 新增朗读者
     * 
     * @param cRecitation 朗读者
     * @return 结果
     */
    @Override
    public int insertCRecitation(CRecitation cRecitation)
    {
        cRecitation.setCreateTime(DateUtils.getNowDate());
        return cRecitationMapper.insertCRecitation(cRecitation);
    }

    /**
     * 修改朗读者
     * 
     * @param cRecitation 朗读者
     * @return 结果
     */
    @Override
    public int updateCRecitation(CRecitation cRecitation)
    {
        cRecitation.setUpdateTime(DateUtils.getNowDate());
        return cRecitationMapper.updateCRecitation(cRecitation);
    }

    /**
     * 批量删除朗读者
     * 
     * @param ids 需要删除的朗读者主键
     * @return 结果
     */
    @Override
    public int deleteCRecitationByIds(Long[] ids)
    {
        return cRecitationMapper.deleteCRecitationByIds(ids);
    }

    /**
     * 删除朗读者信息
     * 
     * @param id 朗读者主键
     * @return 结果
     */
    @Override
    public int deleteCRecitationById(Long id)
    {
        return cRecitationMapper.deleteCRecitationById(id);
    }
}
