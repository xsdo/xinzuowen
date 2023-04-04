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
 * 用户学校对象 u_school
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class USchool extends BaseEntity
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

    /** 学校名称 */
    @Excel(name = "学校名称")
    private String sName;

    /** 学校省份 */
    @Excel(name = "学校省份")
    private String sProvince;

    /** 学校所在市 */
    @Excel(name = "学校所在市")
    private String sCity;

    /** 学校所在区/县 */
    @Excel(name = "学校所在区/县")
    private String sArea;

    /** 学校总鲜花 */
    @Excel(name = "学校总鲜花")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long sFlowers;

    /** 二维码 */
    @Excel(name = "二维码")
    private String qrCode;

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
    public void setsName(String sName) 
    {
        this.sName = sName;
    }

    public String getsName() 
    {
        return sName;
    }
    public void setsProvince(String sProvince) 
    {
        this.sProvince = sProvince;
    }

    public String getsProvince() 
    {
        return sProvince;
    }
    public void setsCity(String sCity) 
    {
        this.sCity = sCity;
    }

    public String getsCity() 
    {
        return sCity;
    }
    public void setsArea(String sArea) 
    {
        this.sArea = sArea;
    }

    public String getsArea() 
    {
        return sArea;
    }
    public void setsFlowers(Long sFlowers) 
    {
        this.sFlowers = sFlowers;
    }

    public Long getsFlowers() 
    {
        return sFlowers;
    }
    public void setQrCode(String qrCode) 
    {
        this.qrCode = qrCode;
    }

    public String getQrCode() 
    {
        return qrCode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isUsed", getIsUsed())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remarks", getRemarks())
            .append("sName", getsName())
            .append("sProvince", getsProvince())
            .append("sCity", getsCity())
            .append("sArea", getsArea())
            .append("sFlowers", getsFlowers())
            .append("qrCode", getQrCode())
            .toString();
    }
}
