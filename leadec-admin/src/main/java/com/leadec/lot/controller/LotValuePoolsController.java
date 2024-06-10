package com.leadec.lot.controller;

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
import com.leadec.lot.domain.LotValuePools;
import com.leadec.lot.service.ILotValuePoolsService;
import com.leadec.common.utils.poi.ExcelUtil;
import com.leadec.common.core.page.TableDataInfo;

/**
 * 收集参数管理Controller
 * 
 * @author Kum
 * @date 2024-06-04
 */
@RestController
@RequestMapping("/lot/params")
public class LotValuePoolsController extends BaseController
{
    @Autowired
    private ILotValuePoolsService lotValuePoolsService;

    /**
     * 查询收集参数管理列表
     */
    @PreAuthorize("@ss.hasPermi('lot:params:list')")
    @GetMapping("/list")
    public TableDataInfo list(LotValuePools lotValuePools)
    {
        startPage();
        List<LotValuePools> list = lotValuePoolsService.selectLotValuePoolsList(lotValuePools);
        return getDataTable(list);
    }

    /**
     * 导出收集参数管理列表
     */
    @PreAuthorize("@ss.hasPermi('lot:params:export')")
    @Log(title = "收集参数管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LotValuePools lotValuePools)
    {
        List<LotValuePools> list = lotValuePoolsService.selectLotValuePoolsList(lotValuePools);
        ExcelUtil<LotValuePools> util = new ExcelUtil<LotValuePools>(LotValuePools.class);
        util.exportExcel(response, list, "收集参数管理数据");
    }

    /**
     * 获取收集参数管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('lot:params:query')")
    @GetMapping(value = "/{valueId}")
    public AjaxResult getInfo(@PathVariable("valueId") String valueId)
    {
        return success(lotValuePoolsService.selectLotValuePoolsByValueId(valueId));
    }

    /**
     * 新增收集参数管理
     */
    @PreAuthorize("@ss.hasPermi('lot:params:add')")
    @Log(title = "收集参数管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LotValuePools lotValuePools)
    {
        return toAjax(lotValuePoolsService.insertLotValuePools(lotValuePools));
    }

    /**
     * 修改收集参数管理
     */
    @PreAuthorize("@ss.hasPermi('lot:params:edit')")
    @Log(title = "收集参数管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LotValuePools lotValuePools)
    {
        return toAjax(lotValuePoolsService.updateLotValuePools(lotValuePools));
    }

    /**
     * 删除收集参数管理
     */
    @PreAuthorize("@ss.hasPermi('lot:params:remove')")
    @Log(title = "收集参数管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{valueIds}")
    public AjaxResult remove(@PathVariable String[] valueIds)
    {
        return toAjax(lotValuePoolsService.deleteLotValuePoolsByValueIds(valueIds));
    }
}
