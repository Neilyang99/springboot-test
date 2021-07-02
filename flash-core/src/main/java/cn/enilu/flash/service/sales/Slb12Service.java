package cn.enilu.flash.service.sales;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.sales.Slb12;
import cn.enilu.flash.dao.sales.Slb12Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Slb12Service extends BaseService<Slb12,Long,Slb12Repository>{
	
	@Autowired
	private Slb12Repository slb12Repository;
	
	public List<Slb12> findBySlb12002(Long slb12002){
		return this.slb12Repository.findBySlb12002(slb12002);
	}
	
	public Optional<Slb12> findById(Long id) {
		return this.slb12Repository.findById(id);
	}
	
}
