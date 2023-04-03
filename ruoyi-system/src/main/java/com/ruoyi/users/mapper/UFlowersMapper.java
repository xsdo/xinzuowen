package com.ruoyi.users.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.users.domain.UFlowers;

/**
 * 鲜花Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_USERS)//切换数据源
public interface UFlowersMapper
{
    /**
     * 查询鲜花
     *
     * @param id 鲜花主键
     * @return 鲜花
     */
    public UFlowers selectUFlowersById(Long id);

    /**
     * 查询鲜花列表
     *
     * @param uFlowers 鲜花
     * @return 鲜花集合
     */
    public List<UFlowers> selectUFlowersList(UFlowers uFlowers);

    /**
     * 新增鲜花
     *
     * @param uFlowers 鲜花
     * @return 结果
     */
    public int insertUFlowers(UFlowers uFlowers);

    /**
     * 修改鲜花
     *
     * @param uFlowers 鲜花
     * @return 结果
     */
    public int updateUFlowers(UFlowers uFlowers);

    /**
     * 删除鲜花
     *
     * @param id 鲜花主键
     * @return 结果
     */
    public int deleteUFlowersById(Long id);

    /**
     * 批量删除鲜花
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUFlowersByIds(Long[] ids);
}
