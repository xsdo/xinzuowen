package com.ruoyi.tasks.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 轮播图对象 rotation_task
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class RotationTask extends BaseEntity
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

    /** 轮播标题 */
    @Excel(name = "轮播标题")
    private String rTitle;

    /** 轮播图 */
    @Excel(name = "轮播图")
    private String rImage;

    /** 轮播类型（默认：0；首页轮播：1；广告轮播：2；图书轮播：3；插播广告：4-唯一） */
    @Excel(name = "轮播类型", readConverterExp = "默=认：0；首页轮播：1；广告轮播：2；图书轮播：3；插播广告：4-唯一")
    private Long rType;

    /** 跳转页链接 */
    @Excel(name = "跳转页链接")
    private String rUrl;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date rEndtime;

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
    public void setrTitle(String rTitle) 
    {
        this.rTitle = rTitle;
    }

    public String getrTitle() 
    {
        return rTitle;
    }
    public void setrImage(String rImage) 
    {
        this.rImage = rImage;
    }

    public String getrImage() 
    {
        return rImage;
    }
    public void setrType(Long rType) 
    {
        this.rType = rType;
    }

    public Long getrType() 
    {
        return rType;
    }
    public void setrUrl(String rUrl) 
    {
        this.rUrl = rUrl;
    }

    public String getrUrl() 
    {
        return rUrl;
    }
    public void setrEndtime(Date rEndtime) 
    {
        this.rEndtime = rEndtime;
    }

    public Date getrEndtime() 
    {
        return rEndtime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isUsed", getIsUsed())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remarks", getRemarks())
            .append("rTitle", getrTitle())
            .append("rImage", getrImage())
            .append("rType", getrType())
            .append("rUrl", getrUrl())
            .append("rEndtime", getrEndtime())
            .toString();
    }
}
