package com.ruoyi.resources.mapper;

import java.util.List;
import com.ruoyi.resources.domain.ReadEssay;

/**
 * 阅读文章Mapper接口
 * 
 * @author xqq
 * @date 2023-04-17
 */
public interface ReadEssayMapper 
{
    /**
     * 查询阅读文章
     * 
     * @param id 阅读文章主键
     * @return 阅读文章
     */
    public ReadEssay selectReadEssayById(Long id);

    /**
     * 查询阅读文章列表
     * 
     * @param readEssay 阅读文章
     * @return 阅读文章集合
     */
    public List<ReadEssay> selectReadEssayList(ReadEssay readEssay);

    /**
     * 新增阅读文章
     * 
     * @param readEssay 阅读文章
     * @return 结果
     */
    public int insertReadEssay(ReadEssay readEssay);

    /**
     * 修改阅读文章
     * 
     * @param readEssay 阅读文章
     * @return 结果
     */
    public int updateReadEssay(ReadEssay readEssay);

    /**
     * 删除阅读文章
     * 
     * @param id 阅读文章主键
     * @return 结果
     */
    public int deleteReadEssayById(Long id);

    /**
     * 批量删除阅读文章
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteReadEssayByIds(Long[] ids);
}
