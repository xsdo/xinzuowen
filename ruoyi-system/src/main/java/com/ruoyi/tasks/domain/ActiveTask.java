package com.ruoyi.tasks.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 活动任务对象 active_task
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class ActiveTask extends BaseEntity
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

    /** 活动名 */
    @Excel(name = "活动名")
    private String acName;

    /** 活动简介 */
    @Excel(name = "活动简介")
    private String acSynopsis;

    /** 活动状态（默认：0未开始；已开始：1；已结束：2） */
    @Excel(name = "活动状态", readConverterExp = "默=认：0未开始；已开始：1；已结束：2")
    private Long acStatus;

    /** 活动类型（默认：0活动；征文：1；推荐阅读：2） */
    @Excel(name = "活动类型", readConverterExp = "默=认：0活动；征文：1；推荐阅读：2")
    private Long acType;

    /** 活动奖励 */
    @Excel(name = "活动奖励")
    private String acAward;

    /** 活动图 */
    @Excel(name = "活动图")
    private String acImage;

    /** 活动开启时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "活动开启时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date acBegintime;

    /** 活动结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "活动结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date acEndtime;

    /** 是否付费 */
    @Excel(name = "是否付费")
    private Long acIspay;

    /** 活动文案 */
    @Excel(name = "活动文案")
    private String acPaperwork;

    /** 活动地址 */
    @Excel(name = "活动地址")
    private String acUrl;

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
    public void setAcName(String acName) 
    {
        this.acName = acName;
    }

    public String getAcName() 
    {
        return acName;
    }
    public void setAcSynopsis(String acSynopsis) 
    {
        this.acSynopsis = acSynopsis;
    }

    public String getAcSynopsis() 
    {
        return acSynopsis;
    }
    public void setAcStatus(Long acStatus) 
    {
        this.acStatus = acStatus;
    }

    public Long getAcStatus() 
    {
        return acStatus;
    }
    public void setAcType(Long acType) 
    {
        this.acType = acType;
    }

    public Long getAcType() 
    {
        return acType;
    }
    public void setAcAward(String acAward) 
    {
        this.acAward = acAward;
    }

    public String getAcAward() 
    {
        return acAward;
    }
    public void setAcImage(String acImage) 
    {
        this.acImage = acImage;
    }

    public String getAcImage() 
    {
        return acImage;
    }
    public void setAcBegintime(Date acBegintime) 
    {
        this.acBegintime = acBegintime;
    }

    public Date getAcBegintime() 
    {
        return acBegintime;
    }
    public void setAcEndtime(Date acEndtime) 
    {
        this.acEndtime = acEndtime;
    }

    public Date getAcEndtime() 
    {
        return acEndtime;
    }
    public void setAcIspay(Long acIspay) 
    {
        this.acIspay = acIspay;
    }

    public Long getAcIspay() 
    {
        return acIspay;
    }
    public void setAcPaperwork(String acPaperwork) 
    {
        this.acPaperwork = acPaperwork;
    }

    public String getAcPaperwork() 
    {
        return acPaperwork;
    }
    public void setAcUrl(String acUrl) 
    {
        this.acUrl = acUrl;
    }

    public String getAcUrl() 
    {
        return acUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isUsed", getIsUsed())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remarks", getRemarks())
            .append("acName", getAcName())
            .append("acSynopsis", getAcSynopsis())
            .append("acStatus", getAcStatus())
            .append("acType", getAcType())
            .append("acAward", getAcAward())
            .append("acImage", getAcImage())
            .append("acBegintime", getAcBegintime())
            .append("acEndtime", getAcEndtime())
            .append("acIspay", getAcIspay())
            .append("acPaperwork", getAcPaperwork())
            .append("acUrl", getAcUrl())
            .toString();
    }
}
