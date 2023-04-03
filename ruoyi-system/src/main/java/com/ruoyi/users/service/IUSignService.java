package com.ruoyi.users.service;

import java.util.List;
import com.ruoyi.users.domain.USign;

/**
 * 签到Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface IUSignService 
{
    /**
     * 查询签到
     * 
     * @param id 签到主键
     * @return 签到
     */
    public USign selectUSignById(Long id);

    /**
     * 查询签到列表
     * 
     * @param uSign 签到
     * @return 签到集合
     */
    public List<USign> selectUSignList(USign uSign);

    /**
     * 新增签到
     * 
     * @param uSign 签到
     * @return 结果
     */
    public int insertUSign(USign uSign);

    /**
     * 修改签到
     * 
     * @param uSign 签到
     * @return 结果
     */
    public int updateUSign(USign uSign);

    /**
     * 批量删除签到
     * 
     * @param ids 需要删除的签到主键集合
     * @return 结果
     */
    public int deleteUSignByIds(Long[] ids);

    /**
     * 删除签到信息
     * 
     * @param id 签到主键
     * @return 结果
     */
    public int deleteUSignById(Long id);
}
