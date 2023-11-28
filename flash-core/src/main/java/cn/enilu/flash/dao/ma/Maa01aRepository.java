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
			"( select null,d.id projectId,maa92002,maa92003,a.id,maa92012,maa00002,maa00003,maa00004,maa90003,maa91005,maa92006,maa92007,maa92008,maa92009,maa92010,round(maa92009*maa92010),maa92011,NOW(),NOW() from maa92 a" + 
			"  inner join maa90 b on a.maa92002=b.id" + 
			"  inner join maa91 c on a.maa92003=c.id" + 
			"  inner join maa00 d on d.id=?1" +
			"  where d.id not in (select maa01a002 from maa01a) " + 
			")", nativeQuery=true)
	public int insertByNewProject(Long projectId);
}
