package com.ruoyi.resources.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.resources.domain.CSubmit;

/**
 * 投稿Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_RESOURCES)//切换数据源
public interface CSubmitMapper
{
    /**
     * 查询投稿
     *
     * @param id 投稿主键
     * @return 投稿
     */
    public CSubmit selectCSubmitById(Long id);

    /**
     * 查询投稿列表
     *
     * @param cSubmit 投稿
     * @return 投稿集合
     */
    public List<CSubmit> selectCSubmitList(CSubmit cSubmit);

    /**
     * 新增投稿
     *
     * @param cSubmit 投稿
     * @return 结果
     */
    public int insertCSubmit(CSubmit cSubmit);

    /**
     * 修改投稿
     *
     * @param cSubmit 投稿
     * @return 结果
     */
    public int updateCSubmit(CSubmit cSubmit);

    /**
     * 删除投稿
     *
     * @param id 投稿主键
     * @return 结果
     */
    public int deleteCSubmitById(Long id);

    /**
     * 批量删除投稿
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCSubmitByIds(Long[] ids);
}
