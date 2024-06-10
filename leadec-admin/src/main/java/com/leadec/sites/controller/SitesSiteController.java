package com.leadec.sites.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.leadec.common.annotation.Log;
import com.leadec.common.core.controller.BaseController;
import com.leadec.common.core.domain.AjaxResult;
import com.leadec.common.enums.BusinessType;
import com.leadec.sites.domain.SitesSite;
import com.leadec.sites.service.ISitesSiteService;
import com.leadec.common.utils.poi.ExcelUtil;
import com.leadec.common.core.page.TableDataInfo;

/**
 * 现场管理Controller
 * 
 * @author Kum
 * @date 2024-05-06
 */
@RestController
@RequestMapping("/sites/site")
public class SitesSiteController extends BaseController
{
    @Autowired
    private ISitesSiteService sitesSiteService;

    /**
     * 查询现场管理列表
     */
    @PreAuthorize("@ss.hasPermi('sites:site:list')")
    @GetMapping("/list")
    public TableDataInfo list(SitesSite sitesSite)
    {
        startPage();
        List<SitesSite> list = sitesSiteService.selectSitesSiteList(sitesSite);
        return getDataTable(list);
    }

    /**
     * 导出现场管理列表
     */
    @PreAuthorize("@ss.hasPermi('sites:site:export')")
    @Log(title = "现场管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SitesSite sitesSite)
    {
        List<SitesSite> list = sitesSiteService.selectSitesSiteList(sitesSite);
        ExcelUtil<SitesSite> util = new ExcelUtil<SitesSite>(SitesSite.class);
        util.exportExcel(response, list, "现场管理数据");
    }

    /**
     * 获取现场管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('sites:site:query')")
    @GetMapping(value = "/{siteId}")
    public AjaxResult getInfo(@PathVariable("siteId") String siteId)
    {
        return success(sitesSiteService.selectSitesSiteBySiteId(siteId));
    }

    /**
     * 新增现场管理
     */
    @PreAuthorize("@ss.hasPermi('sites:site:add')")
    @Log(title = "现场管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SitesSite sitesSite)
    {
        return toAjax(sitesSiteService.insertSitesSite(sitesSite));
    }

    /**
     * 修改现场管理
     */
    @PreAuthorize("@ss.hasPermi('sites:site:edit')")
    @Log(title = "现场管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SitesSite sitesSite)
    {
        return toAjax(sitesSiteService.updateSitesSite(sitesSite));
    }

    /**
     * 删除现场管理
     */
    @PreAuthorize("@ss.hasPermi('sites:site:remove')")
    @Log(title = "现场管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{siteIds}")
    public AjaxResult remove(@PathVariable String[] siteIds)
    {
        return toAjax(sitesSiteService.deleteSitesSiteBySiteIds(siteIds));
    }
}
