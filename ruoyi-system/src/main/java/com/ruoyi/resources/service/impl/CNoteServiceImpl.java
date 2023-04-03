package com.ruoyi.resources.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.CNoteMapper;
import com.ruoyi.resources.domain.CNote;
import com.ruoyi.resources.service.ICNoteService;

/**
 * 笔记Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class CNoteServiceImpl implements ICNoteService 
{
    @Autowired
    private CNoteMapper cNoteMapper;

    /**
     * 查询笔记
     * 
     * @param id 笔记主键
     * @return 笔记
     */
    @Override
    public CNote selectCNoteById(Long id)
    {
        return cNoteMapper.selectCNoteById(id);
    }

    /**
     * 查询笔记列表
     * 
     * @param cNote 笔记
     * @return 笔记
     */
    @Override
    public List<CNote> selectCNoteList(CNote cNote)
    {
        return cNoteMapper.selectCNoteList(cNote);
    }

    /**
     * 新增笔记
     * 
     * @param cNote 笔记
     * @return 结果
     */
    @Override
    public int insertCNote(CNote cNote)
    {
        cNote.setCreateTime(DateUtils.getNowDate());
        return cNoteMapper.insertCNote(cNote);
    }

    /**
     * 修改笔记
     * 
     * @param cNote 笔记
     * @return 结果
     */
    @Override
    public int updateCNote(CNote cNote)
    {
        cNote.setUpdateTime(DateUtils.getNowDate());
        return cNoteMapper.updateCNote(cNote);
    }

    /**
     * 批量删除笔记
     * 
     * @param ids 需要删除的笔记主键
     * @return 结果
     */
    @Override
    public int deleteCNoteByIds(Long[] ids)
    {
        return cNoteMapper.deleteCNoteByIds(ids);
    }

    /**
     * 删除笔记信息
     * 
     * @param id 笔记主键
     * @return 结果
     */
    @Override
    public int deleteCNoteById(Long id)
    {
        return cNoteMapper.deleteCNoteById(id);
    }
}
