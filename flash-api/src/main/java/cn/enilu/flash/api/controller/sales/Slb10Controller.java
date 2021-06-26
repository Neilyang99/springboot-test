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
import cn.enilu.flash.bean.entity.sales.Sla00;
import cn.enilu.flash.bean.entity.sales.Sla01;
import cn.enilu.flash.bean.entity.sales.Slb10;
import cn.enilu.flash.bean.vo.DictVo;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.bean.vo.sales.SalesVo;
import cn.enilu.flash.service.sales.Sla00Service;
import cn.enilu.flash.service.sales.Sla01Service;
import cn.enilu.flash.service.sales.Slb10Service;
import cn.enilu.flash.service.system.impl.ConstantFactory;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.StringUtil;
import cn.enilu.flash.utils.factory.Page;


@RestController
@RequestMapping("/slb10")
public class Slb10Controller extends BaseController{

	@Autowired
    private Slb10Service slb10Service;
    
	@Autowired
    private Sla00Service sla00Service;
	
	@Autowired
    private Sla01Service sla01Service;
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(String name) {
		Page<Slb10> page = new PageFactory<Slb10>().defaultPage();
		if(StringUtil.isNullOrEmpty(name)) {
			
		}else {
			page.addFilter( "slb10004", SearchFilter.Operator.LIKE, name);
		}
		page = slb10Service.queryPage(page);
		
		//List list = (List) new UserWarpper(BeanUtil.objectsToMaps(page.getRecords())).warp();//增加欄位，如XXName=''
		List list = BeanUtil.objectsToMaps(page.getRecords());
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	/**
	 * 取得棟別
	 * @param 銷售案代號
	 * @return
	 */
	@RequestMapping(value = "/getHouse",method = RequestMethod.GET)
	public Object getHouse(String slb10004) {
		List<SalesVo> list = new ArrayList<SalesVo>();
		
		List<Sla01> sla01s = sla01Service.findNotSaleHouse(slb10004);
		
		for(Sla01 sla01 : sla01s) {
			SalesVo vo = new SalesVo(""+sla01.getId(),sla01.getSla01005()+"<>"+sla01.getSla01006());//(id, 棟別<>戶號)
			list.add(vo);
		}
		return Rets.success(list);
	}
	
	/**
	 * 取得銷售案
	 * @return
	 */
	@RequestMapping(value = "/getOnSaleCase",method = RequestMethod.GET)
	public Object getOnSaleCase() {
		List<SalesVo> list = new ArrayList<SalesVo>();
		
		List<Sla00> sla00s = sla00Service.findOnSaleCase();
		
		for(Sla00 sla00 : sla00s) {
			SalesVo vo = new SalesVo(sla00.getSla00002(),sla00.getSla00003());
			list.add(vo);
		}
		return Rets.success(list);
	}
	
	/**
	 * 取得天氣
	 * @return
	 */
	@RequestMapping(value = "/getWeather",method = RequestMethod.GET)
	public Object getWeather() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("天氣");
		
		return Rets.success(dictList);
	}
	/**
	 * 取得出勤
	 * @return
	 */
	@RequestMapping(value = "/getAttendance",method = RequestMethod.GET)
	public Object getAttendance() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("出勤");
		
		return Rets.success(dictList);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Slb10 slb10) {
		if(slb10.getId() == null) {
			
			slb10Service.insert(slb10);
		}else {
			
			slb10Service.update(slb10);
		}
		
		return Rets.success();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id) {
		slb10Service.delete(id);
        return Rets.success();
    }
	
}
