package com.ruoyi.tasks.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 推荐用户对象 suggest_user
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class SuggestUser extends BaseEntity
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

    /** 用户名 */
    @Excel(name = "用户名")
    private String userName;

    /** 用户头像 */
    @Excel(name = "用户头像")
    private String userHead;

    /** 用户标签 */
    @Excel(name = "用户标签")
    private Long userTable;

    /** 用户类型 */
    @Excel(name = "用户类型")
    private Long userType;

    /** 用户粉丝数 */
    @Excel(name = "用户粉丝数")
    private Long userFans;

    /** 是否置顶 */
    @Excel(name = "是否置顶")
    private Long uTop;

    /** 置顶结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "置顶结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date uEndtime;

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
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setUserHead(String userHead) 
    {
        this.userHead = userHead;
    }

    public String getUserHead() 
    {
        return userHead;
    }
    public void setUserTable(Long userTable) 
    {
        this.userTable = userTable;
    }

    public Long getUserTable() 
    {
        return userTable;
    }
    public void setUserType(Long userType) 
    {
        this.userType = userType;
    }

    public Long getUserType() 
    {
        return userType;
    }
    public void setUserFans(Long userFans) 
    {
        this.userFans = userFans;
    }

    public Long getUserFans() 
    {
        return userFans;
    }
    public void setuTop(Long uTop) 
    {
        this.uTop = uTop;
    }

    public Long getuTop() 
    {
        return uTop;
    }
    public void setuEndtime(Date uEndtime) 
    {
        this.uEndtime = uEndtime;
    }

    public Date getuEndtime() 
    {
        return uEndtime;
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
            .append("userName", getUserName())
            .append("userHead", getUserHead())
            .append("userTable", getUserTable())
            .append("userType", getUserType())
            .append("userFans", getUserFans())
            .append("uTop", getuTop())
            .append("uEndtime", getuEndtime())
            .toString();
    }
}
