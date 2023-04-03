package com.ruoyi.resources.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.resources.domain.Composition;

/**
 * 作文Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_RESOURCES)//切换数据源
public interface CompositionMapper
{
    /**
     * 查询作文
     *
     * @param id 作文主键
     * @return 作文
     */
    public Composition selectCompositionById(Long id);

    /**
     * 查询作文列表
     *
     * @param composition 作文
     * @return 作文集合
     */
    public List<Composition> selectCompositionList(Composition composition);

    /**
     * 新增作文
     *
     * @param composition 作文
     * @return 结果
     */
    public int insertComposition(Composition composition);

    /**
     * 修改作文
     *
     * @param composition 作文
     * @return 结果
     */
    public int updateComposition(Composition composition);

    /**
     * 删除作文
     *
     * @param id 作文主键
     * @return 结果
     */
    public int deleteCompositionById(Long id);

    /**
     * 批量删除作文
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCompositionByIds(Long[] ids);
}
