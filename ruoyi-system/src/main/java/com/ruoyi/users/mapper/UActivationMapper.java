package com.ruoyi.users.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.users.domain.UActivation;

/**
 * 激活码Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_USERS)//切换数据源
public interface UActivationMapper
{
    /**
     * 查询激活码
     *
     * @param id 激活码主键
     * @return 激活码
     */
    public UActivation selectUActivationById(Long id);

    /**
     * 查询激活码列表
     *
     * @param uActivation 激活码
     * @return 激活码集合
     */
    public List<UActivation> selectUActivationList(UActivation uActivation);

    /**
     * 新增激活码
     *
     * @param uActivation 激活码
     * @return 结果
     */
    public int insertUActivation(UActivation uActivation);

    /**
     * 修改激活码
     *
     * @param uActivation 激活码
     * @return 结果
     */
    public int updateUActivation(UActivation uActivation);

    /**
     * 删除激活码
     *
     * @param id 激活码主键
     * @return 结果
     */
    public int deleteUActivationById(Long id);

    /**
     * 批量删除激活码
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUActivationByIds(Long[] ids);
}
