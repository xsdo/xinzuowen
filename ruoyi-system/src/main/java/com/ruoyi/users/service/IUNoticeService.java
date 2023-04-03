package com.ruoyi.users.service;

import java.util.List;
import com.ruoyi.users.domain.UNotice;

/**
 * 消息通知Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface IUNoticeService 
{
    /**
     * 查询消息通知
     * 
     * @param id 消息通知主键
     * @return 消息通知
     */
    public UNotice selectUNoticeById(Long id);

    /**
     * 查询消息通知列表
     * 
     * @param uNotice 消息通知
     * @return 消息通知集合
     */
    public List<UNotice> selectUNoticeList(UNotice uNotice);

    /**
     * 新增消息通知
     * 
     * @param uNotice 消息通知
     * @return 结果
     */
    public int insertUNotice(UNotice uNotice);

    /**
     * 修改消息通知
     * 
     * @param uNotice 消息通知
     * @return 结果
     */
    public int updateUNotice(UNotice uNotice);

    /**
     * 批量删除消息通知
     * 
     * @param ids 需要删除的消息通知主键集合
     * @return 结果
     */
    public int deleteUNoticeByIds(Long[] ids);

    /**
     * 删除消息通知信息
     * 
     * @param id 消息通知主键
     * @return 结果
     */
    public int deleteUNoticeById(Long id);
}
