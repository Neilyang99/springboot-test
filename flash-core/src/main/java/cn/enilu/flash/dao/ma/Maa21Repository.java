package cn.enilu.flash.dao.ma;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.enilu.flash.bean.entity.ma.Maa21;
import cn.enilu.flash.dao.BaseRepository;

public interface Maa21Repository  extends BaseRepository<Maa21,Long>{
	
	@Query(value="select max(maa21002) from maa21 where maa21002 like CONCAT(?1,'%') ", nativeQuery=true)
	String getMaxPONo(String param);
	
	@Modifying
	@Query(value="UPDATE maa21 SET maa21021=?2 WHERE id=?1 ", nativeQuery=true)
	int UpdateStatusById(Long id, int status);
}
