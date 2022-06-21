package cn.enilu.flash.dao.ma;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import cn.enilu.flash.bean.entity.ma.Maa10;
import cn.enilu.flash.dao.BaseRepository;

public interface Maa10Repository  extends BaseRepository<Maa10,Long>{
	
	
	@Query(value="SELECT maa94003,sum(maa10008*maa10009),sum(maa10008) FROM maa10 a inner join maa94 b on a.maa10006=b.id "
			+ "where maa10002=?1 and maa10013<>9 group by maa10006 order by maa94005 ", nativeQuery=true)
	List<Object[]> getStock(long projectId);
}
