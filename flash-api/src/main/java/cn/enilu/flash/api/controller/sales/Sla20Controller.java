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
import cn.enilu.flash.bean.entity.sales.Sla20;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.bean.vo.query.SearchFilter.Operator;
import cn.enilu.flash.service.sales.Sla20Service;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.StringUtil;
import cn.enilu.flash.utils.factory.Page;


@RestController
@RequestMapping("/sla20")
public class Sla20Controller extends BaseController{

	@Autowired
    private Sla20Service sla20Service;

	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(String name) {
		Page<Sla20> page = new PageFactory<Sla20>().defaultPage();
		if(StringUtil.isNullOrEmpty(name)) {
			
		}else {
			page.addFilter( "sla20008", SearchFilter.Operator.LIKE, name);
		}
		page = sla20Service.queryPage(page);
		List list = BeanUtil.objectsToMaps(page.getRecords());
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	
	@RequestMapping(value = "/getOrderById",method = RequestMethod.GET)
	public Object getOrderById(Long id) {
		
		List<Sla20> list = sla20Service.queryAll(new SearchFilter("id",Operator.EQ, id));
		
		return Rets.success(list.get(0));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Sla20 sla20) {
		if(sla20.getId() == null) {
			sla20Service.insert(sla20);
		}else {
			sla20Service.update(sla20);
		}
		
		return Rets.success();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id) {
		sla20Service.delete(id);
        return Rets.success();
    }
	
}
