package cn.enilu.flash.service.sales;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.sales.Slb14;
import cn.enilu.flash.dao.sales.Slb14Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Slb14Service extends BaseService<Slb14,Long,Slb14Repository>{
	
	@Autowired
	private Slb14Repository Slb14Repository;
	
	public List<Slb14> findBySlb14002(Long Slb14002){
		return this.Slb14Repository.findBySlb14002(Slb14002);
	}
	
	public Optional<Slb14> findById(Long id) {
		return this.Slb14Repository.findById(id);
	}
	
}
