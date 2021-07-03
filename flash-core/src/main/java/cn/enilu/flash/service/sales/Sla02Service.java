package cn.enilu.flash.service.sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.sales.Sla02;
import cn.enilu.flash.dao.sales.Sla02Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Sla02Service extends BaseService<Sla02,Long,Sla02Repository>{
	
	@Autowired
	private Sla02Repository sla01Repository;
	
	
	public List<Sla02> findBySla02003(String sla01003){
		return sla01Repository.findBySla02003(sla01003);
	}
	
	
	
}
