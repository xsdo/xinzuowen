package com.ruoyi.users.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.users.domain.UNotice;

/**
 * 消息通知Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_USERS)//切换数据源
public interface UNoticeMapper
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
     * 删除消息通知
     *
     * @param id 消息通知主键
     * @return 结果
     */
    public int deleteUNoticeById(Long id);

    /**
     * 批量删除消息通知
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUNoticeByIds(Long[] ids);
}
