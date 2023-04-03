package com.ruoyi.resources.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.resources.domain.Department;

/**
 * 部编同步作文Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_RESOURCES)//切换数据源
public interface DepartmentMapper
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
     * 删除部编同步作文
     *
     * @param id 部编同步作文主键
     * @return 结果
     */
    public int deleteDepartmentById(Long id);

    /**
     * 批量删除部编同步作文
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDepartmentByIds(Long[] ids);
}
