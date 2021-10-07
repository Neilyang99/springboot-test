package cn.enilu.flash.dao.sales;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.enilu.flash.bean.entity.sales.Sla11;
import cn.enilu.flash.dao.BaseRepository;

public interface Sla11Repository extends BaseRepository<Sla11,Long>{

	Sla11 findBySla11004(String str);
	List<Sla11> findBySla11002(Long visitorId);
	
	@Query(value="SELECT a.* FROM sla11 a WHERE a.sla11002 = ?1 and a.sla11024 > 0", nativeQuery=true)
	List<Sla11> getOrderIdBySla11002(Long visitorId);
	
	@Modifying
	@Query(value="update sla11 set sla11024=?2 WHERE id = ?1", nativeQuery=true)
	int updateOrderIdByLogId(Long logId, Long orderId);
}
