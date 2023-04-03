package com.ruoyi.users.service;

import java.util.List;
import com.ruoyi.users.domain.UCharglog;

/**
 * 充值记录Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface IUCharglogService 
{
    /**
     * 查询充值记录
     * 
     * @param id 充值记录主键
     * @return 充值记录
     */
    public UCharglog selectUCharglogById(Long id);

    /**
     * 查询充值记录列表
     * 
     * @param uCharglog 充值记录
     * @return 充值记录集合
     */
    public List<UCharglog> selectUCharglogList(UCharglog uCharglog);

    /**
     * 新增充值记录
     * 
     * @param uCharglog 充值记录
     * @return 结果
     */
    public int insertUCharglog(UCharglog uCharglog);

    /**
     * 修改充值记录
     * 
     * @param uCharglog 充值记录
     * @return 结果
     */
    public int updateUCharglog(UCharglog uCharglog);

    /**
     * 批量删除充值记录
     * 
     * @param ids 需要删除的充值记录主键集合
     * @return 结果
     */
    public int deleteUCharglogByIds(Long[] ids);

    /**
     * 删除充值记录信息
     * 
     * @param id 充值记录主键
     * @return 结果
     */
    public int deleteUCharglogById(Long id);
}
