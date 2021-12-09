package cn.enilu.flash.service.sales;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
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
import cn.enilu.flash.bean.vo.sales.WeeklyReportVo;
import cn.enilu.flash.bean.vo.sales.houseTypeVo;
import cn.enilu.flash.dao.sales.VisitorRepository;
import cn.enilu.flash.service.BaseService;
import cn.enilu.flash.service.system.impl.ConstantFactory;
import cn.enilu.flash.utils.DateUtil;

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
	 * 取得年齡總數量
	 * @param projectCode
	 * @return
	 */
	public List<SalesVo> countAgeBySla10002(String projectCode) {
		
		List<SalesVo> list = new ArrayList<SalesVo>();
		HashMap<String, String> mp = new HashMap<String, String>();
		List<DictVo> dictList = ConstantFactory.me().findByDictName("年齡選項");
		for(DictVo vo : dictList) {
    		mp.put(vo.getKey(), vo.getValue());
    	}
		
		//Get Data
		List<Object[]> objs = visitorDao.countAgeBySla10002(projectCode);
		
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
		}else if(type.equals("week")) {	
			objs = visitorDao.countVisitorBySla10002AndWeek(projectCode);
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
	
	public WeeklyReportVo WeeklyReport(Long projectId, String projectCode) {
		List<WeeklyReportVo> list = new ArrayList<WeeklyReportVo>();
		WeeklyReportVo vo = new WeeklyReportVo();
		
		//first Day = Monday
		Date monday = DateUtil.getThisWeekMonday(new Date());//Monday in this week
		Date tue = DateUtil.getDateAfterDays(monday, "1");
		Date wed = DateUtil.getDateAfterDays(monday, "2");
		Date thu = DateUtil.getDateAfterDays(monday, "3");
		Date fri = DateUtil.getDateAfterDays(monday, "4");
		Date sat = DateUtil.getDateAfterDays(monday, "5");
		Date sunday = DateUtil.getDateAfterDays(monday, "6");//Sunday in this week
		
		String mondayStr = DateUtil.formatDate(monday, "yyyyMMdd");
		String tueStr = DateUtil.formatDate(tue, "yyyyMMdd");
		String wedStr = DateUtil.formatDate(wed, "yyyyMMdd");
		String thuStr = DateUtil.formatDate(thu, "yyyyMMdd");
		String friStr = DateUtil.formatDate(fri, "yyyyMMdd");
		String satStr = DateUtil.formatDate(sat, "yyyyMMdd");
		String sundayStr = DateUtil.formatDate(sunday, "yyyyMMdd");
		
		String mondayMD = DateUtil.formatDate(monday, "MM/dd");
		String tueMD = DateUtil.formatDate(tue, "MM/dd");
		String wedMD = DateUtil.formatDate(wed, "MM/dd");
		String thuMD = DateUtil.formatDate(thu, "MM/dd");
		String friMD = DateUtil.formatDate(fri, "MM/dd");
		String satMD = DateUtil.formatDate(sat, "MM/dd");
		String sundayMD = DateUtil.formatDate(sunday, "MM/dd");
		
		
		//Get Data
		Object[] obj = visitorDao.projectStatusById(projectId).get(0);//0=底價總銷 1=表價總銷 2=總戶數 3=售出戶數 4=可售汽車
		Object[] obj_actual = visitorDao.actualSalesByProjectId(projectId).get(0);//0=實際銷售戶數, 1=金額
		//List<Object[]> obj_customer = visitorDao.customerByProject(projectCode, mondayStr);//[0=A來人,1=上周累計],[0=B來電,1=上周累計]
		//Object[] obj_customerAgain = visitorDao.customerAgainByProject(projectCode, mondayStr).get(0);//上周累計回籠數
		
		
		vo.setPeriod(mondayMD+" ~ "+sundayMD);
		vo.setTotalHouse(Integer.parseInt(""+obj[2]));
		vo.setTotalAmt(Integer.parseInt(""+obj[1]));
		vo.setTotalCar(Integer.parseInt(""+obj[4]));
		vo.setTotalCarAmt(0);//TODO
		vo.setActualHouse(Integer.parseInt(""+obj_actual[0]));
		vo.setActualAmt(Integer.parseInt(""+obj_actual[1]));
		
		//--1-------------
		vo.setDate1(mondayMD);	
		int[] data = this.transferData(projectId, projectCode, mondayStr, 1);
		vo.setPersonCnt1(data[0]);
		vo.setTelCnt1(data[1]);
		vo.setAgainCnt1(data[2]);
		
		vo.setDealHouse1(data[3]);
		vo.setDealAmt1(data[4]);
		vo.setDealCar1(data[5]);
		vo.setDealCarAmt1(data[6]);
		
		vo.setDepositHouse1(data[7]);
		vo.setDepositAmt1(data[8]);
		vo.setDepositCar1(data[9]);
		vo.setDepositCarAmt1(data[10]);	

		vo.setFillHouse1(data[11]);
		vo.setFillAmt1(data[12]);
		vo.setFillCar1(data[13]);
		vo.setFillCarAmt1(data[14]);
		
		vo.setOrderHouse1(data[15]);
		vo.setOrderAmt1(data[16]);
		vo.setOrderCar1(data[17]);
		vo.setOrderCarAmt1(data[18]);

		vo.setCancelHouse1(data[19]);
		vo.setCancelAmt1(data[20]);
		vo.setCancelCar1(data[21]);
		vo.setCancelCarAmt1(data[22]);
		//--2-------------
		vo.setDate2(tueMD);	
		data = this.transferData(projectId, projectCode, tueStr, 1);
		vo.setPersonCnt2(data[0]);
		vo.setTelCnt2(data[1]);
		vo.setAgainCnt2(data[2]);
		
		vo.setDealHouse2(data[3]);
		vo.setDealAmt2(data[4]);
		vo.setDealCar2(data[5]);
		vo.setDealCarAmt2(data[6]);
		
		vo.setDepositHouse2(data[7]);
		vo.setDepositAmt2(data[8]);
		vo.setDepositCar2(data[9]);
		vo.setDepositCarAmt2(data[10]);	

		vo.setFillHouse2(data[11]);
		vo.setFillAmt2(data[12]);
		vo.setFillCar2(data[13]);
		vo.setFillCarAmt2(data[14]);
		
		vo.setOrderHouse2(data[15]);
		vo.setOrderAmt2(data[16]);
		vo.setOrderCar2(data[17]);
		vo.setOrderCarAmt2(data[18]);

		vo.setCancelHouse2(data[19]);
		vo.setCancelAmt2(data[20]);
		vo.setCancelCar2(data[21]);
		vo.setCancelCarAmt2(data[22]);
		//--3-------------
		vo.setDate3(wedMD);	
		data = this.transferData(projectId, projectCode, wedStr, 1);
		vo.setPersonCnt3(data[0]);
		vo.setTelCnt3(data[1]);
		vo.setAgainCnt3(data[2]);
		
		vo.setDealHouse3(data[3]);
		vo.setDealAmt3(data[4]);
		vo.setDealCar3(data[5]);
		vo.setDealCarAmt3(data[6]);
		
		vo.setDepositHouse3(data[7]);
		vo.setDepositAmt3(data[8]);
		vo.setDepositCar3(data[9]);
		vo.setDepositCarAmt3(data[10]);	

		vo.setFillHouse3(data[11]);
		vo.setFillAmt3(data[12]);
		vo.setFillCar3(data[13]);
		vo.setFillCarAmt3(data[14]);
		
		vo.setOrderHouse3(data[15]);
		vo.setOrderAmt3(data[16]);
		vo.setOrderCar3(data[17]);
		vo.setOrderCarAmt3(data[18]);

		vo.setCancelHouse3(data[19]);
		vo.setCancelAmt3(data[20]);
		vo.setCancelCar3(data[21]);
		vo.setCancelCarAmt3(data[22]);
		//--4-------------
		vo.setDate4(thuMD);	
		data = this.transferData(projectId, projectCode, thuStr, 1);
		vo.setPersonCnt4(data[0]);
		vo.setTelCnt4(data[1]);
		vo.setAgainCnt4(data[2]);
		
		vo.setDealHouse4(data[3]);
		vo.setDealAmt4(data[4]);
		vo.setDealCar4(data[5]);
		vo.setDealCarAmt4(data[6]);
		
		vo.setDepositHouse4(data[7]);
		vo.setDepositAmt4(data[8]);
		vo.setDepositCar4(data[9]);
		vo.setDepositCarAmt4(data[10]);	

		vo.setFillHouse4(data[11]);
		vo.setFillAmt4(data[12]);
		vo.setFillCar4(data[13]);
		vo.setFillCarAmt4(data[14]);
		
		vo.setOrderHouse4(data[15]);
		vo.setOrderAmt4(data[16]);
		vo.setOrderCar4(data[17]);
		vo.setOrderCarAmt4(data[18]);

		vo.setCancelHouse4(data[19]);
		vo.setCancelAmt4(data[20]);
		vo.setCancelCar4(data[21]);
		vo.setCancelCarAmt4(data[22]);
		//--5-------------
		vo.setDate5(friMD);	
		data = this.transferData(projectId, projectCode, friStr, 1);
		vo.setPersonCnt5(data[0]);
		vo.setTelCnt5(data[1]);
		vo.setAgainCnt5(data[2]);
		
		vo.setDealHouse5(data[3]);
		vo.setDealAmt5(data[4]);
		vo.setDealCar5(data[5]);
		vo.setDealCarAmt5(data[6]);
		
		vo.setDepositHouse5(data[7]);
		vo.setDepositAmt5(data[8]);
		vo.setDepositCar5(data[9]);
		vo.setDepositCarAmt5(data[10]);	

		vo.setFillHouse5(data[11]);
		vo.setFillAmt5(data[12]);
		vo.setFillCar5(data[13]);
		vo.setFillCarAmt5(data[14]);
		
		vo.setOrderHouse5(data[15]);
		vo.setOrderAmt5(data[16]);
		vo.setOrderCar5(data[17]);
		vo.setOrderCarAmt5(data[18]);

		vo.setCancelHouse5(data[19]);
		vo.setCancelAmt5(data[20]);
		vo.setCancelCar5(data[21]);
		vo.setCancelCarAmt5(data[22]);
		//--6-------------
		vo.setDate6(satMD);	
		data = this.transferData(projectId, projectCode, satStr, 1);
		vo.setPersonCnt6(data[0]);
		vo.setTelCnt6(data[1]);
		vo.setAgainCnt6(data[2]);
		
		vo.setDealHouse6(data[3]);
		vo.setDealAmt6(data[4]);
		vo.setDealCar6(data[5]);
		vo.setDealCarAmt6(data[6]);
		
		vo.setDepositHouse6(data[7]);
		vo.setDepositAmt6(data[8]);
		vo.setDepositCar6(data[9]);
		vo.setDepositCarAmt6(data[10]);	

		vo.setFillHouse6(data[11]);
		vo.setFillAmt6(data[12]);
		vo.setFillCar6(data[13]);
		vo.setFillCarAmt6(data[14]);
		
		vo.setOrderHouse6(data[15]);
		vo.setOrderAmt6(data[16]);
		vo.setOrderCar6(data[17]);
		vo.setOrderCarAmt6(data[18]);

		vo.setCancelHouse6(data[19]);
		vo.setCancelAmt6(data[20]);
		vo.setCancelCar6(data[21]);
		vo.setCancelCarAmt6(data[22]);
		//--7-------------
		vo.setDate7(sundayMD);	
		data = this.transferData(projectId, projectCode, sundayStr, 1);
		vo.setPersonCnt7(data[0]);
		vo.setTelCnt7(data[1]);
		vo.setAgainCnt7(data[2]);
		
		vo.setDealHouse7(data[3]);
		vo.setDealAmt7(data[4]);
		vo.setDealCar7(data[5]);
		vo.setDealCarAmt7(data[6]);
		
		vo.setDepositHouse7(data[7]);
		vo.setDepositAmt7(data[8]);
		vo.setDepositCar7(data[9]);
		vo.setDepositCarAmt7(data[10]);	

		vo.setFillHouse7(data[11]);
		vo.setFillAmt7(data[12]);
		vo.setFillCar7(data[13]);
		vo.setFillCarAmt7(data[14]);
		
		vo.setOrderHouse7(data[15]);
		vo.setOrderAmt7(data[16]);
		vo.setOrderCar7(data[17]);
		vo.setOrderCarAmt7(data[18]);

		vo.setCancelHouse7(data[19]);
		vo.setCancelAmt7(data[20]);
		vo.setCancelCar7(data[21]);
		vo.setCancelCarAmt7(data[22]);
		//--本週累計-------------
		vo.setPersonCntWeek(vo.getPersonCnt1()+vo.getPersonCnt2()+vo.getPersonCnt3()+vo.getPersonCnt4()+vo.getPersonCnt5()+vo.getPersonCnt6()+vo.getPersonCnt7());
		vo.setTelCntWeek(vo.getTelCnt1()+vo.getTelCnt2()+vo.getTelCnt3()+vo.getTelCnt4()+vo.getTelCnt5()+vo.getTelCnt6()+vo.getTelCnt7());
		vo.setAgainCntWeek(vo.getAgainCnt1()+vo.getAgainCnt2()+vo.getAgainCnt3()+vo.getAgainCnt4()+vo.getAgainCnt5()+vo.getAgainCnt6()+vo.getAgainCnt7());
		
		vo.setDealHouseWeek(vo.getDealHouse1()+vo.getDealHouse2()+vo.getDealHouse3()+vo.getDealHouse4()+vo.getDealHouse5()+vo.getDealHouse6()+vo.getDealHouse7());
		vo.setDealAmtWeek(vo.getDealAmt1()+vo.getDealAmt2()+vo.getDealAmt3()+vo.getDealAmt4()+vo.getDealAmt5()+vo.getDealAmt6()+vo.getDealAmt7());
		vo.setDealCarWeek(vo.getDealCar1()+vo.getDealCar2()+vo.getDealCar3()+vo.getDealCar4()+vo.getDealCar5()+vo.getDealCar6()+vo.getDealCar7());
		vo.setDealCarAmtWeek(vo.getDealCarAmt1()+vo.getDealCarAmt2()+vo.getDealCarAmt3()+vo.getDealCarAmt4()+vo.getDealCarAmt5()+vo.getDealCarAmt6()+vo.getDealCarAmt7());
		
		vo.setDepositHouseWeek(vo.getDepositHouse1()+vo.getDepositHouse2()+vo.getDepositHouse3()+vo.getDepositHouse4()+vo.getDepositHouse5()+vo.getDepositHouse6()+vo.getDepositHouse7());
		vo.setDepositAmtWeek(vo.getDepositAmt1()+vo.getDepositAmt2()+vo.getDepositAmt3()+vo.getDepositAmt4()+vo.getDepositAmt5()+vo.getDepositAmt6()+vo.getDepositAmt7());
		vo.setDepositCarWeek(vo.getDepositCar1()+vo.getDepositCar2()+vo.getDepositCar3()+vo.getDepositCar4()+vo.getDepositCar5()+vo.getDepositCar6()+vo.getDepositCar7());
		vo.setDepositCarAmtWeek(vo.getDepositCarAmt1()+vo.getDepositCarAmt2()+vo.getDepositCarAmt3()+vo.getDepositCarAmt4()+vo.getDepositCarAmt5()+vo.getDepositCarAmt6()+vo.getDepositCarAmt7());
		
		vo.setFillHouseWeek(vo.getFillHouse1()+vo.getFillHouse2()+vo.getFillHouse3()+vo.getFillHouse4()+vo.getFillHouse5()+vo.getFillHouse6()+vo.getFillHouse7());
		vo.setFillAmtWeek(vo.getFillAmt1()+vo.getFillAmt2()+vo.getFillAmt3()+vo.getFillAmt4()+vo.getFillAmt5()+vo.getFillAmt6()+vo.getFillAmt7());
		vo.setFillCarWeek(vo.getFillCar1()+vo.getFillCar2()+vo.getFillCar3()+vo.getFillCar4()+vo.getFillCar5()+vo.getFillCar6()+vo.getFillCar7());
		vo.setFillCarAmtWeek(vo.getFillCarAmt1()+vo.getFillCarAmt2()+vo.getFillCarAmt3()+vo.getFillCarAmt4()+vo.getFillCarAmt5()+vo.getFillCarAmt6()+vo.getFillCarAmt7());
		
		vo.setOrderHouseWeek(vo.getOrderHouse1()+vo.getOrderHouse2()+vo.getOrderHouse3()+vo.getOrderHouse4()+vo.getOrderHouse5()+vo.getOrderHouse6()+vo.getOrderHouse7());
		vo.setOrderAmtWeek(vo.getOrderAmt1()+vo.getOrderAmt2()+vo.getOrderAmt3()+vo.getOrderAmt4()+vo.getOrderAmt5()+vo.getOrderAmt6()+vo.getOrderAmt7());
		vo.setOrderCarWeek(vo.getOrderCar1()+vo.getOrderCar2()+vo.getOrderCar3()+vo.getOrderCar4()+vo.getOrderCar5()+vo.getOrderCar6()+vo.getOrderCar7());
		vo.setOrderCarAmtWeek(vo.getOrderCarAmt1()+vo.getOrderCarAmt2()+vo.getOrderCarAmt3()+vo.getOrderCarAmt4()+vo.getOrderCarAmt5()+vo.getOrderCarAmt6()+vo.getOrderCarAmt7());
		
		vo.setCancelHouseWeek(vo.getCancelHouse1()+vo.getCancelHouse2()+vo.getCancelHouse3()+vo.getCancelHouse4()+vo.getCancelHouse5()+vo.getCancelHouse6()+vo.getCancelHouse7());
		vo.setCancelAmtWeek(vo.getCancelAmt1()+vo.getCancelAmt2()+vo.getCancelAmt3()+vo.getCancelAmt4()+vo.getCancelAmt5()+vo.getCancelAmt6()+vo.getCancelAmt7());
		vo.setCancelCarWeek(vo.getCancelCar1()+vo.getCancelCar2()+vo.getCancelCar3()+vo.getCancelCar4()+vo.getCancelCar5()+vo.getCancelCar6()+vo.getCancelCar7());
		vo.setCancelCarAmtWeek(vo.getCancelCarAmt1()+vo.getCancelCarAmt2()+vo.getCancelCarAmt3()+vo.getCancelCarAmt4()+vo.getCancelCarAmt5()+vo.getCancelCarAmt6()+vo.getCancelCarAmt7());
		//--上周累計-------------
		data = this.transferData(projectId, projectCode, mondayStr, 2);//注意要用星期一
		vo.setPersonCntWeekAcc(data[0]);
		vo.setTelCntWeekAcc(data[1]);
		vo.setAgainCntWeekAcc(data[2]);
		
		vo.setDealHouseWeekAcc(data[3]);
		vo.setDealAmtWeekAcc(data[4]);
		vo.setDealCarWeekAcc(data[5]);
		vo.setDealCarAmtWeekAcc(data[6]);
		
		vo.setDepositHouseWeekAcc(data[7]);
		vo.setDepositAmtWeekAcc(data[8]);
		vo.setDepositCarWeekAcc(data[9]);
		vo.setDepositCarAmtWeekAcc(data[10]);	

		vo.setFillHouseWeekAcc(data[11]);
		vo.setFillAmtWeekAcc(data[12]);
		vo.setFillCarWeekAcc(data[13]);
		vo.setFillCarAmtWeekAcc(data[14]);
		
		vo.setOrderHouseWeekAcc(data[15]);
		vo.setOrderAmtWeekAcc(data[16]);
		vo.setOrderCarWeekAcc(data[17]);
		vo.setOrderCarAmtWeekAcc(data[18]);

		vo.setCancelHouseWeekAcc(data[19]);
		vo.setCancelAmtWeekAcc(data[20]);
		vo.setCancelCarWeekAcc(data[21]);
		vo.setCancelCarAmtWeekAcc(data[22]);
		//--總累計-------------
		vo.setPersonCntTotal(vo.getPersonCntWeek()+vo.getPersonCntWeekAcc());
		vo.setTelCntTotal(vo.getTelCntWeek()+vo.getTelCntWeekAcc());
		vo.setAgainCntTotal(vo.getAgainCntWeek()+vo.getAgainCntWeekAcc());
		
		vo.setDealHouseTotal(vo.getDealHouseWeek()+vo.getDealHouseWeekAcc());
		vo.setDealAmtTotal(vo.getDealAmtWeek()+vo.getDealAmtWeekAcc());
		vo.setDealCarTotal(vo.getDealCarWeek()+vo.getDealCarWeekAcc());
		vo.setDealCarAmtTotal(vo.getDealCarAmtWeek()+vo.getDealCarAmtWeekAcc());
		
		vo.setDepositHouseTotal(vo.getDepositHouseWeek()+vo.getDepositHouseWeekAcc());
		vo.setDepositAmtTotal(vo.getDepositAmtWeek()+vo.getDepositAmtWeekAcc());
		vo.setDepositCarTotal(vo.getDepositCarWeek()+vo.getDepositCarWeekAcc());
		vo.setDepositCarAmtTotal(vo.getDepositCarAmtWeek()+vo.getDepositCarAmtWeekAcc());
		
		vo.setFillHouseTotal(vo.getFillHouseWeek()+vo.getFillHouseWeekAcc());
		vo.setFillAmtTotal(vo.getFillAmtWeek()+vo.getFillAmtWeekAcc());
		vo.setFillCarTotal(vo.getFillCarWeek()+vo.getFillCarWeekAcc());
		vo.setFillCarAmtTotal(vo.getFillCarAmtWeek()+vo.getFillCarAmtWeekAcc());
		
		vo.setOrderHouseTotal(vo.getOrderHouseWeek()+vo.getOrderHouseWeekAcc());
		vo.setOrderAmtTotal(vo.getOrderAmtWeek()+vo.getOrderAmtWeekAcc());
		vo.setOrderCarTotal(vo.getOrderCarWeek()+vo.getOrderCarWeekAcc());
		vo.setOrderCarAmtTotal(vo.getOrderCarAmtWeek()+vo.getOrderCarAmtWeekAcc());
		
		vo.setCancelHouseTotal(vo.getCancelHouseWeek()+vo.getCancelHouseWeekAcc());
		vo.setCancelAmtTotal(vo.getCancelAmtWeek()+vo.getCancelAmtWeekAcc());
		vo.setCancelCarTotal(vo.getCancelCarWeek()+vo.getCancelCarWeekAcc());
		vo.setCancelCarAmtTotal(vo.getCancelCarAmtWeek()+vo.getCancelCarAmtWeekAcc());
		//---%-----
		if(vo.getTotalHouse() != 0 && vo.getTotalAmt() != 0 && vo.getTotalCar() != 0) {
			vo.setDealHouseTTP(vo.getDealHouseTotal()/vo.getTotalHouse());
			vo.setDealAmtTTP(vo.getDealAmtTotal()/vo.getTotalAmt());
			vo.setDealCarTTP(vo.getDealCarTotal()/vo.getTotalCar());
			vo.setDealCarAmtTTP(0);
			
			vo.setDepositHouseTTP(vo.getDepositHouseTotal()/vo.getTotalHouse());
			vo.setDepositAmtTTP(vo.getDepositAmtTotal()/vo.getTotalAmt());
			vo.setDepositCarTTP(vo.getDepositCarTotal()/vo.getTotalCar());
			vo.setDepositCarAmtTTP(0);
			
			vo.setFillHouseTTP(vo.getFillHouseTotal()/vo.getTotalHouse());
			vo.setFillAmtTTP(vo.getFillAmtTotal()/vo.getTotalAmt());
			vo.setFillCarTTP(vo.getFillCarTotal()/vo.getTotalCar());
			vo.setFillCarAmtTTP(0);
			
			vo.setOrderHouseTTP(vo.getOrderHouseTotal()/vo.getTotalHouse());
			vo.setOrderAmtTTP(vo.getOrderAmtTotal()/vo.getTotalAmt());
			vo.setOrderCarTTP(vo.getOrderCarTotal()/vo.getTotalCar());
			vo.setOrderCarAmtTTP(0);
			
			vo.setCancelHouseTTP(vo.getCancelHouseTotal()/vo.getTotalHouse());
			vo.setCancelAmtTTP(vo.getCancelAmtTotal()/vo.getTotalAmt());
			vo.setCancelCarTTP(vo.getCancelCarTotal()/vo.getTotalCar());
			vo.setCancelCarAmtTTP(0);
		}
		
		
		return vo;
	}
	
	private int[] transferData(Long projectId, String projectCode, String calDate, int type) {
		int[] aryInt = new int[23];
		List<Object[]> obj_custDaily = null;
		List<Object[]> obj_sales = null;
		
		if(type == 1) {//1=每日 2=上周累計
			obj_custDaily = visitorDao.customerCountByDateAndProject(projectCode, calDate);//當週來人來電0=來人/來電, 1=數量
			obj_sales = visitorDao.salesDataByDateAndProject(projectId, calDate);//銷售紀錄=>0=類別 1=戶數 2=金額
		}else {
			obj_custDaily = visitorDao.customerCountByLastWeekAndProject(projectCode, calDate);//當週來人來電0=來人/來電, 1=數量
			obj_sales = visitorDao.salesDataByLastWeekAndProject(projectId, calDate);//銷售紀錄=>0=類別 1=戶數 2=金額
		}
		
		//來人 來電 回籠數
		for(Object[] ary : obj_custDaily) {
			if(ary[0].equals("A")) {//來人
				aryInt[0] = Integer.parseInt(""+ary[1]);
			}else if(ary[0].equals("B")) {//來電
				aryInt[1] = Integer.parseInt(""+ary[1]);
			}else if(ary[0].equals("F")) {//回籠	
				aryInt[2] = Integer.parseInt(""+ary[1]);
			}
		}
		//銷售紀錄
		for(Object[] ary : obj_sales) {
			if(ary[0].equals("B1")) {//簽約 TODO:簽約 =成交 ??
				aryInt[3] = Integer.parseInt(""+ary[1]);//成交戶數
				aryInt[4] = Integer.parseInt(""+ary[2]);//成交金額
				aryInt[5] = 0;//成交車數
				aryInt[6] = 0;//成交車金額
				
				aryInt[11] = Integer.parseInt(""+ary[1]);//補足戶數
				aryInt[12] = Integer.parseInt(""+ary[2]);//補足金額
				aryInt[13] = 0;//補足訂車
				aryInt[14] = 0;//補足車金額
				
				aryInt[15] = Integer.parseInt(""+ary[1]);//補足戶數
				aryInt[16] = Integer.parseInt(""+ary[2]);//補足金額
				aryInt[17] = 0;//補足訂車
				aryInt[18] = 0;//補足車金額
			}else if(ary[0].equals("B0")) {//訂金
				aryInt[7] = Integer.parseInt(""+ary[1]);//小訂戶數
				aryInt[8] = Integer.parseInt(""+ary[2]);//小訂金額
				aryInt[9] = 0;//小訂車
				aryInt[10] = 0;//小訂車金額
			}else if(ary[0].equals("D0")) {//退訂	
				aryInt[19] = Integer.parseInt(""+ary[1]);//退戶戶數
				aryInt[20] = Integer.parseInt(""+ary[2]);//退戶金額
				aryInt[21] = 0;//退戶訂車
				aryInt[22] = 0;//退戶車金額
			}
		}
			
		return aryInt;
	}
}
