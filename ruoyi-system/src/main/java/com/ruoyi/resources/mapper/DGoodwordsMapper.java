package com.ruoyi.resources.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.resources.domain.DGoodwords;

/**
 * 部编好词Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_RESOURCES)//切换数据源
public interface DGoodwordsMapper
{
    /**
     * 查询部编好词
     *
     * @param id 部编好词主键
     * @return 部编好词
     */
    public DGoodwords selectDGoodwordsById(Long id);

    /**
     * 查询部编好词列表
     *
     * @param dGoodwords 部编好词
     * @return 部编好词集合
     */
    public List<DGoodwords> selectDGoodwordsList(DGoodwords dGoodwords);

    /**
     * 新增部编好词
     *
     * @param dGoodwords 部编好词
     * @return 结果
     */
    public int insertDGoodwords(DGoodwords dGoodwords);

    /**
     * 修改部编好词
     *
     * @param dGoodwords 部编好词
     * @return 结果
     */
    public int updateDGoodwords(DGoodwords dGoodwords);

    /**
     * 删除部编好词
     *
     * @param id 部编好词主键
     * @return 结果
     */
    public int deleteDGoodwordsById(Long id);

    /**
     * 批量删除部编好词
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDGoodwordsByIds(Long[] ids);
}
