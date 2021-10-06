package cn.enilu.flash.api.controller.sales;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.constant.factory.PageFactory;
import cn.enilu.flash.bean.entity.sales.Sla24;
import cn.enilu.flash.bean.vo.DictVo;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.service.sales.Sla24Service;
import cn.enilu.flash.service.system.impl.ConstantFactory;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.factory.Page;
import cn.enilu.flash.warpper.Sla24Wrapper;


@RestController
@RequestMapping("/sla24")
public class Sla24Controller extends BaseController{

	@Autowired
    private Sla24Service sla24Service;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(Integer sla24002) {
		
		Page page = new PageFactory().defaultPage();
        page.addFilter( "sla24002", SearchFilter.Operator.EQ, sla24002);
        page.setSort(new Sort(Direction.DESC,"sla24005"));
        page = sla24Service.queryPage(page);
        List list = (List) new Sla24Wrapper(BeanUtil.objectsToMaps(page.getRecords())).warp();
        page.setRecords(list);
        
        return Rets.success(page);
	}
	
	/**
	 * 取得驗收類別
	 * @return
	 */
	@RequestMapping(value = "/getSla24004",method = RequestMethod.GET)
	public Object getSla24004() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("驗收類別");
		
		return Rets.success(dictList);
	}
	/**
	 * 取得項目分類
	 * @return
	 */
	@RequestMapping(value = "/getSla24006",method = RequestMethod.GET)
	public Object getSla24006() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("項目分類");
		
		return Rets.success(dictList);
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Sla24 sla24) {
		if(sla24.getId() == null) {
			sla24Service.insert(sla24);
		}else {
			
			sla24Service.update(sla24);
		}
		
		return Rets.success();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id) {
		sla24Service.delete(id);
        return Rets.success();
    }
	
	@Transactional
	@RequestMapping(value = "/updateFinishDate",method = RequestMethod.POST)
	public Object updateFinishDate(@ModelAttribute @Valid Sla24 sla24) {
		if(sla24.getId() != null && sla24.getSla24008() != null) {
			sla24Service.updateFinishDate(sla24.getId(), sla24.getSla24008());
		}
		return Rets.success();
	}
	
}
