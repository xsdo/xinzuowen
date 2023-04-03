package com.ruoyi.resources.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.CCollectMapper;
import com.ruoyi.resources.domain.CCollect;
import com.ruoyi.resources.service.ICCollectService;

/**
 * 收藏Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class CCollectServiceImpl implements ICCollectService 
{
    @Autowired
    private CCollectMapper cCollectMapper;

    /**
     * 查询收藏
     * 
     * @param id 收藏主键
     * @return 收藏
     */
    @Override
    public CCollect selectCCollectById(Long id)
    {
        return cCollectMapper.selectCCollectById(id);
    }

    /**
     * 查询收藏列表
     * 
     * @param cCollect 收藏
     * @return 收藏
     */
    @Override
    public List<CCollect> selectCCollectList(CCollect cCollect)
    {
        return cCollectMapper.selectCCollectList(cCollect);
    }

    /**
     * 新增收藏
     * 
     * @param cCollect 收藏
     * @return 结果
     */
    @Override
    public int insertCCollect(CCollect cCollect)
    {
        cCollect.setCreateTime(DateUtils.getNowDate());
        return cCollectMapper.insertCCollect(cCollect);
    }

    /**
     * 修改收藏
     * 
     * @param cCollect 收藏
     * @return 结果
     */
    @Override
    public int updateCCollect(CCollect cCollect)
    {
        cCollect.setUpdateTime(DateUtils.getNowDate());
        return cCollectMapper.updateCCollect(cCollect);
    }

    /**
     * 批量删除收藏
     * 
     * @param ids 需要删除的收藏主键
     * @return 结果
     */
    @Override
    public int deleteCCollectByIds(Long[] ids)
    {
        return cCollectMapper.deleteCCollectByIds(ids);
    }

    /**
     * 删除收藏信息
     * 
     * @param id 收藏主键
     * @return 结果
     */
    @Override
    public int deleteCCollectById(Long id)
    {
        return cCollectMapper.deleteCCollectById(id);
    }
}
