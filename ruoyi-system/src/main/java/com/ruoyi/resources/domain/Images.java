package com.ruoyi.resources.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 随机图对象 images
 * 
 * @author xqq
 * @date 2023-03-27
 */
public class Images extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 大图地址 */
    @Excel(name = "大图地址")
    private String imageB;

    /** 小图地址 */
    @Excel(name = "小图地址")
    private String imageS;

    /** 类型 */
    @Excel(name = "类型")
    private Long type;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setImageB(String imageB) 
    {
        this.imageB = imageB;
    }

    public String getImageB() 
    {
        return imageB;
    }
    public void setImageS(String imageS) 
    {
        this.imageS = imageS;
    }

    public String getImageS() 
    {
        return imageS;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("imageB", getImageB())
            .append("imageS", getImageS())
            .append("type", getType())
            .toString();
    }
}
