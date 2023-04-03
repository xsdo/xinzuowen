package com.ruoyi.resources.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 禁言对象 c_muted
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class CMuted extends BaseEntity
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

    /** 禁言时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "禁言时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date mutetime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endtime;

    /** 禁言时长 */
    @Excel(name = "禁言时长")
    private Long mutehour;

    /** 禁言理由 */
    @Excel(name = "禁言理由")
    private String cause;

    /** 禁言次数 */
    @Excel(name = "禁言次数")
    private Long mutenumber;

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
    public void setMutetime(Date mutetime) 
    {
        this.mutetime = mutetime;
    }

    public Date getMutetime() 
    {
        return mutetime;
    }
    public void setEndtime(Date endtime) 
    {
        this.endtime = endtime;
    }

    public Date getEndtime() 
    {
        return endtime;
    }
    public void setMutehour(Long mutehour) 
    {
        this.mutehour = mutehour;
    }

    public Long getMutehour() 
    {
        return mutehour;
    }
    public void setCause(String cause) 
    {
        this.cause = cause;
    }

    public String getCause() 
    {
        return cause;
    }
    public void setMutenumber(Long mutenumber) 
    {
        this.mutenumber = mutenumber;
    }

    public Long getMutenumber() 
    {
        return mutenumber;
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
            .append("mutetime", getMutetime())
            .append("endtime", getEndtime())
            .append("mutehour", getMutehour())
            .append("cause", getCause())
            .append("mutenumber", getMutenumber())
            .toString();
    }
}
