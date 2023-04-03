package com.ruoyi.users.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.users.domain.USchool;

/**
 * 用户学校Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_USERS)//切换数据源
public interface USchoolMapper
{
    /**
     * 查询用户学校
     *
     * @param id 用户学校主键
     * @return 用户学校
     */
    public USchool selectUSchoolById(Long id);

    /**
     * 查询用户学校列表
     *
     * @param uSchool 用户学校
     * @return 用户学校集合
     */
    public List<USchool> selectUSchoolList(USchool uSchool);

    /**
     * 新增用户学校
     *
     * @param uSchool 用户学校
     * @return 结果
     */
    public int insertUSchool(USchool uSchool);

    /**
     * 修改用户学校
     *
     * @param uSchool 用户学校
     * @return 结果
     */
    public int updateUSchool(USchool uSchool);

    /**
     * 删除用户学校
     *
     * @param id 用户学校主键
     * @return 结果
     */
    public int deleteUSchoolById(Long id);

    /**
     * 批量删除用户学校
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUSchoolByIds(Long[] ids);
}
