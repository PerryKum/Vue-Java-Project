package com.ruoyi.lot.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lot.mapper.LotDevicesMapper;
import com.ruoyi.lot.domain.LotDevices;
import com.ruoyi.lot.service.ILotDevicesService;

/**
 * Lot设备管理Service业务层处理
 * 
 * @author Kum
 * @date 2024-05-14
 */
@Service
public class LotDevicesServiceImpl implements ILotDevicesService 
{
    @Autowired
    private LotDevicesMapper lotDevicesMapper;

    /**
     * 查询Lot设备管理
     * 
     * @param deviceId Lot设备管理主键
     * @return Lot设备管理
     */
    @Override
    public LotDevices selectLotDevicesByDeviceId(String deviceId)
    {
        return lotDevicesMapper.selectLotDevicesByDeviceId(deviceId);
    }

    /**
     * 查询Lot设备管理列表
     * 
     * @param lotDevices Lot设备管理
     * @return Lot设备管理
     */
    @Override
    public List<LotDevices> selectLotDevicesList(LotDevices lotDevices)
    {
        return lotDevicesMapper.selectLotDevicesList(lotDevices);
    }

    /**
     * 新增Lot设备管理
     * 
     * @param lotDevices Lot设备管理
     * @return 结果
     */
    @Override
    public int insertLotDevices(LotDevices lotDevices)
    {
        return lotDevicesMapper.insertLotDevices(lotDevices);
    }

    /**
     * 修改Lot设备管理
     * 
     * @param lotDevices Lot设备管理
     * @return 结果
     */
    @Override
    public int updateLotDevices(LotDevices lotDevices)
    {
        return lotDevicesMapper.updateLotDevices(lotDevices);
    }

    /**
     * 批量删除Lot设备管理
     * 
     * @param deviceIds 需要删除的Lot设备管理主键
     * @return 结果
     */
    @Override
    public int deleteLotDevicesByDeviceIds(String[] deviceIds)
    {
        return lotDevicesMapper.deleteLotDevicesByDeviceIds(deviceIds);
    }

    /**
     * 删除Lot设备管理信息
     * 
     * @param deviceId Lot设备管理主键
     * @return 结果
     */
    @Override
    public int deleteLotDevicesByDeviceId(String deviceId)
    {
        return lotDevicesMapper.deleteLotDevicesByDeviceId(deviceId);
    }
}
