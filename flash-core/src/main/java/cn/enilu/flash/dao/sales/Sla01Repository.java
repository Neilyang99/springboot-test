package cn.enilu.flash.dao.sales;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.enilu.flash.bean.entity.sales.Sla01;
import cn.enilu.flash.dao.BaseRepository;

public interface Sla01Repository  extends BaseRepository<Sla01,Long>{
	
	List<Sla01> findBySla01002(Integer sla01002);
	List<Sla01> findBySla01003(String sla01003);
	Optional<Sla01> findById(Long id);
	
	@Query(value="SELECT a.* FROM sla01 a WHERE a.sla01027 in ('A','C') and a.sla01003 = ?1", nativeQuery=true)
	List<Sla01> findNotSaleHouse(String projectNo);
	
	@Modifying
	@Query(value = "update sla01 set sla01027=?2 where id=?1", nativeQuery = true)
	void updateStatusBySla01ID(Long id, String status);
}
