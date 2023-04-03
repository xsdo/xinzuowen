package com.ruoyi.users.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.users.domain.UQuestion;

/**
 * 问题反馈Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_USERS)//切换数据源
public interface UQuestionMapper
{
    /**
     * 查询问题反馈
     *
     * @param id 问题反馈主键
     * @return 问题反馈
     */
    public UQuestion selectUQuestionById(Long id);

    /**
     * 查询问题反馈列表
     *
     * @param uQuestion 问题反馈
     * @return 问题反馈集合
     */
    public List<UQuestion> selectUQuestionList(UQuestion uQuestion);

    /**
     * 新增问题反馈
     *
     * @param uQuestion 问题反馈
     * @return 结果
     */
    public int insertUQuestion(UQuestion uQuestion);

    /**
     * 修改问题反馈
     *
     * @param uQuestion 问题反馈
     * @return 结果
     */
    public int updateUQuestion(UQuestion uQuestion);

    /**
     * 删除问题反馈
     *
     * @param id 问题反馈主键
     * @return 结果
     */
    public int deleteUQuestionById(Long id);

    /**
     * 批量删除问题反馈
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUQuestionByIds(Long[] ids);
}
