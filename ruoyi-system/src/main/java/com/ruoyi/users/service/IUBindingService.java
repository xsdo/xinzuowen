package com.ruoyi.users.service;

import java.util.List;
import com.ruoyi.users.domain.UBinding;

/**
 * 绑定班级Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface IUBindingService 
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
     * 批量删除绑定班级
     * 
     * @param ids 需要删除的绑定班级主键集合
     * @return 结果
     */
    public int deleteUBindingByIds(Long[] ids);

    /**
     * 删除绑定班级信息
     * 
     * @param id 绑定班级主键
     * @return 结果
     */
    public int deleteUBindingById(Long id);
}
