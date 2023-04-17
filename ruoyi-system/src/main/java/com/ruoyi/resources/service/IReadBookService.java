package com.ruoyi.resources.service;

import java.util.List;
import com.ruoyi.resources.domain.ReadBook;

/**
 * 阅读图书Service接口
 * 
 * @author xqq
 * @date 2023-04-17
 */
public interface IReadBookService 
{
    /**
     * 查询阅读图书
     * 
     * @param id 阅读图书主键
     * @return 阅读图书
     */
    public ReadBook selectReadBookById(Long id);

    /**
     * 查询阅读图书列表
     * 
     * @param readBook 阅读图书
     * @return 阅读图书集合
     */
    public List<ReadBook> selectReadBookList(ReadBook readBook);

    /**
     * 新增阅读图书
     * 
     * @param readBook 阅读图书
     * @return 结果
     */
    public int insertReadBook(ReadBook readBook);

    /**
     * 修改阅读图书
     * 
     * @param readBook 阅读图书
     * @return 结果
     */
    public int updateReadBook(ReadBook readBook);

    /**
     * 批量删除阅读图书
     * 
     * @param ids 需要删除的阅读图书主键集合
     * @return 结果
     */
    public int deleteReadBookByIds(Long[] ids);

    /**
     * 删除阅读图书信息
     * 
     * @param id 阅读图书主键
     * @return 结果
     */
    public int deleteReadBookById(Long id);
}
