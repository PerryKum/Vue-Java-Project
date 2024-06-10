package com.leadec.sims.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.leadec.sims.mapper.SimCardMapper;
import com.leadec.sims.domain.SimCard;
import com.leadec.sims.service.ISimCardService;

/**
 * SIM 卡管理Service业务层处理
 * 
 * @author Kum
 * @date 2024-05-26
 */
@Service
public class SimCardServiceImpl implements ISimCardService 
{
    @Autowired
    private SimCardMapper simCardMapper;

    /**
     * 查询SIM 卡管理
     * 
     * @param cardId SIM 卡管理主键
     * @return SIM 卡管理
     */
    @Override
    public SimCard selectSimCardByCardId(String cardId)
    {
        return simCardMapper.selectSimCardByCardId(cardId);
    }

    /**
     * 查询SIM 卡管理列表
     * 
     * @param simCard SIM 卡管理
     * @return SIM 卡管理
     */
    @Override
    public List<SimCard> selectSimCardList(SimCard simCard)
    {
        return simCardMapper.selectSimCardList(simCard);
    }

    /**
     * 新增SIM 卡管理
     * 
     * @param simCard SIM 卡管理
     * @return 结果
     */
    @Override
    public int insertSimCard(SimCard simCard)
    {
        return simCardMapper.insertSimCard(simCard);
    }

    /**
     * 修改SIM 卡管理
     * 
     * @param simCard SIM 卡管理
     * @return 结果
     */
    @Override
    public int updateSimCard(SimCard simCard)
    {
        return simCardMapper.updateSimCard(simCard);
    }

    /**
     * 批量删除SIM 卡管理
     * 
     * @param cardIds 需要删除的SIM 卡管理主键
     * @return 结果
     */
    @Override
    public int deleteSimCardByCardIds(String[] cardIds)
    {
        return simCardMapper.deleteSimCardByCardIds(cardIds);
    }

    /**
     * 删除SIM 卡管理信息
     * 
     * @param cardId SIM 卡管理主键
     * @return 结果
     */
    @Override
    public int deleteSimCardByCardId(String cardId)
    {
        return simCardMapper.deleteSimCardByCardId(cardId);
    }
}
