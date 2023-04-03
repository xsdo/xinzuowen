package com.ruoyi.users.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 激活码对象 u_activation
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class UActivation extends BaseEntity
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

    /** 会员类型（默认：0注册会员；终身会员：1；年卡：2） */
    @Excel(name = "会员类型", readConverterExp = "默=认：0注册会员；终身会员：1；年卡：2")
    private Long vipType;

    /** 激活码创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "激活码创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date vCreatetime;

    /** 激活码到期时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "激活码到期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date vEndtime;

    /** 激活码 */
    @Excel(name = "激活码")
    private String activationCode;

    /** 激活码状态（默认：0未激活；激活：1） */
    @Excel(name = "激活码状态", readConverterExp = "默=认：0未激活；激活：1")
    private Long status;

    /** 激活时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "激活时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date vUsetime;

    /** 激活用户id */
    @Excel(name = "激活用户id")
    private Long userId;

    /** 建码人 */
    @Excel(name = "建码人")
    private String createUser;

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
    public void setVipType(Long vipType) 
    {
        this.vipType = vipType;
    }

    public Long getVipType() 
    {
        return vipType;
    }
    public void setvCreatetime(Date vCreatetime) 
    {
        this.vCreatetime = vCreatetime;
    }

    public Date getvCreatetime() 
    {
        return vCreatetime;
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
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setvUsetime(Date vUsetime) 
    {
        this.vUsetime = vUsetime;
    }

    public Date getvUsetime() 
    {
        return vUsetime;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setCreateUser(String createUser) 
    {
        this.createUser = createUser;
    }

    public String getCreateUser() 
    {
        return createUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isUsed", getIsUsed())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remarks", getRemarks())
            .append("vipType", getVipType())
            .append("vCreatetime", getvCreatetime())
            .append("vEndtime", getvEndtime())
            .append("activationCode", getActivationCode())
            .append("status", getStatus())
            .append("vUsetime", getvUsetime())
            .append("userId", getUserId())
            .append("createUser", getCreateUser())
            .toString();
    }
}
