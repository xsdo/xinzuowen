package com.ruoyi.users.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户会员对象 u_vip
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class UVip extends BaseEntity
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

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 会员类型（默认：0注册会员；月卡会员：1；终身会员：2；校园年卡：3；激活年卡：4；激活永久：5） */
    @Excel(name = "会员类型", readConverterExp = "默=认：0注册会员；月卡会员：1；终身会员：2；校园年卡：3；激活年卡：4；激活永久：5")
    private Long vipType;

    /** 会员起始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "会员起始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date vBegintime;

    /** 会员到期时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "会员到期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date vEndtime;

    /** 激活码 */
    @Excel(name = "激活码")
    private String activationCode;

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
    public void setVipType(Long vipType) 
    {
        this.vipType = vipType;
    }

    public Long getVipType() 
    {
        return vipType;
    }
    public void setvBegintime(Date vBegintime) 
    {
        this.vBegintime = vBegintime;
    }

    public Date getvBegintime() 
    {
        return vBegintime;
    }
    public void setvEndtime(Date vEndtime) 
    {
        this.vEndtime = vEndtime;
    }

    public Date getvEndtime() 
    {
        return vEndtime;
    }
    public void setActivationCode(String activationCode) 
    {
        this.activationCode = activationCode;
    }

    public String getActivationCode() 
    {
        return activationCode;
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
            .append("vipType", getVipType())
            .append("vBegintime", getvBegintime())
            .append("vEndtime", getvEndtime())
            .append("activationCode", getActivationCode())
            .toString();
    }
}
