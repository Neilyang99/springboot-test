package cn.enilu.flash.dao.sales;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.enilu.flash.bean.entity.sales.Sla24;
import cn.enilu.flash.dao.BaseRepository;

public interface Sla24Repository  extends BaseRepository<Sla24,Long>{
	
	@Modifying
	@Query(value = "update sla24 set sla24008=?2 where id=?1", nativeQuery = true)
	void updateFinishDate(Long id, String date);
}
