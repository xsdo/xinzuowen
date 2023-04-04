package com.ruoyi.resources.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ruoyi.common.utils.LongJsonDeserializer;
import com.ruoyi.common.utils.LongJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ruoyi.common.utils.LongJsonDeserializer;
import com.ruoyi.common.utils.LongJsonSerializer;
/**
 * 视频对象 c_videos
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class CVideos extends BaseEntity
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

    /** 视频名 */
    @Excel(name = "视频名")
    private String vName;

    /** 视频作者 */
    @Excel(name = "视频作者")
    private String vTeacher;

    /** 视频 */
    @Excel(name = "视频")
    private String vVideos;

    /** 视频类型（默认0：通用 ；专题：1 ；专辑：2； 同步：3； 宣传片：4） */
    @Excel(name = "视频类型", readConverterExp = "默=认0：通用,；=专题：1,；=专辑：2；,同=步：3；,宣=传片：4")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long vType;

    /** 作者头衔 */
    @Excel(name = "作者头衔")
    private String vRank;

    /** 视频描述 */
    @Excel(name = "视频描述")
    private String vDescription;

    /** 视频时间 */
    @Excel(name = "视频时间")
    private String vTime;

    /** 年级 */
    @Excel(name = "年级")
    private String vGrade;

    /** 学期 */
    @Excel(name = "学期")
    private String vTerm;

    /** 单元 */
    @Excel(name = "单元")
    private String vUnitarea;

    /** 图片 */
    @Excel(name = "图片")
    private String vImage;

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
    public void setvName(String vName) 
    {
        this.vName = vName;
    }

    public String getvName() 
    {
        return vName;
    }
    public void setvTeacher(String vTeacher) 
    {
        this.vTeacher = vTeacher;
    }

    public String getvTeacher() 
    {
        return vTeacher;
    }
    public void setvVideos(String vVideos) 
    {
        this.vVideos = vVideos;
    }

    public String getvVideos() 
    {
        return vVideos;
    }
    public void setvType(Long vType) 
    {
        this.vType = vType;
    }

    public Long getvType() 
    {
        return vType;
    }
    public void setvRank(String vRank) 
    {
        this.vRank = vRank;
    }

    public String getvRank() 
    {
        return vRank;
    }
    public void setvDescription(String vDescription) 
    {
        this.vDescription = vDescription;
    }

    public String getvDescription() 
    {
        return vDescription;
    }
    public void setvTime(String vTime) 
    {
        this.vTime = vTime;
    }

    public String getvTime() 
    {
        return vTime;
    }
    public void setvGrade(String vGrade) 
    {
        this.vGrade = vGrade;
    }

    public String getvGrade() 
    {
        return vGrade;
    }
    public void setvTerm(String vTerm) 
    {
        this.vTerm = vTerm;
    }

    public String getvTerm() 
    {
        return vTerm;
    }
    public void setvUnitarea(String vUnitarea) 
    {
        this.vUnitarea = vUnitarea;
    }

    public String getvUnitarea() 
    {
        return vUnitarea;
    }
    public void setvImage(String vImage) 
    {
        this.vImage = vImage;
    }

    public String getvImage() 
    {
        return vImage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isUsed", getIsUsed())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remarks", getRemarks())
            .append("vName", getvName())
            .append("vTeacher", getvTeacher())
            .append("vVideos", getvVideos())
            .append("vType", getvType())
            .append("vRank", getvRank())
            .append("vDescription", getvDescription())
            .append("vTime", getvTime())
            .append("vGrade", getvGrade())
            .append("vTerm", getvTerm())
            .append("vUnitarea", getvUnitarea())
            .append("vImage", getvImage())
            .toString();
    }
}
