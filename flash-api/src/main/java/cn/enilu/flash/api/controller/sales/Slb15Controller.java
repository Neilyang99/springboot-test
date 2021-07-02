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
import cn.enilu.flash.bean.entity.sales.Slb15;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.sales.SalesVo;
import cn.enilu.flash.service.sales.Sla01Service;
import cn.enilu.flash.service.sales.Slb10Service;
import cn.enilu.flash.service.sales.Slb15Service;


@RestController
@RequestMapping("/slb15")
public class Slb15Controller extends BaseController{

	@Autowired
    private Slb15Service slb15Service;
	
	@Autowired
    private Sla01Service sla01Service;
	
	@Autowired
    private Slb10Service slb10Service;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(Long slb15002) {
		
		List<Slb15> slb15s = slb15Service.findBySlb15002(slb15002);
		
		return Rets.success(slb15s);
		
	}
	
	
	/**
	 * 取得棟別
	 * @param 銷售案代號
	 * @return
	 */
	@RequestMapping(value = "/getSlb15004",method = RequestMethod.GET)
	public Object getSlb15004(String slb10004) {
		
		//TODO: what kind of status should be selected? not sale or has contract
		List<SalesVo> list = sla01Service.findNotSaleHouseByProjectNo(slb10004);
		return Rets.success(list);
	}
	
	@Transactional
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Slb15 slb15) {
		if(slb15.getId() == null) {
			
			slb15Service.insert(slb15);
		}else {
			
			slb15Service.update(slb15);
		}
		
		//sla01Service.updateStatusBySla01ID(slb15.getSlb15010(), "B");//B=成交 ??
		
		
		return Rets.success();
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id, Long houseId, String projectNo) {
		slb15Service.delete(id);
		
		//變更棟別狀態
		//TODO : what is the status after remove the order
		//sla01Service.updateStatusBySla01ID(houseId, "A");//A=未售 ????

        return Rets.success();
    }
	
	@Transactional
	@RequestMapping(value = "/updateAmt", method = RequestMethod.POST)
    public Object updateAmt(Long id, String projectNo) {
		//int cnt1 = slb10Service.updateCountAmountById(id, "slb10027", "slb10028");
		//int cnt = slb10Service.updateTotalAmountByIdAndProjectNo(id, projectNo);

        return Rets.success("OK= id="+id+" pjNo="+projectNo);
    }
	
}
