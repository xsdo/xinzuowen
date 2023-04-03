package com.ruoyi.users.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.users.mapper.UTeacherMapper;
import com.ruoyi.users.domain.UTeacher;
import com.ruoyi.users.service.IUTeacherService;

/**
 * 教师班级Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class UTeacherServiceImpl implements IUTeacherService 
{
    @Autowired
    private UTeacherMapper uTeacherMapper;

    /**
     * 查询教师班级
     * 
     * @param id 教师班级主键
     * @return 教师班级
     */
    @Override
    public UTeacher selectUTeacherById(Long id)
    {
        return uTeacherMapper.selectUTeacherById(id);
    }

    /**
     * 查询教师班级列表
     * 
     * @param uTeacher 教师班级
     * @return 教师班级
     */
    @Override
    public List<UTeacher> selectUTeacherList(UTeacher uTeacher)
    {
        return uTeacherMapper.selectUTeacherList(uTeacher);
    }

    /**
     * 新增教师班级
     * 
     * @param uTeacher 教师班级
     * @return 结果
     */
    @Override
    public int insertUTeacher(UTeacher uTeacher)
    {
        uTeacher.setCreateTime(DateUtils.getNowDate());
        return uTeacherMapper.insertUTeacher(uTeacher);
    }

    /**
     * 修改教师班级
     * 
     * @param uTeacher 教师班级
     * @return 结果
     */
    @Override
    public int updateUTeacher(UTeacher uTeacher)
    {
        uTeacher.setUpdateTime(DateUtils.getNowDate());
        return uTeacherMapper.updateUTeacher(uTeacher);
    }

    /**
     * 批量删除教师班级
     * 
     * @param ids 需要删除的教师班级主键
     * @return 结果
     */
    @Override
    public int deleteUTeacherByIds(Long[] ids)
    {
        return uTeacherMapper.deleteUTeacherByIds(ids);
    }

    /**
     * 删除教师班级信息
     * 
     * @param id 教师班级主键
     * @return 结果
     */
    @Override
    public int deleteUTeacherById(Long id)
    {
        return uTeacherMapper.deleteUTeacherById(id);
    }
}
