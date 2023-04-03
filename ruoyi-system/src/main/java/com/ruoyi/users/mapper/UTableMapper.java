package com.ruoyi.users.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.users.domain.UTable;

/**
 * 用户标签Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_USERS)//切换数据源
public interface UTableMapper
{
    /**
     * 查询用户标签
     *
     * @param id 用户标签主键
     * @return 用户标签
     */
    public UTable selectUTableById(Long id);

    /**
     * 查询用户标签列表
     *
     * @param uTable 用户标签
     * @return 用户标签集合
     */
    public List<UTable> selectUTableList(UTable uTable);

    /**
     * 新增用户标签
     *
     * @param uTable 用户标签
     * @return 结果
     */
    public int insertUTable(UTable uTable);

    /**
     * 修改用户标签
     *
     * @param uTable 用户标签
     * @return 结果
     */
    public int updateUTable(UTable uTable);

    /**
     * 删除用户标签
     *
     * @param id 用户标签主键
     * @return 结果
     */
    public int deleteUTableById(Long id);

    /**
     * 批量删除用户标签
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUTableByIds(Long[] ids);
}
