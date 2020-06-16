package cn.enilu.flash.api.controller.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.service.sales.Sla11Service;
import cn.enilu.flash.utils.StringUtil;

@RestController
@RequestMapping("/visitorLog")
public class Sla11Controller extends BaseController{

	@Autowired
    private Sla11Service sla11Service;
	
	@RequestMapping(value = "/visitorList",method = RequestMethod.GET)
	public Object list(String visitorId) {
		if(StringUtil.isNullOrEmpty(visitorId)) {
			return Rets.success(sla11Service.queryAll());
		}else {
			return Rets.success(sla11Service.findByVisitId(visitorId));
		}
	}
	
	
	
}
