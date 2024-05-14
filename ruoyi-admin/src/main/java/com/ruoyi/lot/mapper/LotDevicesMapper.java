package com.ruoyi.lot.mapper;

import java.util.List;
import com.ruoyi.lot.domain.LotDevices;

/**
 * Lot设备管理Mapper接口
 * 
 * @author Kum
 * @date 2024-05-14
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
}
