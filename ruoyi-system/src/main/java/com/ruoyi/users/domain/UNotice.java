package com.ruoyi.users.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 消息通知对象 u_notice
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class UNotice extends BaseEntity
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

    /** 通知名 */
    @Excel(name = "通知名")
    private String nName;

    /** 消息类型:announcement公告/remind提醒/message私信 */
    @Excel(name = "消息类型:announcement公告/remind提醒/message私信")
    private Long nType;

    /** 是否已读,0未读,1已读 */
    @Excel(name = "是否已读,0未读,1已读")
    private Long readoff;

    /** 通知内容 */
    @Excel(name = "通知内容")
    private String coment;

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
    public void setnName(String nName) 
    {
        this.nName = nName;
    }

    public String getnName() 
    {
        return nName;
    }
    public void setnType(Long nType) 
    {
        this.nType = nType;
    }

    public Long getnType() 
    {
        return nType;
    }
    public void setReadoff(Long readoff) 
    {
        this.readoff = readoff;
    }

    public Long getReadoff() 
    {
        return readoff;
    }
    public void setComent(String coment) 
    {
        this.coment = coment;
    }

    public String getComent() 
    {
        return coment;
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
            .append("nName", getnName())
            .append("nType", getnType())
            .append("readoff", getReadoff())
            .append("coment", getComent())
            .toString();
    }
}
