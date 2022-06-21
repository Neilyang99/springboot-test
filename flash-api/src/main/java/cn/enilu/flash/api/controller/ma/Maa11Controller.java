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
import cn.enilu.flash.bean.entity.ma.Maa11;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.service.ma.Maa11Service;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.StringUtil;
import cn.enilu.flash.utils.factory.Page;


@RestController
@RequestMapping("/maa11")
public class Maa11Controller extends BaseController{

	@Autowired
    private Maa11Service objService;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(@RequestParam(required = false) Long maa00ID,
						@RequestParam(required = false) String selMaa11003) {
		Page<Maa11> page = new PageFactory<Maa11>().defaultPage();
		page.addFilter( "maa11002", SearchFilter.Operator.EQ, maa00ID);
		page.addFilter( "maa11003", SearchFilter.Operator.EQ, selMaa11003);
		
		page.setSort(Sort.by(Sort.Direction.ASC,"maa11005"));
		page = objService.queryPage(page);
		
		List list = BeanUtil.objectsToMaps(page.getRecords());
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Maa11 maObj) {
		if(maObj.getId() == null) {
			objService.insert(maObj);
		}else {
			objService.update(maObj);
		}
		
		return Rets.success();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id) {
		objService.delete(id);
        return Rets.success();
    }
	
	
}
