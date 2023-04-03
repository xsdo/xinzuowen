package com.ruoyi.resources.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.CCollectlogMapper;
import com.ruoyi.resources.domain.CCollectlog;
import com.ruoyi.resources.service.ICCollectlogService;

/**
 * 收藏夹文件Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class CCollectlogServiceImpl implements ICCollectlogService 
{
    @Autowired
    private CCollectlogMapper cCollectlogMapper;

    /**
     * 查询收藏夹文件
     * 
     * @param id 收藏夹文件主键
     * @return 收藏夹文件
     */
    @Override
    public CCollectlog selectCCollectlogById(Long id)
    {
        return cCollectlogMapper.selectCCollectlogById(id);
    }

    /**
     * 查询收藏夹文件列表
     * 
     * @param cCollectlog 收藏夹文件
     * @return 收藏夹文件
     */
    @Override
    public List<CCollectlog> selectCCollectlogList(CCollectlog cCollectlog)
    {
        return cCollectlogMapper.selectCCollectlogList(cCollectlog);
    }

    /**
     * 新增收藏夹文件
     * 
     * @param cCollectlog 收藏夹文件
     * @return 结果
     */
    @Override
    public int insertCCollectlog(CCollectlog cCollectlog)
    {
        cCollectlog.setCreateTime(DateUtils.getNowDate());
        return cCollectlogMapper.insertCCollectlog(cCollectlog);
    }

    /**
     * 修改收藏夹文件
     * 
     * @param cCollectlog 收藏夹文件
     * @return 结果
     */
    @Override
    public int updateCCollectlog(CCollectlog cCollectlog)
    {
        cCollectlog.setUpdateTime(DateUtils.getNowDate());
        return cCollectlogMapper.updateCCollectlog(cCollectlog);
    }

    /**
     * 批量删除收藏夹文件
     * 
     * @param ids 需要删除的收藏夹文件主键
     * @return 结果
     */
    @Override
    public int deleteCCollectlogByIds(Long[] ids)
    {
        return cCollectlogMapper.deleteCCollectlogByIds(ids);
    }

    /**
     * 删除收藏夹文件信息
     * 
     * @param id 收藏夹文件主键
     * @return 结果
     */
    @Override
    public int deleteCCollectlogById(Long id)
    {
        return cCollectlogMapper.deleteCCollectlogById(id);
    }
}
