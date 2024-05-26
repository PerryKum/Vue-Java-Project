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
import com.ruoyi.lot.domain.LotSensors;
import com.ruoyi.lot.service.ILotSensorsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * LOT 传感器管理Controller
 * 
 * @author Kum
 * @date 2024-05-26
 */
@RestController
@RequestMapping("/lot/sensors")
public class LotSensorsController extends BaseController
{
    @Autowired
    private ILotSensorsService lotSensorsService;

    /**
     * 查询LOT 传感器管理列表
     */
    @PreAuthorize("@ss.hasPermi('lot:sensors:list')")
    @GetMapping("/list")
    public TableDataInfo list(LotSensors lotSensors)
    {
        startPage();
        List<LotSensors> list = lotSensorsService.selectLotSensorsList(lotSensors);
        return getDataTable(list);
    }

    /**
     * 导出LOT 传感器管理列表
     */
    @PreAuthorize("@ss.hasPermi('lot:sensors:export')")
    @Log(title = "LOT 传感器管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LotSensors lotSensors)
    {
        List<LotSensors> list = lotSensorsService.selectLotSensorsList(lotSensors);
        ExcelUtil<LotSensors> util = new ExcelUtil<LotSensors>(LotSensors.class);
        util.exportExcel(response, list, "LOT 传感器管理数据");
    }

    /**
     * 获取LOT 传感器管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('lot:sensors:query')")
    @GetMapping(value = "/{sensorId}")
    public AjaxResult getInfo(@PathVariable("sensorId") String sensorId)
    {
        return success(lotSensorsService.selectLotSensorsBySensorId(sensorId));
    }

    /**
     * 新增LOT 传感器管理
     */
    @PreAuthorize("@ss.hasPermi('lot:sensors:add')")
    @Log(title = "LOT 传感器管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LotSensors lotSensors)
    {
        return toAjax(lotSensorsService.insertLotSensors(lotSensors));
    }

    /**
     * 修改LOT 传感器管理
     */
    @PreAuthorize("@ss.hasPermi('lot:sensors:edit')")
    @Log(title = "LOT 传感器管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LotSensors lotSensors)
    {
        return toAjax(lotSensorsService.updateLotSensors(lotSensors));
    }

    /**
     * 删除LOT 传感器管理
     */
    @PreAuthorize("@ss.hasPermi('lot:sensors:remove')")
    @Log(title = "LOT 传感器管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{sensorIds}")
    public AjaxResult remove(@PathVariable String[] sensorIds)
    {
        return toAjax(lotSensorsService.deleteLotSensorsBySensorIds(sensorIds));
    }
}
