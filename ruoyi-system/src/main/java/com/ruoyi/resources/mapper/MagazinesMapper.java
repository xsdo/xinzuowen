package com.ruoyi.resources.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.resources.domain.Magazines;

/**
 * 杂志栏目Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_RESOURCES)//切换数据源
public interface MagazinesMapper
{
    /**
     * 查询杂志栏目
     *
     * @param id 杂志栏目主键
     * @return 杂志栏目
     */
    public Magazines selectMagazinesById(Long id);

    /**
     * 查询杂志栏目列表
     *
     * @param magazines 杂志栏目
     * @return 杂志栏目集合
     */
    public List<Magazines> selectMagazinesList(Magazines magazines);

    /**
     * 新增杂志栏目
     *
     * @param magazines 杂志栏目
     * @return 结果
     */
    public int insertMagazines(Magazines magazines);

    /**
     * 修改杂志栏目
     *
     * @param magazines 杂志栏目
     * @return 结果
     */
    public int updateMagazines(Magazines magazines);

    /**
     * 删除杂志栏目
     *
     * @param id 杂志栏目主键
     * @return 结果
     */
    public int deleteMagazinesById(Long id);

    /**
     * 批量删除杂志栏目
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMagazinesByIds(Long[] ids);
}
