package com.leadec.lot.mapper;

import java.util.List;
import com.leadec.lot.domain.LotValuePools;

/**
 * 收集参数管理Mapper接口
 * 
 * @author Kum
 * @date 2024-06-04
 */
public interface LotValuePoolsMapper 
{
    /**
     * 查询收集参数管理
     * 
     * @param valueId 收集参数管理主键
     * @return 收集参数管理
     */
    public LotValuePools selectLotValuePoolsByValueId(String valueId);

    /**
     * 查询收集参数管理列表
     * 
     * @param lotValuePools 收集参数管理
     * @return 收集参数管理集合
     */
    public List<LotValuePools> selectLotValuePoolsList(LotValuePools lotValuePools);

    /**
     * 新增收集参数管理
     * 
     * @param lotValuePools 收集参数管理
     * @return 结果
     */
    public int insertLotValuePools(LotValuePools lotValuePools);

    /**
     * 修改收集参数管理
     * 
     * @param lotValuePools 收集参数管理
     * @return 结果
     */
    public int updateLotValuePools(LotValuePools lotValuePools);

    /**
     * 删除收集参数管理
     * 
     * @param valueId 收集参数管理主键
     * @return 结果
     */
    public int deleteLotValuePoolsByValueId(String valueId);

    /**
     * 批量删除收集参数管理
     * 
     * @param valueIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteLotValuePoolsByValueIds(String[] valueIds);
}
