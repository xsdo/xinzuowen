package com.ruoyi.resources.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.resources.domain.CReadlog;

/**
 * 阅读记录Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_RESOURCES)//切换数据源
public interface CReadlogMapper
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
     * 删除阅读记录
     *
     * @param id 阅读记录主键
     * @return 结果
     */
    public int deleteCReadlogById(Long id);

    /**
     * 批量删除阅读记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCReadlogByIds(Long[] ids);
}
