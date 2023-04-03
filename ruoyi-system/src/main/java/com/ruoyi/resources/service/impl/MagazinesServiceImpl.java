package com.ruoyi.resources.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.MagazinesMapper;
import com.ruoyi.resources.domain.Magazines;
import com.ruoyi.resources.service.IMagazinesService;

/**
 * 杂志栏目Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class MagazinesServiceImpl implements IMagazinesService 
{
    @Autowired
    private MagazinesMapper magazinesMapper;

    /**
     * 查询杂志栏目
     * 
     * @param id 杂志栏目主键
     * @return 杂志栏目
     */
    @Override
    public Magazines selectMagazinesById(Long id)
    {
        return magazinesMapper.selectMagazinesById(id);
    }

    /**
     * 查询杂志栏目列表
     * 
     * @param magazines 杂志栏目
     * @return 杂志栏目
     */
    @Override
    public List<Magazines> selectMagazinesList(Magazines magazines)
    {
        return magazinesMapper.selectMagazinesList(magazines);
    }

    /**
     * 新增杂志栏目
     * 
     * @param magazines 杂志栏目
     * @return 结果
     */
    @Override
    public int insertMagazines(Magazines magazines)
    {
        magazines.setCreateTime(DateUtils.getNowDate());
        return magazinesMapper.insertMagazines(magazines);
    }

    /**
     * 修改杂志栏目
     * 
     * @param magazines 杂志栏目
     * @return 结果
     */
    @Override
    public int updateMagazines(Magazines magazines)
    {
        magazines.setUpdateTime(DateUtils.getNowDate());
        return magazinesMapper.updateMagazines(magazines);
    }

    /**
     * 批量删除杂志栏目
     * 
     * @param ids 需要删除的杂志栏目主键
     * @return 结果
     */
    @Override
    public int deleteMagazinesByIds(Long[] ids)
    {
        return magazinesMapper.deleteMagazinesByIds(ids);
    }

    /**
     * 删除杂志栏目信息
     * 
     * @param id 杂志栏目主键
     * @return 结果
     */
    @Override
    public int deleteMagazinesById(Long id)
    {
        return magazinesMapper.deleteMagazinesById(id);
    }
}
