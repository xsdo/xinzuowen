package com.ruoyi.resources.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.CSchoolMapper;
import com.ruoyi.resources.domain.CSchool;
import com.ruoyi.resources.service.ICSchoolService;

/**
 * 校园作文Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class CSchoolServiceImpl implements ICSchoolService 
{
    @Autowired
    private CSchoolMapper cSchoolMapper;

    /**
     * 查询校园作文
     * 
     * @param id 校园作文主键
     * @return 校园作文
     */
    @Override
    public CSchool selectCSchoolById(Long id)
    {
        return cSchoolMapper.selectCSchoolById(id);
    }

    /**
     * 查询校园作文列表
     * 
     * @param cSchool 校园作文
     * @return 校园作文
     */
    @Override
    public List<CSchool> selectCSchoolList(CSchool cSchool)
    {
        return cSchoolMapper.selectCSchoolList(cSchool);
    }

    /**
     * 新增校园作文
     * 
     * @param cSchool 校园作文
     * @return 结果
     */
    @Override
    public int insertCSchool(CSchool cSchool)
    {
        cSchool.setCreateTime(DateUtils.getNowDate());
        return cSchoolMapper.insertCSchool(cSchool);
    }

    /**
     * 修改校园作文
     * 
     * @param cSchool 校园作文
     * @return 结果
     */
    @Override
    public int updateCSchool(CSchool cSchool)
    {
        cSchool.setUpdateTime(DateUtils.getNowDate());
        return cSchoolMapper.updateCSchool(cSchool);
    }

    /**
     * 批量删除校园作文
     * 
     * @param ids 需要删除的校园作文主键
     * @return 结果
     */
    @Override
    public int deleteCSchoolByIds(Long[] ids)
    {
        return cSchoolMapper.deleteCSchoolByIds(ids);
    }

    /**
     * 删除校园作文信息
     * 
     * @param id 校园作文主键
     * @return 结果
     */
    @Override
    public int deleteCSchoolById(Long id)
    {
        return cSchoolMapper.deleteCSchoolById(id);
    }
}
