package com.ruoyi.users.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ruoyi.common.utils.LongJsonDeserializer;
import com.ruoyi.common.utils.LongJsonSerializer;

/**
 * 充值记录对象 u_charglog
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class UCharglog extends BaseEntity
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

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long userId;

    /** 价格 */
    @Excel(name = "价格")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long cPrice;

    /** 类型（会员充值0；有声专辑1；购买图书2；订阅杂志3；专家点评4；在线课程5；活动缴费6） */
    @Excel(name = "类型", readConverterExp = "会=员充值0；有声专辑1；购买图书2；订阅杂志3；专家点评4；在线课程5；活动缴费6")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long cType;

    /** 内容 */
    @Excel(name = "内容")
    private String cContent;

    /** 付款类型 */
    @Excel(name = "付款类型")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long paytype;

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
    public void setcPrice(Long cPrice) 
    {
        this.cPrice = cPrice;
    }

    public Long getcPrice() 
    {
        return cPrice;
    }
    public void setcType(Long cType) 
    {
        this.cType = cType;
    }

    public Long getcType() 
    {
        return cType;
    }
    public void setcContent(String cContent) 
    {
        this.cContent = cContent;
    }

    public String getcContent() 
    {
        return cContent;
    }
    public void setPaytype(Long paytype) 
    {
        this.paytype = paytype;
    }

    public Long getPaytype() 
    {
        return paytype;
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
            .append("cPrice", getcPrice())
            .append("cType", getcType())
            .append("cContent", getcContent())
            .append("paytype", getPaytype())
            .toString();
    }
}
