package com.ruoyi.users.service;

import java.util.List;
import com.ruoyi.users.domain.USchool;

/**
 * 用户学校Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface IUSchoolService 
{
    /**
     * 查询用户学校
     * 
     * @param id 用户学校主键
     * @return 用户学校
     */
    public USchool selectUSchoolById(Long id);

    USchool schoolQRCode(Long schoolId);
    USchool schoolQRCodePress(Long schoolId);
    /**
     * 查询用户学校列表
     * 
     * @param uSchool 用户学校
     * @return 用户学校集合
     */
    public List<USchool> selectUSchoolList(USchool uSchool);

    /**
     * 新增用户学校
     * 
     * @param uSchool 用户学校
     * @return 结果
     */
    public int insertUSchool(USchool uSchool);

    /**
     * 修改用户学校
     * 
     * @param uSchool 用户学校
     * @return 结果
     */
    public int updateUSchool(USchool uSchool);

    /**
     * 批量删除用户学校
     * 
     * @param ids 需要删除的用户学校主键集合
     * @return 结果
     */
    public int deleteUSchoolByIds(Long[] ids);

    /**
     * 删除用户学校信息
     * 
     * @param id 用户学校主键
     * @return 结果
     */
    public int deleteUSchoolById(Long id);
}
