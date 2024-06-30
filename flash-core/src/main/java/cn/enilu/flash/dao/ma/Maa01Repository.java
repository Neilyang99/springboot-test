package cn.enilu.flash.dao.ma;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import cn.enilu.flash.bean.entity.ma.Maa01;
import cn.enilu.flash.dao.BaseRepository;

public interface Maa01Repository  extends BaseRepository<Maa01,Long>{
	
	@Modifying
	@Query(value="UPDATE maa01 a INNER JOIN (select maa01a002,maa01a003,maa01a004,SUM(maa01a017) amount from maa01a where maa01a002=?1 and maa01a004=?2 GROUP BY maa01a002,maa01a003,maa01a004) b ON a.maa01002=b.maa01a002 AND a.maa01003=b.maa01a003 AND a.maa01004=b.maa01a004 SET a.maa01012=b.amount WHERE a.maa01002=?1 and a.maa01004=?2 ", nativeQuery=true)
	int updateBudgeAmountByMaa01004(Long projectId, Long lv2Id);
	
	@Modifying
	@Query(value="UPDATE maa01 a INNER JOIN (select maa01a002,maa01a003,maa01a004,SUM(maa01a017) amount from maa01a where maa01a002=?1 GROUP BY maa01a002,maa01a003,maa01a004) b ON a.maa01002=b.maa01a002 AND a.maa01003=b.maa01a003 AND a.maa01004=b.maa01a004 SET a.maa01012=b.amount WHERE a.maa01002=?1 ", nativeQuery=true)
	int updateBudgeAmountByProject(Long projectId);
	
	@Query(value="select count(1) from maa01 where maa01002=?1 and maa01003=?2 and maa01004=?3 ", nativeQuery=true)
	int checkLevel2Data(Long projectId, Long lv1Id, Long lv2Id);
	
	
	@Modifying
	@Transactional
	@Query(value="insert into maa01 (id,maa01002,maa01003,maa01004,maa01005,maa01006,maa01007,maa01008,maa01009,maa01010,maa01011,maa01017,maa01018,create_time,modify_time) " + 
			"(SELECT NULL,d.id,b.id,a.id,maa00002,maa00003,maa00004,maa90002,maa91004,maa90003,maa91005,(maa90004*1000+maa91006),'Y',NOW(),NOW() FROM maa91 a " + 
			"inner join maa90 b on a.maa91002=b.id " + 
			"inner join maa00 d on d.id=?1 " + 
			"WHERE d.id not in (select maa01002 from maa01) )", nativeQuery=true)
	public int insertByNewProject(Long projectId);
	
	
	@Modifying
	@Query(value="UPDATE maa01 SET maa01019=?2 WHERE maa01002=?1 ", nativeQuery=true)
	int updateBudgeConfirmByProject(Long projectId, String status);
	
	
	int deleteByMaa01002(Long maa01002);
	
}
