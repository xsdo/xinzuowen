package com.ruoyi.resources.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.DepartmentMapper;
import com.ruoyi.resources.domain.Department;
import com.ruoyi.resources.service.IDepartmentService;

/**
 * 部编同步作文Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService 
{
    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 查询部编同步作文
     * 
     * @param id 部编同步作文主键
     * @return 部编同步作文
     */
    @Override
    public Department selectDepartmentById(Long id)
    {
        return departmentMapper.selectDepartmentById(id);
    }

    /**
     * 查询部编同步作文列表
     * 
     * @param department 部编同步作文
     * @return 部编同步作文
     */
    @Override
    public List<Department> selectDepartmentList(Department department)
    {
        return departmentMapper.selectDepartmentList(department);
    }

    /**
     * 新增部编同步作文
     * 
     * @param department 部编同步作文
     * @return 结果
     */
    @Override
    public int insertDepartment(Department department)
    {
        department.setCreateTime(DateUtils.getNowDate());
        return departmentMapper.insertDepartment(department);
    }

    /**
     * 修改部编同步作文
     * 
     * @param department 部编同步作文
     * @return 结果
     */
    @Override
    public int updateDepartment(Department department)
    {
        department.setUpdateTime(DateUtils.getNowDate());
        return departmentMapper.updateDepartment(department);
    }

    /**
     * 批量删除部编同步作文
     * 
     * @param ids 需要删除的部编同步作文主键
     * @return 结果
     */
    @Override
    public int deleteDepartmentByIds(Long[] ids)
    {
        return departmentMapper.deleteDepartmentByIds(ids);
    }

    /**
     * 删除部编同步作文信息
     * 
     * @param id 部编同步作文主键
     * @return 结果
     */
    @Override
    public int deleteDepartmentById(Long id)
    {
        return departmentMapper.deleteDepartmentById(id);
    }
}
