package cn.enilu.flash.dao.ma;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import cn.enilu.flash.bean.entity.ma.Maa93;
import cn.enilu.flash.dao.BaseRepository;

public interface Maa93Repository  extends BaseRepository<Maa93,Long>{
	
	@Query(value="SELECT count(1) FROM maa93 WHERE maa93011=?2", nativeQuery=false)
	int checkMaa93011ForNew(String maa93011);
	
	@Query(value="SELECT count(1) FROM maa93 WHERE id<>?1 and maa93011=?2", nativeQuery=false)
	int checkMaa93011ForUpdate(Long id, String maa93011);
	
}
