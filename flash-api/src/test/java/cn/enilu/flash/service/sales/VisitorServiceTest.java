package cn.enilu.flash.service.sales;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.persistence.FetchType;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.enilu.flash.BaseApplicationStartTest;
import cn.enilu.flash.bean.entity.sales.Sla01;
import cn.enilu.flash.bean.entity.sales.Slb10;
import cn.enilu.flash.bean.entity.sales.Slb11;
import cn.enilu.flash.bean.vo.DictVo;
import cn.enilu.flash.bean.vo.sales.VisitorReportVo;
import cn.enilu.flash.bean.vo.sales.VisitorSummaryVo;
import cn.enilu.flash.service.ma.Maa01aService;
import cn.enilu.flash.service.system.impl.ConstantFactory;
import cn.enilu.flash.utils.DateUtil;

public class VisitorServiceTest extends BaseApplicationStartTest {
	
	@Autowired
    private Slb10Service slb10service;
	
	@Autowired
	private Slb11Service slb11service;
	
	@Autowired
	private Sla01Service sla01service;
	
	@Autowired
	private VisitorService visitorService;
	
	@Autowired
	private Maa01aService maa01aSer;
	
	@Test
	public void showList() {
		//visitorService.findByVisitorName("SS");
		
		//List<Slb10> slb10List = slb10service.queryAll();
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
//		Slb10 slb10 = new Slb10();
//		long a = 8;
//		slb10.setSlb10002("20210614");
		
		System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTT");
		//slb11service.queryAll();
		System.out.println( "ADDDDTTTTTTTTTTTDDDDDDDD=");
		
		try {
			// insert 
//			Optional<Slb10> slb10 = slb10service.findById(3L);
//			Slb10 a = slb10.get();
//			a.getSlb11List().add(slb11);
//			slb10service.insert(a);
			
			//query slb10 fetch=FetchType.LAZY 要自己新增slb11
//			Optional<Slb10> slb10 = slb10service.findById(3L);
//			
//			List<Slb11> slb11s = slb11service.findBySlb11002(slb10.get().getId());
			//slb10.get().setSlb11List(slb11s);
//			
//			System.out.println("UUUUUU="+slb10.get().getSlb10002());
//			
//			List<Sla01> sla01s = sla01service.findBySla01003("2021001");
//			System.out.println("UUUUUU="+sla01s.size());
			
			// OK
			//Slb11 a11 = slb11service.findBySlb11002(3).get(0);
			//System.out.println("YYYYYYYYYYYY10002="+a11.getSlb10().getSlb10002());
			
			//System.out.println("YYYYYDDDDDDDDDD="+this.ll("2021001"));
			
			//List list = maa01aSer.findByMaa01a002((long) 1);
			//System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTT="+list.size());
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCC");
		log.info("BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB");
	}
	
	private List ll(String projectCode) {
		
		ArrayList<VisitorReportVo> list = new ArrayList<VisitorReportVo>();
		
		//Monday = first Day
		Date monday = DateUtil.getThisWeekMonday(new Date());//Monday in this week
		Date sunday = DateUtil.getDateAfterDays(monday, "6");//Sunday in this week
		String mondayStr = DateUtil.formatDate(monday, "yyyyMMdd");
		String sundayStr = DateUtil.formatDate(sunday, "yyyyMMdd");
		
		list = (ArrayList<VisitorReportVo>) visitorService.sumAgeBySla10002AndSla10013Between(projectCode, mondayStr, sundayStr);
		
		return list;
		
	}
	
}
