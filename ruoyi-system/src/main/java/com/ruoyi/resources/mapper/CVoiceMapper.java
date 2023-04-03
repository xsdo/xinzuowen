package com.ruoyi.resources.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.resources.domain.CVoice;

/**
 * 音频Mapper接口
 *
 * @author xqq
 * @date 2023-03-27
 */
@DataSource(value = DataSourceType.XZW_RESOURCES)//切换数据源
public interface CVoiceMapper
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
     * 删除音频
     *
     * @param id 音频主键
     * @return 结果
     */
    public int deleteCVoiceById(Long id);

    /**
     * 批量删除音频
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCVoiceByIds(Long[] ids);
}
