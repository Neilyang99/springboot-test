package cn.enilu.flash.service.sales;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.enilu.flash.bean.entity.sales.Visitor;
import cn.enilu.flash.bean.vo.DictVo;
import cn.enilu.flash.bean.vo.sales.SalesVo;
import cn.enilu.flash.bean.vo.sales.VisitorReportVo;
import cn.enilu.flash.bean.vo.sales.VisitorSummaryVo;
import cn.enilu.flash.dao.sales.VisitorRepository;
import cn.enilu.flash.service.BaseService;
import cn.enilu.flash.service.system.impl.ConstantFactory;

@Service
public class VisitorService extends BaseService<Visitor,Long,VisitorRepository>{
	
	@Autowired
	private VisitorRepository visitorDao;
	
	public List<Visitor> findBySla10006(String name){
		System.out.println("find visitor name AVVVA -----------");
		return visitorDao.findBySla10006(name);
	}
	
	public List<Object[]> queryGridList(){
		return visitorDao.queryGridList();
	}
	
	public Visitor findByUID(Long id) {
		Optional<Visitor> sla10 = visitorDao.findById(id);
		
		return sla10.get();
	}
	
	/**
	 * 取得媒體匯總資料
	 * @param projectCode
	 * @param dateFrom
	 * @param dateTo
	 * @return
	 */
	public List<VisitorReportVo> summarizeMediaBySla10002AndSla10013Between(String projectCode, String dateFrom, String dateTo) {
		
		List<Object[]> objs = visitorDao.summarizeMediaBySla10002AndSla10013Between(projectCode, dateFrom, dateTo);
		
		//Transfer to value object
		List<VisitorSummaryVo> voList = this.objectArrayTransferToVo(objs);
		
		//get all media
		List<DictVo> dictList = ConstantFactory.me().findByDictName("媒體選項");
		
		List<VisitorReportVo> list = this.getStatistic(dictList,voList);
		
		return list;
	}
	
	/**
	 * 取得區域匯總資料
	 * @param projectCode
	 * @param dateFrom
	 * @param dateTo
	 * @return
	 */
	public List<VisitorReportVo> sumAreaBySla10002AndSla10013Between(String projectCode, String dateFrom, String dateTo) {
		
		//Get Data
		List<Object[]> objs = visitorDao.sumAreaBySla10002AndSla10013Between(projectCode, dateFrom, dateTo);
		
		//Transfer to value object
		List<VisitorSummaryVo> voList = this.objectArrayTransferToVo(objs);
		
		//get item list
		List<DictVo> dictList = ConstantFactory.me().findByDictName("區域選項");
		
		//get statistic
		List<VisitorReportVo> list = this.getStatistic(dictList, voList);
		
		return list;
	}
	
	/**
	 * 取得購買動機匯總資料
	 * @param projectCode
	 * @param dateFrom
	 * @param dateTo
	 * @return
	 */
	public List<VisitorReportVo> sumMotivationBySla10002AndSla10013Between(String projectCode, String dateFrom, String dateTo) {
		
		//Get Data
		List<Object[]> objs = visitorDao.sumMotivationBySla10002AndSla10013Between(projectCode, dateFrom, dateTo);
		
		//Transfer to value object
		List<VisitorSummaryVo> voList = this.objectArrayTransferToVo(objs);
		
		//get item list
		List<DictVo> dictList = ConstantFactory.me().findByDictName("購買用途選項");
		
		//get statistic
		List<VisitorReportVo> list = this.getStatistic(dictList, voList);
		
		return list;
	}
	
	/**
	 * 取得職業匯總資料
	 * @param projectCode
	 * @param dateFrom
	 * @param dateTo
	 * @return
	 */
	public List<VisitorReportVo> sumCareerBySla10002AndSla10013Between(String projectCode, String dateFrom, String dateTo) {
		
		//Get Data
		List<Object[]> objs = visitorDao.sumCareerBySla10002AndSla10013Between(projectCode, dateFrom, dateTo);
		
		//Transfer to value object
		List<VisitorSummaryVo> voList = this.objectArrayTransferToVo(objs);
		
		//get item list
		List<DictVo> dictList = ConstantFactory.me().findByDictName("職業選項");
		
		//get statistic
		List<VisitorReportVo> list = this.getStatistic(dictList, voList);
		
		return list;
	}
	
	/**
	 * 取得年齡匯總資料
	 * @param projectCode
	 * @param dateFrom
	 * @param dateTo
	 * @return
	 */
	public List<VisitorReportVo> sumAgeBySla10002AndSla10013Between(String projectCode, String dateFrom, String dateTo) {
		
		//Get Data
		List<Object[]> objs = visitorDao.sumAgeBySla10002AndSla10013Between(projectCode, dateFrom, dateTo);
		
		//Transfer to value object
		List<VisitorSummaryVo> voList = this.objectArrayTransferToVo(objs);
		
		//get item list
		List<DictVo> dictList = ConstantFactory.me().findByDictName("年齡選項");
		
		//get statistic
		List<VisitorReportVo> list = this.getStatistic(dictList, voList);
		
		return list;
	}
	
	
	//物件陣列轉換為value object
	private List<VisitorSummaryVo> objectArrayTransferToVo(List<Object[]> objs){
		
		ArrayList<VisitorSummaryVo> voList = new ArrayList<VisitorSummaryVo>();
		
		for(Object[] ary : objs) {
			VisitorSummaryVo vo = new VisitorSummaryVo();
			vo.setProjectCode((String)ary[0]);
			vo.setProjectName((String)ary[1]);
			vo.setVisitorType((String)ary[2]);
			vo.setItemCode((String)ary[3]);
			vo.setTotalCount(((BigInteger) ary[4]).intValue());
			vo.setWeeklyCount(((BigInteger) ary[5]).intValue());
			
			voList.add(vo);
		}
		
		return voList;
	}
	
	/**
	 * 取得統計數據
	 * @param dictList : item List 
	 * @param voList :summary data of this week and accumulate data
	 * @return
	 */
	private List<VisitorReportVo> getStatistic(List<DictVo> dictList,List<VisitorSummaryVo> voList){
		
		//VisitorSummaryVo=[銷售案Code,銷售案名稱,來人/來電,媒體Code,累積組數,本週組數]
		ArrayList<VisitorReportVo> list = new ArrayList<VisitorReportVo>();
		
		//visitor hash map <media id, value>
		HashMap<String, String> hmpVisitor = new HashMap<String, String>();
		HashMap<String, String> hmpTel = new HashMap<String, String>();
		int ttWeeklyByVisitor = 0;
		int ttAccByVisitor = 0;
		int ttWeeklyByTel = 0;
		int ttAccByTel = 0;
		
		for(VisitorSummaryVo vo : voList) {
			if(vo.getVisitorType().equals("A")) {//來人
				hmpVisitor.put(vo.getItemCode(), vo.getWeeklyCount()+"<>"+vo.getTotalCount());
				ttWeeklyByVisitor += vo.getWeeklyCount();
				ttAccByVisitor += vo.getTotalCount();
			}else if(vo.getVisitorType().equals("B")) {//來電				
				hmpTel.put(vo.getItemCode(), vo.getWeeklyCount()+"<>"+vo.getTotalCount());
				ttWeeklyByTel += vo.getWeeklyCount();
				ttAccByTel += vo.getTotalCount();
			}
		}
		
		String pjCode = "";
		String pjName = "";
		if(voList.size() > 0) {
			pjCode = voList.get(0).getProjectCode();
			pjName = voList.get(0).getProjectName();
		}
		for(DictVo dict : dictList) {
			VisitorReportVo vo = new VisitorReportVo();
			
			String[] cnt = new String[2];//[0]=本週組數 ,[1]=累週組數
			String[] cnt2 = new String[2];//[0]=本週組數 ,[1]=累週組數
			if(hmpVisitor.get(dict.getKey()) != null) {
				cnt = hmpVisitor.get(dict.getKey()).split("<>");
			}
			if(hmpTel.get(dict.getKey()) != null) {
				cnt2 = hmpTel.get(dict.getKey()).split("<>");
			}
			if(cnt[0] == null) {
				cnt[0] = "0";
			}
			if(cnt[1] == null) {
				cnt[1] = "0";
			}
			if(cnt2[0] == null) {
				cnt2[0] = "0";
			}
			if(cnt2[1] == null) {
				cnt2[1] = "0";
			}
			
			double percent = 0;//來人本週%
			double percent2 = 0;//來人累週%
			double percent3 = 0;//來電本週%
			double percent4 = 0;//來電累週%
			if(ttWeeklyByVisitor > 0) {
				percent = (double)(Math.round((double)Integer.parseInt(cnt[0])/ttWeeklyByVisitor*1000))/10;//% 取小數1位
			}
			if(ttAccByVisitor > 0) {
				percent2 = (double)(Math.round((double)Integer.parseInt(cnt[1])/ttAccByVisitor*1000))/10;//% 取小數1位
			}
			if(ttWeeklyByTel > 0) {
				percent3 = (double)(Math.round((double)Integer.parseInt(cnt2[0])/ttWeeklyByTel*1000))/10;//% 取小數1位
			}
			if(ttAccByTel > 0) {
				percent4 = (double)(Math.round((double)Integer.parseInt(cnt2[1])/ttAccByTel*1000))/10;//% 取小數1位
			}
			
			vo.setProjectCode(pjCode);
			vo.setProjectName(pjName);
			vo.setItemName(dict.getValue());
			vo.setCountWeeklyByVisitor(Integer.parseInt(cnt[0]));
			vo.setCountAccByVisitor(Integer.parseInt(cnt[1]));
			vo.setCountPercentByVisitor(percent);
			vo.setCountAccPercentByVisitor(percent2);
			vo.setCountWeeklyByTel(Integer.parseInt(cnt[0]));
			vo.setCountAccByTel(Integer.parseInt(cnt[1]));
			vo.setCountPercentByTel(percent3);
			vo.setCountAccPercentByTel(percent4);
			
			list.add(vo);
		}
		
		//加入total
		if(list.size() > 0) {
			VisitorReportVo vo = new VisitorReportVo();
			
			vo.setProjectCode(pjCode);
			vo.setProjectName(pjName);
			vo.setItemName("TOTAL");
			vo.setCountWeeklyByVisitor(ttWeeklyByVisitor);
			vo.setCountAccByVisitor(ttAccByVisitor);
			vo.setCountPercentByVisitor(100.0);
			vo.setCountAccPercentByVisitor(100.0);
			vo.setCountWeeklyByTel(ttWeeklyByTel);
			vo.setCountAccByTel(ttAccByTel);
			vo.setCountPercentByTel(100.0);
			vo.setCountAccPercentByTel(100.0);
			
			list.add(vo);
		}
		
		
		return list;
	}
	
	
	/**
	 * 取得動機總數量
	 * @param projectCode
	 * @return
	 */
	public List<SalesVo> countMotivationBySla10002(String projectCode) {
		
		List<SalesVo> list = new ArrayList<SalesVo>();
		HashMap<String, String> mp = new HashMap<String, String>();
		List<DictVo> dictList = ConstantFactory.me().findByDictName("購買用途選項");
		for(DictVo vo : dictList) {
    		mp.put(vo.getKey(), vo.getValue());
    	}
		
		//Get Data
		List<Object[]> objs = visitorDao.countMotivationBySla10002(projectCode);
		
		for(Object[] ary : objs) {
			SalesVo vo = new SalesVo();
			String name = mp.get(""+ary[1]);
			vo.setKey((""+ary[1])==null || (""+ary[1]).isEmpty()?"":(""+ary[1]));//項目
			vo.setValue(""+ary[2]);//筆數
			vo.setName(name==null || name.isEmpty()?"N/A":name);//項目名稱
			
			list.add(vo);
		}
		
		return list;
		
	}
	
	/**
	 * 取得來客人數
	 * @param projectCode
	 * @return
	 */
	public List<SalesVo> countVisitorBySla10002(String projectCode) {
		
		List<SalesVo> list = new ArrayList<SalesVo>();
		
		//Get Data
		List<Object[]> objs = visitorDao.countVisitorBySla10002(projectCode);
		
		for(Object[] ary : objs) {
			SalesVo vo = new SalesVo();
			String value = ""+ary[1];
			
			vo.setKey(value==null || value.length()==0?"N/A":value);//年月
			vo.setValue(""+ary[3]);//筆數
			
			list.add(vo);
		}
		
		return list;
		
	}
	
	/**
	 * 取得區域人數
	 * @param projectCode
	 * @return
	 */
	public List<SalesVo> countAreaBySla10002(String projectCode) {
		
		List<SalesVo> list = new ArrayList<SalesVo>();
		HashMap<String, String> mp = new HashMap<String, String>();
		List<DictVo> dictList = ConstantFactory.me().findByDictName("區域選項");
		for(DictVo vo : dictList) {
    		mp.put(vo.getKey(), vo.getValue());
    	}
		
		//Get Data
		List<Object[]> objs = visitorDao.countAreaBySla10002(projectCode);
		
		for(Object[] ary : objs) {
			SalesVo vo = new SalesVo();
			String value = ""+ary[1];
			String name = mp.get(value);
			
			vo.setKey(value==null || value.length()==0?"N/A":value);//區域
			vo.setValue(""+ary[2]);//筆數
			vo.setName(name==null || name.isEmpty()?"N/A":name);//項目名稱
			
			list.add(vo);
		}
		
		return list;
		
	}
	/**
	 * 取得來源人數
	 * @param projectCode
	 * @return
	 */
	public List<SalesVo> countVisitTypeBySla10002(String projectCode) {
		
		List<SalesVo> list = new ArrayList<SalesVo>();
		HashMap<String, String> mp = new HashMap<String, String>();
		List<DictVo> dictList = ConstantFactory.me().findByDictName("來人來電");
		for(DictVo vo : dictList) {
    		mp.put(vo.getKey(), vo.getValue());
    	}
		
		//Get Data
		List<Object[]> objs = visitorDao.countVisitTypeBySla10002(projectCode);
		
		for(Object[] ary : objs) {
			SalesVo vo = new SalesVo();
			String value = ""+ary[1];
			String name = mp.get(value);
			
			vo.setKey(value==null || value.length()==0?"N/A":value);//來人/來電
			vo.setValue(""+ary[2]);//筆數
			vo.setName(name==null || name.isEmpty()?"N/A":name);//項目名稱
			
			list.add(vo);
		}
		
		return list;
		
	}
}
