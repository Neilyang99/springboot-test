package cn.enilu.flash.api.controller.ma;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.constant.factory.PageFactory;
import cn.enilu.flash.bean.entity.ma.Maa17;
import cn.enilu.flash.bean.vo.DictVo;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.service.ma.Maa16Service;
import cn.enilu.flash.service.ma.Maa17Service;
import cn.enilu.flash.service.system.impl.ConstantFactory;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.factory.Page;
import cn.enilu.flash.warpper.Maa17Wrapper;


@RestController
@RequestMapping("/maa17")
public class Maa17Controller extends BaseController{

	@Autowired
    private Maa17Service objService;
	
	@Autowired
    private Maa16Service obj16Service;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(Long maa16ID, String type) {
		Page<Maa17> page = new PageFactory<Maa17>().defaultPage();
		
		page.addFilter( "maa17002", SearchFilter.Operator.EQ, maa16ID);
		page.addFilter( "maa17003", SearchFilter.Operator.EQ, type);
		
		//TODO: 無法兩個filter?
		
		//page.addFilter(SearchFilter.build("maa17002", SearchFilter.Operator.EQ, maa16ID));
		//page.addFilter(SearchFilter.build("maa17003", SearchFilter.Operator.EQ, type));
		
		page.setSort(Sort.by(Sort.Direction.ASC,"maa17004"));
		
		page = objService.queryPage(page);
		List list = (List) new Maa17Wrapper(BeanUtil.objectsToMaps(page.getRecords())).warp();
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	/**
	 * 取得零用金項目來源
	 * @return
	 */
	@RequestMapping(value = "/getMaa17006",method = RequestMethod.GET)
	public Object getMaa17006() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("零用金項目來源");
		
//		for(DictVo vo : dictList) {
//			if(vo.getKey().equals("0")) {//上期餘額
//				dictList.remove(vo);
//			}
//		}
		
		return Rets.success(dictList);
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Maa17 obj) {
		if(obj.getId() == null) {
			objService.insert(obj);
		}else {
			objService.update(obj);
		}
		
		//更新收入與支出金額
		obj16Service.updateAmt(obj.getMaa17002());
		
		return Rets.success();
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id, Long maa16PK) {
		objService.delete(id);
		//更新收入與支出金額
		obj16Service.updateAmt(maa16PK);
		
        return Rets.success();
    }
	
	
}
