package cn.enilu.flash.service.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.sales.Sla30;
import cn.enilu.flash.dao.sales.Sla30Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Sla30Service extends BaseService<Sla30,Long,Sla30Repository>{
	
	@Autowired
	private Sla30Repository sla30Repository;
	
}
