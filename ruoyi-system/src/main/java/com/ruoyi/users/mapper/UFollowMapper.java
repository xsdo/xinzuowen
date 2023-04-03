package com.ruoyi.users.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.users.domain.UFollow;

/**
 * 用户关注Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_USERS)//切换数据源
public interface UFollowMapper
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
     * 删除用户关注
     *
     * @param id 用户关注主键
     * @return 结果
     */
    public int deleteUFollowById(Long id);

    /**
     * 批量删除用户关注
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUFollowByIds(Long[] ids);
}
