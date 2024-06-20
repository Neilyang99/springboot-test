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
import cn.enilu.flash.bean.entity.ma.Maa90;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.service.ma.Maa90Service;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.StringUtil;
import cn.enilu.flash.utils.factory.Page;


@RestController
@RequestMapping("/maa90")
public class Maa90Controller extends BaseController{

	@Autowired
    private Maa90Service maa90Service;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(@RequestParam(required = false) String selMaa90003) {
		Page<Maa90> page = new PageFactory<Maa90>().defaultPage();
		if(StringUtil.isNullOrEmpty(selMaa90003)) {
			
		}else {
			page.addFilter( "maa90003", SearchFilter.Operator.LIKE, selMaa90003);
		}
		page.setSort(Sort.by(Sort.Direction.ASC,"maa90004"));
		page = maa90Service.queryPage(page);
		
		List list = BeanUtil.objectsToMaps(page.getRecords());
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	@RequestMapping(value = "/selectList",method = RequestMethod.GET)
	public Object selectList() {
		//
		return Rets.success(maa90Service.getDataForSelection());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Maa90 maObj) {
		if(maObj.getId() == null) {
			maa90Service.insert(maObj);
		}else {
			maa90Service.update(maObj);
		}
		
		return Rets.success();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id) {
		maa90Service.delete(id);//TODO: 不可以實體刪除
        return Rets.success();
    }
	
	
}
