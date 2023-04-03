package com.ruoyi.resources.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 全国作文对象 c_nation
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class CNation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 是否使用（默认0：启用； 1：废弃） */
    @Excel(name = "是否使用", readConverterExp = "默=认0：启用；,1=：废弃")
    private Long isUsed;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 作文id */
    @Excel(name = "作文id")
    private Long compositionId;

    /** 文章图片 */
    @Excel(name = "文章图片")
    private String nImage;

    /** 文章音频id */
    @Excel(name = "文章音频id")
    private Long nVoice;

    /** 点赞数 */
    @Excel(name = "点赞数")
    private Long nLikes;

    /** 评论数 */
    @Excel(name = "评论数")
    private Long nDiscuss;

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
    public void setnImage(String nImage) 
    {
        this.nImage = nImage;
    }

    public String getnImage() 
    {
        return nImage;
    }
    public void setnVoice(Long nVoice) 
    {
        this.nVoice = nVoice;
    }

    public Long getnVoice() 
    {
        return nVoice;
    }
    public void setnLikes(Long nLikes) 
    {
        this.nLikes = nLikes;
    }

    public Long getnLikes() 
    {
        return nLikes;
    }
    public void setnDiscuss(Long nDiscuss) 
    {
        this.nDiscuss = nDiscuss;
    }

    public Long getnDiscuss() 
    {
        return nDiscuss;
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
            .append("nImage", getnImage())
            .append("nVoice", getnVoice())
            .append("nLikes", getnLikes())
            .append("nDiscuss", getnDiscuss())
            .toString();
    }
}
