package cn.enilu.flash.dao.sales;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import cn.enilu.flash.bean.entity.sales.Sla00;
import cn.enilu.flash.dao.BaseRepository;

public interface Sla00Repository  extends BaseRepository<Sla00,Long>{
	
	Sla00 findBySla00002(String code);
	
	@Query(value="SELECT a FROM sla00 a WHERE a.sla00041 not in ('N','P','S')", nativeQuery=false)
	List<Sla00> findOnSaleCase();
}
