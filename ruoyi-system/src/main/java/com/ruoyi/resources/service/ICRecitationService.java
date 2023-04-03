package com.ruoyi.resources.service;

import java.util.List;
import com.ruoyi.resources.domain.CRecitation;

/**
 * 朗读者Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface ICRecitationService 
{
    /**
     * 查询朗读者
     * 
     * @param id 朗读者主键
     * @return 朗读者
     */
    public CRecitation selectCRecitationById(Long id);

    /**
     * 查询朗读者列表
     * 
     * @param cRecitation 朗读者
     * @return 朗读者集合
     */
    public List<CRecitation> selectCRecitationList(CRecitation cRecitation);

    /**
     * 新增朗读者
     * 
     * @param cRecitation 朗读者
     * @return 结果
     */
    public int insertCRecitation(CRecitation cRecitation);

    /**
     * 修改朗读者
     * 
     * @param cRecitation 朗读者
     * @return 结果
     */
    public int updateCRecitation(CRecitation cRecitation);

    /**
     * 批量删除朗读者
     * 
     * @param ids 需要删除的朗读者主键集合
     * @return 结果
     */
    public int deleteCRecitationByIds(Long[] ids);

    /**
     * 删除朗读者信息
     * 
     * @param id 朗读者主键
     * @return 结果
     */
    public int deleteCRecitationById(Long id);
}
