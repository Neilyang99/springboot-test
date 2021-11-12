package cn.enilu.flash.service.sales;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.enilu.flash.bean.entity.sales.Visitor;
import cn.enilu.flash.bean.vo.DictVo;
import cn.enilu.flash.bean.vo.sales.NotDealAgainVo;
import cn.enilu.flash.bean.vo.sales.OrderCauseVo;
import cn.enilu.flash.bean.vo.sales.SaleStatusVo;
import cn.enilu.flash.bean.vo.sales.SalesVo;
import cn.enilu.flash.bean.vo.sales.VisitorReportVo;
import cn.enilu.flash.bean.vo.sales.VisitorSummaryVo;
import cn.enilu.flash.bean.vo.sales.houseTypeVo;
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
	
	public List<Object[]> queryGridList(String projectName, String name, String cellPhone, String tel){
		return visitorDao.queryGridList(projectName,name,cellPhone,tel);
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
			double percent5 = 0;//回籠本週%
			double percent6 = 0;//回籠累週%
			double percent7 = 0;//已購本週%
			double percent8 = 0;//已購累週%
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
			//TODO:
			vo.setCountWeeklyByAgain(0);
			vo.setCountPercentByAgain(percent5);
			vo.setCountAccByAgain(0);
			vo.setCountAccPercentByAgain(percent6);
			vo.setCountWeeklyByOrder(0);
			vo.setCountPercentByOrder(percent7);
			vo.setCountAccByOrder(0);
			vo.setCountAccPercentByOrder(percent8);
			
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
			
			//TODO:
			vo.setCountWeeklyByAgain(0);
			vo.setCountPercentByAgain(0.0);
			vo.setCountAccByAgain(0);
			vo.setCountAccPercentByAgain(0.0);
			vo.setCountWeeklyByOrder(0);
			vo.setCountPercentByOrder(0.0);
			vo.setCountAccByOrder(0);
			vo.setCountAccPercentByOrder(0.0);
			
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
	 * @param type=year/quarter/month
	 * @return
	 */
	public List<SalesVo> countVisitorBySla10002(String projectCode,String type) {
		
		List<SalesVo> list = new ArrayList<SalesVo>();
		
		//Get Data
		List<Object[]> objs = null;
		if(type.equals("year")) {
			objs = visitorDao.countVisitorBySla10002AndYear(projectCode);
		}else if(type.equals("quarter")) {
			objs = visitorDao.countVisitorBySla10002AndQuarter(projectCode);
		}else {
			objs = visitorDao.countVisitorBySla10002(projectCode);
		}
		
		for(Object[] ary : objs) {
			SalesVo vo = new SalesVo();
			String value = ""+ary[2];
			
			vo.setKey(value==null || value.length()==0?"N/A":value);// 年/月/季
			vo.setValue(""+ary[1]);//筆數
			
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
	
	/**
	 * 已購原因分析
	 * @return
	 */
	public List<OrderCauseVo> orderCause(Long projectId, String dateFrom, String dateTo) {
		
		ArrayList<OrderCauseVo> voList = new ArrayList<OrderCauseVo>();
		HashMap<String, Integer> mpWeekly = new HashMap<String, Integer>();
		HashMap<String, Integer> mpAcc = new HashMap<String, Integer>();
		HashMap<String, Integer> mpAll = new HashMap<String, Integer>();
		
		HashMap<String, String> mp = new HashMap<String, String>();
		List<DictVo> dictList = ConstantFactory.me().findByDictName("已購原因選項");
		for(DictVo vo : dictList) {
    		mp.put(vo.getKey(), vo.getValue());
    	}
		
		//Get Data
		List<Object[]> objWeekly = visitorDao.orderCauseBySla10002(projectId, dateFrom, dateTo);
		List<Object[]> objAccBeforeWeek = visitorDao.orderCauseAccBySla10002(projectId, dateFrom);
		int total = 0;
		for(Object[] ary : objWeekly) {
			int qty = 0;
			if(ary[1] != null) {
				qty = Integer.parseInt(""+ary[1]);
			}
			mpWeekly.put(""+ary[0], qty);
			mpAll.put(""+ary[0], 1);
			total = total + qty;
		}
		for(Object[] ary : objAccBeforeWeek) {
			int qty = 0;
			if(ary[1] != null) {
				qty = Integer.parseInt(""+ary[1]);
			}
			mpAcc.put(""+ary[0], qty);
			mpAll.put(""+ary[0], 1);
			total = total + qty;
		}
		
		for (Entry<String, Integer> entry : mpAll.entrySet()) {
			
			OrderCauseVo vo = new OrderCauseVo();
			
			String code = entry.getKey();
			int weekly = mpWeekly.get(code)== null ? 0:mpWeekly.get(code);
			int acc = mpAcc.get(code)== null ? 0:mpAcc.get(code);
			double pec = ((double)(weekly+acc)/total)*100;
			
			vo.setItemCode(code);
			vo.setItemName(mp.get(code));
			vo.setCount1(weekly);
			vo.setCount2(acc);
			vo.setCount3(weekly+acc);
			vo.setCount4(pec);
			
			voList.add(vo);
			
		}
		
		
				
		return voList;
	}
	
	/**
	 * 回籠未交易分析
	 * @param projectCode
	 * @return
	 */
	public List<NotDealAgainVo> notDealAgain(String projectCode) {
		
		ArrayList<NotDealAgainVo> voList = new ArrayList<NotDealAgainVo>();
		
		HashMap<String, String> mp = new HashMap<String, String>();
		List<DictVo> dictList = ConstantFactory.me().findByDictName("未購原因選項");
		for(DictVo vo : dictList) {
    		mp.put(vo.getKey(), vo.getValue());
    	}
		//Get Data
		List<Object[]> obj = visitorDao.notDealAgainBySla10002(projectCode);
		for(Object[] ary : obj) {
			NotDealAgainVo vo = new NotDealAgainVo();
			vo.setOccurDate((String)ary[0]);
			vo.setCustomerName((String)ary[1]);
			vo.setHouseNo((String)ary[2]);
			vo.setCauseName(mp.get(ary[3]));
			vo.setSalesName((String)ary[4]);
			
			voList.add(vo);
		}
				
				
		return voList;
	}
	
	/**
	 * 格局去化分析
	 * @param projectId
	 * @return
	 */
	public List<houseTypeVo> houseType(Long projectId) {
		
		List<houseTypeVo> list = new ArrayList<houseTypeVo>();
		HashMap<String, String> mpHouse = new HashMap<String, String>();
		HashMap<String, String> mpRoom = new HashMap<String, String>();
		List<DictVo> dictList = ConstantFactory.me().findByDictName("屋型");
		List<DictVo> dictListRoom = ConstantFactory.me().findByDictName("格局");
		for(DictVo vo : dictList) {
			mpHouse.put(vo.getKey(), vo.getValue());
    	}
		for(DictVo vo : dictListRoom) {
			mpRoom.put(vo.getKey(), vo.getValue());
    	}
		
		//Get Data
		List<Object[]> objs = visitorDao.houseTypeBySla01002(projectId);
		
		int tt1=0;
		int tt2=0;
		int tt3=0;
		int tt4=0;
		int tt5=0;
		int tt6=0;
		
		for(Object[] ary : objs) {
			houseTypeVo vo = new houseTypeVo();
			String name = "";
			String[] houseType;
			if(ary[0] != null) {
				houseType = ((String) ary[0]).split("_");
				if(houseType[0].equals("A") || houseType[0].equals("B") || houseType[0].equals("C")) {
					name = mpHouse.get(houseType[0]);
				}else {
					name = mpRoom.get(houseType[1]);
				}
			}
			vo.setHouseType(name);
			vo.setPlanQty(Integer.parseInt(""+ary[1]));
			vo.setRemainQty(Integer.parseInt(""+ary[1]));//TODO
			
			list.add(vo);
			
			tt1 = tt1 + Integer.parseInt(""+ary[1]);
			tt6 = tt1;//TODO
			
		}
		//total
		houseTypeVo vo = new houseTypeVo();
		vo.setHouseType("總計");
		vo.setPlanQty(tt1);
		vo.setWeeklyQty(tt2);
		vo.setAccQty(tt3);
		vo.setWeeklyCancelQty(tt4);
		vo.setWeeklyCancelAccQty(tt5);
		vo.setRemainQty(tt6);
		
		list.add(vo);
		
		return list;
	}
	
	/**
	 * 銷況表
	 * @param projectId
	 * @return
	 */
	public SaleStatusVo SaleStatusReport(Long projectId) {
		SaleStatusVo vo = new SaleStatusVo();
		
		//Get Data
		Object[] obj = visitorDao.projectStatusById(projectId).get(0);//0=底價總銷 1=表價總銷 2=總戶數 3=售出戶數
		int remainQty = (Integer.parseInt(""+obj[2]) - Integer.parseInt(""+obj[3]));
		int soldQty = Integer.parseInt(""+obj[3]);
		
		vo.setTotalAmt_under(Integer.parseInt(""+obj[0]));
		vo.setTotalAmt_form(Integer.parseInt(""+obj[1]));
		vo.setSoldQty(soldQty);
		vo.setRemainQty(remainQty);
		
		//TODO
		vo.setWeeklySoldAmt(0);
		vo.setWeeklyCancelAmt(0);
		vo.setWeeklyChangeAmt(0);
		vo.setWeeklyDealAmt(0);
		vo.setWeeklyOrderAmt(0);
		vo.setWeeklyCancelQty(0);
		vo.setWeeklyChangeQty(0);
		vo.setWeeklyDealQty(0);
		vo.setWeeklyOrderQty(0);
		vo.setWeeklySoldQty(0);
		
		vo.setAccSoldAmt(soldQty*6500000);
		vo.setAccSoldQty(soldQty);
		vo.setAccDealQty(soldQty);
		vo.setAccDealAmt(vo.getAccDealQty()*6500000);
		vo.setAccOrderQty(vo.getAccDealQty());
		vo.setAccOrderAmt(vo.getAccDealAmt());
		vo.setAccCancelAmt(0);
		vo.setAccCancelQty(0);
		vo.setAccChangeAmt(0);
		vo.setAccChangeQty(0);
		
		return vo;
	}
}
