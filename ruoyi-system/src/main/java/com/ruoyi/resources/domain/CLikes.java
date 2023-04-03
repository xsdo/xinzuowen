package com.ruoyi.resources.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户点赞对象 c_likes
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class CLikes extends BaseEntity
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

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 被点赞id */
    @Excel(name = "被点赞id")
    private Long likesId;

    /** 点赞状态：是否取消点赞（默认：0；取消：1） */
    @Excel(name = "点赞状态：是否取消点赞", readConverterExp = "默=认：0；取消：1")
    private Long status;

    /** 类型（文章 随笔 评论 圈子） */
    @Excel(name = "类型", readConverterExp = "文=章,随=笔,评=论,圈=子")
    private Long type;

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
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setLikesId(Long likesId) 
    {
        this.likesId = likesId;
    }

    public Long getLikesId() 
    {
        return likesId;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isUsed", getIsUsed())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remarks", getRemarks())
            .append("userId", getUserId())
            .append("likesId", getLikesId())
            .append("status", getStatus())
            .append("type", getType())
            .toString();
    }
}
