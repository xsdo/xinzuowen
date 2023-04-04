package com.ruoyi.users.domain;

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
 * 绑定班级对象 u_binding
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class UBinding extends BaseEntity
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

    /** 教师班级id */
    @Excel(name = "教师班级id")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long teacherId;

    /** 用户id */
    @Excel(name = "用户id")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long userId;

    /** 扫码时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "扫码时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date scantime;

    /** 绑定时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "绑定时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date bindtime;

    /** 绑定状态（默认0：待绑定；已绑定：1；绑定失败：2） */
    @Excel(name = "绑定状态", readConverterExp = "默=认0：待绑定；已绑定：1；绑定失败：2")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long bStatus;

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
    public void setTeacherId(Long teacherId) 
    {
        this.teacherId = teacherId;
    }

    public Long getTeacherId() 
    {
        return teacherId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setScantime(Date scantime) 
    {
        this.scantime = scantime;
    }

    public Date getScantime() 
    {
        return scantime;
    }
    public void setBindtime(Date bindtime) 
    {
        this.bindtime = bindtime;
    }

    public Date getBindtime() 
    {
        return bindtime;
    }
    public void setbStatus(Long bStatus) 
    {
        this.bStatus = bStatus;
    }

    public Long getbStatus() 
    {
        return bStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isUsed", getIsUsed())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remarks", getRemarks())
            .append("teacherId", getTeacherId())
            .append("userId", getUserId())
            .append("scantime", getScantime())
            .append("bindtime", getBindtime())
            .append("bStatus", getbStatus())
            .toString();
    }
}
