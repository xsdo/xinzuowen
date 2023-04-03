package com.ruoyi.resources.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.CAuthorsMapper;
import com.ruoyi.resources.domain.CAuthors;
import com.ruoyi.resources.service.ICAuthorsService;

/**
 * 作者Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class CAuthorsServiceImpl implements ICAuthorsService 
{
    @Autowired
    private CAuthorsMapper cAuthorsMapper;

    /**
     * 查询作者
     * 
     * @param id 作者主键
     * @return 作者
     */
    @Override
    public CAuthors selectCAuthorsById(Long id)
    {
        return cAuthorsMapper.selectCAuthorsById(id);
    }

    /**
     * 查询作者列表
     * 
     * @param cAuthors 作者
     * @return 作者
     */
    @Override
    public List<CAuthors> selectCAuthorsList(CAuthors cAuthors)
    {
        return cAuthorsMapper.selectCAuthorsList(cAuthors);
    }

    /**
     * 新增作者
     * 
     * @param cAuthors 作者
     * @return 结果
     */
    @Override
    public int insertCAuthors(CAuthors cAuthors)
    {
        cAuthors.setCreateTime(DateUtils.getNowDate());
        return cAuthorsMapper.insertCAuthors(cAuthors);
    }

    /**
     * 修改作者
     * 
     * @param cAuthors 作者
     * @return 结果
     */
    @Override
    public int updateCAuthors(CAuthors cAuthors)
    {
        cAuthors.setUpdateTime(DateUtils.getNowDate());
        return cAuthorsMapper.updateCAuthors(cAuthors);
    }

    /**
     * 批量删除作者
     * 
     * @param ids 需要删除的作者主键
     * @return 结果
     */
    @Override
    public int deleteCAuthorsByIds(Long[] ids)
    {
        return cAuthorsMapper.deleteCAuthorsByIds(ids);
    }

    /**
     * 删除作者信息
     * 
     * @param id 作者主键
     * @return 结果
     */
    @Override
    public int deleteCAuthorsById(Long id)
    {
        return cAuthorsMapper.deleteCAuthorsById(id);
    }
}
