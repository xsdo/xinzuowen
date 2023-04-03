package com.ruoyi.resources.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 作文对象 composition
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class Composition extends BaseEntity
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

    /** 标题 */
    @Excel(name = "标题")
    private String cTitle;

    /** 作者id */
    @Excel(name = "作者id")
    private Long cAuthorid;

    /** 简介/提要 */
    @Excel(name = "简介/提要")
    private String cSynopsis;

    /** 内容 */
    @Excel(name = "内容")
    private String cArticle;

    /** 图片大尺寸 */
    @Excel(name = "图片大尺寸")
    private String cImageb;

    /** 图片小尺寸 */
    @Excel(name = "图片小尺寸")
    private String cImages;

    /** 音频id */
    @Excel(name = "音频id")
    private Long cVoice;

    /** 视频id */
    @Excel(name = "视频id")
    private Long cVideos;

    /** 会员作文（默认：0非会员；会员作文：1） */
    @Excel(name = "会员作文", readConverterExp = "默=认：0非会员；会员作文：1")
    private Long cVip;

    /** 级别（小低；小高） */
    @Excel(name = "级别", readConverterExp = "小=低；小高")
    private String cGrade;

    /** 类型（记事；想象；写人；写事；议论等） */
    @Excel(name = "类型", readConverterExp = "记=事；想象；写人；写事；议论等")
    private String cGatetype;

    /** 字数 */
    @Excel(name = "字数")
    private Long cWords;

    /** 状态（已投稿：1；审核中：2；审核通过（发布）：3） */
    @Excel(name = "状态", readConverterExp = "已=投稿：1；审核中：2；审核通过（发布")
    private Long cStatus;

    /** 点赞数 */
    @Excel(name = "点赞数")
    private Long cLikes;

    /** 评论数 */
    @Excel(name = "评论数")
    private Long cDiscuss;

    /** 阅读次数 */
    @Excel(name = "阅读次数")
    private Long cReadtimes;

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
    public void setcTitle(String cTitle) 
    {
        this.cTitle = cTitle;
    }

    public String getcTitle() 
    {
        return cTitle;
    }
    public void setcAuthorid(Long cAuthorid) 
    {
        this.cAuthorid = cAuthorid;
    }

    public Long getcAuthorid() 
    {
        return cAuthorid;
    }
    public void setcSynopsis(String cSynopsis) 
    {
        this.cSynopsis = cSynopsis;
    }

    public String getcSynopsis() 
    {
        return cSynopsis;
    }
    public void setcArticle(String cArticle) 
    {
        this.cArticle = cArticle;
    }

    public String getcArticle() 
    {
        return cArticle;
    }
    public void setcImageb(String cImageb) 
    {
        this.cImageb = cImageb;
    }

    public String getcImageb() 
    {
        return cImageb;
    }
    public void setcImages(String cImages) 
    {
        this.cImages = cImages;
    }

    public String getcImages() 
    {
        return cImages;
    }
    public void setcVoice(Long cVoice) 
    {
        this.cVoice = cVoice;
    }

    public Long getcVoice() 
    {
        return cVoice;
    }
    public void setcVideos(Long cVideos) 
    {
        this.cVideos = cVideos;
    }

    public Long getcVideos() 
    {
        return cVideos;
    }
    public void setcVip(Long cVip) 
    {
        this.cVip = cVip;
    }

    public Long getcVip() 
    {
        return cVip;
    }
    public void setcGrade(String cGrade) 
    {
        this.cGrade = cGrade;
    }

    public String getcGrade() 
    {
        return cGrade;
    }
    public void setcGatetype(String cGatetype) 
    {
        this.cGatetype = cGatetype;
    }

    public String getcGatetype() 
    {
        return cGatetype;
    }
    public void setcWords(Long cWords) 
    {
        this.cWords = cWords;
    }

    public Long getcWords() 
    {
        return cWords;
    }
    public void setcStatus(Long cStatus) 
    {
        this.cStatus = cStatus;
    }

    public Long getcStatus() 
    {
        return cStatus;
    }
    public void setcLikes(Long cLikes) 
    {
        this.cLikes = cLikes;
    }

    public Long getcLikes() 
    {
        return cLikes;
    }
    public void setcDiscuss(Long cDiscuss) 
    {
        this.cDiscuss = cDiscuss;
    }

    public Long getcDiscuss() 
    {
        return cDiscuss;
    }
    public void setcReadtimes(Long cReadtimes) 
    {
        this.cReadtimes = cReadtimes;
    }

    public Long getcReadtimes() 
    {
        return cReadtimes;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isUsed", getIsUsed())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remarks", getRemarks())
            .append("cTitle", getcTitle())
            .append("cAuthorid", getcAuthorid())
            .append("cSynopsis", getcSynopsis())
            .append("cArticle", getcArticle())
            .append("cImageb", getcImageb())
            .append("cImages", getcImages())
            .append("cVoice", getcVoice())
            .append("cVideos", getcVideos())
            .append("cVip", getcVip())
            .append("cGrade", getcGrade())
            .append("cGatetype", getcGatetype())
            .append("cWords", getcWords())
            .append("cStatus", getcStatus())
            .append("cLikes", getcLikes())
            .append("cDiscuss", getcDiscuss())
            .append("cReadtimes", getcReadtimes())
            .toString();
    }
}
