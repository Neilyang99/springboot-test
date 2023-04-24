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
import cn.enilu.flash.bean.entity.ma.Maa21;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.service.ma.Maa21Service;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.StringUtil;
import cn.enilu.flash.utils.factory.Page;


@RestController
@RequestMapping("/maa21")
public class Maa21Controller extends BaseController{

	@Autowired
    private Maa21Service maa21Service;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(@RequestParam(required = false) String selMaa21002) {
		Page<Maa21> page = new PageFactory<Maa21>().defaultPage();
		if(StringUtil.isNullOrEmpty(selMaa21002)) {
			
		}else {
			page.addFilter( "maa21002", SearchFilter.Operator.LIKE, selMaa21002);
		}
		page.setSort(Sort.by(Sort.Direction.DESC,"maa21006"));
		page = maa21Service.queryPage(page);
		
		List list = BeanUtil.objectsToMaps(page.getRecords());
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Maa21 maObj) {
		if(maObj.getId() == null) {
			maa21Service.insert(maObj);
		}else {
			maa21Service.update(maObj);
		}
		
		return Rets.success();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id) {
		maa21Service.delete(id);//TODO: 不可以實體刪除
        return Rets.success();
    }
	
	
}
