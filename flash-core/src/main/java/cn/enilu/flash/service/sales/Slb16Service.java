package cn.enilu.flash.service.sales;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.sales.Slb16;
import cn.enilu.flash.dao.sales.Slb16Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Slb16Service extends BaseService<Slb16,Long,Slb16Repository>{
	
	@Autowired
	private Slb16Repository Slb16Repository;
	
	public List<Slb16> findBySlb16002(Long Slb16002){
		return this.Slb16Repository.findBySlb16002(Slb16002);
	}
	
	public Optional<Slb16> findById(Long id) {
		return this.Slb16Repository.findById(id);
	}
	
}
