package com.ruoyi.users.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户标签对象 u_table
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class UTable extends BaseEntity
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

    /** 标签名称 */
    @Excel(name = "标签名称")
    private String uTableName;

    /** 标签样式 */
    @Excel(name = "标签样式")
    private String uTablePattern;

    /** 标签类型（默认：0；任务：1；活动：2） */
    @Excel(name = "标签类型", readConverterExp = "默=认：0；任务：1；活动：2")
    private Long uTableType;

    /** 标签来源（url） */
    @Excel(name = "标签来源", readConverterExp = "u=rl")
    private String uTableSource;

    /** 标签描述 */
    @Excel(name = "标签描述")
    private String uTableDescribe;

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
    public void setuTableName(String uTableName) 
    {
        this.uTableName = uTableName;
    }

    public String getuTableName() 
    {
        return uTableName;
    }
    public void setuTablePattern(String uTablePattern) 
    {
        this.uTablePattern = uTablePattern;
    }

    public String getuTablePattern() 
    {
        return uTablePattern;
    }
    public void setuTableType(Long uTableType) 
    {
        this.uTableType = uTableType;
    }

    public Long getuTableType() 
    {
        return uTableType;
    }
    public void setuTableSource(String uTableSource) 
    {
        this.uTableSource = uTableSource;
    }

    public String getuTableSource() 
    {
        return uTableSource;
    }
    public void setuTableDescribe(String uTableDescribe) 
    {
        this.uTableDescribe = uTableDescribe;
    }

    public String getuTableDescribe() 
    {
        return uTableDescribe;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isUsed", getIsUsed())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remarks", getRemarks())
            .append("uTableName", getuTableName())
            .append("uTablePattern", getuTablePattern())
            .append("uTableType", getuTableType())
            .append("uTableSource", getuTableSource())
            .append("uTableDescribe", getuTableDescribe())
            .toString();
    }
}
