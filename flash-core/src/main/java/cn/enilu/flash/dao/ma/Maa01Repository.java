package cn.enilu.flash.dao.ma;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.enilu.flash.bean.entity.ma.Maa01;
import cn.enilu.flash.dao.BaseRepository;

public interface Maa01Repository  extends BaseRepository<Maa01,Long>{
	
	@Modifying
	@Query(value="UPDATE maa01 a INNER JOIN (select maa01a002,maa01a003,maa01a004,SUM(maa01a017) amount from maa01a where maa01a004=?1 GROUP BY maa01a002,maa01a003,maa01a004) b ON a.maa01002=b.maa01a002 AND a.maa01003=b.maa01a003 AND a.maa01004=b.maa01a004 SET a.maa01012=b.amount WHERE a.maa01004=?1 ", nativeQuery=true)
	int updateBudgeAmountByMaa01004(Long lv2Id);
	
	@Query(value="select count(1) from maa01 where maa01002=?1 and maa01003=?2 and maa01004=?3 ", nativeQuery=true)
	int checkLevel2Data(Long projectId, Long lv1Id, Long lv2Id);
	
}
