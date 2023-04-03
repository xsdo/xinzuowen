package com.ruoyi.resources.service;

import java.util.List;
import com.ruoyi.resources.domain.DGoodwords;

/**
 * 部编好词Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface IDGoodwordsService 
{
    /**
     * 查询部编好词
     * 
     * @param id 部编好词主键
     * @return 部编好词
     */
    public DGoodwords selectDGoodwordsById(Long id);

    /**
     * 查询部编好词列表
     * 
     * @param dGoodwords 部编好词
     * @return 部编好词集合
     */
    public List<DGoodwords> selectDGoodwordsList(DGoodwords dGoodwords);

    /**
     * 新增部编好词
     * 
     * @param dGoodwords 部编好词
     * @return 结果
     */
    public int insertDGoodwords(DGoodwords dGoodwords);

    /**
     * 修改部编好词
     * 
     * @param dGoodwords 部编好词
     * @return 结果
     */
    public int updateDGoodwords(DGoodwords dGoodwords);

    /**
     * 批量删除部编好词
     * 
     * @param ids 需要删除的部编好词主键集合
     * @return 结果
     */
    public int deleteDGoodwordsByIds(Long[] ids);

    /**
     * 删除部编好词信息
     * 
     * @param id 部编好词主键
     * @return 结果
     */
    public int deleteDGoodwordsById(Long id);
}
