package cn.enilu.flash.api.controller.sales;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.entity.sales.Sla11;
import cn.enilu.flash.bean.vo.DictVo;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.sales.Sla11Vo;
import cn.enilu.flash.service.sales.Sla11Service;
import cn.enilu.flash.service.sales.Sla20Service;
import cn.enilu.flash.service.system.impl.ConstantFactory;
import cn.enilu.flash.utils.StringUtil;

@RestController
@RequestMapping("/visitorLog")
public class Sla11Controller extends BaseController{

	@Autowired
    private Sla11Service sla11Service;
	
	@Autowired
	private Sla20Service sla20Service;
	
	@RequestMapping(value = "/visitorList",method = RequestMethod.GET)
	public Object list(Long visitorId) {
		if(StringUtil.isNullOrEmpty(visitorId)) {
			List<Sla11Vo> sla11VoList = new ArrayList<Sla11Vo>();
			List<Sla11> list = sla11Service.queryAll();
			for(Sla11 sla11 : list) {
				Sla11Vo sla11Vo = new Sla11Vo();
				sla11Vo.setId(sla11.getId());
				sla11Vo.setSla11002(sla11.getSla11002());
				sla11Vo.setSla11003(sla11.getSla11003());
				sla11Vo.setSla11004(sla11.getSla11004());
				sla11Vo.setSla11005(sla11.getSla11005());
				sla11Vo.setSla11006(sla11.getSla11006());
				sla11Vo.setSla11007(sla11.getSla11007());
				sla11Vo.setSla11008(sla11.getSla11008());
				sla11Vo.setSla11009(sla11.getSla11009());
				sla11Vo.setSla11003Name(ConstantFactory.me().getDictsByName("洽詢類別",sla11.getSla11003()));
				
				sla11VoList.add(sla11Vo);
			}
			
			return Rets.success(sla11VoList);
		}else {
			//TODO: maybe have good way to define wrap value
			
			List<Sla11Vo> sla11VoList = new ArrayList<Sla11Vo>();
			List<Sla11> list = sla11Service.findByVisitId(visitorId);
			
			for(Sla11 sla11 : list) {
				Sla11Vo sla11Vo = new Sla11Vo();
				sla11Vo.setId(sla11.getId());
				sla11Vo.setSla11002(sla11.getSla11002());
				sla11Vo.setSla11003(sla11.getSla11003());
				sla11Vo.setSla11004(sla11.getSla11004());
				sla11Vo.setSla11005(sla11.getSla11005());
				sla11Vo.setSla11006(sla11.getSla11006());
				sla11Vo.setSla11007(sla11.getSla11007());
				sla11Vo.setSla11008(sla11.getSla11008());
				sla11Vo.setSla11009(sla11.getSla11009());
				sla11Vo.setSla11003Name(ConstantFactory.me().getDictsByName("洽詢類別",sla11.getSla11003()));
				
				
				sla11VoList.add(sla11Vo);
			}
			
			return Rets.success(sla11VoList);
		}
	}
	
	/**
	 * 取得洽詢類別清單
	 * @return
	 */
	@RequestMapping(value = "/getSla11003",method = RequestMethod.GET)
	public Object getSla11003() {
		List<DictVo> dictList = ConstantFactory.me().findByDictName("洽詢類別");
		
		return Rets.success(dictList);
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Sla11 sla11) {
		if(sla11.getId() == null) {
			sla11Service.insert(sla11);
			//G=小訂 H=大訂
			if(sla11.getSla11003().equals("G") || sla11.getSla11003().equals("H")) {
				sla20Service.insertOrder(sla11);
			}
			
		}else {
			
			sla11Service.update(sla11);
		}
		
		return Rets.success();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id) {
		sla11Service.delete(id);
        return Rets.success();
    }
	
	
}
