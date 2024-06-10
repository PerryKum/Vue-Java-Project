package com.leadec.lot.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.leadec.common.annotation.Excel;
import com.leadec.common.core.domain.BaseEntity;

/**
 * LOT 传感器管理对象 lot_sensors
 * 
 * @author Kum
 * @date 2024-05-26
 */
public class LotSensors extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 传感器ID */
    @Excel(name = "传感器ID")
    private String sensorId;

    /** 传感器名称 */
    @Excel(name = "传感器名称")
    private String sensorName;

    /** 传感器种类 */
    @Excel(name = "传感器种类")
    private String sensorType;

    /** 传感器标签 */
    @Excel(name = "传感器标签")
    private String sensorTag;

    /** 是否可用 */
    @Excel(name = "是否可用")
    private Long isactive;

    public void setSensorId(String sensorId) 
    {
        this.sensorId = sensorId;
    }

    public String getSensorId() 
    {
        return sensorId;
    }
    public void setSensorName(String sensorName) 
    {
        this.sensorName = sensorName;
    }

    public String getSensorName() 
    {
        return sensorName;
    }
    public void setSensorType(String sensorType) 
    {
        this.sensorType = sensorType;
    }

    public String getSensorType() 
    {
        return sensorType;
    }
    public void setSensorTag(String sensorTag) 
    {
        this.sensorTag = sensorTag;
    }

    public String getSensorTag() 
    {
        return sensorTag;
    }
    public void setIsactive(Long isactive) 
    {
        this.isactive = isactive;
    }

    public Long getIsactive() 
    {
        return isactive;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sensorId", getSensorId())
            .append("sensorName", getSensorName())
            .append("sensorType", getSensorType())
            .append("sensorTag", getSensorTag())
            .append("isactive", getIsactive())
            .toString();
    }
}
