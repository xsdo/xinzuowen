package com.ruoyi.resources.service;

import java.util.List;
import com.ruoyi.resources.domain.CReadlog;

/**
 * 阅读记录Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface ICReadlogService 
{
    /**
     * 查询阅读记录
     * 
     * @param id 阅读记录主键
     * @return 阅读记录
     */
    public CReadlog selectCReadlogById(Long id);

    /**
     * 查询阅读记录列表
     * 
     * @param cReadlog 阅读记录
     * @return 阅读记录集合
     */
    public List<CReadlog> selectCReadlogList(CReadlog cReadlog);

    /**
     * 新增阅读记录
     * 
     * @param cReadlog 阅读记录
     * @return 结果
     */
    public int insertCReadlog(CReadlog cReadlog);

    /**
     * 修改阅读记录
     * 
     * @param cReadlog 阅读记录
     * @return 结果
     */
    public int updateCReadlog(CReadlog cReadlog);

    /**
     * 批量删除阅读记录
     * 
     * @param ids 需要删除的阅读记录主键集合
     * @return 结果
     */
    public int deleteCReadlogByIds(Long[] ids);

    /**
     * 删除阅读记录信息
     * 
     * @param id 阅读记录主键
     * @return 结果
     */
    public int deleteCReadlogById(Long id);
}
