package cn.enilu.flash.dao.sales;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import cn.enilu.flash.bean.entity.sales.Visitor;
import cn.enilu.flash.dao.BaseRepository;

public interface VisitorDao extends BaseRepository<Visitor, Long>{

	 //List<Visitor> findByVisitorName(String name);
	
	//@Query(value = "select id,sla10002,sla10004,sla10005,sla10006,sla10009,sla10013,sla10014 from sla10 where sla10006 like ?1", nativeQuery = true)
	List<Visitor> findBySla10006(String name);
	
	
}
