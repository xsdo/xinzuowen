package com.ruoyi.tasks.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 阅读任务对象 read_task
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class ReadTask extends BaseEntity
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

    /** 任务标题 */
    @Excel(name = "任务标题")
    private String rTitle;

    /** 任务描述 */
    @Excel(name = "任务描述")
    private String rSynopsis;

    /** 任务起始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "任务起始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date rBegintime;

    /** 任务结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "任务结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date rEndtime;

    /** 任务状态（默认：0未开始；已开始：1；已结束：2） */
    @Excel(name = "任务状态", readConverterExp = "默=认：0未开始；已开始：1；已结束：2")
    private Long rStatus;

    /** 任务1url */
    @Excel(name = "任务1url")
    private String rTaskfirst;

    /** 任务2url */
    @Excel(name = "任务2url")
    private String rTasksecond;

    /** 需要阅读时间 */
    @Excel(name = "需要阅读时间")
    private String rTime;

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
    public void setrTitle(String rTitle) 
    {
        this.rTitle = rTitle;
    }

    public String getrTitle() 
    {
        return rTitle;
    }
    public void setrSynopsis(String rSynopsis) 
    {
        this.rSynopsis = rSynopsis;
    }

    public String getrSynopsis() 
    {
        return rSynopsis;
    }
    public void setrBegintime(Date rBegintime) 
    {
        this.rBegintime = rBegintime;
    }

    public Date getrBegintime() 
    {
        return rBegintime;
    }
    public void setrEndtime(Date rEndtime) 
    {
        this.rEndtime = rEndtime;
    }

    public Date getrEndtime() 
    {
        return rEndtime;
    }
    public void setrStatus(Long rStatus) 
    {
        this.rStatus = rStatus;
    }

    public Long getrStatus() 
    {
        return rStatus;
    }
    public void setrTaskfirst(String rTaskfirst) 
    {
        this.rTaskfirst = rTaskfirst;
    }

    public String getrTaskfirst() 
    {
        return rTaskfirst;
    }
    public void setrTasksecond(String rTasksecond) 
    {
        this.rTasksecond = rTasksecond;
    }

    public String getrTasksecond() 
    {
        return rTasksecond;
    }
    public void setrTime(String rTime) 
    {
        this.rTime = rTime;
    }

    public String getrTime() 
    {
        return rTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isUsed", getIsUsed())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remarks", getRemarks())
            .append("rTitle", getrTitle())
            .append("rSynopsis", getrSynopsis())
            .append("rBegintime", getrBegintime())
            .append("rEndtime", getrEndtime())
            .append("rStatus", getrStatus())
            .append("rTaskfirst", getrTaskfirst())
            .append("rTasksecond", getrTasksecond())
            .append("rTime", getrTime())
            .toString();
    }
}
