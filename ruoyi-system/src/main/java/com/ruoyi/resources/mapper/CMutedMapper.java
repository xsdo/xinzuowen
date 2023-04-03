package com.ruoyi.resources.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.resources.domain.CMuted;

/**
 * 禁言Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_RESOURCES)//切换数据源
public interface CMutedMapper
{
    /**
     * 查询禁言
     *
     * @param id 禁言主键
     * @return 禁言
     */
    public CMuted selectCMutedById(Long id);

    /**
     * 查询禁言列表
     *
     * @param cMuted 禁言
     * @return 禁言集合
     */
    public List<CMuted> selectCMutedList(CMuted cMuted);

    /**
     * 新增禁言
     *
     * @param cMuted 禁言
     * @return 结果
     */
    public int insertCMuted(CMuted cMuted);

    /**
     * 修改禁言
     *
     * @param cMuted 禁言
     * @return 结果
     */
    public int updateCMuted(CMuted cMuted);

    /**
     * 删除禁言
     *
     * @param id 禁言主键
     * @return 结果
     */
    public int deleteCMutedById(Long id);

    /**
     * 批量删除禁言
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCMutedByIds(Long[] ids);
}
