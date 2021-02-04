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
	
}
