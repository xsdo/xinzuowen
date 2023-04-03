package com.ruoyi.resources.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.resources.domain.MContent;

/**
 * 杂志内容Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_RESOURCES)//切换数据源
public interface MContentMapper
{
    /**
     * 查询杂志内容
     *
     * @param id 杂志内容主键
     * @return 杂志内容
     */
    public MContent selectMContentById(Long id);

    /**
     * 查询杂志内容列表
     *
     * @param mContent 杂志内容
     * @return 杂志内容集合
     */
    public List<MContent> selectMContentList(MContent mContent);

    /**
     * 新增杂志内容
     *
     * @param mContent 杂志内容
     * @return 结果
     */
    public int insertMContent(MContent mContent);

    /**
     * 修改杂志内容
     *
     * @param mContent 杂志内容
     * @return 结果
     */
    public int updateMContent(MContent mContent);

    /**
     * 删除杂志内容
     *
     * @param id 杂志内容主键
     * @return 结果
     */
    public int deleteMContentById(Long id);

    /**
     * 批量删除杂志内容
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMContentByIds(Long[] ids);
}
