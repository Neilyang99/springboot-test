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
import cn.enilu.flash.bean.entity.ma.Maa22;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.service.ma.Maa22Service;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.StringUtil;
import cn.enilu.flash.utils.factory.Page;


@RestController
@RequestMapping("/maa22")
public class Maa22Controller extends BaseController{

	@Autowired
    private Maa22Service maa22Service;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(@RequestParam(required = false) String selMaa22005) {
		Page<Maa22> page = new PageFactory<Maa22>().defaultPage();
		if(StringUtil.isNullOrEmpty(selMaa22005)) {
			
		}else {
			page.addFilter( "maa22005", SearchFilter.Operator.LIKE, selMaa22005);
		}
		page.setSort(Sort.by(Sort.Direction.ASC,"maa22003"));
		page = maa22Service.queryPage(page);
		
		List list = BeanUtil.objectsToMaps(page.getRecords());
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Maa22 maObj) {
		if(maObj.getId() == null) {
			maa22Service.insert(maObj);
		}else {
			maa22Service.update(maObj);
		}
		
		return Rets.success();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id) {
		maa22Service.delete(id);
        return Rets.success();
    }
	
	
}
