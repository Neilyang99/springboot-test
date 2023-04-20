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
import cn.enilu.flash.bean.entity.ma.Maa01a;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.service.ma.Maa01aService;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.StringUtil;
import cn.enilu.flash.utils.factory.Page;


@RestController
@RequestMapping("/maa01a")
public class Maa01aController extends BaseController{

	@Autowired
    private Maa01aService maa01aService;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(String name) {
		Page<Maa01a> page = new PageFactory<Maa01a>().defaultPage();
		if(StringUtil.isNullOrEmpty(name)) {
			
		}else {
			page.addFilter( "maa01a009", SearchFilter.Operator.LIKE, name);
		}
		page = maa01aService.queryPage(page);
		List list = BeanUtil.objectsToMaps(page.getRecords());
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	@RequestMapping(value = "/listByProject",method = RequestMethod.GET)
	public Object listByProject(Long projectId) {
		List<Maa01a> list = maa01aService.findByMaa01a002(projectId);
		
		return Rets.success(list);
	}
	
	@RequestMapping(value = "/listByPrjLv2",method = RequestMethod.GET)
	public Object listByPrjLv2(Long projectId, Long lv2) {
		Page<Maa01a> page = new PageFactory<Maa01a>().defaultPage();
		page.addFilter( "maa01a002", SearchFilter.Operator.EQ, projectId);
		page.addFilter( "maa01a004", SearchFilter.Operator.EQ, lv2);
		page.setSort(Sort.by(Sort.Direction.ASC,"maa01a006"));
		page = maa01aService.queryPage(page);
		
		List list = BeanUtil.objectsToMaps(page.getRecords());
        page.setRecords(list);
        
		return Rets.success(list);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Maa01a maa01a) {
		if(maa01a.getId() == null) {
			maa01aService.insert(maa01a);
		}else {
			maa01aService.update(maa01a);
		}
		
		return Rets.success();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id) {
		maa01aService.delete(id);
        return Rets.success();
    }
	
	
}
