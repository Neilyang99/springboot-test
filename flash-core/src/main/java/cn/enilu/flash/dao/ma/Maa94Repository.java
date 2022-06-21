package cn.enilu.flash.dao.ma;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import cn.enilu.flash.bean.entity.ma.Maa94;
import cn.enilu.flash.dao.BaseRepository;

public interface Maa94Repository  extends BaseRepository<Maa94,Long>{
	
	
	@Query(value="SELECT maa94003 FROM maa94 where id=?1 and maa94010='' ", nativeQuery=true)
	String findItemNameById(Long id);
	
	@Query(value="SELECT * FROM maa94 where maa94002=?1 and maa94007=1 and maa94010='' order by maa94005", nativeQuery=true)
	List<Maa94> getItemList(int itemCode);
	
	
}
