package com.ruoyi.lot.controller;

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
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.lot.domain.LotDevices;
import com.ruoyi.lot.service.ILotDevicesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * Lot设备管理Controller
 * 
 * @author Kum
 * @date 2024-05-26
 */
@RestController
@RequestMapping("/lot/devices")
public class LotDevicesController extends BaseController
{
    @Autowired
    private ILotDevicesService lotDevicesService;

    /**
     * 查询Lot设备管理列表
     */
    @PreAuthorize("@ss.hasPermi('lot:devices:list')")
    @GetMapping("/list")
    public TableDataInfo list(LotDevices lotDevices)
    {
        startPage();
        List<LotDevices> list = lotDevicesService.selectLotDevicesList(lotDevices);
        return getDataTable(list);
    }

    /**
     * 导出Lot设备管理列表
     */
    @PreAuthorize("@ss.hasPermi('lot:devices:export')")
    @Log(title = "Lot设备管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LotDevices lotDevices)
    {
        List<LotDevices> list = lotDevicesService.selectLotDevicesList(lotDevices);
        ExcelUtil<LotDevices> util = new ExcelUtil<LotDevices>(LotDevices.class);
        util.exportExcel(response, list, "Lot设备管理数据");
    }

    /**
     * 获取Lot设备管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('lot:devices:query')")
    @GetMapping(value = "/{deviceId}")
    public AjaxResult getInfo(@PathVariable("deviceId") String deviceId)
    {
        return success(lotDevicesService.selectLotDevicesByDeviceId(deviceId));
    }

    /**
     * 新增Lot设备管理
     */
    @PreAuthorize("@ss.hasPermi('lot:devices:add')")
    @Log(title = "Lot设备管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LotDevices lotDevices)
    {
        return toAjax(lotDevicesService.insertLotDevices(lotDevices));
    }

    /**
     * 修改Lot设备管理
     */
    @PreAuthorize("@ss.hasPermi('lot:devices:edit')")
    @Log(title = "Lot设备管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LotDevices lotDevices)
    {
        return toAjax(lotDevicesService.updateLotDevices(lotDevices));
    }

    /**
     * 删除Lot设备管理
     */
    @PreAuthorize("@ss.hasPermi('lot:devices:remove')")
    @Log(title = "Lot设备管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{deviceIds}")
    public AjaxResult remove(@PathVariable String[] deviceIds)
    {
        return toAjax(lotDevicesService.deleteLotDevicesByDeviceIds(deviceIds));
    }
}
