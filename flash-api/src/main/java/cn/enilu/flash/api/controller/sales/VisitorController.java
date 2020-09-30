package cn.enilu.flash.api.controller.sales;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.entity.sales.Sla00;
import cn.enilu.flash.bean.entity.sales.Sla11;
import cn.enilu.flash.bean.entity.sales.Visitor;
import cn.enilu.flash.bean.enumeration.Permission;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.sales.Sla10Vo;
import cn.enilu.flash.utils.StringUtil;
import cn.enilu.flash.service.sales.Sla00Service;
import cn.enilu.flash.service.sales.VisitorService;


@RestController
@RequestMapping("/visitor")
public class VisitorController  extends BaseController {
	@Autowired
    private VisitorService visitorService;
	//private Sla00Service sla00Service;
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
    //@RequiresPermissions(value = {Permission.VISITOR})
	public Object list(String name) {
		if(StringUtil.isNullOrEmpty(name)) {
//			List<Visitor> list = new ArrayList<Visitor>();
//			Sla00Service sla00Service = new Sla00Service();
//			List<Sla00> sla00List = sla00Service.queryAll();
//			List<Visitor> visitorList = visitorService.queryAll();
//			
//			for(Visitor visitor : visitorList) {
//				if(!visitor.getSla10002().equals(null)) {
//					for(Sla00 sla00 : sla00List) {
//						if(visitor.getSla10002().equals(sla00.getSla00002())){
//							visitor.setSla10003(sla00.getSla00003());
//						}
//					}
//				}
//				list.add(visitor);
//			}
			
			List<Sla10Vo> list = new ArrayList<Sla10Vo>();
			
			List<Object[]> obj = visitorService.queryGridList();
			for(Object[] ary : obj) {
				Sla10Vo sla10Vo = new Sla10Vo(); 
				sla10Vo.setSla10001((Integer) ary[0]);
				sla10Vo.setSla10002((String) ary[1]);
				sla10Vo.setSla10002Name((String) ary[2]);
				sla10Vo.setSla10004((String) ary[3]);
				sla10Vo.setSla10005((String) ary[4]);
				sla10Vo.setSla10006((String) ary[5]);
				sla10Vo.setSla10010((String) ary[6]);
				sla10Vo.setSla10013((String) ary[7]);
				sla10Vo.setSla10014((String) ary[8]);
				sla10Vo.setSla10015((String) ary[9]);
				
				list.add(sla10Vo);
			}
			
			return Rets.success(list);
		}else {
			return Rets.success(visitorService.findBySla10006(name));
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Visitor visitor) {
		if(visitor.getId() == null) {
			visitorService.insert(visitor);
		}else {
			
			visitorService.update(visitor);
		}
		
		return Rets.success();
	}
}
