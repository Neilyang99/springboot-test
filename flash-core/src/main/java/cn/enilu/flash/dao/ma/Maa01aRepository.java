package cn.enilu.flash.dao.ma;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import cn.enilu.flash.bean.entity.ma.Maa01a;
import cn.enilu.flash.dao.BaseRepository;

public interface Maa01aRepository  extends BaseRepository<Maa01a,Long>{
	
	public List<Maa01a> findByMaa01a002(Long projectId);
	
	@Query(value="SELECT count(1) FROM maa01a WHERE maa01a002=?1", nativeQuery=false)
	public int checkfindByMaa01a002(Long projectId);
	
	public List<Maa01a> findByMaa01a002AndMaa01a004(Long projectId, Long lv2Id);
	
	@Query(value="SELECT a.maa01010,a.maa01011,b.maa01a013,b.maa01a014,b.maa01a015,b.maa01a016,b.maa01a017,c.maa00004,b.maa01a018 FROM maa01 a " + 
			" LEFT JOIN maa01a b ON a.maa01002=b.maa01a002 AND a.maa01003=b.maa01a003 AND a.maa01004=b.maa01a004  " +
			" INNER JOIN maa00 c ON a.maa01002=c.id " +
			" WHERE a.maa01002=?1 ORDER BY a.maa01003,a.maa01004,b.maa01a006", nativeQuery=false)
	public List exportToExcel(Long projectId);
	
	@Modifying
	@Transactional
	@Query(value="insert into maa01a (id,maa01a002,maa01a003,maa01a004,maa01a005,maa01a006,maa01a007,maa01a008,maa01a009,maa01a010,maa01a011,maa01a012,maa01a013,maa01a014,maa01a015,maa01a016,maa01a017,maa01a018,create_time,modify_time) " + 
			"( select null,d.id projectId,maa92002,maa92003,a.id,maa92012,maa00002,maa00003,maa00004,maa90003,maa91005,maa92006,maa92007,maa92008,maa92009,0,0,maa92011,NOW(),NOW() from maa92 a" + 
			"  inner join maa90 b on a.maa92002=b.id and maa90005='Y'" + 
			"  inner join maa91 c on a.maa92003=c.id and maa91007='Y'" + 
			"  inner join maa00 d on d.id=?1" +
			"  where maa92013='Y' and d.id not in (select maa01a002 from maa01a) " + 
			")", nativeQuery=true)
	public int insertByNewProject(Long projectId);
	
	@Modifying
	@Transactional
	@Query(value="insert into maa01a (id,maa01a002,maa01a003,maa01a004,maa01a005,maa01a006,maa01a007,maa01a008,maa01a009,maa01a010,maa01a011,maa01a012,maa01a013,maa01a014,maa01a015,maa01a016,maa01a017,maa01a018,create_time,modify_time) " + 
			"( select null,d.id projectId,maa92002,maa92003,a.id,maa92012,maa00002,maa00003,maa00004,maa90003,maa91005,maa92006,maa92007,maa92008,maa92009,0,0,maa92011,NOW(),NOW() from maa92 a" + 
			"  inner join maa90 b on a.maa92002=b.id and maa90005='Y'" + 
			"  inner join maa91 c on a.maa92003=c.id and maa91007='Y'" + 
			"  inner join maa00 d on d.id=?1" +
			"  where maa92013='Y' and d.id not in (select maa01a002 from maa01a)  AND b.id in (?2) " + 
			")", nativeQuery=true)
	public int insertByNewProject(Long projectId, List<String> buildTypeList);
	
	@Modifying
	@Query(value="update maa01a a inner join "
			+ "(select maa01b002,maa01b003,maa01b004,maa01b005,sum(maa01b011) price from maa01b "
			+ "	 where maa01b002=?1 "
			+ "  group by maa01b002,maa01b003,maa01b004,maa01b005"
			+ ") b on a.maa01a002=b.maa01b002 and a.maa01a003=b.maa01b003 and a.maa01a004=b.maa01b004 and a.maa01a005=b.maa01b005 "
			+ "set a.maa01a016=b.price,a.maa01a017=ROUND(a.maa01a015*b.price),a.maa01a029='Y'  "
			+ "where a.maa01a002=?1 ", nativeQuery=true)
	//注意此method只能用於批次產生預算資料使用，因為maa01a005=maa01b005的限制
	public int updateBudgeAmountByProject(Long projectId);
	
	@Modifying
	@Query(value="update maa01a a LEFT join "
			+ "(select maa01b002,maa01b003,maa01b004,maa01b007,sum(maa01b011) price from maa01b "
			+ "	 where maa01b002=?1 and maa01b007=?2 "
			+ "  group by maa01b002,maa01b003,maa01b004,maa01b007"
			+ ") b on a.maa01a002=b.maa01b002 and a.maa01a003=b.maa01b003 and a.maa01a004=b.maa01b004 and a.id=b.maa01b007 "
			+ "set a.maa01a016=IFNULL(b.price,0),a.maa01a017=IFNULL(ROUND(a.maa01a015*b.price),0),a.maa01a029=IF(ISNULL(b.price),'','Y')  "
			+ "where a.id=?2 ", nativeQuery=true)
	public int updateAmountByProjectAndItem(Long projectId, Long itemId);
	
	@Modifying
	@Query(value="UPDATE maa01a SET maa01a029='' WHERE id=?2 and id not in (select maa01b007 from maa01b where maa01b002=?1 and maa01b007=?2)", nativeQuery=true)
	public int updateWorkItemFlag(Long projectId, Long itemId );
	
	@Modifying
	@Query(value="UPDATE maa01a SET maa01a025=?2,maa01a034=?2 WHERE maa01a002=?1 ", nativeQuery=true)
	public int updateBudgeConfirmByProject(Long projectId, String status);
	
	@Modifying
	@Query(value="DELETE FROM maa01a WHERE maa01a002=?1 and maa01a003=?2 and maa01a004=?3 ", nativeQuery=true)
	public int deleteByMaa01(Long projectId, Long lv1, Long lv2);
	
	public int deleteByMaa01a002(Long projectId);
}
