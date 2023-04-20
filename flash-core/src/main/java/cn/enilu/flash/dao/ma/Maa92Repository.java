package cn.enilu.flash.dao.ma;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import cn.enilu.flash.bean.entity.ma.Maa92;
import cn.enilu.flash.dao.BaseRepository;

public interface Maa92Repository  extends BaseRepository<Maa92,Long>{
	
	@Query(value = "select a.id as firstId,a.maa90003,b.id as secId,b.maa91005 from maa90 a inner join maa91 b on a.id=b.maa91002 and b.maa91007='Y' where a.maa90005='Y' order by a.maa90004,b.maa91006", nativeQuery = true)
	List<Object[]> queryBudgetItem();
	
	@Query(value = "select a.id as firstId,a.maa90003,b.id as secId,b.maa91005,c.id as itemId,c.maa92007 "
			+ " from maa90 a "
			+ " inner join maa91 b on a.id=b.maa91002 and b.maa91007='Y' "
			+ " inner join maa92 c on a.id=c.maa92002 and b.id=c.maa92003 and c.maa92013='Y' "
			+ " where a.maa90005='Y' and c.maa92003=?1 "
			+ " order by a.maa90004,b.maa91006", nativeQuery = true)
	public List<Object[]> findByMaa92003(Long lv2);
}
