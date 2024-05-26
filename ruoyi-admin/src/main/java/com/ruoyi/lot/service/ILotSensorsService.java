package com.ruoyi.lot.service;

import java.util.List;
import com.ruoyi.lot.domain.LotSensors;

/**
 * LOT 传感器管理Service接口
 * 
 * @author Kum
 * @date 2024-05-26
 */
public interface ILotSensorsService 
{
    /**
     * 查询LOT 传感器管理
     * 
     * @param sensorId LOT 传感器管理主键
     * @return LOT 传感器管理
     */
    public LotSensors selectLotSensorsBySensorId(String sensorId);

    /**
     * 查询LOT 传感器管理列表
     * 
     * @param lotSensors LOT 传感器管理
     * @return LOT 传感器管理集合
     */
    public List<LotSensors> selectLotSensorsList(LotSensors lotSensors);

    /**
     * 新增LOT 传感器管理
     * 
     * @param lotSensors LOT 传感器管理
     * @return 结果
     */
    public int insertLotSensors(LotSensors lotSensors);

    /**
     * 修改LOT 传感器管理
     * 
     * @param lotSensors LOT 传感器管理
     * @return 结果
     */
    public int updateLotSensors(LotSensors lotSensors);

    /**
     * 批量删除LOT 传感器管理
     * 
     * @param sensorIds 需要删除的LOT 传感器管理主键集合
     * @return 结果
     */
    public int deleteLotSensorsBySensorIds(String[] sensorIds);

    /**
     * 删除LOT 传感器管理信息
     * 
     * @param sensorId LOT 传感器管理主键
     * @return 结果
     */
    public int deleteLotSensorsBySensorId(String sensorId);
}
