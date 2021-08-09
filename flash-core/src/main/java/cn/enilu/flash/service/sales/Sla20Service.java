package cn.enilu.flash.service.sales;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.sales.Sla11;
import cn.enilu.flash.bean.entity.sales.Sla20;
import cn.enilu.flash.bean.entity.sales.Visitor;
import cn.enilu.flash.dao.sales.Sla20Repository;
import cn.enilu.flash.service.BaseService;
import cn.enilu.flash.utils.DateUtil;

@Service
public class Sla20Service extends BaseService<Sla20,Long,Sla20Repository>{
	
	@Autowired
	private Sla20Repository Sla20Repository;
	
	@Autowired
	private VisitorService sla10Service;
	
	public boolean insertOrder(Sla11 sla11) {
		
		Visitor sla10 = this.sla10Service.findByUID(sla11.getSla11002());
		
		Sla20 sla20 = new Sla20();
		sla20.setSla20002(0L);
		sla20.setSla20003("");
		sla20.setSla20004(DateUtil.getDays());
		sla20.setSla20005("A0");//A0=編輯, 尚未確定的訂單
		sla20.setSla20006(sla11.getSla11002());
		sla20.setSla20007(sla10.getSla10005());
		sla20.setSla20008(sla10.getSla10006());
		sla20.setSla20013(sla10.getSla10007());
		sla20.setSla20014(sla10.getSla10008());
		sla20.setSla20015(sla10.getSla10009());
		sla20.setSla20016(sla10.getSla10010());
		sla20.setSla20017(sla10.getSla10011());
		sla20.setSla20018(sla10.getSla10012());
		sla20.setSla20039(sla10.getSla10002());
		
		return true;
	}
	
	public Sla20 findOrderByProjectAndCustomer(int projectUID, int customerUID) {
		
		Sla20 sla20 = this.Sla20Repository.findBySla20002AndSla20006(projectUID, customerUID);
		
		return sla20;
	}
	
}
