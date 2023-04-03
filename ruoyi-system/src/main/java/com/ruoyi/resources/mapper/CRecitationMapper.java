package com.ruoyi.resources.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.resources.domain.CRecitation;

/**
 * 朗读者Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_RESOURCES)//切换数据源
public interface CRecitationMapper
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
     * 删除朗读者
     *
     * @param id 朗读者主键
     * @return 结果
     */
    public int deleteCRecitationById(Long id);

    /**
     * 批量删除朗读者
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCRecitationByIds(Long[] ids);
}
