package com.ruoyi.users.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.users.domain.UCharglog;

/**
 * 充值记录Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_USERS)//切换数据源
public interface UCharglogMapper
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
     * 删除充值记录
     *
     * @param id 充值记录主键
     * @return 结果
     */
    public int deleteUCharglogById(Long id);

    /**
     * 批量删除充值记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUCharglogByIds(Long[] ids);
}
