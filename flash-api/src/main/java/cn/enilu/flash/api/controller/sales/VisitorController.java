package cn.enilu.flash.api.controller.sales;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.constant.factory.PageFactory;
import cn.enilu.flash.bean.entity.sales.Visitor;
import cn.enilu.flash.bean.vo.DictVo;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.sales.Sla10Vo;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.StringUtil;
import cn.enilu.flash.utils.factory.Page;
import cn.enilu.flash.warpper.UserWarpper;
import cn.enilu.flash.service.sales.VisitorService;
import cn.enilu.flash.service.system.impl.ConstantFactory;


@RestController
@RequestMapping("/visitor")
public class VisitorController  extends BaseController {
	@Autowired
    private VisitorService visitorService;
	//private Sla00Service sla00Service;
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
    //@RequiresPermissions(value = {Permission.VISITOR})
	public Object list(String name) {
		if(StringUtil.isNullOrEmpty(name)) {
//			List<Visitor> list = new ArrayList<Visitor>();
//			Sla00Service sla00Service = new Sla00Service();
//			List<Sla00> sla00List = sla00Service.queryAll();
//			List<Visitor> visitorList = visitorService.queryAll();
//			
//			for(Visitor visitor : visitorList) {
//				if(!visitor.getSla10002().equals(null)) {
//					for(Sla00 sla00 : sla00List) {
//						if(visitor.getSla10002().equals(sla00.getSla00002())){
//							visitor.setSla10003(sla00.getSla00003());
//						}
//					}
//				}
//				list.add(visitor);
//			}
			
			Page<Visitor> page = new PageFactory<Visitor>().defaultPage();
			
			List<Sla10Vo> list = new ArrayList<Sla10Vo>();
			
			List<Object[]> obj = visitorService.queryGridList();
			for(Object[] ary : obj) {
				Sla10Vo sla10Vo = new Sla10Vo(); 
				sla10Vo.setSla10001((Integer) ary[0]);
				sla10Vo.setSla10002((String) ary[1]);
				sla10Vo.setSla10002Name((String) ary[2]);
				sla10Vo.setSla10004((String) ary[3]);
				sla10Vo.setSla10005((String) ary[4]);
				sla10Vo.setSla10006((String) ary[5]);
				sla10Vo.setSla10010((String) ary[6]);
				sla10Vo.setSla10013((String) ary[7]);
				sla10Vo.setSla10014((String) ary[8]);
				sla10Vo.setSla10015((String) ary[9]);
				
				list.add(sla10Vo);
			}
			
			page = visitorService.queryPage(page);
			List listPage = (List) new UserWarpper(BeanUtil.objectsToMaps(page.getRecords())).warp();
			
			page.setRecords(listPage);
			
			return Rets.success(page);
		}else {
			return Rets.success(visitorService.findBySla10006(name));
		}
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
