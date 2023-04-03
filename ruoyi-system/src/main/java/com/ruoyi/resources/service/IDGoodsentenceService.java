package com.ruoyi.resources.service;

import java.util.List;
import com.ruoyi.resources.domain.DGoodsentence;

/**
 * 部编好句Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface IDGoodsentenceService 
{
    /**
     * 查询部编好句
     * 
     * @param id 部编好句主键
     * @return 部编好句
     */
    public DGoodsentence selectDGoodsentenceById(Long id);

    /**
     * 查询部编好句列表
     * 
     * @param dGoodsentence 部编好句
     * @return 部编好句集合
     */
    public List<DGoodsentence> selectDGoodsentenceList(DGoodsentence dGoodsentence);

    /**
     * 新增部编好句
     * 
     * @param dGoodsentence 部编好句
     * @return 结果
     */
    public int insertDGoodsentence(DGoodsentence dGoodsentence);

    /**
     * 修改部编好句
     * 
     * @param dGoodsentence 部编好句
     * @return 结果
     */
    public int updateDGoodsentence(DGoodsentence dGoodsentence);

    /**
     * 批量删除部编好句
     * 
     * @param ids 需要删除的部编好句主键集合
     * @return 结果
     */
    public int deleteDGoodsentenceByIds(Long[] ids);

    /**
     * 删除部编好句信息
     * 
     * @param id 部编好句主键
     * @return 结果
     */
    public int deleteDGoodsentenceById(Long id);
}
