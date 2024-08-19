package cn.enilu.flash.dao.ma;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.enilu.flash.bean.entity.ma.Maa95;
import cn.enilu.flash.dao.BaseRepository;

public interface Maa95Repository  extends BaseRepository<Maa95,Long>{
	
	List<Maa95> findByMaa95013(String status);

	@Modifying
	@Query(value="UPDATE maa95 SET maa95013=?2 WHERE id=?1 ", nativeQuery=true)
	int UpdateStatusById(Long id,String status);
	
}
