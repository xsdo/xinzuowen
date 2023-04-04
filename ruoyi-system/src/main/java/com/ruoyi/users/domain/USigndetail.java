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
 * 签到明细对象 u_signdetail
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class USigndetail extends BaseEntity
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

    /** 签到时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "签到时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date signDate;

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
    public void setSignDate(Date signDate) 
    {
        this.signDate = signDate;
    }

    public Date getSignDate() 
    {
        return signDate;
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
            .append("signDate", getSignDate())
            .toString();
    }
}
