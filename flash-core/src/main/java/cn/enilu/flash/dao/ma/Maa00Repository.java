package cn.enilu.flash.dao.ma;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.enilu.flash.bean.entity.ma.Maa00;
import cn.enilu.flash.dao.BaseRepository;

public interface Maa00Repository  extends BaseRepository<Maa00,Long>{
	
	@Modifying
	@Query(value="UPDATE maa00 a INNER JOIN (select maa01a002,SUM(maa01a017) amount from maa01a where maa01a002=?1 GROUP BY maa01a002) b ON a.id=b.maa01a002 SET a.maa00027=b.amount WHERE a.id=?1 ", nativeQuery=true)
	int updateBudgeAmountByProject(Long projectId);
	
}
