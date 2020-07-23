package cn.enilu.flash.api.controller.sales;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.entity.sales.Sla11;
import cn.enilu.flash.bean.vo.DictVo;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.sales.Sla11Vo;
import cn.enilu.flash.service.sales.Sla11Service;
import cn.enilu.flash.service.system.impl.ConstantFactory;
import cn.enilu.flash.utils.StringUtil;

@RestController
@RequestMapping("/visitorLog")
public class Sla11Controller extends BaseController{

	@Autowired
    private Sla11Service sla11Service;
	
	@RequestMapping(value = "/visitorList",method = RequestMethod.GET)
	public Object list(String visitorId) {
		if(StringUtil.isNullOrEmpty(visitorId)) {
			List<Sla11Vo> sla11VoList = new ArrayList<Sla11Vo>();
			List<DictVo> dictList = ConstantFactory.me().findByDictName("洽詢類別");
			List<Sla11> list = sla11Service.queryAll();
			for(Sla11 sla11 : list) {
				Sla11Vo sla11Vo = new Sla11Vo();
				sla11Vo.setSla11002(sla11.getSla11002());
				sla11Vo.setSla11003(sla11.getSla11003());
				sla11Vo.setSla11004(sla11.getSla11004());
				sla11Vo.setSla11005(sla11.getSla11005());
				sla11Vo.setSla11006(sla11.getSla11006());
				sla11Vo.setSla11007(sla11.getSla11007());
				sla11Vo.setSla11008(sla11.getSla11008());
				sla11Vo.setSla11009(sla11.getSla11009());
				
				for(DictVo vo : dictList) {
					if(vo.getKey().equals(sla11.getSla11003())) {
						sla11Vo.setSla11003Name(vo.getValue());
						break;
					}
				}
				
				sla11VoList.add(sla11Vo);
			}
			
			return Rets.success(sla11VoList);
		}else {
			//TODO: maybe have good way to define wrap value
			
			List<Sla11Vo> sla11VoList = new ArrayList<Sla11Vo>();
			List<DictVo> dictList = ConstantFactory.me().findByDictName("洽詢類別");
			List<Sla11> list = sla11Service.findByVisitId(visitorId);
			
			for(Sla11 sla11 : list) {
				Sla11Vo sla11Vo = new Sla11Vo();
				sla11Vo.setSla11002(sla11.getSla11002());
				sla11Vo.setSla11003(sla11.getSla11003());
				sla11Vo.setSla11004(sla11.getSla11004());
				sla11Vo.setSla11005(sla11.getSla11005());
				sla11Vo.setSla11006(sla11.getSla11006());
				sla11Vo.setSla11007(sla11.getSla11007());
				sla11Vo.setSla11008(sla11.getSla11008());
				sla11Vo.setSla11009(sla11.getSla11009());
				
				for(DictVo vo : dictList) {
					if(vo.getKey().equals(sla11.getSla11003())) {
						sla11Vo.setSla11003Name(vo.getValue());
						break;
					}
				}
				
				sla11VoList.add(sla11Vo);
			}
			
			return Rets.success(sla11VoList);
		}
	}
	
	
	
}
