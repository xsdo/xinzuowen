package com.ruoyi.users.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.users.domain.UBinding;

/**
 * 绑定班级Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_USERS)//切换数据源
public interface UBindingMapper
{
    /**
     * 查询绑定班级
     *
     * @param id 绑定班级主键
     * @return 绑定班级
     */
    public UBinding selectUBindingById(Long id);

    /**
     * 查询绑定班级列表
     *
     * @param uBinding 绑定班级
     * @return 绑定班级集合
     */
    public List<UBinding> selectUBindingList(UBinding uBinding);

    /**
     * 新增绑定班级
     *
     * @param uBinding 绑定班级
     * @return 结果
     */
    public int insertUBinding(UBinding uBinding);

    /**
     * 修改绑定班级
     *
     * @param uBinding 绑定班级
     * @return 结果
     */
    public int updateUBinding(UBinding uBinding);

    /**
     * 删除绑定班级
     *
     * @param id 绑定班级主键
     * @return 结果
     */
    public int deleteUBindingById(Long id);

    /**
     * 批量删除绑定班级
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUBindingByIds(Long[] ids);
}
