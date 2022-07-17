package cn.enilu.flash.dao.ma;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import cn.enilu.flash.bean.entity.ma.Maa14;
import cn.enilu.flash.dao.BaseRepository;

public interface Maa14Repository  extends BaseRepository<Maa14,Long>{
	
	@Query(value="SELECT maa14003 FROM maa14 where maa14010<>'9' ORDER BY maa14003 ", nativeQuery=true)
	List<String> findWorkerName();
	
}
