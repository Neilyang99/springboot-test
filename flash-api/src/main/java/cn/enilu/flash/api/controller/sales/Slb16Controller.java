package cn.enilu.flash.api.controller.sales;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.entity.sales.Slb16;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.sales.SalesVo;
import cn.enilu.flash.service.sales.Sla01Service;
import cn.enilu.flash.service.sales.Slb10Service;
import cn.enilu.flash.service.sales.Slb16Service;


@RestController
@RequestMapping("/slb16")
public class Slb16Controller extends BaseController{

	@Autowired
    private Slb16Service slb16Service;
	
	@Autowired
    private Sla01Service sla01Service;
	
	@Autowired
    private Slb10Service slb10Service;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(Long slb16002) {
		
		List<Slb16> slb16s = slb16Service.findBySlb16002(slb16002);
		
		return Rets.success(slb16s);
		
	}
	
	
	/**
	 * 取得棟別
	 * @param 銷售案代號
	 * @return
	 */
	@RequestMapping(value = "/getSlb16004",method = RequestMethod.GET)
	public Object getSlb16004(String slb10004) {
		List<SalesVo> list = sla01Service.findNotSaleHouseByProjectNo(slb10004);
		return Rets.success(list);
	}
	
	@Transactional
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Slb16 slb16) {
		if(slb16.getId() == null) {
			
			slb16Service.insert(slb16);
		}else {
			
			slb16Service.update(slb16);
		}
		
		sla01Service.updateStatusBySla01ID(slb16.getSlb16010(), "B");//B=成交
		
		
		return Rets.success();
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id, Long houseId, String projectNo) {
		slb16Service.delete(id);
		
		//變更棟別狀態
		sla01Service.updateStatusBySla01ID(houseId, "A");//A=未售

        return Rets.success();
    }
	
	@Transactional
	@RequestMapping(value = "/updateAmt", method = RequestMethod.POST)
    public Object updateAmt(Long id, String projectNo) {
		int cnt1 = slb10Service.updateAmountById(id);
		int cnt = slb10Service.updateTotalAmountByIdAndProjectNo(id, projectNo);

        return Rets.success("OK="+cnt+" =>"+cnt1+" id="+id+" pjNo="+projectNo);
    }
	
}
