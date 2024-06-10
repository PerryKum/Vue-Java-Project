package com.leadec.lot.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.leadec.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.leadec.lot.domain.LotSensors;
import com.leadec.lot.mapper.LotDevicesMapper;
import com.leadec.lot.domain.LotDevices;
import com.leadec.lot.service.ILotDevicesService;

/**
 * Lot设备管理Service业务层处理
 * 
 * @author Kum
 * @date 2024-05-26
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
    @Transactional
    @Override
    public int insertLotDevices(LotDevices lotDevices)
    {
        int rows = lotDevicesMapper.insertLotDevices(lotDevices);
        insertLotSensors(lotDevices);
        return rows;
    }

    /**
     * 修改Lot设备管理
     * 
     * @param lotDevices Lot设备管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateLotDevices(LotDevices lotDevices)
    {
        lotDevicesMapper.deleteLotSensorsBySensorId(lotDevices.getDeviceId());
        insertLotSensors(lotDevices);
        return lotDevicesMapper.updateLotDevices(lotDevices);
    }

    /**
     * 批量删除Lot设备管理
     * 
     * @param deviceIds 需要删除的Lot设备管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteLotDevicesByDeviceIds(String[] deviceIds)
    {
        lotDevicesMapper.deleteLotSensorsBySensorIds(deviceIds);
        return lotDevicesMapper.deleteLotDevicesByDeviceIds(deviceIds);
    }

    /**
     * 删除Lot设备管理信息
     * 
     * @param deviceId Lot设备管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteLotDevicesByDeviceId(String deviceId)
    {
        lotDevicesMapper.deleteLotSensorsBySensorId(deviceId);
        return lotDevicesMapper.deleteLotDevicesByDeviceId(deviceId);
    }

    /**
     * 新增LOT 传感器管理信息
     * 
     * @param lotDevices Lot设备管理对象
     */
    public void insertLotSensors(LotDevices lotDevices)
    {
        List<LotSensors> lotSensorsList = lotDevices.getLotSensorsList();
        String deviceId = lotDevices.getDeviceId();
        if (StringUtils.isNotNull(lotSensorsList))
        {
            List<LotSensors> list = new ArrayList<LotSensors>();
            for (LotSensors lotSensors : lotSensorsList)
            {
                lotSensors.setSensorId(deviceId);
                list.add(lotSensors);
            }
            if (list.size() > 0)
            {
                lotDevicesMapper.batchLotSensors(list);
            }
        }
    }
}
