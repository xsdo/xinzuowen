package com.ruoyi.resources.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ruoyi.common.utils.LongJsonDeserializer;
import com.ruoyi.common.utils.LongJsonSerializer;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 阅读图书对象 read_book
 * 
 * @author xqq
 * @date 2023-04-17
 */
public class ReadBook extends BaseEntity
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

    /** 图书名 */
    @Excel(name = "图书名")
    private String name;

    /** 封面图 */
    @Excel(name = "封面图")
    private String image;

    /** 简介 */
    @Excel(name = "简介")
    private String profile;

    /** 出版社 */
    @Excel(name = "出版社")
    private String press;

    /** 序图 */
    @Excel(name = "序图")
    private String diagram;

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
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }
    public void setProfile(String profile) 
    {
        this.profile = profile;
    }

    public String getProfile() 
    {
        return profile;
    }
    public void setPress(String press) 
    {
        this.press = press;
    }

    public String getPress() 
    {
        return press;
    }
    public void setDiagram(String diagram) 
    {
        this.diagram = diagram;
    }

    public String getDiagram() 
    {
        return diagram;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isUsed", getIsUsed())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remarks", getRemarks())
            .append("name", getName())
            .append("image", getImage())
            .append("profile", getProfile())
            .append("press", getPress())
            .append("diagram", getDiagram())
            .toString();
    }
}
