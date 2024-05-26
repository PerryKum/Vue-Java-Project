package com.ruoyi.sims.controller;

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
import com.ruoyi.sims.domain.SimCard;
import com.ruoyi.sims.service.ISimCardService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * SIM 卡管理Controller
 * 
 * @author Kum
 * @date 2024-05-26
 */
@RestController
@RequestMapping("/sims/sim")
public class SimCardController extends BaseController
{
    @Autowired
    private ISimCardService simCardService;

    /**
     * 查询SIM 卡管理列表
     */
    @PreAuthorize("@ss.hasPermi('sims:sim:list')")
    @GetMapping("/list")
    public TableDataInfo list(SimCard simCard)
    {
        startPage();
        List<SimCard> list = simCardService.selectSimCardList(simCard);
        return getDataTable(list);
    }

    /**
     * 导出SIM 卡管理列表
     */
    @PreAuthorize("@ss.hasPermi('sims:sim:export')")
    @Log(title = "SIM 卡管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SimCard simCard)
    {
        List<SimCard> list = simCardService.selectSimCardList(simCard);
        ExcelUtil<SimCard> util = new ExcelUtil<SimCard>(SimCard.class);
        util.exportExcel(response, list, "SIM 卡管理数据");
    }

    /**
     * 获取SIM 卡管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('sims:sim:query')")
    @GetMapping(value = "/{cardId}")
    public AjaxResult getInfo(@PathVariable("cardId") String cardId)
    {
        return success(simCardService.selectSimCardByCardId(cardId));
    }

    /**
     * 新增SIM 卡管理
     */
    @PreAuthorize("@ss.hasPermi('sims:sim:add')")
    @Log(title = "SIM 卡管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SimCard simCard)
    {
        return toAjax(simCardService.insertSimCard(simCard));
    }

    /**
     * 修改SIM 卡管理
     */
    @PreAuthorize("@ss.hasPermi('sims:sim:edit')")
    @Log(title = "SIM 卡管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SimCard simCard)
    {
        return toAjax(simCardService.updateSimCard(simCard));
    }

    /**
     * 删除SIM 卡管理
     */
    @PreAuthorize("@ss.hasPermi('sims:sim:remove')")
    @Log(title = "SIM 卡管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{cardIds}")
    public AjaxResult remove(@PathVariable String[] cardIds)
    {
        return toAjax(simCardService.deleteSimCardByCardIds(cardIds));
    }
}
