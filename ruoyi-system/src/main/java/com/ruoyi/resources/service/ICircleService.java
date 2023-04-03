package com.ruoyi.resources.service;

import java.util.List;
import com.ruoyi.resources.domain.Circle;

/**
 * 圈子Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface ICircleService 
{
    /**
     * 查询圈子
     * 
     * @param id 圈子主键
     * @return 圈子
     */
    public Circle selectCircleById(Long id);

    /**
     * 查询圈子列表
     * 
     * @param circle 圈子
     * @return 圈子集合
     */
    public List<Circle> selectCircleList(Circle circle);

    /**
     * 新增圈子
     * 
     * @param circle 圈子
     * @return 结果
     */
    public int insertCircle(Circle circle);

    /**
     * 修改圈子
     * 
     * @param circle 圈子
     * @return 结果
     */
    public int updateCircle(Circle circle);

    /**
     * 批量删除圈子
     * 
     * @param ids 需要删除的圈子主键集合
     * @return 结果
     */
    public int deleteCircleByIds(Long[] ids);

    /**
     * 删除圈子信息
     * 
     * @param id 圈子主键
     * @return 结果
     */
    public int deleteCircleById(Long id);
}
