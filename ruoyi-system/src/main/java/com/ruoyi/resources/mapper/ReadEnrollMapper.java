package com.ruoyi.resources.mapper;

import java.util.List;
import com.ruoyi.resources.domain.ReadEnroll;

/**
 * 活动报名Mapper接口
 * 
 * @author xqq
 * @date 2023-04-17
 */
public interface ReadEnrollMapper 
{
    /**
     * 查询活动报名
     * 
     * @param id 活动报名主键
     * @return 活动报名
     */
    public ReadEnroll selectReadEnrollById(Long id);

    /**
     * 查询活动报名列表
     * 
     * @param readEnroll 活动报名
     * @return 活动报名集合
     */
    public List<ReadEnroll> selectReadEnrollList(ReadEnroll readEnroll);

    /**
     * 新增活动报名
     * 
     * @param readEnroll 活动报名
     * @return 结果
     */
    public int insertReadEnroll(ReadEnroll readEnroll);

    /**
     * 修改活动报名
     * 
     * @param readEnroll 活动报名
     * @return 结果
     */
    public int updateReadEnroll(ReadEnroll readEnroll);

    /**
     * 删除活动报名
     * 
     * @param id 活动报名主键
     * @return 结果
     */
    public int deleteReadEnrollById(Long id);

    /**
     * 批量删除活动报名
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReadEnrollByIds(Long[] ids);
}
