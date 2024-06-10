package com.leadec.sites.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.leadec.common.annotation.Excel;
import com.leadec.common.core.domain.BaseEntity;

/**
 * 现场管理对象 sites_site
 * 
 * @author Kum
 * @date 2024-05-06
 */
public class SitesSite extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 现场ID */
    @Excel(name = "现场ID")
    private String siteId;

    /** 现场logo */
    @Excel(name = "现场logo")
    private String logo;

    /** 现场名称 */
    @Excel(name = "现场名称")
    private String siteName;

    /** 现场简称 */
    @Excel(name = "现场简称")
    private String siteShortName;

    /** 权限字段 */
    @Excel(name = "权限字段")
    private String siteKey;

    /** 现场地址 */
    @Excel(name = "现场地址")
    private String address;

    /** 服务线 */
    @Excel(name = "服务线")
    private String serviceLine;

    /** 现场图片 */
    @Excel(name = "现场图片")
    private String picture;

    /** 是否可用 */
    @Excel(name = "是否可用")
    private Integer isactive;

    /** 现场经度 */
    @Excel(name = "现场经度")
    private Long longitude;

    /** 现场纬度 */
    @Excel(name = "现场纬度")
    private Long latitude;

    /** 现场描述 */
    @Excel(name = "现场描述")
    private String description;

    public void setSiteId(String siteId) 
    {
        this.siteId = siteId;
    }

    public String getSiteId() 
    {
        return siteId;
    }
    public void setLogo(String logo) 
    {
        this.logo = logo;
    }

    public String getLogo() 
    {
        return logo;
    }
    public void setSiteName(String siteName) 
    {
        this.siteName = siteName;
    }

    public String getSiteName() 
    {
        return siteName;
    }
    public void setSiteShortName(String siteShortName) 
    {
        this.siteShortName = siteShortName;
    }

    public String getSiteShortName() 
    {
        return siteShortName;
    }
    public void setSiteKey(String siteKey) 
    {
        this.siteKey = siteKey;
    }

    public String getSiteKey() 
    {
        return siteKey;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setServiceLine(String serviceLine) 
    {
        this.serviceLine = serviceLine;
    }

    public String getServiceLine() 
    {
        return serviceLine;
    }
    public void setPicture(String picture) 
    {
        this.picture = picture;
    }

    public String getPicture() 
    {
        return picture;
    }
    public void setIsactive(Integer isactive) 
    {
        this.isactive = isactive;
    }

    public Integer getIsactive() 
    {
        return isactive;
    }
    public void setLongitude(Long longitude) 
    {
        this.longitude = longitude;
    }

    public Long getLongitude() 
    {
        return longitude;
    }
    public void setLatitude(Long latitude) 
    {
        this.latitude = latitude;
    }

    public Long getLatitude() 
    {
        return latitude;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("siteId", getSiteId())
            .append("logo", getLogo())
            .append("siteName", getSiteName())
            .append("siteShortName", getSiteShortName())
            .append("siteKey", getSiteKey())
            .append("address", getAddress())
            .append("serviceLine", getServiceLine())
            .append("picture", getPicture())
            .append("isactive", getIsactive())
            .append("longitude", getLongitude())
            .append("latitude", getLatitude())
            .append("description", getDescription())
            .toString();
    }
}
