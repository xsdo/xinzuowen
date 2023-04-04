package com.ruoyi.users.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ruoyi.common.utils.LongJsonDeserializer;
import com.ruoyi.common.utils.LongJsonSerializer;

/**
 * 用户属性对象 u_attribute
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class UAttribute extends BaseEntity
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

    /** 性别（默认：0；男：1；女：2） */
    @Excel(name = "性别", readConverterExp = "默=认：0；男：1；女：2")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long sex;

    /** 生日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /** 头像（url） */
    @Excel(name = "头像", readConverterExp = "u=rl")
    private String portrait;

    /** qq */
    @Excel(name = "qq")
    private String qqnum;

    /** 微信号 */
    @Excel(name = "微信号")
    private String wechatnum;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 用户类型(默认：0；读者：1；作者：2；编辑：3；播音：4；教师：5；代理商：6) */
    @Excel(name = "用户类型(默认：0；读者：1；作者：2；编辑：3；播音：4；教师：5；代理商：6)")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long uType;

    /** 展示标签id，绑定标签表 */
    @Excel(name = "展示标签id，绑定标签表")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long uTableuse;

    /** 已获取标签id集合 */
    @Excel(name = "已获取标签id集合")
    private String uTableids;

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

    /** 是否认证用户(no0;yes1) */
    @Excel(name = "是否认证用户(no0;yes1)")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long isAuth;

    /** 个性签名 */
    @Excel(name = "个性签名")
    private String sign;

    /** 背景图（url） */
    @Excel(name = "背景图", readConverterExp = "u=rl")
    private String background;

    /** 绑定老师id */
    @Excel(name = "绑定老师id")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long teacherid;

    /** 是否优评员（默认0：非；优评：1） */
    @Excel(name = "是否优评员", readConverterExp = "默=认0：非；优评：1")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long isgoodcommons;

    /** 积分 */
    @Excel(name = "积分")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long integral;

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
    public void setSex(Long sex) 
    {
        this.sex = sex;
    }

    public Long getSex() 
    {
        return sex;
    }
    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }

    public Date getBirthday() 
    {
        return birthday;
    }
    public void setPortrait(String portrait) 
    {
        this.portrait = portrait;
    }

    public String getPortrait() 
    {
        return portrait;
    }
    public void setQqnum(String qqnum) 
    {
        this.qqnum = qqnum;
    }

    public String getQqnum() 
    {
        return qqnum;
    }
    public void setWechatnum(String wechatnum) 
    {
        this.wechatnum = wechatnum;
    }

    public String getWechatnum() 
    {
        return wechatnum;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setuType(Long uType) 
    {
        this.uType = uType;
    }

    public Long getuType() 
    {
        return uType;
    }
    public void setuTableuse(Long uTableuse) 
    {
        this.uTableuse = uTableuse;
    }

    public Long getuTableuse() 
    {
        return uTableuse;
    }
    public void setuTableids(String uTableids) 
    {
        this.uTableids = uTableids;
    }

    public String getuTableids() 
    {
        return uTableids;
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
    public void setIsAuth(Long isAuth) 
    {
        this.isAuth = isAuth;
    }

    public Long getIsAuth() 
    {
        return isAuth;
    }
    public void setSign(String sign) 
    {
        this.sign = sign;
    }

    public String getSign() 
    {
        return sign;
    }
    public void setBackground(String background) 
    {
        this.background = background;
    }

    public String getBackground() 
    {
        return background;
    }
    public void setTeacherid(Long teacherid) 
    {
        this.teacherid = teacherid;
    }

    public Long getTeacherid() 
    {
        return teacherid;
    }
    public void setIsgoodcommons(Long isgoodcommons) 
    {
        this.isgoodcommons = isgoodcommons;
    }

    public Long getIsgoodcommons() 
    {
        return isgoodcommons;
    }
    public void setIntegral(Long integral) 
    {
        this.integral = integral;
    }

    public Long getIntegral() 
    {
        return integral;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isUsed", getIsUsed())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remarks", getRemarks())
            .append("sex", getSex())
            .append("birthday", getBirthday())
            .append("portrait", getPortrait())
            .append("qqnum", getQqnum())
            .append("wechatnum", getWechatnum())
            .append("email", getEmail())
            .append("uType", getuType())
            .append("uTableuse", getuTableuse())
            .append("uTableids", getuTableids())
            .append("province", getProvince())
            .append("city", getCity())
            .append("area", getArea())
            .append("school", getSchool())
            .append("isAuth", getIsAuth())
            .append("sign", getSign())
            .append("background", getBackground())
            .append("teacherid", getTeacherid())
            .append("isgoodcommons", getIsgoodcommons())
            .append("integral", getIntegral())
            .toString();
    }
}
