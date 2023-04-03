package com.ruoyi.users.service;

import java.util.List;
import com.ruoyi.users.domain.USigndetail;

/**
 * 签到明细Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface IUSigndetailService 
{
    /**
     * 查询签到明细
     * 
     * @param id 签到明细主键
     * @return 签到明细
     */
    public USigndetail selectUSigndetailById(Long id);

    /**
     * 查询签到明细列表
     * 
     * @param uSigndetail 签到明细
     * @return 签到明细集合
     */
    public List<USigndetail> selectUSigndetailList(USigndetail uSigndetail);

    /**
     * 新增签到明细
     * 
     * @param uSigndetail 签到明细
     * @return 结果
     */
    public int insertUSigndetail(USigndetail uSigndetail);

    /**
     * 修改签到明细
     * 
     * @param uSigndetail 签到明细
     * @return 结果
     */
    public int updateUSigndetail(USigndetail uSigndetail);

    /**
     * 批量删除签到明细
     * 
     * @param ids 需要删除的签到明细主键集合
     * @return 结果
     */
    public int deleteUSigndetailByIds(Long[] ids);

    /**
     * 删除签到明细信息
     * 
     * @param id 签到明细主键
     * @return 结果
     */
    public int deleteUSigndetailById(Long id);
}
