package com.ruoyi.users.service;

import java.util.List;
import com.ruoyi.users.domain.UFlowers;

/**
 * 鲜花Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface IUFlowersService 
{
    /**
     * 查询鲜花
     * 
     * @param id 鲜花主键
     * @return 鲜花
     */
    public UFlowers selectUFlowersById(Long id);

    /**
     * 查询鲜花列表
     * 
     * @param uFlowers 鲜花
     * @return 鲜花集合
     */
    public List<UFlowers> selectUFlowersList(UFlowers uFlowers);

    /**
     * 新增鲜花
     * 
     * @param uFlowers 鲜花
     * @return 结果
     */
    public int insertUFlowers(UFlowers uFlowers);

    /**
     * 修改鲜花
     * 
     * @param uFlowers 鲜花
     * @return 结果
     */
    public int updateUFlowers(UFlowers uFlowers);

    /**
     * 批量删除鲜花
     * 
     * @param ids 需要删除的鲜花主键集合
     * @return 结果
     */
    public int deleteUFlowersByIds(Long[] ids);

    /**
     * 删除鲜花信息
     * 
     * @param id 鲜花主键
     * @return 结果
     */
    public int deleteUFlowersById(Long id);
}
