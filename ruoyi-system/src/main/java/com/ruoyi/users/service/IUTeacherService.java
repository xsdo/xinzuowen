package com.ruoyi.users.service;

import java.util.List;
import com.ruoyi.users.domain.UTeacher;

/**
 * 教师班级Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface IUTeacherService 
{
    /**
     * 查询教师班级
     * 
     * @param id 教师班级主键
     * @return 教师班级
     */
    public UTeacher selectUTeacherById(Long id);

    UTeacher teacherQRCode(Long teacherId);

    UTeacher teacherQRCodePress(Long teacherId);
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
     * 批量删除教师班级
     * 
     * @param ids 需要删除的教师班级主键集合
     * @return 结果
     */
    public int deleteUTeacherByIds(Long[] ids);

    /**
     * 删除教师班级信息
     * 
     * @param id 教师班级主键
     * @return 结果
     */
    public int deleteUTeacherById(Long id);
}
