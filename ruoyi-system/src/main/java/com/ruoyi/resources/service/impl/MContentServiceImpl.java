package com.ruoyi.resources.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.MContentMapper;
import com.ruoyi.resources.domain.MContent;
import com.ruoyi.resources.service.IMContentService;

/**
 * 杂志内容Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class MContentServiceImpl implements IMContentService 
{
    @Autowired
    private MContentMapper mContentMapper;

    /**
     * 查询杂志内容
     * 
     * @param id 杂志内容主键
     * @return 杂志内容
     */
    @Override
    public MContent selectMContentById(Long id)
    {
        return mContentMapper.selectMContentById(id);
    }

    /**
     * 查询杂志内容列表
     * 
     * @param mContent 杂志内容
     * @return 杂志内容
     */
    @Override
    public List<MContent> selectMContentList(MContent mContent)
    {
        return mContentMapper.selectMContentList(mContent);
    }

    /**
     * 新增杂志内容
     * 
     * @param mContent 杂志内容
     * @return 结果
     */
    @Override
    public int insertMContent(MContent mContent)
    {
        mContent.setCreateTime(DateUtils.getNowDate());
        return mContentMapper.insertMContent(mContent);
    }

    /**
     * 修改杂志内容
     * 
     * @param mContent 杂志内容
     * @return 结果
     */
    @Override
    public int updateMContent(MContent mContent)
    {
        mContent.setUpdateTime(DateUtils.getNowDate());
        return mContentMapper.updateMContent(mContent);
    }

    /**
     * 批量删除杂志内容
     * 
     * @param ids 需要删除的杂志内容主键
     * @return 结果
     */
    @Override
    public int deleteMContentByIds(Long[] ids)
    {
        return mContentMapper.deleteMContentByIds(ids);
    }

    /**
     * 删除杂志内容信息
     * 
     * @param id 杂志内容主键
     * @return 结果
     */
    @Override
    public int deleteMContentById(Long id)
    {
        return mContentMapper.deleteMContentById(id);
    }
}
