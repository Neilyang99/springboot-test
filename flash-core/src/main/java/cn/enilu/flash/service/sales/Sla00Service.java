package cn.enilu.flash.service.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.sales.Sla00;
import cn.enilu.flash.dao.sales.Sla00Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Sla00Service extends BaseService<Sla00,Long,Sla00Repository>{
	
	@Autowired
	private Sla00Repository sla00Repository;
	
	public Sla00 findByBuildingCode(String code) {
		return sla00Repository.findBySla00002(code);
	}
}
