package com.ruoyi.resources.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.ReadEssayMapper;
import com.ruoyi.resources.domain.ReadEssay;
import com.ruoyi.resources.service.IReadEssayService;

/**
 * 阅读文章Service业务层处理
 * 
 * @author xqq
 * @date 2023-04-17
 */
@Service
public class ReadEssayServiceImpl implements IReadEssayService 
{
    @Autowired
    private ReadEssayMapper readEssayMapper;

    /**
     * 查询阅读文章
     * 
     * @param id 阅读文章主键
     * @return 阅读文章
     */
    @Override
    public ReadEssay selectReadEssayById(Long id)
    {
        return readEssayMapper.selectReadEssayById(id);
    }

    /**
     * 查询阅读文章列表
     * 
     * @param readEssay 阅读文章
     * @return 阅读文章
     */
    @Override
    public List<ReadEssay> selectReadEssayList(ReadEssay readEssay)
    {
        return readEssayMapper.selectReadEssayList(readEssay);
    }

    /**
     * 新增阅读文章
     * 
     * @param readEssay 阅读文章
     * @return 结果
     */
    @Override
    public int insertReadEssay(ReadEssay readEssay)
    {
        readEssay.setCreateTime(DateUtils.getNowDate());
        return readEssayMapper.insertReadEssay(readEssay);
    }

    /**
     * 修改阅读文章
     * 
     * @param readEssay 阅读文章
     * @return 结果
     */
    @Override
    public int updateReadEssay(ReadEssay readEssay)
    {
        readEssay.setUpdateTime(DateUtils.getNowDate());
        return readEssayMapper.updateReadEssay(readEssay);
    }

    /**
     * 批量删除阅读文章
     * 
     * @param ids 需要删除的阅读文章主键
     * @return 结果
     */
    @Override
    public int deleteReadEssayByIds(Long[] ids)
    {
        return readEssayMapper.deleteReadEssayByIds(ids);
    }

    /**
     * 删除阅读文章信息
     * 
     * @param id 阅读文章主键
     * @return 结果
     */
    @Override
    public int deleteReadEssayById(Long id)
    {
        return readEssayMapper.deleteReadEssayById(id);
    }
}
