package cn.enilu.flash.service.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.sales.Sla01;
import cn.enilu.flash.dao.sales.Sla01Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Sla01Service extends BaseService<Sla01,Long,Sla01Repository>{
	
	@Autowired
	private Sla01Repository sla01Repository;
	
}
