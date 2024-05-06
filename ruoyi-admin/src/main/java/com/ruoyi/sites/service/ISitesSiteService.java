package com.ruoyi.sites.service;

import java.util.List;
import com.ruoyi.sites.domain.SitesSite;

/**
 * 现场管理Service接口
 * 
 * @author Kum
 * @date 2024-05-06
 */
public interface ISitesSiteService 
{
    /**
     * 查询现场管理
     * 
     * @param siteId 现场管理主键
     * @return 现场管理
     */
    public SitesSite selectSitesSiteBySiteId(String siteId);

    /**
     * 查询现场管理列表
     * 
     * @param sitesSite 现场管理
     * @return 现场管理集合
     */
    public List<SitesSite> selectSitesSiteList(SitesSite sitesSite);

    /**
     * 新增现场管理
     * 
     * @param sitesSite 现场管理
     * @return 结果
     */
    public int insertSitesSite(SitesSite sitesSite);

    /**
     * 修改现场管理
     * 
     * @param sitesSite 现场管理
     * @return 结果
     */
    public int updateSitesSite(SitesSite sitesSite);

    /**
     * 批量删除现场管理
     * 
     * @param siteIds 需要删除的现场管理主键集合
     * @return 结果
     */
    public int deleteSitesSiteBySiteIds(String[] siteIds);

    /**
     * 删除现场管理信息
     * 
     * @param siteId 现场管理主键
     * @return 结果
     */
    public int deleteSitesSiteBySiteId(String siteId);
}
