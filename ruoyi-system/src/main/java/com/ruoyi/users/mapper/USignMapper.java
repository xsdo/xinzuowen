package com.ruoyi.users.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.users.domain.USign;

/**
 * 签到Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_USERS)//切换数据源
public interface USignMapper
{
    /**
     * 查询签到
     *
     * @param id 签到主键
     * @return 签到
     */
    public USign selectUSignById(Long id);

    /**
     * 查询签到列表
     *
     * @param uSign 签到
     * @return 签到集合
     */
    public List<USign> selectUSignList(USign uSign);

    /**
     * 新增签到
     *
     * @param uSign 签到
     * @return 结果
     */
    public int insertUSign(USign uSign);

    /**
     * 修改签到
     *
     * @param uSign 签到
     * @return 结果
     */
    public int updateUSign(USign uSign);

    /**
     * 删除签到
     *
     * @param id 签到主键
     * @return 结果
     */
    public int deleteUSignById(Long id);

    /**
     * 批量删除签到
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUSignByIds(Long[] ids);
}
