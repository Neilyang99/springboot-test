package cn.enilu.flash.api.controller.sales;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.constant.factory.PageFactory;
import cn.enilu.flash.bean.entity.sales.Sla00;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.service.sales.Sla00Service;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.DateUtil;
import cn.enilu.flash.utils.StringUtil;
import cn.enilu.flash.utils.factory.Page;


@RestController
@RequestMapping("/sla00")
public class Sla00Controller extends BaseController{

	@Autowired
    private Sla00Service sla00Service;
	
	@RequestMapping(value = "/selectList",method = RequestMethod.GET)
	public Object selectList() {
		return Rets.success(sla00Service.queryAll());
	}
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(String name) {
		Page<Sla00> page = new PageFactory<Sla00>().defaultPage();
		if(StringUtil.isNullOrEmpty(name)) {
			
		}else {
			page.addFilter( "sla00003", SearchFilter.Operator.LIKE, name);
		}
		page = sla00Service.queryPage(page);
		List list = BeanUtil.objectsToMaps(page.getRecords());
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Sla00 sla00) {
		if(sla00.getId() == null) {
			Sla00 house = sla00Service.findByBuildingCode(sla00.getSla00002());
			if(house == null) {
				sla00Service.insert(sla00);
			}else {
				return Rets.failure("銷售案代號重複。");
			}
			
		}else {
			
			sla00Service.update(sla00);
		}
		
		return Rets.success();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id) {
		sla00Service.delete(id);
        return Rets.success();
    }
	
	@RequestMapping(value="/startToSale",method = RequestMethod.GET)
    public Object startToSale(Long id,String status) {
		Sla00 sla00 = sla00Service.get(id);
		sla00.setSla00041(status);
		if(status.equals("Y")) {
			sla00.setSla00008(DateUtil.getDays());//開始銷售
		}else if(status.equals("S")) {//完銷
			sla00.setSla00009(DateUtil.getDays());
		}
		sla00.setSla00041(status);
		sla00Service.update(sla00);
		
        return Rets.success();
    }
	
}
