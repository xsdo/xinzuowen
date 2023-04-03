package com.ruoyi.users.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.users.mapper.UTableMapper;
import com.ruoyi.users.domain.UTable;
import com.ruoyi.users.service.IUTableService;

/**
 * 用户标签Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class UTableServiceImpl implements IUTableService 
{
    @Autowired
    private UTableMapper uTableMapper;

    /**
     * 查询用户标签
     * 
     * @param id 用户标签主键
     * @return 用户标签
     */
    @Override
    public UTable selectUTableById(Long id)
    {
        return uTableMapper.selectUTableById(id);
    }

    /**
     * 查询用户标签列表
     * 
     * @param uTable 用户标签
     * @return 用户标签
     */
    @Override
    public List<UTable> selectUTableList(UTable uTable)
    {
        return uTableMapper.selectUTableList(uTable);
    }

    /**
     * 新增用户标签
     * 
     * @param uTable 用户标签
     * @return 结果
     */
    @Override
    public int insertUTable(UTable uTable)
    {
        uTable.setCreateTime(DateUtils.getNowDate());
        return uTableMapper.insertUTable(uTable);
    }

    /**
     * 修改用户标签
     * 
     * @param uTable 用户标签
     * @return 结果
     */
    @Override
    public int updateUTable(UTable uTable)
    {
        uTable.setUpdateTime(DateUtils.getNowDate());
        return uTableMapper.updateUTable(uTable);
    }

    /**
     * 批量删除用户标签
     * 
     * @param ids 需要删除的用户标签主键
     * @return 结果
     */
    @Override
    public int deleteUTableByIds(Long[] ids)
    {
        return uTableMapper.deleteUTableByIds(ids);
    }

    /**
     * 删除用户标签信息
     * 
     * @param id 用户标签主键
     * @return 结果
     */
    @Override
    public int deleteUTableById(Long id)
    {
        return uTableMapper.deleteUTableById(id);
    }
}
