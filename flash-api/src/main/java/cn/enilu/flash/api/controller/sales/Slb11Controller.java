package cn.enilu.flash.api.controller.sales;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.constant.factory.PageFactory;
import cn.enilu.flash.bean.entity.sales.Sla01;
import cn.enilu.flash.bean.entity.sales.Slb10;
import cn.enilu.flash.bean.entity.sales.Slb11;
import cn.enilu.flash.bean.vo.DictVo;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.bean.vo.sales.SalesVo;
import cn.enilu.flash.service.sales.Sla01Service;
import cn.enilu.flash.service.sales.Slb10Service;
import cn.enilu.flash.service.sales.Slb11Service;
import cn.enilu.flash.service.system.impl.ConstantFactory;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.StringUtil;
import cn.enilu.flash.utils.factory.Page;
import cn.enilu.flash.warpper.UserWarpper;


@RestController
@RequestMapping("/slb11")
public class Slb11Controller extends BaseController{

	@Autowired
    private Slb11Service slb11Service;
	
	@Autowired
    private Sla01Service sla01Service;
	
	@Autowired
    private Slb10Service slb10Service;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(Long slb11002) {
		
		List<Slb11> slb11s = slb11Service.findBySlb11002(slb11002);
		
		return Rets.success(slb11s);
		
	}
	
	
	/**
	 * 取得棟別
	 * @param 銷售案代號
	 * @return
	 */
	@RequestMapping(value = "/getSlb11004",method = RequestMethod.GET)
	public Object getSlb11004(String slb10004) {
		List<SalesVo> list = new ArrayList<SalesVo>();
		
		List<Sla01> sla01s = sla01Service.findNotSaleHouse(slb10004);
		
		for(Sla01 sla01 : sla01s) {
			SalesVo vo = new SalesVo(""+sla01.getId(),sla01.getSla01005()+"<>"+sla01.getSla01006());//(id, 棟別<>戶號)
			list.add(vo);
		}
		return Rets.success(list);
	}
	
	@Transactional
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Slb11 slb11) {
		if(slb11.getId() == null) {
			
			slb11Service.insert(slb11);
		}else {
			
			slb11Service.update(slb11);
		}
		
		sla01Service.updateStatusBySla01ID(slb11.getSlb11010(), "B");//B=成交
		
		
		return Rets.success();
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id, Long houseId, String projectNo) {
		slb11Service.delete(id);
		
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
