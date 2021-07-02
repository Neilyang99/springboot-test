package cn.enilu.flash.service.sales;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.sales.Slb15;
import cn.enilu.flash.dao.sales.Slb15Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Slb15Service extends BaseService<Slb15,Long,Slb15Repository>{
	
	@Autowired
	private Slb15Repository slb15Repository;
	
	public List<Slb15> findBySlb15002(Long slb15002){
		return this.slb15Repository.findBySlb15002(slb15002);
	}
	
	public Optional<Slb15> findById(Long id) {
		return this.slb15Repository.findById(id);
	}
	
}
