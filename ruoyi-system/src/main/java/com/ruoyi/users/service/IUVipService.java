package com.ruoyi.users.service;

import java.util.List;
import com.ruoyi.users.domain.UVip;

/**
 * 用户会员Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface IUVipService 
{
    /**
     * 查询用户会员
     * 
     * @param id 用户会员主键
     * @return 用户会员
     */
    public UVip selectUVipById(Long id);

    /**
     * 查询用户会员列表
     * 
     * @param uVip 用户会员
     * @return 用户会员集合
     */
    public List<UVip> selectUVipList(UVip uVip);

    /**
     * 新增用户会员
     * 
     * @param uVip 用户会员
     * @return 结果
     */
    public int insertUVip(UVip uVip);

    /**
     * 修改用户会员
     * 
     * @param uVip 用户会员
     * @return 结果
     */
    public int updateUVip(UVip uVip);

    /**
     * 批量删除用户会员
     * 
     * @param ids 需要删除的用户会员主键集合
     * @return 结果
     */
    public int deleteUVipByIds(Long[] ids);

    /**
     * 删除用户会员信息
     * 
     * @param id 用户会员主键
     * @return 结果
     */
    public int deleteUVipById(Long id);
}
