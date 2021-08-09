package cn.enilu.flash.service.sales;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.sales.Sla23;
import cn.enilu.flash.dao.sales.Sla23Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Sla23Service extends BaseService<Sla23,Long,Sla23Repository>{
	
	@Autowired
	private Sla23Repository Sla23Repository;
	
	
	
}
