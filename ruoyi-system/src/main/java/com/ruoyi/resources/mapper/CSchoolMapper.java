package com.ruoyi.resources.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.resources.domain.CSchool;

/**
 * 校园作文Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_RESOURCES)//切换数据源
public interface CSchoolMapper
{
    /**
     * 查询校园作文
     *
     * @param id 校园作文主键
     * @return 校园作文
     */
    public CSchool selectCSchoolById(Long id);

    /**
     * 查询校园作文列表
     *
     * @param cSchool 校园作文
     * @return 校园作文集合
     */
    public List<CSchool> selectCSchoolList(CSchool cSchool);

    /**
     * 新增校园作文
     *
     * @param cSchool 校园作文
     * @return 结果
     */
    public int insertCSchool(CSchool cSchool);

    /**
     * 修改校园作文
     *
     * @param cSchool 校园作文
     * @return 结果
     */
    public int updateCSchool(CSchool cSchool);

    /**
     * 删除校园作文
     *
     * @param id 校园作文主键
     * @return 结果
     */
    public int deleteCSchoolById(Long id);

    /**
     * 批量删除校园作文
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCSchoolByIds(Long[] ids);
}
