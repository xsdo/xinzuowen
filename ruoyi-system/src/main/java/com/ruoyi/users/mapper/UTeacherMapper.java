package com.ruoyi.users.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.users.domain.UTeacher;

/**
 * 教师班级Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_USERS)//切换数据源
public interface UTeacherMapper
{
    /**
     * 查询教师班级
     *
     * @param id 教师班级主键
     * @return 教师班级
     */
    public UTeacher selectUTeacherById(Long id);

    /**
     * 查询教师班级列表
     *
     * @param uTeacher 教师班级
     * @return 教师班级集合
     */
    public List<UTeacher> selectUTeacherList(UTeacher uTeacher);

    /**
     * 新增教师班级
     *
     * @param uTeacher 教师班级
     * @return 结果
     */
    public int insertUTeacher(UTeacher uTeacher);

    /**
     * 修改教师班级
     *
     * @param uTeacher 教师班级
     * @return 结果
     */
    public int updateUTeacher(UTeacher uTeacher);

    /**
     * 删除教师班级
     *
     * @param id 教师班级主键
     * @return 结果
     */
    public int deleteUTeacherById(Long id);

    /**
     * 批量删除教师班级
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUTeacherByIds(Long[] ids);
}
