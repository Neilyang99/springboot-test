package cn.enilu.flash.api.controller.ma;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.constant.factory.PageFactory;
import cn.enilu.flash.bean.entity.ma.Maa02;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.service.ma.Maa02Service;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.StringUtil;
import cn.enilu.flash.utils.factory.Page;


@RestController
@RequestMapping("/maa02")
public class Maa02Controller extends BaseController{

	@Autowired
    private Maa02Service maa02Service;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(String name) {
		Page<Maa02> page = new PageFactory<Maa02>().defaultPage();
		if(StringUtil.isNullOrEmpty(name)) {
			
		}else {
			page.addFilter( "maa02004", SearchFilter.Operator.LIKE, name);
		}
		page = maa02Service.queryPage(page);
		List list = BeanUtil.objectsToMaps(page.getRecords());
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	@RequestMapping(value = "/listByProject",method = RequestMethod.GET)
	public Object listByProject(@RequestParam(required = false) Long projectId) {
		Page<Maa02> page = new PageFactory<Maa02>().defaultPage();
		page.addFilter( "maa02002", SearchFilter.Operator.EQ, projectId);
		
		page = maa02Service.queryPage(page);
		List list = BeanUtil.objectsToMaps(page.getRecords());
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Maa02 maObj) {
		
		String msg = "";
		
		if(maObj.getId() == null) {
			maa02Service.insert(maObj);
		}else {
			maa02Service.update(maObj);
			
		}
		
		if(msg == "") {
			return Rets.success();
		}else {
			return Rets.failure(msg);
		}
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id) {
		maa02Service.delete(id);
        return Rets.success();
    }
	
	
}
