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
 * 教师班级对象 u_teacher
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class UTeacher extends BaseEntity
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

    /** 名称 */
    @Excel(name = "名称")
    private String tName;

    /** 绑定学校id */
    @Excel(name = "绑定学校id")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long tSchoolid;

    /** 年级 */
    @Excel(name = "年级")
    private String tGrade;

    /** 学期 */
    @Excel(name = "学期")
    private String tTerm;

    /** 二维码 */
    @Excel(name = "二维码")
    private String qrCode;

    /** 学生人数 */
    @Excel(name = "学生人数")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long tStudent;

    /** 班级鲜花数 */
    @Excel(name = "班级鲜花数")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long tFlowers;

    /** 班级头像 */
    @Excel(name = "班级头像")
    private String tImage;

    /** 教师姓名 */
    @Excel(name = "教师姓名")
    private String teaName;

    /** 教师头像 */
    @Excel(name = "教师头像")
    private String teaImage;

    /** 教师签名 */
    @Excel(name = "教师签名")
    private String teaSign;

    /** 班级口号 */
    @Excel(name = "班级口号")
    private String tSlogan;

    /** 写作数 */
    @Excel(name = "写作数")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long writes;

    /** 阅读数 */
    @Excel(name = "阅读数")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long readings;

    /** 朗读数 */
    @Excel(name = "朗读数")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long readalouds;

    /** 班级开关 0不可加入 */
    @Excel(name = "班级开关 0不可加入")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long tOpen;

    /** 排名 */
    @Excel(name = "排名")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long rankings;

    /** 老师id */
    @Excel(name = "老师id")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long teacherId;

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
    public void settName(String tName) 
    {
        this.tName = tName;
    }

    public String gettName() 
    {
        return tName;
    }
    public void settSchoolid(Long tSchoolid) 
    {
        this.tSchoolid = tSchoolid;
    }

    public Long gettSchoolid() 
    {
        return tSchoolid;
    }
    public void settGrade(String tGrade) 
    {
        this.tGrade = tGrade;
    }

    public String gettGrade() 
    {
        return tGrade;
    }
    public void settTerm(String tTerm) 
    {
        this.tTerm = tTerm;
    }

    public String gettTerm() 
    {
        return tTerm;
    }
    public void setQrCode(String qrCode) 
    {
        this.qrCode = qrCode;
    }

    public String getQrCode() 
    {
        return qrCode;
    }
    public void settStudent(Long tStudent) 
    {
        this.tStudent = tStudent;
    }

    public Long gettStudent() 
    {
        return tStudent;
    }
    public void settFlowers(Long tFlowers) 
    {
        this.tFlowers = tFlowers;
    }

    public Long gettFlowers() 
    {
        return tFlowers;
    }
    public void settImage(String tImage) 
    {
        this.tImage = tImage;
    }

    public String gettImage() 
    {
        return tImage;
    }
    public void setTeaName(String teaName) 
    {
        this.teaName = teaName;
    }

    public String getTeaName() 
    {
        return teaName;
    }
    public void setTeaImage(String teaImage) 
    {
        this.teaImage = teaImage;
    }

    public String getTeaImage() 
    {
        return teaImage;
    }
    public void setTeaSign(String teaSign) 
    {
        this.teaSign = teaSign;
    }

    public String getTeaSign() 
    {
        return teaSign;
    }
    public void settSlogan(String tSlogan) 
    {
        this.tSlogan = tSlogan;
    }

    public String gettSlogan() 
    {
        return tSlogan;
    }
    public void setWrites(Long writes) 
    {
        this.writes = writes;
    }

    public Long getWrites() 
    {
        return writes;
    }
    public void setReadings(Long readings) 
    {
        this.readings = readings;
    }

    public Long getReadings() 
    {
        return readings;
    }
    public void setReadalouds(Long readalouds) 
    {
        this.readalouds = readalouds;
    }

    public Long getReadalouds() 
    {
        return readalouds;
    }
    public void settOpen(Long tOpen) 
    {
        this.tOpen = tOpen;
    }

    public Long gettOpen() 
    {
        return tOpen;
    }
    public void setRankings(Long rankings) 
    {
        this.rankings = rankings;
    }

    public Long getRankings() 
    {
        return rankings;
    }
    public void setTeacherId(Long teacherId) 
    {
        this.teacherId = teacherId;
    }

    public Long getTeacherId() 
    {
        return teacherId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isUsed", getIsUsed())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remarks", getRemarks())
            .append("tName", gettName())
            .append("tSchoolid", gettSchoolid())
            .append("tGrade", gettGrade())
            .append("tTerm", gettTerm())
            .append("qrCode", getQrCode())
            .append("tStudent", gettStudent())
            .append("tFlowers", gettFlowers())
            .append("tImage", gettImage())
            .append("teaName", getTeaName())
            .append("teaImage", getTeaImage())
            .append("teaSign", getTeaSign())
            .append("tSlogan", gettSlogan())
            .append("writes", getWrites())
            .append("readings", getReadings())
            .append("readalouds", getReadalouds())
            .append("tOpen", gettOpen())
            .append("rankings", getRankings())
            .append("teacherId", getTeacherId())
            .toString();
    }
}
