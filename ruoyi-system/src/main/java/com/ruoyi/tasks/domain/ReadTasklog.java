package com.ruoyi.tasks.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 阅读任务记录对象 read_tasklog
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class ReadTasklog extends BaseEntity
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

    /** 阅读任务id */
    @Excel(name = "阅读任务id")
    private Long taskId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 任务1状态（默认0未开启；进行中：1；完成：2；未完成：3） */
    @Excel(name = "任务1状态", readConverterExp = "默=认0未开启；进行中：1；完成：2；未完成：3")
    private Long statusfirst;

    /** 任务2状态（默认0未开启；进行中：1；完成：2；未完成：3） */
    @Excel(name = "任务2状态", readConverterExp = "默=认0未开启；进行中：1；完成：2；未完成：3")
    private Long statussecond;

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
    public void setTaskId(Long taskId) 
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setStatusfirst(Long statusfirst) 
    {
        this.statusfirst = statusfirst;
    }

    public Long getStatusfirst() 
    {
        return statusfirst;
    }
    public void setStatussecond(Long statussecond) 
    {
        this.statussecond = statussecond;
    }

    public Long getStatussecond() 
    {
        return statussecond;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isUsed", getIsUsed())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remarks", getRemarks())
            .append("taskId", getTaskId())
            .append("userId", getUserId())
            .append("statusfirst", getStatusfirst())
            .append("statussecond", getStatussecond())
            .toString();
    }
}
