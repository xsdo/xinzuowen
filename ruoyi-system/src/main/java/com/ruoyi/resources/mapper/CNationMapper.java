package com.ruoyi.resources.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.resources.domain.CNation;

/**
 * 全国作文Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_RESOURCES)//切换数据源
public interface CNationMapper
{
    /**
     * 查询全国作文
     *
     * @param id 全国作文主键
     * @return 全国作文
     */
    public CNation selectCNationById(Long id);

    /**
     * 查询全国作文列表
     *
     * @param cNation 全国作文
     * @return 全国作文集合
     */
    public List<CNation> selectCNationList(CNation cNation);

    /**
     * 新增全国作文
     *
     * @param cNation 全国作文
     * @return 结果
     */
    public int insertCNation(CNation cNation);

    /**
     * 修改全国作文
     *
     * @param cNation 全国作文
     * @return 结果
     */
    public int updateCNation(CNation cNation);

    /**
     * 删除全国作文
     *
     * @param id 全国作文主键
     * @return 结果
     */
    public int deleteCNationById(Long id);

    /**
     * 批量删除全国作文
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCNationByIds(Long[] ids);
}
