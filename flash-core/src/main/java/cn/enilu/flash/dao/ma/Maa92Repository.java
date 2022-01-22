package cn.enilu.flash.dao.ma;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import cn.enilu.flash.bean.entity.ma.Maa92;
import cn.enilu.flash.dao.BaseRepository;

public interface Maa92Repository  extends BaseRepository<Maa92,Long>{
	
	@Query(value = "select a.id as firstId,a.maa90003,b.id as secId,b.maa91005 from maa90 a inner join maa91 b on a.id=b.maa91002 and b.maa91007='Y' where a.maa90005='Y' order by a.maa90004,b.maa91006", nativeQuery = true)
	List<Object[]> queryBudgetItem();
	
}
