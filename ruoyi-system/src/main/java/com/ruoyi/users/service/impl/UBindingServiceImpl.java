package com.ruoyi.users.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.users.mapper.UBindingMapper;
import com.ruoyi.users.domain.UBinding;
import com.ruoyi.users.service.IUBindingService;

/**
 * 绑定班级Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class UBindingServiceImpl implements IUBindingService 
{
    @Autowired
    private UBindingMapper uBindingMapper;

    /**
     * 查询绑定班级
     * 
     * @param id 绑定班级主键
     * @return 绑定班级
     */
    @Override
    public UBinding selectUBindingById(Long id)
    {
        return uBindingMapper.selectUBindingById(id);
    }

    /**
     * 查询绑定班级列表
     * 
     * @param uBinding 绑定班级
     * @return 绑定班级
     */
    @Override
    public List<UBinding> selectUBindingList(UBinding uBinding)
    {
        return uBindingMapper.selectUBindingList(uBinding);
    }

    /**
     * 新增绑定班级
     * 
     * @param uBinding 绑定班级
     * @return 结果
     */
    @Override
    public int insertUBinding(UBinding uBinding)
    {
        uBinding.setCreateTime(DateUtils.getNowDate());
        return uBindingMapper.insertUBinding(uBinding);
    }

    /**
     * 修改绑定班级
     * 
     * @param uBinding 绑定班级
     * @return 结果
     */
    @Override
    public int updateUBinding(UBinding uBinding)
    {
        uBinding.setUpdateTime(DateUtils.getNowDate());
        return uBindingMapper.updateUBinding(uBinding);
    }

    /**
     * 批量删除绑定班级
     * 
     * @param ids 需要删除的绑定班级主键
     * @return 结果
     */
    @Override
    public int deleteUBindingByIds(Long[] ids)
    {
        return uBindingMapper.deleteUBindingByIds(ids);
    }

    /**
     * 删除绑定班级信息
     * 
     * @param id 绑定班级主键
     * @return 结果
     */
    @Override
    public int deleteUBindingById(Long id)
    {
        return uBindingMapper.deleteUBindingById(id);
    }
}
