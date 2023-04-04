package com.ruoyi.tasks.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ruoyi.common.utils.LongJsonDeserializer;
import com.ruoyi.common.utils.LongJsonSerializer;

/**
 * 推荐作文对象 suggest_task
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class SuggestTask extends BaseEntity
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

    /** 作文类型 */
    @Excel(name = "作文类型")
    private String compositionType;

    /** 作文名 */
    @Excel(name = "作文名")
    private String comName;

    /** 作文图 */
    @Excel(name = "作文图")
    private String comImage;

    /** 点赞数 */
    @Excel(name = "点赞数")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long comLikes;

    /** 评论数 */
    @Excel(name = "评论数")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long comDiscuss;

    /** 是否置顶 */
    @Excel(name = "是否置顶")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long tTop;

    /** 置顶结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "置顶结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date tEndtime;

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
    public void setCompositionType(String compositionType) 
    {
        this.compositionType = compositionType;
    }

    public String getCompositionType() 
    {
        return compositionType;
    }
    public void setComName(String comName) 
    {
        this.comName = comName;
    }

    public String getComName() 
    {
        return comName;
    }
    public void setComImage(String comImage) 
    {
        this.comImage = comImage;
    }

    public String getComImage() 
    {
        return comImage;
    }
    public void setComLikes(Long comLikes) 
    {
        this.comLikes = comLikes;
    }

    public Long getComLikes() 
    {
        return comLikes;
    }
    public void setComDiscuss(Long comDiscuss) 
    {
        this.comDiscuss = comDiscuss;
    }

    public Long getComDiscuss() 
    {
        return comDiscuss;
    }
    public void settTop(Long tTop) 
    {
        this.tTop = tTop;
    }

    public Long gettTop() 
    {
        return tTop;
    }
    public void settEndtime(Date tEndtime) 
    {
        this.tEndtime = tEndtime;
    }

    public Date gettEndtime() 
    {
        return tEndtime;
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
            .append("compositionType", getCompositionType())
            .append("comName", getComName())
            .append("comImage", getComImage())
            .append("comLikes", getComLikes())
            .append("comDiscuss", getComDiscuss())
            .append("tTop", gettTop())
            .append("tEndtime", gettEndtime())
            .toString();
    }
}
