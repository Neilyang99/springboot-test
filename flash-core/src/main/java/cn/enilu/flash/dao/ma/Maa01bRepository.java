package cn.enilu.flash.dao.ma;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import cn.enilu.flash.bean.entity.ma.Maa01b;
import cn.enilu.flash.bean.vo.ma.BudgetDataVo;
import cn.enilu.flash.dao.BaseRepository;

public interface Maa01bRepository  extends BaseRepository<Maa01b,Long>{
	
	public List<Maa01b> findByMaa01b002(Long projectId);
	
	/**
	 * 查詢 預算書清單 
	 * @param projectId
	 * @return
	 */
	@Query(value="SELECT a.id AS Maa01aId,a.maa01a010,a.maa01a011,a.maa01a013,a.maa01a014,a.maa01a015,a.maa01a016,a.maa01a017,"
			+ "b.id AS Maa01bId,b.maa01b017,b.maa01b008,b.maa01b009,b.maa01b010,b.maa01b011 "
			+ "FROM maa01a a "
			+ "INNER JOIN maa01 c ON c.maa01002=a.maa01a002 AND c.maa01003=a.maa01a003 AND c.maa01004=a.maa01a004 AND maa01018='Y' AND maa01019='Y' "
			+ "LEFT JOIN maa01b b ON a.id=b.maa01b007 AND a.maa01a002=b.maa01b002 AND b.maa01b018='Y' AND b.maa01b019='Y' "
			+ "WHERE maa01a025='Y' AND maa01a034='Y' AND maa01a002=?1 "
			+ "ORDER BY c.maa01017,a.maa01a006,b.maa01b020 ", nativeQuery=true)
	public List<Object[]> getBudgetData(Long projectId);
	
	/**
	 * 查詢 預算書清單 
	 * @param projectId
	 * @return
	 */
	@Query(value="SELECT a.id AS Maa01aId,a.maa01a010,a.maa01a011,a.maa01a013,a.maa01a014,a.maa01a015,a.maa01a016,a.maa01a017,"
			+ "b.id AS Maa01bId,b.maa01b017,b.maa01b008,b.maa01b009,b.maa01b010,b.maa01b011 "
			+ "FROM maa01a a "
			+ "INNER JOIN maa01 c ON c.maa01002=a.maa01a002 AND c.maa01003=a.maa01a003 AND c.maa01004=a.maa01a004 AND maa01018='Y' AND maa01019='Y' "
			+ "INNER JOIN maa01b b ON a.id=b.maa01b007 AND a.maa01a002=b.maa01b002 AND b.maa01b018='Y' AND b.maa01b019='Y' "
			+ "INNER JOIN maa93c d  ON b.maa01b006=d.maa93c003 AND d.maa93c002=?2 "
			+ "WHERE maa01a025='Y' AND maa01a034='Y' AND maa01a002=?1 "
			+ "ORDER BY c.maa01017,a.maa01a006,b.maa01b020 ", nativeQuery=true)
	public List<Object[]> getBudgetData(Long projectId, Long vendorId);
	
	@Modifying
	@Query(value="UPDATE maa01b SET maa01b019=?2 WHERE maa01b002=?1 ", nativeQuery=true)
	int updateBudgeConfirmByProject(Long projectId, String status);
	
	@Modifying
	@Transactional
	@Query(value="insert into maa01b (id,maa01b002,maa01b003,maa01b004,maa01b005,maa01b006,maa01b007,maa01b008,maa01b009,maa01b010,maa01b011,maa01b012,maa01b013,maa01b014,maa01b015,maa01b016,maa01b017,maa01b018,maa01b019,maa01b020,create_time,modify_time) " + 
			"(select null,f.id ,maa92002,maa92003,a.id,d.id,g.id,maa95003,maa92a005,maa95005,ROUND(maa95005*maa92a005,2),maa92a006,maa95007,maa95008,maa95009,maa95010,maa95002,'Y','',maa92a007,NOW(),NOW() " + 
			"from maa92 a  " + 
			"inner join maa90 b on a.maa92002=b.id and maa90005='Y' " + 
			"inner join maa91 c on a.maa92003=c.id and maa91007='Y' " + 
			"inner join maa92a d on a.id=d.maa92a002 and maa92a008='Y'" + 
			"inner join maa95 e on e.id=d.maa92a003 and maa95013='Y' " + 
			"inner join maa00 f on f.id=?1 " + 
			"inner join maa01a g on g.maa01a002=f.id and g.maa01a003=b.id and g.maa01a004=c.id and g.maa01a005=a.id " +
			"where maa92013='Y' and f.id not in (select maa01b002 from maa01b) " + 
			")", nativeQuery=true)
	public int insertByNewProject(Long projectId);
	
	@Modifying
	@Transactional
	@Query(value="insert into maa01b (id,maa01b002,maa01b003,maa01b004,maa01b005,maa01b006,maa01b007,maa01b008,maa01b009,maa01b010,maa01b011,maa01b012,maa01b013,maa01b014,maa01b015,maa01b016,maa01b017,maa01b018,maa01b019,maa01b020,create_time,modify_time) " + 
			"(select null,f.id ,maa92002,maa92003,a.id,d.id,g.id,maa95003,maa92a005,maa95005,ROUND(maa95005*maa92a005,2),maa92a006,maa95007,maa95008,maa95009,maa95010,maa95002,'Y','',maa92a007,NOW(),NOW() " + 
			"from maa92 a  " + 
			"inner join maa90 b on a.maa92002=b.id and maa90005='Y' " + 
			"inner join maa91 c on a.maa92003=c.id and maa91007='Y' " + 
			"inner join maa92a d on a.id=d.maa92a002 and maa92a008='Y'" + 
			"inner join maa95 e on e.id=d.maa92a003 and maa95013='Y' " + 
			"inner join maa00 f on f.id=?1 " + 
			"inner join maa01a g on g.maa01a002=f.id and g.maa01a003=b.id and g.maa01a004=c.id and g.maa01a005=a.id " +
			"where maa92013='Y' and f.id not in (select maa01b002 from maa01b)  AND b.id in (?2)" + 
			")", nativeQuery=true)
	public int insertByNewProject(Long projectId, List<String> buildTypeList);
	
	@Modifying
	@Query(value="DELETE FROM maa01b WHERE maa01b007=?1 ", nativeQuery=true)
	int deleteByMaa01a(Long projectLV3Id);
	
	@Modifying
	@Query(value="DELETE FROM maa01b WHERE maa01b002=?1 and maa01b003=?2 and maa01b004=?3 ", nativeQuery=true)
	int deleteByMaa01(Long projectId, Long lv1, Long lv2);
	
	int deleteByMaa01b002(Long projectId);
}
