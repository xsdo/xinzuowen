package com.ruoyi.resources.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 阅读记录对象 c_readlog
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class CReadlog extends BaseEntity
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

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 图片 */
    @Excel(name = "图片")
    private String rImage;

    /** 文章名 */
    @Excel(name = "文章名")
    private String rName;

    /** 作文id */
    @Excel(name = "作文id")
    private Long compositionId;

    /** 文章类型（最新有声0；校园1；同步2） */
    @Excel(name = "文章类型", readConverterExp = "最=新有声0；校园1；同步2")
    private Long rType;

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
    public void setrImage(String rImage) 
    {
        this.rImage = rImage;
    }

    public String getrImage() 
    {
        return rImage;
    }
    public void setrName(String rName) 
    {
        this.rName = rName;
    }

    public String getrName() 
    {
        return rName;
    }
    public void setCompositionId(Long compositionId) 
    {
        this.compositionId = compositionId;
    }

    public Long getCompositionId() 
    {
        return compositionId;
    }
    public void setrType(Long rType) 
    {
        this.rType = rType;
    }

    public Long getrType() 
    {
        return rType;
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
            .append("rImage", getrImage())
            .append("rName", getrName())
            .append("compositionId", getCompositionId())
            .append("rType", getrType())
            .toString();
    }
}
