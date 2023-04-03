package com.ruoyi.resources.service;

import java.util.List;
import com.ruoyi.resources.domain.Composition;

/**
 * 作文Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface ICompositionService 
{
    /**
     * 查询作文
     * 
     * @param id 作文主键
     * @return 作文
     */
    public Composition selectCompositionById(Long id);

    /**
     * 查询作文列表
     * 
     * @param composition 作文
     * @return 作文集合
     */
    public List<Composition> selectCompositionList(Composition composition);

    /**
     * 新增作文
     * 
     * @param composition 作文
     * @return 结果
     */
    public int insertComposition(Composition composition);

    /**
     * 修改作文
     * 
     * @param composition 作文
     * @return 结果
     */
    public int updateComposition(Composition composition);

    /**
     * 批量删除作文
     * 
     * @param ids 需要删除的作文主键集合
     * @return 结果
     */
    public int deleteCompositionByIds(Long[] ids);

    /**
     * 删除作文信息
     * 
     * @param id 作文主键
     * @return 结果
     */
    public int deleteCompositionById(Long id);
}
