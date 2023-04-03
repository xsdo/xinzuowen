package com.ruoyi.resources.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.DGoodsentenceMapper;
import com.ruoyi.resources.domain.DGoodsentence;
import com.ruoyi.resources.service.IDGoodsentenceService;

/**
 * 部编好句Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class DGoodsentenceServiceImpl implements IDGoodsentenceService 
{
    @Autowired
    private DGoodsentenceMapper dGoodsentenceMapper;

    /**
     * 查询部编好句
     * 
     * @param id 部编好句主键
     * @return 部编好句
     */
    @Override
    public DGoodsentence selectDGoodsentenceById(Long id)
    {
        return dGoodsentenceMapper.selectDGoodsentenceById(id);
    }

    /**
     * 查询部编好句列表
     * 
     * @param dGoodsentence 部编好句
     * @return 部编好句
     */
    @Override
    public List<DGoodsentence> selectDGoodsentenceList(DGoodsentence dGoodsentence)
    {
        return dGoodsentenceMapper.selectDGoodsentenceList(dGoodsentence);
    }

    /**
     * 新增部编好句
     * 
     * @param dGoodsentence 部编好句
     * @return 结果
     */
    @Override
    public int insertDGoodsentence(DGoodsentence dGoodsentence)
    {
        dGoodsentence.setCreateTime(DateUtils.getNowDate());
        return dGoodsentenceMapper.insertDGoodsentence(dGoodsentence);
    }

    /**
     * 修改部编好句
     * 
     * @param dGoodsentence 部编好句
     * @return 结果
     */
    @Override
    public int updateDGoodsentence(DGoodsentence dGoodsentence)
    {
        dGoodsentence.setUpdateTime(DateUtils.getNowDate());
        return dGoodsentenceMapper.updateDGoodsentence(dGoodsentence);
    }

    /**
     * 批量删除部编好句
     * 
     * @param ids 需要删除的部编好句主键
     * @return 结果
     */
    @Override
    public int deleteDGoodsentenceByIds(Long[] ids)
    {
        return dGoodsentenceMapper.deleteDGoodsentenceByIds(ids);
    }

    /**
     * 删除部编好句信息
     * 
     * @param id 部编好句主键
     * @return 结果
     */
    @Override
    public int deleteDGoodsentenceById(Long id)
    {
        return dGoodsentenceMapper.deleteDGoodsentenceById(id);
    }
}
