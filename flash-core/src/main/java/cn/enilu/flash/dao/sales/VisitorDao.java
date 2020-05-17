package cn.enilu.flash.dao.sales;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import cn.enilu.flash.bean.entity.sales.Visitor;
import cn.enilu.flash.dao.BaseRepository;

public interface VisitorDao extends BaseRepository<Visitor, Long>{

	 //List<Visitor> findByVisitorName(String name);
	
	@Query(value= "select * from sla10")
	List<Visitor> findAll();
}
