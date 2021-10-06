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
import cn.enilu.flash.bean.entity.sales.Sla23;
import cn.enilu.flash.bean.vo.DictVo;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.service.sales.Sla23Service;
import cn.enilu.flash.service.system.impl.ConstantFactory;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.factory.Page;
import cn.enilu.flash.warpper.Sla23Wrapper;


@RestController
@RequestMapping("/sla23")
public class Sla23Controller extends BaseController{

	@Autowired
    private Sla23Service sla23Service;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(Integer sla23002) {
		
		Page page = new PageFactory().defaultPage();
        page.addFilter( "sla23002", SearchFilter.Operator.EQ, sla23002);
        page = sla23Service.queryPage(page);
        List list = (List) new Sla23Wrapper(BeanUtil.objectsToMaps(page.getRecords())).warp();
        page.setRecords(list);
        
        return Rets.success(page);
	}
	
	/**
	 * 取得收款方式
	 * @return
	 */
	@RequestMapping(value = "/getSla23006",method = RequestMethod.GET)
	public Object getSla23006() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("收款方式");
		
		return Rets.success(dictList);
	}
	/**
	 * 取得收款類別
	 * @return
	 */
	@RequestMapping(value = "/getSla23031",method = RequestMethod.GET)
	public Object getSla23031() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("收款類別");
		
		return Rets.success(dictList);
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Sla23 sla23) {
		if(sla23.getId() == null) {
			sla23Service.insert(sla23);
		}else {
			
			sla23Service.update(sla23);
		}
		
		return Rets.success();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id) {
		sla23Service.delete(id);
        return Rets.success();
    }
	
}
