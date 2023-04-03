package com.ruoyi.resources.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.CircleMapper;
import com.ruoyi.resources.domain.Circle;
import com.ruoyi.resources.service.ICircleService;

/**
 * 圈子Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class CircleServiceImpl implements ICircleService 
{
    @Autowired
    private CircleMapper circleMapper;

    /**
     * 查询圈子
     * 
     * @param id 圈子主键
     * @return 圈子
     */
    @Override
    public Circle selectCircleById(Long id)
    {
        return circleMapper.selectCircleById(id);
    }

    /**
     * 查询圈子列表
     * 
     * @param circle 圈子
     * @return 圈子
     */
    @Override
    public List<Circle> selectCircleList(Circle circle)
    {
        return circleMapper.selectCircleList(circle);
    }

    /**
     * 新增圈子
     * 
     * @param circle 圈子
     * @return 结果
     */
    @Override
    public int insertCircle(Circle circle)
    {
        circle.setCreateTime(DateUtils.getNowDate());
        return circleMapper.insertCircle(circle);
    }

    /**
     * 修改圈子
     * 
     * @param circle 圈子
     * @return 结果
     */
    @Override
    public int updateCircle(Circle circle)
    {
        circle.setUpdateTime(DateUtils.getNowDate());
        return circleMapper.updateCircle(circle);
    }

    /**
     * 批量删除圈子
     * 
     * @param ids 需要删除的圈子主键
     * @return 结果
     */
    @Override
    public int deleteCircleByIds(Long[] ids)
    {
        return circleMapper.deleteCircleByIds(ids);
    }

    /**
     * 删除圈子信息
     * 
     * @param id 圈子主键
     * @return 结果
     */
    @Override
    public int deleteCircleById(Long id)
    {
        return circleMapper.deleteCircleById(id);
    }
}
