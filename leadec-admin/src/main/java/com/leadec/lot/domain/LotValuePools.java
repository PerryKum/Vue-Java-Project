package com.leadec.lot.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.leadec.common.annotation.Excel;
import com.leadec.common.core.domain.BaseEntity;

/**
 * 收集参数管理对象 lot_value_pools
 * 
 * @author Kum
 * @date 2024-06-04
 */
public class LotValuePools extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    @Excel(name = "")
    private String valueId;

    /**  */
    @Excel(name = "")
    private String valueName;

    /**  */
    @Excel(name = "")
    private String unit;

    /**  */
    @Excel(name = "")
    private Long intervalTime;

    /**  */
    @Excel(name = "")
    private Integer isactive;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createData;

    public void setValueId(String valueId) 
    {
        this.valueId = valueId;
    }

    public String getValueId() 
    {
        return valueId;
    }
    public void setValueName(String valueName) 
    {
        this.valueName = valueName;
    }

    public String getValueName() 
    {
        return valueName;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setIntervalTime(Long intervalTime) 
    {
        this.intervalTime = intervalTime;
    }

    public Long getIntervalTime() 
    {
        return intervalTime;
    }
    public void setIsactive(Integer isactive) 
    {
        this.isactive = isactive;
    }

    public Integer getIsactive() 
    {
        return isactive;
    }
    public void setCreateData(Date createData) 
    {
        this.createData = createData;
    }

    public Date getCreateData() 
    {
        return createData;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("valueId", getValueId())
            .append("valueName", getValueName())
            .append("unit", getUnit())
            .append("intervalTime", getIntervalTime())
            .append("isactive", getIsactive())
            .append("createData", getCreateData())
            .toString();
    }
}
