package com.ruoyi.resources.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 笔记对象 c_note
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class CNote extends BaseEntity
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

    /** 用户ID */
    @Excel(name = "用户ID")
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

    /** 图片 */
    @Excel(name = "图片")
    private String images;

    /** 音频id */
    @Excel(name = "音频id")
    private Long voice;

    /** 视频id */
    @Excel(name = "视频id")
    private Long videos;

    /** 评论数 */
    @Excel(name = "评论数")
    private Long discuss;

    /** 点赞数 */
    @Excel(name = "点赞数")
    private Long likes;

    /** 阅读次数 */
    @Excel(name = "阅读次数")
    private Long readtimes;

    /** 状态（已投稿：1；审核中：2；审核通过（发布）：3） */
    @Excel(name = "状态", readConverterExp = "已=投稿：1；审核中：2；审核通过（发布")
    private Long status;

    /** 类型（默认随笔：0；文章：1；音频：2；视频：3） */
    @Excel(name = "类型", readConverterExp = "默=认随笔：0；文章：1；音频：2；视频：3")
    private Long type;

    /** 引用文章id */
    @Excel(name = "引用文章id")
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
    public void setImages(String images) 
    {
        this.images = images;
    }

    public String getImages() 
    {
        return images;
    }
    public void setVoice(Long voice) 
    {
        this.voice = voice;
    }

    public Long getVoice() 
    {
        return voice;
    }
    public void setVideos(Long videos) 
    {
        this.videos = videos;
    }

    public Long getVideos() 
    {
        return videos;
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
    public void setReadtimes(Long readtimes) 
    {
        this.readtimes = readtimes;
    }

    public Long getReadtimes() 
    {
        return readtimes;
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
            .append("images", getImages())
            .append("voice", getVoice())
            .append("videos", getVideos())
            .append("discuss", getDiscuss())
            .append("likes", getLikes())
            .append("readtimes", getReadtimes())
            .append("status", getStatus())
            .append("type", getType())
            .append("compositionId", getCompositionId())
            .toString();
    }
}
