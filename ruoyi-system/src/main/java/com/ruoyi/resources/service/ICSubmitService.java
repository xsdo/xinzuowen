package com.ruoyi.resources.service;

import java.util.List;
import com.ruoyi.resources.domain.CSubmit;

/**
 * 投稿Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface ICSubmitService 
{
    /**
     * 查询投稿
     * 
     * @param id 投稿主键
     * @return 投稿
     */
    public CSubmit selectCSubmitById(Long id);

    /**
     * 查询投稿列表
     * 
     * @param cSubmit 投稿
     * @return 投稿集合
     */
    public List<CSubmit> selectCSubmitList(CSubmit cSubmit);

    /**
     * 新增投稿
     * 
     * @param cSubmit 投稿
     * @return 结果
     */
    public int insertCSubmit(CSubmit cSubmit);

    /**
     * 修改投稿
     * 
     * @param cSubmit 投稿
     * @return 结果
     */
    public int updateCSubmit(CSubmit cSubmit);

    /**
     * 批量删除投稿
     * 
     * @param ids 需要删除的投稿主键集合
     * @return 结果
     */
    public int deleteCSubmitByIds(Long[] ids);

    /**
     * 删除投稿信息
     * 
     * @param id 投稿主键
     * @return 结果
     */
    public int deleteCSubmitById(Long id);
}
