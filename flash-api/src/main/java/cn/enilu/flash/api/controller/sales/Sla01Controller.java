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
import cn.enilu.flash.bean.entity.sales.Sla01;
import cn.enilu.flash.bean.vo.DictVo;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.sales.SalesVo;
import cn.enilu.flash.bean.vo.sales.Sla01Vo;
import cn.enilu.flash.service.sales.Sla01Service;
import cn.enilu.flash.service.system.impl.ConstantFactory;


@RestController
@RequestMapping("/sla01")
public class Sla01Controller extends BaseController{

	@Autowired
    private Sla01Service sla01Service;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(Long sla01002) {
		
		List<Sla01Vo> volist = new ArrayList<Sla01Vo>();
		
		List<Sla01> list = sla01Service.findBySla01002(sla01002);
		for(Sla01 sla01 : list) {
			Sla01Vo sla01Vo = new Sla01Vo();
			sla01Vo.setId(sla01.getId());
			sla01Vo.setSla01002(sla01.getSla01002());
			sla01Vo.setSla01003(sla01.getSla01003());
			sla01Vo.setSla01004(sla01.getSla01004());
			sla01Vo.setSla01005(sla01.getSla01005());
			sla01Vo.setSla01006(sla01.getSla01006());
			sla01Vo.setSla01007(sla01.getSla01007());
			sla01Vo.setSla01008(sla01.getSla01008());
			sla01Vo.setSla01009(sla01.getSla01009());
			sla01Vo.setSla01010(sla01.getSla01010());
			sla01Vo.setSla01011(sla01.getSla01011());
			sla01Vo.setSla01012(sla01.getSla01012());
			sla01Vo.setSla01013(sla01.getSla01013());
			sla01Vo.setSla01014(sla01.getSla01014());
			sla01Vo.setSla01015(sla01.getSla01015());
			sla01Vo.setSla01027(sla01.getSla01027());
			sla01Vo.setSla01033(sla01.getSla01033());
			
			sla01Vo.setSla01007Name(ConstantFactory.me().getDictsByName("屋型", sla01.getSla01007()));
			sla01Vo.setSla01008Name(ConstantFactory.me().getDictsByName("格局", sla01.getSla01008()));
			sla01Vo.setSla01027Name(ConstantFactory.me().getDictsByName("房屋銷售狀態", sla01.getSla01027()));
			
			volist.add(sla01Vo);
			
		}
		
		return Rets.success(volist);
	}
	
	/**
	 * 取得屋型
	 * @return
	 */
	@RequestMapping(value = "/getSla01007",method = RequestMethod.GET)
	public Object getSla01007() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("屋型");
		
		return Rets.success(dictList);
	}
	/**
	 * 取得格局
	 * @return
	 */
	@RequestMapping(value = "/getSla01008",method = RequestMethod.GET)
	public Object getSla01008() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("格局");
		
		return Rets.success(dictList);
	}
	/**
	 * 取得車位類別
	 * @return
	 */
	@RequestMapping(value = "/getSla01015",method = RequestMethod.GET)
	public Object getSla01015() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("車位類別");
		
		return Rets.success(dictList);
	}
	
	/**
	 * 取得尚未銷售過的房屋
	 * @param 銷售案代號
	 * @return(id, 棟別<>戶號)
	 */
	@RequestMapping(value = "/getNotSaleHouse",method = RequestMethod.GET)
	public Object getNotSaleHouse(String projectNo) {
		
		List<SalesVo> list = sla01Service.findNotSaleHouseByProjectNo(projectNo);
		
		return Rets.success(list);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Sla01 sla01) {
		if(sla01.getId() == null) {
			sla01Service.insert(sla01);
		}else {
			
			sla01Service.update(sla01);
		}
		
		return Rets.success();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id) {
		sla01Service.delete(id);
        return Rets.success();
    }
	
}
