package com.ruoyi.resources.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 杂志栏目对象 magazines
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class Magazines extends BaseEntity
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

    /** 栏目名 */
    @Excel(name = "栏目名")
    private String titles;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date readTime;

    /** 杂志名 */
    @Excel(name = "杂志名")
    private String name;

    /** 类型(0：1-3年级；1：4-6年级 */
    @Excel(name = "类型(0：1-3年级；1：4-6年级")
    private Long type;

    /** 非会员试读(1 试读 0非试读 */
    @Excel(name = "非会员试读(1 试读 0非试读")
    private Long tryVip;

    /** 图片 */
    @Excel(name = "图片")
    private String image;

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
    public void setTitles(String titles) 
    {
        this.titles = titles;
    }

    public String getTitles() 
    {
        return titles;
    }
    public void setReadTime(Date readTime) 
    {
        this.readTime = readTime;
    }

    public Date getReadTime() 
    {
        return readTime;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setTryVip(Long tryVip) 
    {
        this.tryVip = tryVip;
    }

    public Long getTryVip() 
    {
        return tryVip;
    }
    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isUsed", getIsUsed())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remarks", getRemarks())
            .append("titles", getTitles())
            .append("readTime", getReadTime())
            .append("name", getName())
            .append("type", getType())
            .append("tryVip", getTryVip())
            .append("image", getImage())
            .toString();
    }
}
