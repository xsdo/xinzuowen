package com.ruoyi.users.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.users.domain.UFans;

/**
 * 用户粉丝Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_USERS)//切换数据源
public interface UFansMapper
{
    /**
     * 查询用户粉丝
     *
     * @param id 用户粉丝主键
     * @return 用户粉丝
     */
    public UFans selectUFansById(Long id);

    /**
     * 查询用户粉丝列表
     *
     * @param uFans 用户粉丝
     * @return 用户粉丝集合
     */
    public List<UFans> selectUFansList(UFans uFans);

    /**
     * 新增用户粉丝
     *
     * @param uFans 用户粉丝
     * @return 结果
     */
    public int insertUFans(UFans uFans);

    /**
     * 修改用户粉丝
     *
     * @param uFans 用户粉丝
     * @return 结果
     */
    public int updateUFans(UFans uFans);

    /**
     * 删除用户粉丝
     *
     * @param id 用户粉丝主键
     * @return 结果
     */
    public int deleteUFansById(Long id);

    /**
     * 批量删除用户粉丝
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUFansByIds(Long[] ids);
}
