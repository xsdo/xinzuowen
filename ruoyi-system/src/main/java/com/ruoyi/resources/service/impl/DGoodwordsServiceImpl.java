package com.ruoyi.resources.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.DGoodwordsMapper;
import com.ruoyi.resources.domain.DGoodwords;
import com.ruoyi.resources.service.IDGoodwordsService;

/**
 * 部编好词Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class DGoodwordsServiceImpl implements IDGoodwordsService 
{
    @Autowired
    private DGoodwordsMapper dGoodwordsMapper;

    /**
     * 查询部编好词
     * 
     * @param id 部编好词主键
     * @return 部编好词
     */
    @Override
    public DGoodwords selectDGoodwordsById(Long id)
    {
        return dGoodwordsMapper.selectDGoodwordsById(id);
    }

    /**
     * 查询部编好词列表
     * 
     * @param dGoodwords 部编好词
     * @return 部编好词
     */
    @Override
    public List<DGoodwords> selectDGoodwordsList(DGoodwords dGoodwords)
    {
        return dGoodwordsMapper.selectDGoodwordsList(dGoodwords);
    }

    /**
     * 新增部编好词
     * 
     * @param dGoodwords 部编好词
     * @return 结果
     */
    @Override
    public int insertDGoodwords(DGoodwords dGoodwords)
    {
        dGoodwords.setCreateTime(DateUtils.getNowDate());
        return dGoodwordsMapper.insertDGoodwords(dGoodwords);
    }

    /**
     * 修改部编好词
     * 
     * @param dGoodwords 部编好词
     * @return 结果
     */
    @Override
    public int updateDGoodwords(DGoodwords dGoodwords)
    {
        dGoodwords.setUpdateTime(DateUtils.getNowDate());
        return dGoodwordsMapper.updateDGoodwords(dGoodwords);
    }

    /**
     * 批量删除部编好词
     * 
     * @param ids 需要删除的部编好词主键
     * @return 结果
     */
    @Override
    public int deleteDGoodwordsByIds(Long[] ids)
    {
        return dGoodwordsMapper.deleteDGoodwordsByIds(ids);
    }

    /**
     * 删除部编好词信息
     * 
     * @param id 部编好词主键
     * @return 结果
     */
    @Override
    public int deleteDGoodwordsById(Long id)
    {
        return dGoodwordsMapper.deleteDGoodwordsById(id);
    }
}
