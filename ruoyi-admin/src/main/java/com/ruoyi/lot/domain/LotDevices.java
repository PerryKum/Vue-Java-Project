package com.ruoyi.lot.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * Lot设备管理对象 lot_devices
 * 
 * @author Kum
 * @date 2024-05-14
 */
public class LotDevices extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备ID */
    @Excel(name = "设备ID")
    private String deviceId;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String deviceName;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private String deviceType;

    /** 设备连接类型 */
    @Excel(name = "设备连接类型")
    private String deviceConnectType;

    /** 设备位置 */
    @Excel(name = "设备位置")
    private String location;

    /** 设备图片 */
    @Excel(name = "设备图片")
    private String picture;

    /** 设备主题 */
    @Excel(name = "设备主题")
    private String topic;

    /** 设备纬度 */
    @Excel(name = "设备纬度")
    private Long latitude;

    /** 设备经度 */
    @Excel(name = "设备经度")
    private Long longitude;

    /** 是否可用 */
    @Excel(name = "是否可用")
    private Integer isactive;

    /** 设备描述 */
    @Excel(name = "设备描述")
    private String description;

    public void setDeviceId(String deviceId) 
    {
        this.deviceId = deviceId;
    }

    public String getDeviceId() 
    {
        return deviceId;
    }
    public void setDeviceName(String deviceName) 
    {
        this.deviceName = deviceName;
    }

    public String getDeviceName() 
    {
        return deviceName;
    }
    public void setDeviceType(String deviceType) 
    {
        this.deviceType = deviceType;
    }

    public String getDeviceType() 
    {
        return deviceType;
    }
    public void setDeviceConnectType(String deviceConnectType) 
    {
        this.deviceConnectType = deviceConnectType;
    }

    public String getDeviceConnectType() 
    {
        return deviceConnectType;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }
    public void setPicture(String picture) 
    {
        this.picture = picture;
    }

    public String getPicture() 
    {
        return picture;
    }
    public void setTopic(String topic) 
    {
        this.topic = topic;
    }

    public String getTopic() 
    {
        return topic;
    }
    public void setLatitude(Long latitude) 
    {
        this.latitude = latitude;
    }

    public Long getLatitude() 
    {
        return latitude;
    }
    public void setLongitude(Long longitude) 
    {
        this.longitude = longitude;
    }

    public Long getLongitude() 
    {
        return longitude;
    }
    public void setIsactive(Integer isactive) 
    {
        this.isactive = isactive;
    }

    public Integer getIsactive() 
    {
        return isactive;
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
            .append("deviceId", getDeviceId())
            .append("deviceName", getDeviceName())
            .append("deviceType", getDeviceType())
            .append("deviceConnectType", getDeviceConnectType())
            .append("location", getLocation())
            .append("picture", getPicture())
            .append("topic", getTopic())
            .append("latitude", getLatitude())
            .append("longitude", getLongitude())
            .append("isactive", getIsactive())
            .append("description", getDescription())
            .toString();
    }
}
