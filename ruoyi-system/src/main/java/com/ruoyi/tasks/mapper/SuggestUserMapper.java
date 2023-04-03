package com.ruoyi.tasks.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.tasks.domain.SuggestUser;

/**
 * 推荐用户Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_TASKS)//切换数据源
public interface SuggestUserMapper
{
    /**
     * 查询推荐用户
     *
     * @param id 推荐用户主键
     * @return 推荐用户
     */
    public SuggestUser selectSuggestUserById(Long id);

    /**
     * 查询推荐用户列表
     *
     * @param suggestUser 推荐用户
     * @return 推荐用户集合
     */
    public List<SuggestUser> selectSuggestUserList(SuggestUser suggestUser);

    /**
     * 新增推荐用户
     *
     * @param suggestUser 推荐用户
     * @return 结果
     */
    public int insertSuggestUser(SuggestUser suggestUser);

    /**
     * 修改推荐用户
     *
     * @param suggestUser 推荐用户
     * @return 结果
     */
    public int updateSuggestUser(SuggestUser suggestUser);

    /**
     * 删除推荐用户
     *
     * @param id 推荐用户主键
     * @return 结果
     */
    public int deleteSuggestUserById(Long id);

    /**
     * 批量删除推荐用户
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSuggestUserByIds(Long[] ids);
}
