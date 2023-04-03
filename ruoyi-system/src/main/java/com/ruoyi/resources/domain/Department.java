package com.ruoyi.resources.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 部编同步作文对象 department
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class Department extends BaseEntity
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

    /** 标题 */
    @Excel(name = "标题")
    private String dTitle;

    /** 字数 */
    @Excel(name = "字数")
    private Long dWords;

    /** 内容 */
    @Excel(name = "内容")
    private String dContents;

    /** 年级 */
    @Excel(name = "年级")
    private String dGrade;

    /** 学期 */
    @Excel(name = "学期")
    private String dTerm;

    /** 单元 */
    @Excel(name = "单元")
    private String dUnitarea;

    /** 阅读次数 */
    @Excel(name = "阅读次数")
    private Long dReadtimes;

    /** 图片 */
    @Excel(name = "图片")
    private String dImage;

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
    public void setdTitle(String dTitle) 
    {
        this.dTitle = dTitle;
    }

    public String getdTitle() 
    {
        return dTitle;
    }
    public void setdWords(Long dWords) 
    {
        this.dWords = dWords;
    }

    public Long getdWords() 
    {
        return dWords;
    }
    public void setdContents(String dContents) 
    {
        this.dContents = dContents;
    }

    public String getdContents() 
    {
        return dContents;
    }
    public void setdGrade(String dGrade) 
    {
        this.dGrade = dGrade;
    }

    public String getdGrade() 
    {
        return dGrade;
    }
    public void setdTerm(String dTerm) 
    {
        this.dTerm = dTerm;
    }

    public String getdTerm() 
    {
        return dTerm;
    }
    public void setdUnitarea(String dUnitarea) 
    {
        this.dUnitarea = dUnitarea;
    }

    public String getdUnitarea() 
    {
        return dUnitarea;
    }
    public void setdReadtimes(Long dReadtimes) 
    {
        this.dReadtimes = dReadtimes;
    }

    public Long getdReadtimes() 
    {
        return dReadtimes;
    }
    public void setdImage(String dImage) 
    {
        this.dImage = dImage;
    }

    public String getdImage() 
    {
        return dImage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isUsed", getIsUsed())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remarks", getRemarks())
            .append("dTitle", getdTitle())
            .append("dWords", getdWords())
            .append("dContents", getdContents())
            .append("dGrade", getdGrade())
            .append("dTerm", getdTerm())
            .append("dUnitarea", getdUnitarea())
            .append("dReadtimes", getdReadtimes())
            .append("dImage", getdImage())
            .toString();
    }
}
