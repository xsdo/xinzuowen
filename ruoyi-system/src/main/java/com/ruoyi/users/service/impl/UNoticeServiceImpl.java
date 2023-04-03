package com.ruoyi.users.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.users.mapper.UNoticeMapper;
import com.ruoyi.users.domain.UNotice;
import com.ruoyi.users.service.IUNoticeService;

/**
 * 消息通知Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class UNoticeServiceImpl implements IUNoticeService 
{
    @Autowired
    private UNoticeMapper uNoticeMapper;

    /**
     * 查询消息通知
     * 
     * @param id 消息通知主键
     * @return 消息通知
     */
    @Override
    public UNotice selectUNoticeById(Long id)
    {
        return uNoticeMapper.selectUNoticeById(id);
    }

    /**
     * 查询消息通知列表
     * 
     * @param uNotice 消息通知
     * @return 消息通知
     */
    @Override
    public List<UNotice> selectUNoticeList(UNotice uNotice)
    {
        return uNoticeMapper.selectUNoticeList(uNotice);
    }

    /**
     * 新增消息通知
     * 
     * @param uNotice 消息通知
     * @return 结果
     */
    @Override
    public int insertUNotice(UNotice uNotice)
    {
        uNotice.setCreateTime(DateUtils.getNowDate());
        return uNoticeMapper.insertUNotice(uNotice);
    }

    /**
     * 修改消息通知
     * 
     * @param uNotice 消息通知
     * @return 结果
     */
    @Override
    public int updateUNotice(UNotice uNotice)
    {
        uNotice.setUpdateTime(DateUtils.getNowDate());
        return uNoticeMapper.updateUNotice(uNotice);
    }

    /**
     * 批量删除消息通知
     * 
     * @param ids 需要删除的消息通知主键
     * @return 结果
     */
    @Override
    public int deleteUNoticeByIds(Long[] ids)
    {
        return uNoticeMapper.deleteUNoticeByIds(ids);
    }

    /**
     * 删除消息通知信息
     * 
     * @param id 消息通知主键
     * @return 结果
     */
    @Override
    public int deleteUNoticeById(Long id)
    {
        return uNoticeMapper.deleteUNoticeById(id);
    }
}
