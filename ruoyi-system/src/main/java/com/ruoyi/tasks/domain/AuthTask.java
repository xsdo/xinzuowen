package com.ruoyi.tasks.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ruoyi.common.utils.LongJsonDeserializer;
import com.ruoyi.common.utils.LongJsonSerializer;

/**
 * 认证任务对象 auth_task
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class AuthTask extends BaseEntity
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

    /** 任务名 */
    @Excel(name = "任务名")
    private String aName;

    /** 任务描述 */
    @Excel(name = "任务描述")
    private String aSynopsis;

    /** 任务状态（默认：0开启；关闭：1） */
    @Excel(name = "任务状态", readConverterExp = "默=认：0开启；关闭：1")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long aStatus;

    /** 任务类型 */
    @Excel(name = "任务类型")
    private String aType;

    /** 任务奖励 */
    @Excel(name = "任务奖励")
    private String aAward;

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
    public void setaName(String aName) 
    {
        this.aName = aName;
    }

    public String getaName() 
    {
        return aName;
    }
    public void setaSynopsis(String aSynopsis) 
    {
        this.aSynopsis = aSynopsis;
    }

    public String getaSynopsis() 
    {
        return aSynopsis;
    }
    public void setaStatus(Long aStatus) 
    {
        this.aStatus = aStatus;
    }

    public Long getaStatus() 
    {
        return aStatus;
    }
    public void setaType(String aType) 
    {
        this.aType = aType;
    }

    public String getaType() 
    {
        return aType;
    }
    public void setaAward(String aAward) 
    {
        this.aAward = aAward;
    }

    public String getaAward() 
    {
        return aAward;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isUsed", getIsUsed())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remarks", getRemarks())
            .append("aName", getaName())
            .append("aSynopsis", getaSynopsis())
            .append("aStatus", getaStatus())
            .append("aType", getaType())
            .append("aAward", getaAward())
            .toString();
    }
}
