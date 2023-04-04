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
 * 圈子对象 circle
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class Circle extends BaseEntity
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

    /** 用户ID */
    @Excel(name = "用户ID")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long userId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 用户头像 */
    @Excel(name = "用户头像")
    private String userHead;

    /** 用户标签 */
    @Excel(name = "用户标签")
    private String userTable;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 评论数 */
    @Excel(name = "评论数")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long discuss;

    /** 点赞数 */
    @Excel(name = "点赞数")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long likes;

    /** 类型（默认自动：0；个人评论：1） */
    @Excel(name = "类型", readConverterExp = "默=认自动：0；个人评论：1")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long type;

    /** 引用文章id */
    @Excel(name = "引用文章id")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long compositionId;

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
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setUserHead(String userHead) 
    {
        this.userHead = userHead;
    }

    public String getUserHead() 
    {
        return userHead;
    }
    public void setUserTable(String userTable) 
    {
        this.userTable = userTable;
    }

    public String getUserTable() 
    {
        return userTable;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setDiscuss(Long discuss) 
    {
        this.discuss = discuss;
    }

    public Long getDiscuss() 
    {
        return discuss;
    }
    public void setLikes(Long likes) 
    {
        this.likes = likes;
    }

    public Long getLikes() 
    {
        return likes;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setCompositionId(Long compositionId) 
    {
        this.compositionId = compositionId;
    }

    public Long getCompositionId() 
    {
        return compositionId;
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
            .append("userName", getUserName())
            .append("userHead", getUserHead())
            .append("userTable", getUserTable())
            .append("content", getContent())
            .append("discuss", getDiscuss())
            .append("likes", getLikes())
            .append("type", getType())
            .append("compositionId", getCompositionId())
            .toString();
    }
}
