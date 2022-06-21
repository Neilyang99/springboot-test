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
import cn.enilu.flash.bean.entity.ma.Maa10;
import cn.enilu.flash.bean.entity.ma.Maa94;
import cn.enilu.flash.bean.vo.DictVo;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.ma.MaaStockVo;
import cn.enilu.flash.bean.vo.ma.MaaVo;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.service.ma.Maa10Service;
import cn.enilu.flash.service.ma.Maa94Service;
import cn.enilu.flash.service.system.impl.ConstantFactory;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.StringUtil;
import cn.enilu.flash.utils.factory.Page;
import cn.enilu.flash.warpper.Maa10Wrapper;


@RestController
@RequestMapping("/maa10")
public class Maa10Controller extends BaseController{

	@Autowired
    private Maa10Service objService;
	
	@Autowired
    private Maa94Service maa94Service;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(@RequestParam(required = false) Long maa00ID) {
		Page<Maa10> page = new PageFactory<Maa10>().defaultPage();
		
		page.addFilter( "maa10002", SearchFilter.Operator.EQ, maa00ID);
		
		page.setSort(Sort.by(Sort.Direction.ASC,"maa10005"));
		page = objService.queryPage(page);
		
		//取得項目
		List<MaaVo> itemList = maa94Service.getMaterialItem();
		
		List list = (List) new Maa10Wrapper(itemList, BeanUtil.objectsToMaps(page.getRecords())).warp();
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	@RequestMapping(value = "/getStock",method = RequestMethod.GET)
	public Object getStock(@RequestParam(required = false) Long maa00ID) {
		Page<MaaStockVo> page = new PageFactory<MaaStockVo>().defaultPage();
		
		List<MaaStockVo> list = objService.getStock(maa00ID);
		page.setRecords(list);
        
		return Rets.success(page);
	}
	

	/**
	 * 取得材料項目
	 * @return
	 */
	@RequestMapping(value = "/getMaterialItem",method = RequestMethod.GET)
	public Object getMaterialItem() {
		
		List<MaaVo> list = maa94Service.getMaterialItem();
		
		return Rets.success(list);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Maa10 maObj) {
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
