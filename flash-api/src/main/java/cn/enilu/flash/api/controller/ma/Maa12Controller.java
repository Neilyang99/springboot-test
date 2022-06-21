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
import cn.enilu.flash.bean.entity.ma.Maa12;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.service.ma.Maa12Service;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.StringUtil;
import cn.enilu.flash.utils.factory.Page;


@RestController
@RequestMapping("/maa12")
public class Maa12Controller extends BaseController{

	@Autowired
    private Maa12Service objService;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(@RequestParam(required = false) Long maa00ID,
						@RequestParam(required = false) String reportType) {
		Page<Maa12> page = new PageFactory<Maa12>().defaultPage();
		
		page.addFilter( "maa12002", SearchFilter.Operator.EQ, maa00ID);
		page.addFilter( "maa12003", SearchFilter.Operator.EQ, reportType);
		page.setSort(Sort.by(Sort.Direction.ASC,"maa12005"));
		page = objService.queryPage(page);
		
		List list = BeanUtil.objectsToMaps(page.getRecords());
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Maa12 maObj) {
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
