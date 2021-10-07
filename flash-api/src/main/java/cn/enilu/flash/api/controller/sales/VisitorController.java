package cn.enilu.flash.api.controller.sales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.constant.factory.PageFactory;
import cn.enilu.flash.bean.entity.sales.Visitor;
import cn.enilu.flash.bean.vo.DictVo;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.bean.vo.query.SearchFilter.Operator;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.factory.Page;
import cn.enilu.flash.warpper.Sla10Wrapper;
import cn.enilu.flash.service.sales.VisitorService;
import cn.enilu.flash.service.system.impl.ConstantFactory;


@RestController
@RequestMapping("/visitor")
public class VisitorController  extends BaseController {
	@Autowired
    private VisitorService visitorService;
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list( @RequestParam(required = false) String sla10003,
						@RequestParam(required = false) String sla10006,
						@RequestParam(required = false) String sla10010,
						@RequestParam(required = false) String sla10009) {
	
		Page<Visitor> page = new PageFactory<Visitor>().defaultPage();
		page.addFilter( "sla10003", SearchFilter.Operator.LIKE, sla10003);
		page.addFilter( "sla10006", SearchFilter.Operator.LIKE, sla10006);
		page.addFilter( "sla10010", SearchFilter.Operator.LIKE, sla10010);
		page.addFilter( "sla10009", SearchFilter.Operator.LIKE, sla10009);
				
		page = visitorService.queryPage(page);
		List list = (List) new Sla10Wrapper(BeanUtil.objectsToMaps(page.getRecords())).warp();
		
		page.setRecords(list);
		
		return Rets.success(page);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Visitor visitor) {
		if(visitor.getId() == null) {
			visitorService.insert(visitor);
		}else {
			
			visitorService.update(visitor);
		}
		
		return Rets.success();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id) {
		visitorService.delete(id);
        return Rets.success();
    }
	
	@RequestMapping(value = "/getCustomerById",method = RequestMethod.GET)
	public Object getCustomerById(Long id) {
		
		List<Visitor> list = visitorService.queryAll(new SearchFilter("id",Operator.EQ, id));
		
		return Rets.success(list.get(0));
	}
	
	/**
	 * 取得來人來電
	 * @return
	 */
	@RequestMapping(value = "/getSla10004",method = RequestMethod.GET)
	public Object getSla10004() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("來人來電");
		
		return Rets.success(dictList);
	}
	/**
	 * 取得區域
	 * @return
	 */
	@RequestMapping(value = "/getSla10016",method = RequestMethod.GET)
	public Object getSla10016() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("區域選項");
		
		return Rets.success(dictList);
	}
	/**
	 * 取得年齡
	 * @return
	 */
	@RequestMapping(value = "/getSla10017",method = RequestMethod.GET)
	public Object getSla10017() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("年齡選項");
		
		return Rets.success(dictList);
	}
	/**
	 * 取得職業
	 * @return
	 */
	@RequestMapping(value = "/getSla10018",method = RequestMethod.GET)
	public Object getSla10018() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("職業選項");
		
		return Rets.success(dictList);
	}
	/**
	 * 取得需求產品
	 * @return
	 */
	@RequestMapping(value = "/getSla10019",method = RequestMethod.GET)
	public Object getSla10019() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("屋型");
		
		return Rets.success(dictList);
	}
	/**
	 * 取得購買用途
	 * @return
	 */
	@RequestMapping(value = "/getSla10020",method = RequestMethod.GET)
	public Object getSla10020() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("購買用途選項");
		
		return Rets.success(dictList);
	}
	/**
	 * 取得現住狀況
	 * @return
	 */
	@RequestMapping(value = "/getSla10021",method = RequestMethod.GET)
	public Object getSla10021() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("現住狀況選項");
		
		return Rets.success(dictList);
	}
	/**
	 * 取得車位需求
	 * @return
	 */
	@RequestMapping(value = "/getSla10022",method = RequestMethod.GET)
	public Object getSla10022() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("車位需求選項");
		
		return Rets.success(dictList);
	}
	/**
	 * 取得媒體
	 * @return
	 */
	@RequestMapping(value = "/getSla10023",method = RequestMethod.GET)
	public Object getSla10023() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("媒體選項");
		
		return Rets.success(dictList);
	}
	/**
	 * 取得詢問重點
	 * @return
	 */
	@RequestMapping(value = "/getSla10024",method = RequestMethod.GET)
	public Object getSla10024() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("詢問重點選項");
		
		return Rets.success(dictList);
	}
	/**
	 * 取得需求房數
	 * @return
	 */
	@RequestMapping(value = "/getSla10025",method = RequestMethod.GET)
	public Object getSla10025() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("格局");
		
		return Rets.success(dictList);
	}
	/**
	 * 取得需求坪數
	 * @return
	 */
	@RequestMapping(value = "/getSla10026",method = RequestMethod.GET)
	public Object getSla10026() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("需求坪數選項");
		
		return Rets.success(dictList);
	}
	/**
	 * 取得需求價位
	 * @return
	 */
	@RequestMapping(value = "/getSla10027",method = RequestMethod.GET)
	public Object getSla10027() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("需求價位選項");
		
		return Rets.success(dictList);
	}
	/**
	 * 取得已購原因
	 * @return
	 */
	@RequestMapping(value = "/getSla10029",method = RequestMethod.GET)
	public Object getSla10029() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("已購原因選項");
		
		return Rets.success(dictList);
	}
	/**
	 * 取得未購原因
	 * @return
	 */
	@RequestMapping(value = "/getSla10030",method = RequestMethod.GET)
	public Object getSla10030() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("未購原因選項");
		
		return Rets.success(dictList);
	}
}
