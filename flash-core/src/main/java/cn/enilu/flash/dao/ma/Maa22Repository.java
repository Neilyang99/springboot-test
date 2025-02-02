package cn.enilu.flash.dao.ma;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.enilu.flash.bean.entity.ma.Maa22;
import cn.enilu.flash.dao.BaseRepository;

public interface Maa22Repository  extends BaseRepository<Maa22,Long>{
	
	@Modifying
	@Query(value="UPDATE maa22 SET maa22018=?2 WHERE maa22002=?1 ", nativeQuery=true)
	int UpdateStatusByMaa22002(Long maa22002, int status);
	
}
