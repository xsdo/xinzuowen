package com.ruoyi.resources.service;

import java.util.List;
import com.ruoyi.resources.domain.CCollect;

/**
 * 收藏Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface ICCollectService 
{
    /**
     * 查询收藏
     * 
     * @param id 收藏主键
     * @return 收藏
     */
    public CCollect selectCCollectById(Long id);

    /**
     * 查询收藏列表
     * 
     * @param cCollect 收藏
     * @return 收藏集合
     */
    public List<CCollect> selectCCollectList(CCollect cCollect);

    /**
     * 新增收藏
     * 
     * @param cCollect 收藏
     * @return 结果
     */
    public int insertCCollect(CCollect cCollect);

    /**
     * 修改收藏
     * 
     * @param cCollect 收藏
     * @return 结果
     */
    public int updateCCollect(CCollect cCollect);

    /**
     * 批量删除收藏
     * 
     * @param ids 需要删除的收藏主键集合
     * @return 结果
     */
    public int deleteCCollectByIds(Long[] ids);

    /**
     * 删除收藏信息
     * 
     * @param id 收藏主键
     * @return 结果
     */
    public int deleteCCollectById(Long id);
}
