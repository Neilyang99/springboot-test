package cn.enilu.flash.service.sales;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.sales.Slb11;
import cn.enilu.flash.dao.sales.Slb11Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Slb11Service extends BaseService<Slb11,Long,Slb11Repository>{
	
	@Autowired
	private Slb11Repository slb11Repository;
	
	public List<Slb11> findBySlb11002(Long slb11002){
		return this.slb11Repository.findBySlb11002(slb11002);
	}
	
	public Optional<Slb11> findById(Long id) {
		return this.slb11Repository.findById(id);
	}
	
}
