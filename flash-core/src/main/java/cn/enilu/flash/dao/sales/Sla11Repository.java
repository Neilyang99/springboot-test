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
	
	@Query(value="SELECT a.id customerId,c.id sla11Id,a.sla10002,a.sla10003,a.sla10006,a.sla10010,c.sla11004,c.sla11006,c.sla11008,IFNULL(c.sla11023,0),IFNULL(c.sla11024,0),c.modify_time,TIMESTAMPDIFF(DAY,c.modify_time,now()) dt FROM sla10 a " + 
			"INNER JOIN (SELECT id,sla11002,MAX(sla11004) FROM sla11 GROUP BY sla11002) b ON a.id=b.sla11002 " + 
			"INNER JOIN sla11 c ON b.id=c.id and (c.sla11024=0 or c.sla11024 is null)" + 
			"WHERE c.create_time=c.modify_time AND TIMESTAMPDIFF(DAY,c.modify_time,NOW())>7 and SLA10014=?1", nativeQuery=true)
	List<Object[]> findNoHandleList(String salesNo);
}
