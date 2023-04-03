package com.ruoyi.resources.service;

import java.util.List;
import com.ruoyi.resources.domain.CAuthors;

/**
 * 作者Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface ICAuthorsService 
{
    /**
     * 查询作者
     * 
     * @param id 作者主键
     * @return 作者
     */
    public CAuthors selectCAuthorsById(Long id);

    /**
     * 查询作者列表
     * 
     * @param cAuthors 作者
     * @return 作者集合
     */
    public List<CAuthors> selectCAuthorsList(CAuthors cAuthors);

    /**
     * 新增作者
     * 
     * @param cAuthors 作者
     * @return 结果
     */
    public int insertCAuthors(CAuthors cAuthors);

    /**
     * 修改作者
     * 
     * @param cAuthors 作者
     * @return 结果
     */
    public int updateCAuthors(CAuthors cAuthors);

    /**
     * 批量删除作者
     * 
     * @param ids 需要删除的作者主键集合
     * @return 结果
     */
    public int deleteCAuthorsByIds(Long[] ids);

    /**
     * 删除作者信息
     * 
     * @param id 作者主键
     * @return 结果
     */
    public int deleteCAuthorsById(Long id);
}
