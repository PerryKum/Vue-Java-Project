package com.leadec.lot.mapper;

import java.util.List;
import com.leadec.lot.domain.LotDevices;
import com.leadec.lot.domain.LotSensors;

/**
 * Lot设备管理Mapper接口
 * 
 * @author Kum
 * @date 2024-05-26
 */
public interface LotDevicesMapper 
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
     * 删除Lot设备管理
     * 
     * @param deviceId Lot设备管理主键
     * @return 结果
     */
    public int deleteLotDevicesByDeviceId(String deviceId);

    /**
     * 批量删除Lot设备管理
     * 
     * @param deviceIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLotDevicesByDeviceIds(String[] deviceIds);

    /**
     * 批量删除LOT 传感器管理
     * 
     * @param deviceIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLotSensorsBySensorIds(String[] deviceIds);
    
    /**
     * 批量新增LOT 传感器管理
     * 
     * @param lotSensorsList LOT 传感器管理列表
     * @return 结果
     */
    public int batchLotSensors(List<LotSensors> lotSensorsList);
    

    /**
     * 通过Lot设备管理主键删除LOT 传感器管理信息
     * 
     * @param deviceId Lot设备管理ID
     * @return 结果
     */
    public int deleteLotSensorsBySensorId(String deviceId);
}
