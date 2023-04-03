package com.ruoyi.resources.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 收藏夹文件对象 c_collectlog
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class CCollectlog extends BaseEntity
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

    /** 收藏夹id */
    @Excel(name = "收藏夹id")
    private Long collectId;

    /** 作文名 */
    @Excel(name = "作文名")
    private String cName;

    /** 作文图 */
    @Excel(name = "作文图")
    private String cImage;

    /** 作文ID */
    @Excel(name = "作文ID")
    private Long compositionId;

    /** 作文类型 */
    @Excel(name = "作文类型")
    private Long cType;

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
    public void setCollectId(Long collectId) 
    {
        this.collectId = collectId;
    }

    public Long getCollectId() 
    {
        return collectId;
    }
    public void setcName(String cName) 
    {
        this.cName = cName;
    }

    public String getcName() 
    {
        return cName;
    }
    public void setcImage(String cImage) 
    {
        this.cImage = cImage;
    }

    public String getcImage() 
    {
        return cImage;
    }
    public void setCompositionId(Long compositionId) 
    {
        this.compositionId = compositionId;
    }

    public Long getCompositionId() 
    {
        return compositionId;
    }
    public void setcType(Long cType) 
    {
        this.cType = cType;
    }

    public Long getcType() 
    {
        return cType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isUsed", getIsUsed())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remarks", getRemarks())
            .append("collectId", getCollectId())
            .append("cName", getcName())
            .append("cImage", getcImage())
            .append("compositionId", getCompositionId())
            .append("cType", getcType())
            .toString();
    }
}
