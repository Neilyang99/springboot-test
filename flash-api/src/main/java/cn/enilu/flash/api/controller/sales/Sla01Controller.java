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
import cn.enilu.flash.bean.entity.sales.Sla01;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.service.sales.Sla01Service;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.StringUtil;
import cn.enilu.flash.utils.factory.Page;
import cn.enilu.flash.warpper.UserWarpper;


@RestController
@RequestMapping("/sla01")
public class Sla01Controller extends BaseController{

	@Autowired
    private Sla01Service sla01Service;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(String house) {
		Page<Sla01> page = new PageFactory<Sla01>().defaultPage();
		if(StringUtil.isNullOrEmpty(house)) {
			
		}else {
			page.addFilter( "sla01005", SearchFilter.Operator.LIKE, house);
		}
		page = sla01Service.queryPage(page);
		List list = (List) new UserWarpper(BeanUtil.objectsToMaps(page.getRecords())).warp();
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Sla01 sla01) {
		if(sla01.getId() == null) {
			sla01Service.insert(sla01);
		}else {
			
			sla01Service.update(sla01);
		}
		
		return Rets.success();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id) {
		sla01Service.delete(id);
        return Rets.success();
    }
	
}
