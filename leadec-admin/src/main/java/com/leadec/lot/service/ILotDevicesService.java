package com.leadec.lot.service;

import java.util.List;
import com.leadec.lot.domain.LotDevices;

/**
 * Lot设备管理Service接口
 * 
 * @author Kum
 * @date 2024-05-26
 */
public interface ILotDevicesService 
{
    /**
     * 查询Lot设备管理
     * 
     * @param deviceId Lot设备管理主键
     * @return Lot设备管理
     */
    public LotDevices selectLotDevicesByDeviceId(String deviceId);

    /**
     * 查询Lot设备管理列表
     * 
     * @param lotDevices Lot设备管理
     * @return Lot设备管理集合
     */
    public List<LotDevices> selectLotDevicesList(LotDevices lotDevices);

    /**
     * 新增Lot设备管理
     * 
     * @param lotDevices Lot设备管理
     * @return 结果
     */
    public int insertLotDevices(LotDevices lotDevices);

    /**
     * 修改Lot设备管理
     * 
     * @param lotDevices Lot设备管理
     * @return 结果
     */
    public int updateLotDevices(LotDevices lotDevices);

    /**
     * 批量删除Lot设备管理
     * 
     * @param deviceIds 需要删除的Lot设备管理主键集合
     * @return 结果
     */
    public int deleteLotDevicesByDeviceIds(String[] deviceIds);

    /**
     * 删除Lot设备管理信息
     * 
     * @param deviceId Lot设备管理主键
     * @return 结果
     */
    public int deleteLotDevicesByDeviceId(String deviceId);
}
