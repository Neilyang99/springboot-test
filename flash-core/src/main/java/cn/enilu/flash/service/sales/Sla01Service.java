package cn.enilu.flash.service.sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.sales.Sla01;
import cn.enilu.flash.dao.sales.Sla01Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Sla01Service extends BaseService<Sla01,Long,Sla01Repository>{
	
	@Autowired
	private Sla01Repository sla01Repository;
	
	public List<Sla01> findBySla01002(Integer sla01002){
		return sla01Repository.findBySla01002(sla01002);
	}
	
	public List<Sla01> findBySla01003(String sla01003){
		return sla01Repository.findBySla01003(sla01003);
	}
	
	public List<Sla01> findNotSaleHouse(String sla01003){
		return sla01Repository.findNotSaleHouse(sla01003);
	}
	
	public void updateStatusBySla01ID(Long id, String status) {
		sla01Repository.updateStatusBySla01ID(id, status);
	}
	
}
