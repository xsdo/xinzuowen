package com.ruoyi.resources.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.ReadBookMapper;
import com.ruoyi.resources.domain.ReadBook;
import com.ruoyi.resources.service.IReadBookService;

/**
 * 阅读图书Service业务层处理
 * 
 * @author xqq
 * @date 2023-04-17
 */
@Service
public class ReadBookServiceImpl implements IReadBookService 
{
    @Autowired
    private ReadBookMapper readBookMapper;

    /**
     * 查询阅读图书
     * 
     * @param id 阅读图书主键
     * @return 阅读图书
     */
    @Override
    public ReadBook selectReadBookById(Long id)
    {
        return readBookMapper.selectReadBookById(id);
    }

    /**
     * 查询阅读图书列表
     * 
     * @param readBook 阅读图书
     * @return 阅读图书
     */
    @Override
    public List<ReadBook> selectReadBookList(ReadBook readBook)
    {
        return readBookMapper.selectReadBookList(readBook);
    }

    /**
     * 新增阅读图书
     * 
     * @param readBook 阅读图书
     * @return 结果
     */
    @Override
    public int insertReadBook(ReadBook readBook)
    {
        readBook.setCreateTime(DateUtils.getNowDate());
        return readBookMapper.insertReadBook(readBook);
    }

    /**
     * 修改阅读图书
     * 
     * @param readBook 阅读图书
     * @return 结果
     */
    @Override
    public int updateReadBook(ReadBook readBook)
    {
        readBook.setUpdateTime(DateUtils.getNowDate());
        return readBookMapper.updateReadBook(readBook);
    }

    /**
     * 批量删除阅读图书
     * 
     * @param ids 需要删除的阅读图书主键
     * @return 结果
     */
    @Override
    public int deleteReadBookByIds(Long[] ids)
    {
        return readBookMapper.deleteReadBookByIds(ids);
    }

    /**
     * 删除阅读图书信息
     * 
     * @param id 阅读图书主键
     * @return 结果
     */
    @Override
    public int deleteReadBookById(Long id)
    {
        return readBookMapper.deleteReadBookById(id);
    }
}
