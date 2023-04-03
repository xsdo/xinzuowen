package com.ruoyi.resources.service;

import java.util.List;
import com.ruoyi.resources.domain.Department;

/**
 * 部编同步作文Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface IDepartmentService 
{
    /**
     * 查询部编同步作文
     * 
     * @param id 部编同步作文主键
     * @return 部编同步作文
     */
    public Department selectDepartmentById(Long id);

    /**
     * 查询部编同步作文列表
     * 
     * @param department 部编同步作文
     * @return 部编同步作文集合
     */
    public List<Department> selectDepartmentList(Department department);

    /**
     * 新增部编同步作文
     * 
     * @param department 部编同步作文
     * @return 结果
     */
    public int insertDepartment(Department department);

    /**
     * 修改部编同步作文
     * 
     * @param department 部编同步作文
     * @return 结果
     */
    public int updateDepartment(Department department);

    /**
     * 批量删除部编同步作文
     * 
     * @param ids 需要删除的部编同步作文主键集合
     * @return 结果
     */
    public int deleteDepartmentByIds(Long[] ids);

    /**
     * 删除部编同步作文信息
     * 
     * @param id 部编同步作文主键
     * @return 结果
     */
    public int deleteDepartmentById(Long id);
}
