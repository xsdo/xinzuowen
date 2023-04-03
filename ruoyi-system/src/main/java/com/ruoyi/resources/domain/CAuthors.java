package com.ruoyi.resources.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 作者对象 c_authors
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class CAuthors extends BaseEntity
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

    /** 作者名 */
    @Excel(name = "作者名")
    private String aName;

    /** 头像 */
    @Excel(name = "头像")
    private String aHead;

    /** 类型（默认：0学生；教师：1；其他：2） */
    @Excel(name = "类型", readConverterExp = "默=认：0学生；教师：1；其他：2")
    private Long aType;

    /** 省 */
    @Excel(name = "省")
    private String province;

    /** 市 */
    @Excel(name = "市")
    private String city;

    /** 县、区 */
    @Excel(name = "县、区")
    private String area;

    /** 学校 */
    @Excel(name = "学校")
    private String school;

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
    public void setaHead(String aHead) 
    {
        this.aHead = aHead;
    }

    public String getaHead() 
    {
        return aHead;
    }
    public void setaType(Long aType) 
    {
        this.aType = aType;
    }

    public Long getaType() 
    {
        return aType;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setArea(String area) 
    {
        this.area = area;
    }

    public String getArea() 
    {
        return area;
    }
    public void setSchool(String school) 
    {
        this.school = school;
    }

    public String getSchool() 
    {
        return school;
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
            .append("aHead", getaHead())
            .append("aType", getaType())
            .append("province", getProvince())
            .append("city", getCity())
            .append("area", getArea())
            .append("school", getSchool())
            .toString();
    }
}
