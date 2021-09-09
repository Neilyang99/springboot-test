package cn.enilu.flash.dao.sales;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import cn.enilu.flash.bean.entity.sales.Visitor;
import cn.enilu.flash.dao.BaseRepository;

public interface VisitorRepository extends BaseRepository<Visitor, Long>{

	 //List<Visitor> findByVisitorName(String name);
	
	//@Query(value = "select id,sla10002,sla10004,sla10005,sla10006,sla10009,sla10013,sla10014 from sla10 where sla10006 like ?1", nativeQuery = true)
	List<Visitor> findBySla10006(String name);
	
	Optional<Visitor> findById(Long id);
	
	@Query(value = "select sla10.id,sla10002,sla00003 as sla10002name,sla10004,sla10005,sla10006,sla10010,sla10013,sla10014,sla10015 from sla10 left join sla00 on sla10002=sla00002 ", nativeQuery = true)
	List<Object[]> queryGridList();
	
	//get media statistics
	//totalCount=累計, thisWeek=本周
	@Query(value = "select a.sla10002 projectCode,a.sla10003 projectName,a.sla10004 visitorType,a.sla10023 itemCode,a.acc totalCount,if(isnull(thisWeek),0,b.thisWeek) weeklyCount from "
			+ "(select sla10002,sla10003,sla10004,sla10023,count(1) acc from sla10  group by sla10002,sla10004,sla10023) a "
			+ "left join (select sla10002,sla10003,sla10004,sla10023,count(1) thisWeek from sla10 where sla10013 between ?2 and ?3 group by sla10002,sla10004,sla10023) b " 
			+ "on a.sla10002=b.sla10002 and a.sla10004=b.sla10004 and a.sla10023=b.sla10023 "
			+ "where a.sla10002=?1 "
			+ "order by 3,4", nativeQuery = true)
	List<Object[]> summarizeMediaBySla10002AndSla10013Between(String projectCode, String dateFrom, String dateTo);
	
	//區域分析
	@Query(value = "select a.sla10002 projectCode,a.sla10003 projectName,a.sla10004 visitorType,a.itemCode,a.acc totalCount,if(isnull(thisWeek),0,b.thisWeek) weeklyCount from "
			+ "(select sla10002,sla10003,sla10004,sla10016 itemCode,count(1) acc from sla10  group by sla10002,sla10004,sla10016) a "
			+ "left join (select sla10002,sla10003,sla10004,sla10016 itemCode,count(1) thisWeek from sla10 where sla10013 between ?2 and ?3 group by sla10002,sla10004,sla10016) b " 
			+ "on a.sla10002=b.sla10002 and a.sla10004=b.sla10004 and a.itemCode=b.itemCode "
			+ "where a.sla10002=?1 "
			+ "order by 3,4", nativeQuery = true)
	List<Object[]> sumAreaBySla10002AndSla10013Between(String projectCode, String dateFrom, String dateTo);
	
	//職業分析
	@Query(value = "select a.sla10002 projectCode,a.sla10003 projectName,a.sla10004 visitorType,a.itemCode,a.acc totalCount,if(isnull(thisWeek),0,b.thisWeek) weeklyCount from "
			+ "(select sla10002,sla10003,sla10004,sla10018 itemCode,count(1) acc from sla10  group by sla10002,sla10004,sla10018) a "
			+ "left join (select sla10002,sla10003,sla10004,sla10018 itemCode,count(1) thisWeek from sla10 where sla10013 between ?2 and ?3 group by sla10002,sla10004,sla10018) b " 
			+ "on a.sla10002=b.sla10002 and a.sla10004=b.sla10004 and a.itemCode=b.itemCode "
			+ "where a.sla10002=?1 "
			+ "order by 3,4", nativeQuery = true)
	List<Object[]> sumCareerBySla10002AndSla10013Between(String projectCode, String dateFrom, String dateTo);
	
	//購買動機分析
	@Query(value = "select a.sla10002 projectCode,a.sla10003 projectName,a.sla10004 visitorType,a.itemCode,a.acc totalCount,if(isnull(thisWeek),0,b.thisWeek) weeklyCount from "
			+ "(select sla10002,sla10003,sla10004,sla10020 itemCode,count(1) acc from sla10  group by sla10002,sla10004,sla10020) a "
			+ "left join (select sla10002,sla10003,sla10004,sla10020 itemCode,count(1) thisWeek from sla10 where sla10013 between ?2 and ?3 group by sla10002,sla10004,sla10020) b " 
			+ "on a.sla10002=b.sla10002 and a.sla10004=b.sla10004 and a.itemCode=b.itemCode "
			+ "where a.sla10002=?1 "
			+ "order by 3,4", nativeQuery = true)
	List<Object[]> sumMotivationBySla10002AndSla10013Between(String projectCode, String dateFrom, String dateTo);
	
	//年齡
	@Query(value = "select a.sla10002 projectCode,a.sla10003 projectName,a.sla10004 visitorType,a.itemCode,a.acc totalCount,if(isnull(thisWeek),0,b.thisWeek) weeklyCount from "
			+ "(select sla10002,sla10003,sla10004,sla10017 itemCode,count(1) acc from sla10  group by sla10002,sla10004,sla10017) a "
			+ "left join (select sla10002,sla10003,sla10004,sla10017 itemCode,count(1) thisWeek from sla10 where sla10013 between ?2 and ?3 group by sla10002,sla10004,sla10017) b " 
			+ "on a.sla10002=b.sla10002 and a.sla10004=b.sla10004 and a.itemCode=b.itemCode "
			+ "where a.sla10002=?1 "
			+ "order by 3,4", nativeQuery = true)
	List<Object[]> sumAgeBySla10002AndSla10013Between(String projectCode, String dateFrom, String dateTo);
	
	//尚未使用
	//get media statistics by SLA11
	//itemCode=媒體Code, totalCount=累計, thisWeek=本周
	@Query(value = "select t.sla10002 projectCode,t.sla10003 projectName,t.sla11003 visitorType,t.sla10023 itemCode,t.acc totalCount,if(isnull(thisWeek),0,w.thisWeek) weeklyCount " + 
			"from (select sla10002,sla10003,sla11003,sla10023,count(1) acc from sla10 a inner join sla11 b on a.id=b.sla11002 group by sla10002,sla11003,sla10023) t " + 
			"left join (select sla10002,sla10003,sla11003,sla10023,count(1) thisWeek from sla10 a inner join sla11 b on a.id=b.sla11002 where sla11004 between ?2 and ?3 group by sla10002,sla11003,sla10023) w " + 
			"on t.sla10002=w.sla10002 and t.sla11003=w.sla11003 " + 
			"where t.sla10002=?1", nativeQuery = true)
	List<Object[]> sumMediaBySla11(String projectCode, String dateFrom, String dateTo);
	
	
	//for 客戶資料圖表 :動機總數量---------------
	@Query(value = "SELECT sla10002,sla10020,count(1) FROM sla10 where sla10002=?1 group by sla10002,sla10020", nativeQuery = true)
	List<Object[]> countMotivationBySla10002(String projectCode);
	
	//for 客戶資料圖表 :來客量總數量---------------
	@Query(value = "SELECT sla10002,substr(sla10013,1,6),sla10013,count(1) FROM sla10 where sla10002=?1 group by sla10002,substr(sla10013,1,6)", nativeQuery = true)
	List<Object[]> countVisitorBySla10002(String projectCode);
	
	//for 客戶資料圖表 :位置總數---------------
	@Query(value = "SELECT sla10002,sla10016,count(1) FROM sla10 where sla10002=?1 group by sla10002,sla10016", nativeQuery = true)
	List<Object[]> countAreaBySla10002(String projectCode);

	//for 客戶資料圖表 :來源總數---------------
	@Query(value = "SELECT sla10002,sla10004,count(1) FROM sla10 where sla10002=?1 group by sla10002,sla10004", nativeQuery = true)
	List<Object[]> countVisitTypeBySla10002(String projectCode);
}
