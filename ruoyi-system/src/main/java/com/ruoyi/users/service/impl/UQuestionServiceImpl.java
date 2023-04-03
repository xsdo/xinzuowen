package com.ruoyi.users.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.users.mapper.UQuestionMapper;
import com.ruoyi.users.domain.UQuestion;
import com.ruoyi.users.service.IUQuestionService;

/**
 * 问题反馈Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class UQuestionServiceImpl implements IUQuestionService 
{
    @Autowired
    private UQuestionMapper uQuestionMapper;

    /**
     * 查询问题反馈
     * 
     * @param id 问题反馈主键
     * @return 问题反馈
     */
    @Override
    public UQuestion selectUQuestionById(Long id)
    {
        return uQuestionMapper.selectUQuestionById(id);
    }

    /**
     * 查询问题反馈列表
     * 
     * @param uQuestion 问题反馈
     * @return 问题反馈
     */
    @Override
    public List<UQuestion> selectUQuestionList(UQuestion uQuestion)
    {
        return uQuestionMapper.selectUQuestionList(uQuestion);
    }

    /**
     * 新增问题反馈
     * 
     * @param uQuestion 问题反馈
     * @return 结果
     */
    @Override
    public int insertUQuestion(UQuestion uQuestion)
    {
        uQuestion.setCreateTime(DateUtils.getNowDate());
        return uQuestionMapper.insertUQuestion(uQuestion);
    }

    /**
     * 修改问题反馈
     * 
     * @param uQuestion 问题反馈
     * @return 结果
     */
    @Override
    public int updateUQuestion(UQuestion uQuestion)
    {
        uQuestion.setUpdateTime(DateUtils.getNowDate());
        return uQuestionMapper.updateUQuestion(uQuestion);
    }

    /**
     * 批量删除问题反馈
     * 
     * @param ids 需要删除的问题反馈主键
     * @return 结果
     */
    @Override
    public int deleteUQuestionByIds(Long[] ids)
    {
        return uQuestionMapper.deleteUQuestionByIds(ids);
    }

    /**
     * 删除问题反馈信息
     * 
     * @param id 问题反馈主键
     * @return 结果
     */
    @Override
    public int deleteUQuestionById(Long id)
    {
        return uQuestionMapper.deleteUQuestionById(id);
    }
}
