package cn.enilu.flash.api.controller.ma;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.constant.factory.PageFactory;
import cn.enilu.flash.bean.entity.ma.Maa17;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.service.ma.Maa17Service;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.factory.Page;


@RestController
@RequestMapping("/maa17")
public class Maa17Controller extends BaseController{

	@Autowired
    private Maa17Service objService;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(Long maa16ID) {
		Page<Maa17> page = new PageFactory<Maa17>().defaultPage();
		
		page.addFilter( "maa17002", SearchFilter.Operator.EQ, maa16ID);
		page.setSort(Sort.by(Sort.Direction.ASC,"maa17003"));
		page.setSort(Sort.by(Sort.Direction.ASC,"maa17004"));
		
		page = objService.queryPage(page);
		List list = BeanUtil.objectsToMaps(page.getRecords());
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Maa17 obj) {
		if(obj.getId() == null) {
			objService.insert(obj);
		}else {
			objService.update(obj);
		}
		
		return Rets.success();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id) {
		objService.delete(id);
        return Rets.success();
    }
	
	
}
