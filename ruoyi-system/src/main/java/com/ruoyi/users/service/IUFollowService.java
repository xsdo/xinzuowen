package com.ruoyi.users.service;

import java.util.List;
import com.ruoyi.users.domain.UFollow;

/**
 * 用户关注Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface IUFollowService 
{
    /**
     * 查询用户关注
     * 
     * @param id 用户关注主键
     * @return 用户关注
     */
    public UFollow selectUFollowById(Long id);

    /**
     * 查询用户关注列表
     * 
     * @param uFollow 用户关注
     * @return 用户关注集合
     */
    public List<UFollow> selectUFollowList(UFollow uFollow);

    /**
     * 新增用户关注
     * 
     * @param uFollow 用户关注
     * @return 结果
     */
    public int insertUFollow(UFollow uFollow);

    /**
     * 修改用户关注
     * 
     * @param uFollow 用户关注
     * @return 结果
     */
    public int updateUFollow(UFollow uFollow);

    /**
     * 批量删除用户关注
     * 
     * @param ids 需要删除的用户关注主键集合
     * @return 结果
     */
    public int deleteUFollowByIds(Long[] ids);

    /**
     * 删除用户关注信息
     * 
     * @param id 用户关注主键
     * @return 结果
     */
    public int deleteUFollowById(Long id);
}
