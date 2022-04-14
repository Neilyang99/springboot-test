package cn.enilu.flash.api.controller.ma;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.constant.factory.PageFactory;
import cn.enilu.flash.bean.entity.ma.Maa94;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.service.ma.Maa94Service;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.StringUtil;
import cn.enilu.flash.utils.factory.Page;


@RestController
@RequestMapping("/maa94")
public class Maa94Controller extends BaseController{

	@Autowired
    private Maa94Service maaService;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(String name) {
		Page<Maa94> page = new PageFactory<Maa94>().defaultPage();
		page.addFilter( "maa94006", SearchFilter.Operator.EQ, 0);//父階
		if(StringUtil.isNullOrEmpty(name)) {
			
		}else {
			page.addFilter( "maa94003", SearchFilter.Operator.LIKE, name);
		}
		page.setSort(Sort.by(Sort.Direction.ASC,"maa94002"));
		page = maaService.queryPage(page);
		List list = BeanUtil.objectsToMaps(page.getRecords());
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	@RequestMapping(value = "/itemList",method = RequestMethod.GET)
	public Object itemList(@RequestParam(required = false) String name,@RequestParam(required = false) Long typeId) {
		Page<Maa94> page = new PageFactory<Maa94>().defaultPage();
		page.addFilter( "maa94006", SearchFilter.Operator.EQ, typeId);
		if(StringUtil.isNullOrEmpty(name)) {
			
		}else {
			page.addFilter( "maa94003", SearchFilter.Operator.LIKE, name);
		}
		page.setSort(Sort.by(Sort.Direction.ASC,"maa94005"));
		page = maaService.queryPage(page);
		List list = BeanUtil.objectsToMaps(page.getRecords());
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Maa94 maaObj) {
		if(maaObj.getId() == null) {
			maaService.insert(maaObj);
		}else {
			maaService.update(maaObj);
		}
		
		return Rets.success();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id) {
		maaService.delete(id);
        return Rets.success();
    }
	
	
}
