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
 * 举报对象 c_tips
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class CTips extends BaseEntity
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

    /** 评论id */
    @Excel(name = "评论id")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long discussId;

    /** 评论用户id */
    @Excel(name = "评论用户id")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long discussUserId;

    /** 举报人id */
    @Excel(name = "举报人id")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long tipsUserId;

    /** 举报理由 */
    @Excel(name = "举报理由")
    private String cause;

    /** 状态（默认已举报：0；举报处理中：3；举报成功：4；举报驳回：5） */
    @Excel(name = "状态", readConverterExp = "默=认已举报：0；举报处理中：3；举报成功：4；举报驳回：5")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long status;

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
    public void setDiscussId(Long discussId) 
    {
        this.discussId = discussId;
    }

    public Long getDiscussId() 
    {
        return discussId;
    }
    public void setDiscussUserId(Long discussUserId) 
    {
        this.discussUserId = discussUserId;
    }

    public Long getDiscussUserId() 
    {
        return discussUserId;
    }
    public void setTipsUserId(Long tipsUserId) 
    {
        this.tipsUserId = tipsUserId;
    }

    public Long getTipsUserId() 
    {
        return tipsUserId;
    }
    public void setCause(String cause) 
    {
        this.cause = cause;
    }

    public String getCause() 
    {
        return cause;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isUsed", getIsUsed())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remarks", getRemarks())
            .append("discussId", getDiscussId())
            .append("discussUserId", getDiscussUserId())
            .append("tipsUserId", getTipsUserId())
            .append("cause", getCause())
            .append("status", getStatus())
            .toString();
    }
}
