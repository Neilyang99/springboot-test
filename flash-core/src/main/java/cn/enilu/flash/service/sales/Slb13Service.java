package cn.enilu.flash.service.sales;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.sales.Slb13;
import cn.enilu.flash.dao.sales.Slb13Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Slb13Service extends BaseService<Slb13,Long,Slb13Repository>{
	
	@Autowired
	private Slb13Repository Slb13Repository;
	
	public List<Slb13> findBySlb13002(Long Slb13002){
		return this.Slb13Repository.findBySlb13002(Slb13002);
	}
	
	public Optional<Slb13> findById(Long id) {
		return this.Slb13Repository.findById(id);
	}
	
}
