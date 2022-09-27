package cn.enilu.flash.dao.ma;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.enilu.flash.bean.entity.ma.Maa16;
import cn.enilu.flash.dao.BaseRepository;

public interface Maa16Repository  extends BaseRepository<Maa16,Long>{
	
	@Query(value="SELECT max(maa16003) AS count FROM maa16 a WHERE a.maa16002=?1", nativeQuery=false)
	String getMaxPeriod(Long projectId);
	
	@Modifying
	@Query(value="UPDATE maa16 a SET maa16005=(SELECT SUM(maa17005) FROM maa17 b WHERE maa17002=a.id AND maa17003='I'), maa16006=(SELECT SUM(maa17005) FROM maa17 b WHERE maa17002=a.id AND maa17003='O') WHERE a.id=?1", nativeQuery=false)
	void updateAmt(Long PK);
	
}
