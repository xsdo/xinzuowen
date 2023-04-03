package com.ruoyi.resources.service;

import java.util.List;
import com.ruoyi.resources.domain.CNation;

/**
 * 全国作文Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface ICNationService 
{
    /**
     * 查询全国作文
     * 
     * @param id 全国作文主键
     * @return 全国作文
     */
    public CNation selectCNationById(Long id);

    /**
     * 查询全国作文列表
     * 
     * @param cNation 全国作文
     * @return 全国作文集合
     */
    public List<CNation> selectCNationList(CNation cNation);

    /**
     * 新增全国作文
     * 
     * @param cNation 全国作文
     * @return 结果
     */
    public int insertCNation(CNation cNation);

    /**
     * 修改全国作文
     * 
     * @param cNation 全国作文
     * @return 结果
     */
    public int updateCNation(CNation cNation);

    /**
     * 批量删除全国作文
     * 
     * @param ids 需要删除的全国作文主键集合
     * @return 结果
     */
    public int deleteCNationByIds(Long[] ids);

    /**
     * 删除全国作文信息
     * 
     * @param id 全国作文主键
     * @return 结果
     */
    public int deleteCNationById(Long id);
}
