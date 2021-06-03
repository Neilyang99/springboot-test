package cn.enilu.flash.api.controller.sales;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.constant.factory.PageFactory;
import cn.enilu.flash.bean.entity.sales.Sla30;
import cn.enilu.flash.bean.vo.DictVo;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.service.sales.Sla30Service;
import cn.enilu.flash.service.system.impl.ConstantFactory;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.StringUtil;
import cn.enilu.flash.utils.factory.Page;
import cn.enilu.flash.warpper.UserWarpper;


@RestController
@RequestMapping("/sla30")
public class Sla30Controller extends BaseController{

	@Autowired
    private Sla30Service sla30Service;
	
		
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(String name) {
		Page<Sla30> page = new PageFactory<Sla30>().defaultPage();
		if(StringUtil.isNullOrEmpty(name)) {
			
		}else {
			page.addFilter( "sla30004", SearchFilter.Operator.LIKE, name);
		}
		page = sla30Service.queryPage(page);
		List list = (List) new UserWarpper(BeanUtil.objectsToMaps(page.getRecords())).warp();
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Sla30 sla30) {
		if(sla30.getId() == null) {
			sla30Service.insert(sla30);
		}else {
			
			sla30Service.update(sla30);
		}
		
		return Rets.success();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id) {
		sla30Service.delete(id);
        return Rets.success();
    }
	
	/**
	 * 取得行政區
	 * @return
	 */
	@RequestMapping(value = "/getSla30005",method = RequestMethod.GET)
	public Object getSla30005() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("行政區選項");
		
		return Rets.success(dictList);
	}
	
	/**
	 * 取得個案進度
	 * @return
	 */
	@RequestMapping(value = "/getSla30084",method = RequestMethod.GET)
	public Object getSla30084() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("個案進度");
		
		return Rets.success(dictList);
	}
	
	
}
