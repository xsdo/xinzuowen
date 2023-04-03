package com.ruoyi.resources.service;

import java.util.List;
import com.ruoyi.resources.domain.Magazines;

/**
 * 杂志栏目Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface IMagazinesService 
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
     * 批量删除杂志栏目
     * 
     * @param ids 需要删除的杂志栏目主键集合
     * @return 结果
     */
    public int deleteMagazinesByIds(Long[] ids);

    /**
     * 删除杂志栏目信息
     * 
     * @param id 杂志栏目主键
     * @return 结果
     */
    public int deleteMagazinesById(Long id);
}
