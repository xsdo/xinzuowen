package com.ruoyi.users.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.users.mapper.USignMapper;
import com.ruoyi.users.domain.USign;
import com.ruoyi.users.service.IUSignService;

/**
 * 签到Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class USignServiceImpl implements IUSignService 
{
    @Autowired
    private USignMapper uSignMapper;

    /**
     * 查询签到
     * 
     * @param id 签到主键
     * @return 签到
     */
    @Override
    public USign selectUSignById(Long id)
    {
        return uSignMapper.selectUSignById(id);
    }

    /**
     * 查询签到列表
     * 
     * @param uSign 签到
     * @return 签到
     */
    @Override
    public List<USign> selectUSignList(USign uSign)
    {
        return uSignMapper.selectUSignList(uSign);
    }

    /**
     * 新增签到
     * 
     * @param uSign 签到
     * @return 结果
     */
    @Override
    public int insertUSign(USign uSign)
    {
        uSign.setCreateTime(DateUtils.getNowDate());
        return uSignMapper.insertUSign(uSign);
    }

    /**
     * 修改签到
     * 
     * @param uSign 签到
     * @return 结果
     */
    @Override
    public int updateUSign(USign uSign)
    {
        uSign.setUpdateTime(DateUtils.getNowDate());
        return uSignMapper.updateUSign(uSign);
    }

    /**
     * 批量删除签到
     * 
     * @param ids 需要删除的签到主键
     * @return 结果
     */
    @Override
    public int deleteUSignByIds(Long[] ids)
    {
        return uSignMapper.deleteUSignByIds(ids);
    }

    /**
     * 删除签到信息
     * 
     * @param id 签到主键
     * @return 结果
     */
    @Override
    public int deleteUSignById(Long id)
    {
        return uSignMapper.deleteUSignById(id);
    }
}
