package com.ruoyi.resources.service;

import java.util.List;
import com.ruoyi.resources.domain.CSchool;

/**
 * 校园作文Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface ICSchoolService 
{
    /**
     * 查询校园作文
     * 
     * @param id 校园作文主键
     * @return 校园作文
     */
    public CSchool selectCSchoolById(Long id);

    /**
     * 查询校园作文列表
     * 
     * @param cSchool 校园作文
     * @return 校园作文集合
     */
    public List<CSchool> selectCSchoolList(CSchool cSchool);

    /**
     * 新增校园作文
     * 
     * @param cSchool 校园作文
     * @return 结果
     */
    public int insertCSchool(CSchool cSchool);

    /**
     * 修改校园作文
     * 
     * @param cSchool 校园作文
     * @return 结果
     */
    public int updateCSchool(CSchool cSchool);

    /**
     * 批量删除校园作文
     * 
     * @param ids 需要删除的校园作文主键集合
     * @return 结果
     */
    public int deleteCSchoolByIds(Long[] ids);

    /**
     * 删除校园作文信息
     * 
     * @param id 校园作文主键
     * @return 结果
     */
    public int deleteCSchoolById(Long id);
}
