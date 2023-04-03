package com.ruoyi.resources.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.resources.domain.CNote;

/**
 * 笔记Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_RESOURCES)//切换数据源
public interface CNoteMapper
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
     * 删除笔记
     *
     * @param id 笔记主键
     * @return 结果
     */
    public int deleteCNoteById(Long id);

    /**
     * 批量删除笔记
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCNoteByIds(Long[] ids);
}
