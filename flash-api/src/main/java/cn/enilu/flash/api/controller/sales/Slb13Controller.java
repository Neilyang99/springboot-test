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
import cn.enilu.flash.bean.entity.sales.Slb13;
import cn.enilu.flash.bean.enumeration.SalesEnum.HouseEnum;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.sales.SalesVo;
import cn.enilu.flash.service.sales.Sla01Service;
import cn.enilu.flash.service.sales.Slb10Service;
import cn.enilu.flash.service.sales.Slb13Service;


@RestController
@RequestMapping("/slb13")
public class Slb13Controller extends BaseController{

	@Autowired
    private Slb13Service slb13Service;
	
	@Autowired
    private Sla01Service sla01Service;
	
	@Autowired
    private Slb10Service slb10Service;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(Long slb13002) {
		
		List<Slb13> slb13s = slb13Service.findBySlb13002(slb13002);
		
		return Rets.success(slb13s);
		
	}
	
	
	/**
	 * 取得棟別
	 * @param 銷售案代號
	 * @return
	 */
	@RequestMapping(value = "/getSlb13004",method = RequestMethod.GET)
	public Object getSlb13004(String slb10004) {
		List<SalesVo> list = sla01Service.findNotSaleHouseByProjectNo(slb10004);
		return Rets.success(list);
	}
	
	@Transactional
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Slb13 slb13) {
		if(slb13.getId() == null) {
			
			slb13Service.insert(slb13);
		}else {
			
			slb13Service.update(slb13);
		}
		
		sla01Service.updateStatusBySla01ID(slb13.getSlb13010(), HouseEnum.CANCEL.getValue());//CANCEL=退戶
		
		
		return Rets.success();
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id, Long houseId, String projectNo) {
		slb13Service.delete(id);
		
		//變更棟別狀態
		sla01Service.updateStatusBySla01ID(houseId, HouseEnum.DEAL.getValue());//DEAL=成交
		

        return Rets.success();
    }
	
	@Transactional
	@RequestMapping(value = "/updateAmt", method = RequestMethod.POST)
    public Object updateAmt(Long id, String projectNo) {
//		int cnt1 = slb10Service.updateAmountById(id);
//		int cnt = slb10Service.updateTotalAmountByIdAndProjectNo(id, projectNo);

        return Rets.success("OK=> id="+id+" pjNo="+projectNo);
    }
	
}
