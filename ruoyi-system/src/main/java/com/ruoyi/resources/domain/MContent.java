package com.ruoyi.resources.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 杂志内容对象 m_content
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class MContent extends BaseEntity
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

    /** 杂志id */
    @Excel(name = "杂志id")
    private Long magazinesId;

    /** 文章标题 */
    @Excel(name = "文章标题")
    private String titles;

    /** 文章内容 */
    @Excel(name = "文章内容")
    private String content;

    /** 非会员试读 */
    @Excel(name = "非会员试读")
    private Long tryVip;

    /** 作文id */
    @Excel(name = "作文id")
    private Long compositionId;

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
    public void setMagazinesId(Long magazinesId) 
    {
        this.magazinesId = magazinesId;
    }

    public Long getMagazinesId() 
    {
        return magazinesId;
    }
    public void setTitles(String titles) 
    {
        this.titles = titles;
    }

    public String getTitles() 
    {
        return titles;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setTryVip(Long tryVip) 
    {
        this.tryVip = tryVip;
    }

    public Long getTryVip() 
    {
        return tryVip;
    }
    public void setCompositionId(Long compositionId) 
    {
        this.compositionId = compositionId;
    }

    public Long getCompositionId() 
    {
        return compositionId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isUsed", getIsUsed())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remarks", getRemarks())
            .append("magazinesId", getMagazinesId())
            .append("titles", getTitles())
            .append("content", getContent())
            .append("tryVip", getTryVip())
            .append("compositionId", getCompositionId())
            .toString();
    }
}
