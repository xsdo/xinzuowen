package com.ruoyi.resources.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.CTipsMapper;
import com.ruoyi.resources.domain.CTips;
import com.ruoyi.resources.service.ICTipsService;

/**
 * 举报Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class CTipsServiceImpl implements ICTipsService 
{
    @Autowired
    private CTipsMapper cTipsMapper;

    /**
     * 查询举报
     * 
     * @param id 举报主键
     * @return 举报
     */
    @Override
    public CTips selectCTipsById(Long id)
    {
        return cTipsMapper.selectCTipsById(id);
    }

    /**
     * 查询举报列表
     * 
     * @param cTips 举报
     * @return 举报
     */
    @Override
    public List<CTips> selectCTipsList(CTips cTips)
    {
        return cTipsMapper.selectCTipsList(cTips);
    }

    /**
     * 新增举报
     * 
     * @param cTips 举报
     * @return 结果
     */
    @Override
    public int insertCTips(CTips cTips)
    {
        cTips.setCreateTime(DateUtils.getNowDate());
        return cTipsMapper.insertCTips(cTips);
    }

    /**
     * 修改举报
     * 
     * @param cTips 举报
     * @return 结果
     */
    @Override
    public int updateCTips(CTips cTips)
    {
        cTips.setUpdateTime(DateUtils.getNowDate());
        return cTipsMapper.updateCTips(cTips);
    }

    /**
     * 批量删除举报
     * 
     * @param ids 需要删除的举报主键
     * @return 结果
     */
    @Override
    public int deleteCTipsByIds(Long[] ids)
    {
        return cTipsMapper.deleteCTipsByIds(ids);
    }

    /**
     * 删除举报信息
     * 
     * @param id 举报主键
     * @return 结果
     */
    @Override
    public int deleteCTipsById(Long id)
    {
        return cTipsMapper.deleteCTipsById(id);
    }
}
