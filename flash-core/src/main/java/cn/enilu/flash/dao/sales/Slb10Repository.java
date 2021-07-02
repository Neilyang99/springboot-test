package cn.enilu.flash.dao.sales;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import cn.enilu.flash.bean.entity.sales.Slb10;
import cn.enilu.flash.bean.entity.sales.Slb11;
import cn.enilu.flash.dao.BaseRepository;

public interface Slb10Repository  extends BaseRepository<Slb10,Long>{
	
	Slb10 findBySlb10004(String code);
	Optional<Slb10> findById(Long id);
	
//	List<Slb11> findBySlb11002(Integer slb11002);
	
	//更新今日成交戶數與金額
	@Modifying
	@Query(value="update slb10 a inner join ( " +
			"select slb11002,count(1) as cnt,sum(slb11006) as amount from slb11 group  by slb11002) b on a.id=slb11002 " + 
			"set slb10013=b.cnt, slb10014=b.amount where a.id=?1", nativeQuery = true)
	int updateAmountById(Long id);
	
	@Modifying
	@Query(value="update slb10 a inner join ( " +
			"select slb11002,count(1) as cnt,sum(slb11006) as amount from slb11 group  by slb11002) b on a.id=slb11002 " + 
			"set ?2=b.cnt, ?3=b.amount where a.id=?1", nativeQuery = true)
	int updateCountAmountById(Long id, String cntField, String amtField);
	
		
	//更新今日累計成交戶數與金額
	@Modifying
	@Query(value="update slb10 a inner join ("
			+ "select slb10004,count(1) as cnt,sum(slb11006) as amount from slb10 a "
			+ "inner join slb11 b on a.id=b.slb11002 where a.slb10004=?2 group  by slb10004) b on a.slb10004=b.slb10004 "
			+ "set slb10015=b.cnt, slb10016=b.amount where a.id=?1", nativeQuery = true)
	int updateTotalAmountByIdAndProjectNo(Long id, String projectNo);
	
	
	//更新回籠人數
	@Modifying
	@Query(value="update slb10 a inner join ( " +
			"select slb12002,count(1) as cnt from slb12 group  by slb12002) b on a.id=slb12002 " + 
			"set slb10011=b.cnt where a.id=?1", nativeQuery = true)
	int updateAgainCountById(Long id);
	
	
}
