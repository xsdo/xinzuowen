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
 * 用户对象 xzw_user
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class XzwUser extends BaseEntity
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

    /** 用户唯一标识 */
    @Excel(name = "用户唯一标识")
    private String uuid;

    /** 用户姓名 */
    @Excel(name = "用户姓名")
    private String userName;

    /** 登录名称（不可更改) */
    @Excel(name = "登录名称", readConverterExp = "登录名称（不可更改)")
    private String loginName;

    /** 登录密码 */
    @Excel(name = "登录密码")
    private String loginPwd;

    /** 属性绑定id，查询用户属性 */
    @Excel(name = "属性绑定id，查询用户属性")
    @JsonSerialize(using = LongJsonSerializer.class)
    @JsonDeserialize(using = LongJsonDeserializer.class)
    private Long attributeId;

    /** 微信登录唯一标识 */
    @Excel(name = "微信登录唯一标识")
    private String openId;

    /** 电话号码 */
    @Excel(name = "电话号码")
    private String phoneNumber;

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
    public void setUuid(String uuid) 
    {
        this.uuid = uuid;
    }

    public String getUuid() 
    {
        return uuid;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setLoginName(String loginName) 
    {
        this.loginName = loginName;
    }

    public String getLoginName() 
    {
        return loginName;
    }
    public void setLoginPwd(String loginPwd) 
    {
        this.loginPwd = loginPwd;
    }

    public String getLoginPwd() 
    {
        return loginPwd;
    }
    public void setAttributeId(Long attributeId) 
    {
        this.attributeId = attributeId;
    }

    public Long getAttributeId() 
    {
        return attributeId;
    }
    public void setOpenId(String openId) 
    {
        this.openId = openId;
    }

    public String getOpenId() 
    {
        return openId;
    }
    public void setPhoneNumber(String phoneNumber) 
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("isUsed", getIsUsed())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("remarks", getRemarks())
            .append("uuid", getUuid())
            .append("userName", getUserName())
            .append("loginName", getLoginName())
            .append("loginPwd", getLoginPwd())
            .append("attributeId", getAttributeId())
            .append("openId", getOpenId())
            .append("phoneNumber", getPhoneNumber())
            .toString();
    }
}
