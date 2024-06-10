package com.leadec.sites.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.leadec.sites.mapper.SitesSiteMapper;
import com.leadec.sites.domain.SitesSite;
import com.leadec.sites.service.ISitesSiteService;

/**
 * 现场管理Service业务层处理
 * 
 * @author Kum
 * @date 2024-05-06
 */
@Service
public class SitesSiteServiceImpl implements ISitesSiteService 
{
    @Autowired
    private SitesSiteMapper sitesSiteMapper;

    /**
     * 查询现场管理
     * 
     * @param siteId 现场管理主键
     * @return 现场管理
     */
    @Override
    public SitesSite selectSitesSiteBySiteId(String siteId)
    {
        return sitesSiteMapper.selectSitesSiteBySiteId(siteId);
    }

    /**
     * 查询现场管理列表
     * 
     * @param sitesSite 现场管理
     * @return 现场管理
     */
    @Override
    public List<SitesSite> selectSitesSiteList(SitesSite sitesSite)
    {
        return sitesSiteMapper.selectSitesSiteList(sitesSite);
    }

    /**
     * 新增现场管理
     * 
     * @param sitesSite 现场管理
     * @return 结果
     */
    @Override
    public int insertSitesSite(SitesSite sitesSite)
    {
        return sitesSiteMapper.insertSitesSite(sitesSite);
    }

    /**
     * 修改现场管理
     * 
     * @param sitesSite 现场管理
     * @return 结果
     */
    @Override
    public int updateSitesSite(SitesSite sitesSite)
    {
        return sitesSiteMapper.updateSitesSite(sitesSite);
    }

    /**
     * 批量删除现场管理
     * 
     * @param siteIds 需要删除的现场管理主键
     * @return 结果
     */
    @Override
    public int deleteSitesSiteBySiteIds(String[] siteIds)
    {
        return sitesSiteMapper.deleteSitesSiteBySiteIds(siteIds);
    }

    /**
     * 删除现场管理信息
     * 
     * @param siteId 现场管理主键
     * @return 结果
     */
    @Override
    public int deleteSitesSiteBySiteId(String siteId)
    {
        return sitesSiteMapper.deleteSitesSiteBySiteId(siteId);
    }
}
