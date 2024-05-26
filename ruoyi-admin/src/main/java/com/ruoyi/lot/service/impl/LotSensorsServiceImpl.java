package com.ruoyi.lot.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lot.mapper.LotSensorsMapper;
import com.ruoyi.lot.domain.LotSensors;
import com.ruoyi.lot.service.ILotSensorsService;

/**
 * LOT 传感器管理Service业务层处理
 * 
 * @author Kum
 * @date 2024-05-26
 */
@Service
public class LotSensorsServiceImpl implements ILotSensorsService 
{
    @Autowired
    private LotSensorsMapper lotSensorsMapper;

    /**
     * 查询LOT 传感器管理
     * 
     * @param sensorId LOT 传感器管理主键
     * @return LOT 传感器管理
     */
    @Override
    public LotSensors selectLotSensorsBySensorId(String sensorId)
    {
        return lotSensorsMapper.selectLotSensorsBySensorId(sensorId);
    }

    /**
     * 查询LOT 传感器管理列表
     * 
     * @param lotSensors LOT 传感器管理
     * @return LOT 传感器管理
     */
    @Override
    public List<LotSensors> selectLotSensorsList(LotSensors lotSensors)
    {
        return lotSensorsMapper.selectLotSensorsList(lotSensors);
    }

    /**
     * 新增LOT 传感器管理
     * 
     * @param lotSensors LOT 传感器管理
     * @return 结果
     */
    @Override
    public int insertLotSensors(LotSensors lotSensors)
    {
        return lotSensorsMapper.insertLotSensors(lotSensors);
    }

    /**
     * 修改LOT 传感器管理
     * 
     * @param lotSensors LOT 传感器管理
     * @return 结果
     */
    @Override
    public int updateLotSensors(LotSensors lotSensors)
    {
        return lotSensorsMapper.updateLotSensors(lotSensors);
    }

    /**
     * 批量删除LOT 传感器管理
     * 
     * @param sensorIds 需要删除的LOT 传感器管理主键
     * @return 结果
     */
    @Override
    public int deleteLotSensorsBySensorIds(String[] sensorIds)
    {
        return lotSensorsMapper.deleteLotSensorsBySensorIds(sensorIds);
    }

    /**
     * 删除LOT 传感器管理信息
     * 
     * @param sensorId LOT 传感器管理主键
     * @return 结果
     */
    @Override
    public int deleteLotSensorsBySensorId(String sensorId)
    {
        return lotSensorsMapper.deleteLotSensorsBySensorId(sensorId);
    }
}
