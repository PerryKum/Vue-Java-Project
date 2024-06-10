package com.leadec.lot.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.leadec.lot.mapper.LotValuePoolsMapper;
import com.leadec.lot.domain.LotValuePools;
import com.leadec.lot.service.ILotValuePoolsService;

/**
 * 收集参数管理Service业务层处理
 * 
 * @author Kum
 * @date 2024-06-04
 */
@Service
public class LotValuePoolsServiceImpl implements ILotValuePoolsService 
{
    @Autowired
    private LotValuePoolsMapper lotValuePoolsMapper;

    /**
     * 查询收集参数管理
     * 
     * @param valueId 收集参数管理主键
     * @return 收集参数管理
     */
    @Override
    public LotValuePools selectLotValuePoolsByValueId(String valueId)
    {
        return lotValuePoolsMapper.selectLotValuePoolsByValueId(valueId);
    }

    /**
     * 查询收集参数管理列表
     * 
     * @param lotValuePools 收集参数管理
     * @return 收集参数管理
     */
    @Override
    public List<LotValuePools> selectLotValuePoolsList(LotValuePools lotValuePools)
    {
        return lotValuePoolsMapper.selectLotValuePoolsList(lotValuePools);
    }

    /**
     * 新增收集参数管理
     * 
     * @param lotValuePools 收集参数管理
     * @return 结果
     */
    @Override
    public int insertLotValuePools(LotValuePools lotValuePools)
    {
        return lotValuePoolsMapper.insertLotValuePools(lotValuePools);
    }

    /**
     * 修改收集参数管理
     * 
     * @param lotValuePools 收集参数管理
     * @return 结果
     */
    @Override
    public int updateLotValuePools(LotValuePools lotValuePools)
    {
        return lotValuePoolsMapper.updateLotValuePools(lotValuePools);
    }

    /**
     * 批量删除收集参数管理
     * 
     * @param valueIds 需要删除的收集参数管理主键
     * @return 结果
     */
    @Override
    public int deleteLotValuePoolsByValueIds(String[] valueIds)
    {
        return lotValuePoolsMapper.deleteLotValuePoolsByValueIds(valueIds);
    }

    /**
     * 删除收集参数管理信息
     * 
     * @param valueId 收集参数管理主键
     * @return 结果
     */
    @Override
    public int deleteLotValuePoolsByValueId(String valueId)
    {
        return lotValuePoolsMapper.deleteLotValuePoolsByValueId(valueId);
    }
}
