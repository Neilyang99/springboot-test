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
import cn.enilu.flash.bean.entity.sales.Slb12;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.sales.SalesVo;
import cn.enilu.flash.service.sales.Sla01Service;
import cn.enilu.flash.service.sales.Slb10Service;
import cn.enilu.flash.service.sales.Slb12Service;


@RestController
@RequestMapping("/slb12")
public class Slb12Controller extends BaseController{

	@Autowired
    private Slb12Service slb12Service;
	
	@Autowired
    private Sla01Service sla01Service;
	
	@Autowired
    private Slb10Service slb10Service;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(Long slb12002) {
		
		List<Slb12> slb12s = slb12Service.findBySlb12002(slb12002);
		
		return Rets.success(slb12s);
		
	}
	
	
	/**
	 * 取得棟別
	 * @param 銷售案代號
	 * @return
	 */
	@RequestMapping(value = "/getSlb12004",method = RequestMethod.GET)
	public Object getSlb12004(String slb10004) {
		
		List<SalesVo> list = sla01Service.findNotSaleHouseByProjectNo(slb10004);
		
		return Rets.success(list);
	}
	
	@Transactional
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Slb12 slb12) {
		if(slb12.getId() == null) {
			
			slb12Service.insert(slb12);
		}else {
			
			slb12Service.update(slb12);
		}
		
		return Rets.success();
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id, Long houseId, String projectNo) {
		slb12Service.delete(id);
		
        return Rets.success();
    }
	
	@Transactional
	@RequestMapping(value = "/updateCount", method = RequestMethod.POST)
    public Object updateCount(Long id) {
		
		int cnt = slb10Service.updateAgainCountById(id);

        return Rets.success("OK="+cnt+" id="+id);
    }
	
}
