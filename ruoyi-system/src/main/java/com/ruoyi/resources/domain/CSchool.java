package com.ruoyi.resources.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ruoyi.common.utils.LongJsonDeserializer;
import com.ruoyi.common.utils.LongJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ruoyi.common.utils.LongJsonDeserializer;
import com.ruoyi.common.utils.LongJsonSerializer;
/**
 * 校园作文对象 c_school
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class CSchool extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long id;

    /** 是否使用（默认0：启用； 1：废弃） */
    @Excel(name = "是否使用", readConverterExp = "默=认0：启用；,1=：废弃")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long isUsed;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 作文id */
    @Excel(name = "作文id")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long compositionId;

    /** 文章图片 */
    @Excel(name = "文章图片")
    private String sImage;

    /** 文章音频id */
    @Excel(name = "文章音频id")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long sVoice;

    /** 点赞数 */
    @Excel(name = "点赞数")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long sLikes;

    /** 评论数 */
    @Excel(name = "评论数")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long sDiscuss;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setIsUsed(Long isUsed) 
    {
        this.isUsed = isUsed;
    }

    public Long getIsUsed() 
    {
        return isUsed;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setCompositionId(Long compositionId) 
    {
        this.compositionId = compositionId;
    }

    public Long getCompositionId() 
    {
        return compositionId;
    }
    public void setsImage(String sImage) 
    {
        this.sImage = sImage;
    }

    public String getsImage() 
    {
        return sImage;
    }
    public void setsVoice(Long sVoice) 
    {
        this.sVoice = sVoice;
    }

    public Long getsVoice() 
    {
        return sVoice;
    }
    public void setsLikes(Long sLikes) 
    {
        this.sLikes = sLikes;
    }

    public Long getsLikes() 
    {
        return sLikes;
    }
    public void setsDiscuss(Long sDiscuss) 
    {
        this.sDiscuss = sDiscuss;
    }

    public Long getsDiscuss() 
    {
        return sDiscuss;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isUsed", getIsUsed())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remarks", getRemarks())
            .append("compositionId", getCompositionId())
            .append("sImage", getsImage())
            .append("sVoice", getsVoice())
            .append("sLikes", getsLikes())
            .append("sDiscuss", getsDiscuss())
            .toString();
    }
}
