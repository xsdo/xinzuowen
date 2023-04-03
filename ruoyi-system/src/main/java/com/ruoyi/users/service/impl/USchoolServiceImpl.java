package com.ruoyi.users.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.users.mapper.USchoolMapper;
import com.ruoyi.users.domain.USchool;
import com.ruoyi.users.service.IUSchoolService;

/**
 * 用户学校Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class USchoolServiceImpl implements IUSchoolService 
{
    @Autowired
    private USchoolMapper uSchoolMapper;

    /**
     * 查询用户学校
     * 
     * @param id 用户学校主键
     * @return 用户学校
     */
    @Override
    public USchool selectUSchoolById(Long id)
    {
        return uSchoolMapper.selectUSchoolById(id);
    }

    /**
     * 查询用户学校列表
     * 
     * @param uSchool 用户学校
     * @return 用户学校
     */
    @Override
    public List<USchool> selectUSchoolList(USchool uSchool)
    {
        return uSchoolMapper.selectUSchoolList(uSchool);
    }

    /**
     * 新增用户学校
     * 
     * @param uSchool 用户学校
     * @return 结果
     */
    @Override
    public int insertUSchool(USchool uSchool)
    {
        uSchool.setCreateTime(DateUtils.getNowDate());
        return uSchoolMapper.insertUSchool(uSchool);
    }

    /**
     * 修改用户学校
     * 
     * @param uSchool 用户学校
     * @return 结果
     */
    @Override
    public int updateUSchool(USchool uSchool)
    {
        uSchool.setUpdateTime(DateUtils.getNowDate());
        return uSchoolMapper.updateUSchool(uSchool);
    }

    /**
     * 批量删除用户学校
     * 
     * @param ids 需要删除的用户学校主键
     * @return 结果
     */
    @Override
    public int deleteUSchoolByIds(Long[] ids)
    {
        return uSchoolMapper.deleteUSchoolByIds(ids);
    }

    /**
     * 删除用户学校信息
     * 
     * @param id 用户学校主键
     * @return 结果
     */
    @Override
    public int deleteUSchoolById(Long id)
    {
        return uSchoolMapper.deleteUSchoolById(id);
    }
}
