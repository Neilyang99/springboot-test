package cn.enilu.flash.dao.ma;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.enilu.flash.bean.entity.ma.Maa93c;
import cn.enilu.flash.dao.BaseRepository;

public interface Maa93cRepository  extends BaseRepository<Maa93c,Long>{
	
	
	@Query(value="SELECT a.id,b.id,b.maa95002,b.maa95003,b.maa95006,a.maa93c002 FROM maa95 b "
			+ "left JOIN maa93c a ON a.maa93c003=b.id AND a.maa93c002=?1 "
			+ "WHERE b.maa95013='Y' "
			+ "ORDER BY b.maa95012", nativeQuery=false)
	List<Object[]> getWorkItemListByVendor(Long vendorId);
	
	@Query(value="SELECT count(1) FROM maa95 b "
			+ "INNER JOIN maa93c a ON a.maa93c003=b.id AND a.maa93c002=?1 "
			+ "WHERE b.maa95013='Y' ", nativeQuery=false)
	int getWorkItemCountByVendor(Long vendorId);
	
	@Modifying
	@Query(value="delete from maa93c where maa93c002=?1", nativeQuery=false)
	int deleteByVendorId(Long vendorId);
	
	
	@Query(value="SELECT a.id,a.maa93004,c.maa95002 from maa93 a inner join maa93c b on a.id=b.maa93c002 " + 
			"inner join maa95 c on b.maa93c003=c.id and c.maa95013='Y' " + 
			"where a.id=?1 " + 
			"order by c.maa95012", nativeQuery=false)
	List<Object[]> getVendorWorkItem(Long vendorId);
	
}
