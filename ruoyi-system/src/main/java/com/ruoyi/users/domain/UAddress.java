package com.ruoyi.users.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户地址对象 u_address
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class UAddress extends BaseEntity
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

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long userId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String aName;

    /** 电话 */
    @Excel(name = "电话")
    private String aPhonenumber;

    /** 地址 */
    @Excel(name = "地址")
    private String aAddress;

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
    public void setaName(String aName) 
    {
        this.aName = aName;
    }

    public String getaName() 
    {
        return aName;
    }
    public void setaPhonenumber(String aPhonenumber) 
    {
        this.aPhonenumber = aPhonenumber;
    }

    public String getaPhonenumber() 
    {
        return aPhonenumber;
    }
    public void setaAddress(String aAddress) 
    {
        this.aAddress = aAddress;
    }

    public String getaAddress() 
    {
        return aAddress;
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
            .append("aName", getaName())
            .append("aPhonenumber", getaPhonenumber())
            .append("aAddress", getaAddress())
            .toString();
    }
}
