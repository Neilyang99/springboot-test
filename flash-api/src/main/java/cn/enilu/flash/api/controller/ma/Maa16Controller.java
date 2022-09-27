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
import cn.enilu.flash.bean.entity.ma.Maa16;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.service.ma.Maa16Service;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.factory.Page;


@RestController
@RequestMapping("/maa16")
public class Maa16Controller extends BaseController{

	@Autowired
    private Maa16Service objService;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(Long maa00ID) {
		Page<Maa16> page = new PageFactory<Maa16>().defaultPage();
		
		page.addFilter( "maa16002", SearchFilter.Operator.EQ, maa00ID);
		page.setSort(Sort.by(Sort.Direction.DESC,"maa16003"));
		
		page = objService.queryPage(page);
		List list = BeanUtil.objectsToMaps(page.getRecords());
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	/**
	 * 取得期別最大值
	 * @param 工程案ID
	 * @return
	 */
	@RequestMapping(value = "/getMaxPeriod",method = RequestMethod.GET)
	public Object getMaxPeriod(Long maa00ID) {
		
		int count = objService.getMaxPeriod(maa00ID);
		
		return Rets.success(count);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Maa16 obj) {
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
