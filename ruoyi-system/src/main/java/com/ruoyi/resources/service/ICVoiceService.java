package com.ruoyi.resources.service;

import java.util.List;
import com.ruoyi.resources.domain.CVoice;

/**
 * 音频Service接口
 * 
 * @author xqq
 * @date 2023-03-27
 */
public interface ICVoiceService 
{
    /**
     * 查询音频
     * 
     * @param id 音频主键
     * @return 音频
     */
    public CVoice selectCVoiceById(Long id);

    /**
     * 查询音频列表
     * 
     * @param cVoice 音频
     * @return 音频集合
     */
    public List<CVoice> selectCVoiceList(CVoice cVoice);

    /**
     * 新增音频
     * 
     * @param cVoice 音频
     * @return 结果
     */
    public int insertCVoice(CVoice cVoice);

    /**
     * 修改音频
     * 
     * @param cVoice 音频
     * @return 结果
     */
    public int updateCVoice(CVoice cVoice);

    /**
     * 批量删除音频
     * 
     * @param ids 需要删除的音频主键集合
     * @return 结果
     */
    public int deleteCVoiceByIds(Long[] ids);

    /**
     * 删除音频信息
     * 
     * @param id 音频主键
     * @return 结果
     */
    public int deleteCVoiceById(Long id);
}
