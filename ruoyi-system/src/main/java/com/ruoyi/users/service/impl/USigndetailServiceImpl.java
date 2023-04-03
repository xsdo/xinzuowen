package com.ruoyi.users.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.users.mapper.USigndetailMapper;
import com.ruoyi.users.domain.USigndetail;
import com.ruoyi.users.service.IUSigndetailService;

/**
 * 签到明细Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class USigndetailServiceImpl implements IUSigndetailService 
{
    @Autowired
    private USigndetailMapper uSigndetailMapper;

    /**
     * 查询签到明细
     * 
     * @param id 签到明细主键
     * @return 签到明细
     */
    @Override
    public USigndetail selectUSigndetailById(Long id)
    {
        return uSigndetailMapper.selectUSigndetailById(id);
    }

    /**
     * 查询签到明细列表
     * 
     * @param uSigndetail 签到明细
     * @return 签到明细
     */
    @Override
    public List<USigndetail> selectUSigndetailList(USigndetail uSigndetail)
    {
        return uSigndetailMapper.selectUSigndetailList(uSigndetail);
    }

    /**
     * 新增签到明细
     * 
     * @param uSigndetail 签到明细
     * @return 结果
     */
    @Override
    public int insertUSigndetail(USigndetail uSigndetail)
    {
        uSigndetail.setCreateTime(DateUtils.getNowDate());
        return uSigndetailMapper.insertUSigndetail(uSigndetail);
    }

    /**
     * 修改签到明细
     * 
     * @param uSigndetail 签到明细
     * @return 结果
     */
    @Override
    public int updateUSigndetail(USigndetail uSigndetail)
    {
        uSigndetail.setUpdateTime(DateUtils.getNowDate());
        return uSigndetailMapper.updateUSigndetail(uSigndetail);
    }

    /**
     * 批量删除签到明细
     * 
     * @param ids 需要删除的签到明细主键
     * @return 结果
     */
    @Override
    public int deleteUSigndetailByIds(Long[] ids)
    {
        return uSigndetailMapper.deleteUSigndetailByIds(ids);
    }

    /**
     * 删除签到明细信息
     * 
     * @param id 签到明细主键
     * @return 结果
     */
    @Override
    public int deleteUSigndetailById(Long id)
    {
        return uSigndetailMapper.deleteUSigndetailById(id);
    }
}
