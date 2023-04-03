package com.ruoyi.resources.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.CompositionMapper;
import com.ruoyi.resources.domain.Composition;
import com.ruoyi.resources.service.ICompositionService;

/**
 * 作文Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class CompositionServiceImpl implements ICompositionService 
{
    @Autowired
    private CompositionMapper compositionMapper;

    /**
     * 查询作文
     * 
     * @param id 作文主键
     * @return 作文
     */
    @Override
    public Composition selectCompositionById(Long id)
    {
        return compositionMapper.selectCompositionById(id);
    }

    /**
     * 查询作文列表
     * 
     * @param composition 作文
     * @return 作文
     */
    @Override
    public List<Composition> selectCompositionList(Composition composition)
    {
        return compositionMapper.selectCompositionList(composition);
    }

    /**
     * 新增作文
     * 
     * @param composition 作文
     * @return 结果
     */
    @Override
    public int insertComposition(Composition composition)
    {
        composition.setCreateTime(DateUtils.getNowDate());
        return compositionMapper.insertComposition(composition);
    }

    /**
     * 修改作文
     * 
     * @param composition 作文
     * @return 结果
     */
    @Override
    public int updateComposition(Composition composition)
    {
        composition.setUpdateTime(DateUtils.getNowDate());
        return compositionMapper.updateComposition(composition);
    }

    /**
     * 批量删除作文
     * 
     * @param ids 需要删除的作文主键
     * @return 结果
     */
    @Override
    public int deleteCompositionByIds(Long[] ids)
    {
        return compositionMapper.deleteCompositionByIds(ids);
    }

    /**
     * 删除作文信息
     * 
     * @param id 作文主键
     * @return 结果
     */
    @Override
    public int deleteCompositionById(Long id)
    {
        return compositionMapper.deleteCompositionById(id);
    }
}
