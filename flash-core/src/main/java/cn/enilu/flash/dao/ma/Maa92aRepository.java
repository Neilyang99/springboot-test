package cn.enilu.flash.dao.ma;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import cn.enilu.flash.bean.entity.ma.Maa92a;
import cn.enilu.flash.bean.vo.ma.Maa92aVo;
import cn.enilu.flash.dao.BaseRepository;

public interface Maa92aRepository  extends BaseRepository<Maa92a,Long>{
	
	
	@Query(value = "select b.id,b.maa92a002,b.maa92a003,b.maa92a004,b.maa92a005,b.maa92a006,b.maa92a007,b.maa92a008,b.maa92a009, "
			+" a.maa92007,c.maa95002,c.maa95003 "
			+ " from maa92 a "
			+ " inner join maa92a b on a.id=b.maa92a002 "
			+ " left join maa95 c on c.id=b.maa92a003 "
			+ " where b.maa92a008='Y' and a.id=?1 "
			+ " order by b.maa92a007", nativeQuery = true)
	public List<Object[]> findByMaa92a002(Long budgetItemId);
	
	
	@Query(value = "select count(1) from maa92a where id<>?1 and maa92a002=?2 and maa92a003=?3 and maa92a009=?4 ", nativeQuery = true)
	public int checkDuplicateWorkItem(Long subId, Long budgetItemId, Long workItemId, Long companyId);
}
