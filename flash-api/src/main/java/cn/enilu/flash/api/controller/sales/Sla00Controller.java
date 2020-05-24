package cn.enilu.flash.api.controller.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.service.sales.Sla00Service;


@RestController
@RequestMapping("/sla00")
public class Sla00Controller extends BaseController{

	@Autowired
    private Sla00Service sla00Service;
	
	@RequestMapping(value = "/selectList",method = RequestMethod.GET)
	public Object selectList() {
		return Rets.success(sla00Service.queryAll());
	}
	
}
