package com.leadec.lot.mapper;

import java.util.List;
import com.leadec.lot.domain.LotSensors;

/**
 * LOT 传感器管理Mapper接口
 * 
 * @author Kum
 * @date 2024-05-26
 */
public interface LotSensorsMapper 
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
     * 删除LOT 传感器管理
     * 
     * @param sensorId LOT 传感器管理主键
     * @return 结果
     */
    public int deleteLotSensorsBySensorId(String sensorId);

    /**
     * 批量删除LOT 传感器管理
     * 
     * @param sensorIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLotSensorsBySensorIds(String[] sensorIds);
}
