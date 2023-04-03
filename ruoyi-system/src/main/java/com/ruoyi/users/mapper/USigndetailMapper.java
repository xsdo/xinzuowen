package com.ruoyi.users.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.users.domain.USigndetail;

/**
 * 签到明细Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_USERS)//切换数据源
public interface USigndetailMapper
{
    /**
     * 查询签到明细
     *
     * @param id 签到明细主键
     * @return 签到明细
     */
    public USigndetail selectUSigndetailById(Long id);

    /**
     * 查询签到明细列表
     *
     * @param uSigndetail 签到明细
     * @return 签到明细集合
     */
    public List<USigndetail> selectUSigndetailList(USigndetail uSigndetail);

    /**
     * 新增签到明细
     *
     * @param uSigndetail 签到明细
     * @return 结果
     */
    public int insertUSigndetail(USigndetail uSigndetail);

    /**
     * 修改签到明细
     *
     * @param uSigndetail 签到明细
     * @return 结果
     */
    public int updateUSigndetail(USigndetail uSigndetail);

    /**
     * 删除签到明细
     *
     * @param id 签到明细主键
     * @return 结果
     */
    public int deleteUSigndetailById(Long id);

    /**
     * 批量删除签到明细
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUSigndetailByIds(Long[] ids);
}
