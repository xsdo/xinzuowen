package com.ruoyi.resources.service;

import java.util.List;
import com.ruoyi.resources.domain.MContent;

/**
 * 杂志内容Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface IMContentService 
{
    /**
     * 查询杂志内容
     * 
     * @param id 杂志内容主键
     * @return 杂志内容
     */
    public MContent selectMContentById(Long id);

    /**
     * 查询杂志内容列表
     * 
     * @param mContent 杂志内容
     * @return 杂志内容集合
     */
    public List<MContent> selectMContentList(MContent mContent);

    /**
     * 新增杂志内容
     * 
     * @param mContent 杂志内容
     * @return 结果
     */
    public int insertMContent(MContent mContent);

    /**
     * 修改杂志内容
     * 
     * @param mContent 杂志内容
     * @return 结果
     */
    public int updateMContent(MContent mContent);

    /**
     * 批量删除杂志内容
     * 
     * @param ids 需要删除的杂志内容主键集合
     * @return 结果
     */
    public int deleteMContentByIds(Long[] ids);

    /**
     * 删除杂志内容信息
     * 
     * @param id 杂志内容主键
     * @return 结果
     */
    public int deleteMContentById(Long id);
}
