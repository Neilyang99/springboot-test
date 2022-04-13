package cn.enilu.flash.service.sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.sales.Sla11;
import cn.enilu.flash.dao.sales.Sla11Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Sla11Service  extends BaseService<Sla11,Long,Sla11Repository>{

	@Autowired
	private Sla11Repository sla11Repository;
	
	public List<Sla11> findByVisitId(Long visitorId) {
		return sla11Repository.findBySla11002(visitorId);
	}
	public Sla11 findByVisitDate(String dt) {
		return sla11Repository.findBySla11004(dt);
	}
	public List<Sla11> getOrderIdBySla11002(Long visitorId) {
		return sla11Repository.getOrderIdBySla11002(visitorId);
	}
	
	public int updateOrderIdByLogId(Long visitorLogId, Long orderId) {
		return sla11Repository.updateOrderIdByLogId(visitorLogId, orderId);
	}
	
	public List<Object[]> findNoHandleList(String salesNo){
		return sla11Repository.findNoHandleList(salesNo);
	}
	
}
