package com.ruoyi.resources.service;

import java.util.List;
import com.ruoyi.resources.domain.CNote;

/**
 * 笔记Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface ICNoteService 
{
    /**
     * 查询笔记
     * 
     * @param id 笔记主键
     * @return 笔记
     */
    public CNote selectCNoteById(Long id);

    /**
     * 查询笔记列表
     * 
     * @param cNote 笔记
     * @return 笔记集合
     */
    public List<CNote> selectCNoteList(CNote cNote);

    /**
     * 新增笔记
     * 
     * @param cNote 笔记
     * @return 结果
     */
    public int insertCNote(CNote cNote);

    /**
     * 修改笔记
     * 
     * @param cNote 笔记
     * @return 结果
     */
    public int updateCNote(CNote cNote);

    /**
     * 批量删除笔记
     * 
     * @param ids 需要删除的笔记主键集合
     * @return 结果
     */
    public int deleteCNoteByIds(Long[] ids);

    /**
     * 删除笔记信息
     * 
     * @param id 笔记主键
     * @return 结果
     */
    public int deleteCNoteById(Long id);
}
