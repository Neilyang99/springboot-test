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
import cn.enilu.flash.bean.entity.sales.Sla02;
import cn.enilu.flash.bean.vo.DictVo;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.service.sales.Sla02Service;
import cn.enilu.flash.service.system.impl.ConstantFactory;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.factory.Page;
import cn.enilu.flash.warpper.Sla02Wrapper;


@RestController
@RequestMapping("/sla02")
public class Sla02Controller extends BaseController{

	@Autowired
    private Sla02Service sla02Service;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(Integer sla02002) {
		
		Page page = new PageFactory().defaultPage();
        page.addFilter( "sla02002", SearchFilter.Operator.EQ, sla02002);
        
		page = sla02Service.queryPage(page);
        List list = (List) new Sla02Wrapper(BeanUtil.objectsToMaps(page.getRecords())).warp();
        page.setRecords(list);
        
        return Rets.success(page);
	}
	
	
	/**
	 * 取得車位類別
	 * @return
	 */
	@RequestMapping(value = "/getSla02005",method = RequestMethod.GET)
	public Object getSla02005() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("汽機車類別");
		
		return Rets.success(dictList);
	}
	
	/**
	 * 取得車位類型
	 * @return
	 */
	@RequestMapping(value = "/getSla02006",method = RequestMethod.GET)
	public Object getSla02006() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("車位類型");
		
		return Rets.success(dictList);
	}
	
	/**
	 * 車位購買類型
	 * @return
	 */
	@RequestMapping(value = "/getSla02008",method = RequestMethod.GET)
	public Object getSla02008() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("車位購買類別");
		
		return Rets.success(dictList);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Sla02 sla02) {
		if(sla02.getId() == null) {
			sla02Service.insert(sla02);
		}else {
			
			sla02Service.update(sla02);
		}
		
		return Rets.success();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id) {
		sla02Service.delete(id);
        return Rets.success();
    }
	
}
