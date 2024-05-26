package com.ruoyi.sims.service;

import java.util.List;
import com.ruoyi.sims.domain.SimCard;

/**
 * SIM 卡管理Service接口
 * 
 * @author Kum
 * @date 2024-05-26
 */
public interface ISimCardService 
{
    /**
     * 查询SIM 卡管理
     * 
     * @param cardId SIM 卡管理主键
     * @return SIM 卡管理
     */
    public SimCard selectSimCardByCardId(String cardId);

    /**
     * 查询SIM 卡管理列表
     * 
     * @param simCard SIM 卡管理
     * @return SIM 卡管理集合
     */
    public List<SimCard> selectSimCardList(SimCard simCard);

    /**
     * 新增SIM 卡管理
     * 
     * @param simCard SIM 卡管理
     * @return 结果
     */
    public int insertSimCard(SimCard simCard);

    /**
     * 修改SIM 卡管理
     * 
     * @param simCard SIM 卡管理
     * @return 结果
     */
    public int updateSimCard(SimCard simCard);

    /**
     * 批量删除SIM 卡管理
     * 
     * @param cardIds 需要删除的SIM 卡管理主键集合
     * @return 结果
     */
    public int deleteSimCardByCardIds(String[] cardIds);

    /**
     * 删除SIM 卡管理信息
     * 
     * @param cardId SIM 卡管理主键
     * @return 结果
     */
    public int deleteSimCardByCardId(String cardId);
}
