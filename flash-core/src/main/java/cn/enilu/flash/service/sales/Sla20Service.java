package cn.enilu.flash.service.sales;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.sales.Sla01;
import cn.enilu.flash.bean.entity.sales.Sla11;
import cn.enilu.flash.bean.entity.sales.Sla20;
import cn.enilu.flash.bean.entity.sales.Visitor;
import cn.enilu.flash.dao.sales.Sla20Repository;
import cn.enilu.flash.service.BaseService;
import cn.enilu.flash.utils.DateUtil;

@Service
public class Sla20Service extends BaseService<Sla20,Long,Sla20Repository>{
	
	@Autowired
	private Sla20Repository sla20Repository;
	
	@Autowired
	private VisitorService sla10Service;
	
	@Autowired
	private Sla01Service sla01Service;
	
	public boolean insertOrder(Sla11 sla11) {
		
		Visitor sla10 = this.sla10Service.findByUID(sla11.getSla11002());
		Sla01 sla01 = sla01Service.findById(sla11.getSla11023());
		
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
		sla20.setSla20038(sla01.getId());
		sla20.setSla20039(sla10.getSla10002());
		sla20.setSla20040(sla01.getSla01004());
		sla20.setSla20041(sla01.getSla01005());
		sla20.setSla20042(sla01.getSla01006());
		sla20.setSla20043(sla01.getSla01007());
		sla20.setSla20044(sla01.getSla01008());
		sla20.setSla20045(sla01.getSla01009());
		sla20.setSla20046(sla01.getSla01010());
		sla20.setSla20047(sla01.getSla01011());
		sla20.setSla20048(sla01.getSla01012());
		sla20.setSla20049(sla01.getSla01013());
		sla20.setSla20050(sla01.getSla01014());
		sla20.setSla20059(sla01.getSla01018());
		sla20.setSla20060(sla01.getSla01019());
		sla20.setSla20061(sla01.getSla01020());
		sla20.setSla20062(sla01.getSla01021());
		sla20.setSla20063(sla01.getSla01022());
		sla20.setSla20064(sla01.getSla01023());
		sla20.setSla20065(sla01.getSla01024());
		sla20.setSla20066(sla01.getSla01025());
		sla20.setSla20067(sla01.getSla01026());
		
		if(this.findOrderByProjectAndCustomer(sla01.getSla01002(), sla11.getSla11002()) == null) {
			this.sla20Repository.save(sla20);
		}
		
			
				
		return true;
	}
	
	public Sla20 findOrderByProjectAndCustomer(Long projectUID, Long customerUID) {
		
		Sla20 sla20 = this.sla20Repository.findBySla20002AndSla20006(projectUID, customerUID);
		
		return sla20;
	}
	
}
