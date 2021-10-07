package cn.enilu.flash.dao.sales;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.enilu.flash.bean.entity.sales.Sla20;
import cn.enilu.flash.dao.BaseRepository;

public interface Sla20Repository  extends BaseRepository<Sla20,Long>{
	
	public Sla20 findBySla20002AndSla20006(Long projectUID, Long customerUID);
	
	@Modifying
	@Query(value = "update sla20 set sla20005=?2 where id=?1", nativeQuery = true)
	void updateOrderStatus(Long id, String status);
}
