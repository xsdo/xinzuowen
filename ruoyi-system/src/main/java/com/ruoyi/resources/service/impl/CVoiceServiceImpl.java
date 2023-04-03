package com.ruoyi.resources.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.resources.mapper.CVoiceMapper;
import com.ruoyi.resources.domain.CVoice;
import com.ruoyi.resources.service.ICVoiceService;

/**
 * 音频Service业务层处理
 * 
 * @author xqq
 * @date 2023-03-27
 */
@Service
public class CVoiceServiceImpl implements ICVoiceService 
{
    @Autowired
    private CVoiceMapper cVoiceMapper;

    /**
     * 查询音频
     * 
     * @param id 音频主键
     * @return 音频
     */
    @Override
    public CVoice selectCVoiceById(Long id)
    {
        return cVoiceMapper.selectCVoiceById(id);
    }

    /**
     * 查询音频列表
     * 
     * @param cVoice 音频
     * @return 音频
     */
    @Override
    public List<CVoice> selectCVoiceList(CVoice cVoice)
    {
        return cVoiceMapper.selectCVoiceList(cVoice);
    }

    /**
     * 新增音频
     * 
     * @param cVoice 音频
     * @return 结果
     */
    @Override
    public int insertCVoice(CVoice cVoice)
    {
        cVoice.setCreateTime(DateUtils.getNowDate());
        return cVoiceMapper.insertCVoice(cVoice);
    }

    /**
     * 修改音频
     * 
     * @param cVoice 音频
     * @return 结果
     */
    @Override
    public int updateCVoice(CVoice cVoice)
    {
        cVoice.setUpdateTime(DateUtils.getNowDate());
        return cVoiceMapper.updateCVoice(cVoice);
    }

    /**
     * 批量删除音频
     * 
     * @param ids 需要删除的音频主键
     * @return 结果
     */
    @Override
    public int deleteCVoiceByIds(Long[] ids)
    {
        return cVoiceMapper.deleteCVoiceByIds(ids);
    }

    /**
     * 删除音频信息
     * 
     * @param id 音频主键
     * @return 结果
     */
    @Override
    public int deleteCVoiceById(Long id)
    {
        return cVoiceMapper.deleteCVoiceById(id);
    }
}
