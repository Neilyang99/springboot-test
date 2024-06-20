package cn.enilu.flash.dao.ma;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import cn.enilu.flash.bean.entity.ma.Maa90;
import cn.enilu.flash.bean.vo.ma.MaaVo;
import cn.enilu.flash.dao.BaseRepository;

public interface Maa90Repository  extends BaseRepository<Maa90,Long>{
	
	@Query(value="SELECT id,maa90002,maa90003 FROM maa90 where maa90005='Y' order by maa90004 ", nativeQuery=true)
	List<Object[]> getFirstType();
	
}
