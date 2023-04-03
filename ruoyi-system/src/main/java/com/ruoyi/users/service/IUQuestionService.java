package com.ruoyi.users.service;

import java.util.List;
import com.ruoyi.users.domain.UQuestion;

/**
 * 问题反馈Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface IUQuestionService 
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
     * 批量删除问题反馈
     * 
     * @param ids 需要删除的问题反馈主键集合
     * @return 结果
     */
    public int deleteUQuestionByIds(Long[] ids);

    /**
     * 删除问题反馈信息
     * 
     * @param id 问题反馈主键
     * @return 结果
     */
    public int deleteUQuestionById(Long id);
}
