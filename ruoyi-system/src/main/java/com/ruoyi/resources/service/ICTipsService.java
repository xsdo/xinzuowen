package com.ruoyi.resources.service;

import java.util.List;
import com.ruoyi.resources.domain.CTips;

/**
 * 举报Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface ICTipsService 
{
    /**
     * 查询举报
     * 
     * @param id 举报主键
     * @return 举报
     */
    public CTips selectCTipsById(Long id);

    /**
     * 查询举报列表
     * 
     * @param cTips 举报
     * @return 举报集合
     */
    public List<CTips> selectCTipsList(CTips cTips);

    /**
     * 新增举报
     * 
     * @param cTips 举报
     * @return 结果
     */
    public int insertCTips(CTips cTips);

    /**
     * 修改举报
     * 
     * @param cTips 举报
     * @return 结果
     */
    public int updateCTips(CTips cTips);

    /**
     * 批量删除举报
     * 
     * @param ids 需要删除的举报主键集合
     * @return 结果
     */
    public int deleteCTipsByIds(Long[] ids);

    /**
     * 删除举报信息
     * 
     * @param id 举报主键
     * @return 结果
     */
    public int deleteCTipsById(Long id);
}
