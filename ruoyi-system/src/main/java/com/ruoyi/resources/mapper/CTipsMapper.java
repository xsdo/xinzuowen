package com.ruoyi.resources.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.resources.domain.CTips;

/**
 * 举报Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_RESOURCES)//切换数据源
public interface CTipsMapper
{
    /**
     * 查询举报
     *
     * @param id 举报主键
     * @return 举报
     */
    public CTips selectCTipsById(Long id);

    /**
     * 查询举报列表
     *
     * @param cTips 举报
     * @return 举报集合
     */
    public List<CTips> selectCTipsList(CTips cTips);

    /**
     * 新增举报
     *
     * @param cTips 举报
     * @return 结果
     */
    public int insertCTips(CTips cTips);

    /**
     * 修改举报
     *
     * @param cTips 举报
     * @return 结果
     */
    public int updateCTips(CTips cTips);

    /**
     * 删除举报
     *
     * @param id 举报主键
     * @return 结果
     */
    public int deleteCTipsById(Long id);

    /**
     * 批量删除举报
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCTipsByIds(Long[] ids);
}
