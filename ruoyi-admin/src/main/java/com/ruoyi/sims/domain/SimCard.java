package com.ruoyi.sims.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * SIM 卡管理对象 sim_card
 * 
 * @author Kum
 * @date 2024-05-26
 */
public class SimCard extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** sim卡ID */
    @Excel(name = "sim卡ID")
    private String cardId;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startData;

    /** 供应商 */
    @Excel(name = "供应商")
    private String supplier;

    /** sim卡号码 */
    @Excel(name = "sim卡号码")
    private Long numberID;

    /** sim卡图片 */
    @Excel(name = "sim卡图片")
    private String picture;

    /** 是否可用 */
    @Excel(name = "是否可用")
    private Integer isactive;

    /** 消费等级 */
    @Excel(name = "消费等级")
    private String costLevel;

    /** SIMICMI */
    @Excel(name = "SIMICMI")
    private String SIMICMI;

    public void setCardId(String cardId) 
    {
        this.cardId = cardId;
    }

    public String getCardId() 
    {
        return cardId;
    }
    public void setStartData(Date startData) 
    {
        this.startData = startData;
    }

    public Date getStartData() 
    {
        return startData;
    }
    public void setSupplier(String supplier) 
    {
        this.supplier = supplier;
    }

    public String getSupplier() 
    {
        return supplier;
    }
    public void setNumberID(Long numberID) 
    {
        this.numberID = numberID;
    }

    public Long getNumberID() 
    {
        return numberID;
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
    public void setCostLevel(String costLevel) 
    {
        this.costLevel = costLevel;
    }

    public String getCostLevel() 
    {
        return costLevel;
    }
    public void setSIMICMI(String SIMICMI) 
    {
        this.SIMICMI = SIMICMI;
    }

    public String getSIMICMI() 
    {
        return SIMICMI;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cardId", getCardId())
            .append("startData", getStartData())
            .append("supplier", getSupplier())
            .append("numberID", getNumberID())
            .append("picture", getPicture())
            .append("isactive", getIsactive())
            .append("costLevel", getCostLevel())
            .append("SIMICMI", getSIMICMI())
            .toString();
    }
}
