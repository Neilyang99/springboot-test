package cn.enilu.flash.api.controller.sales;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.sales.VisitorReportVo;
import cn.enilu.flash.service.sales.VisitorService;
import cn.enilu.flash.utils.DateUtil;

@RestController
@RequestMapping("/visitorReport")
public class VisitorReportController  extends BaseController {
	
	@Autowired
    private VisitorService visitorService;
	
	@RequestMapping(value = "/getMediaAnalysis",method = RequestMethod.GET)
	public Object getMedia(String projectCode) {
		ArrayList<VisitorReportVo> list = new ArrayList<VisitorReportVo>();
		
		//first Day = Monday
		Date monday = DateUtil.getThisWeekMonday(new Date());//Monday in this week
		Date sunday = DateUtil.getDateAfterDays(monday, "6");//Sunday in this week
		String mondayStr = DateUtil.formatDate(monday, "yyyyMMdd");
		String sundayStr = DateUtil.formatDate(sunday, "yyyyMMdd");
		
		list = (ArrayList<VisitorReportVo>) visitorService.summarizeMediaBySla10002AndSla10013Between(projectCode, mondayStr, sundayStr);
		
		return Rets.success(list);
	}

	@RequestMapping(value = "/getReportAnalysis",method = RequestMethod.GET)
	public Object getArea(String projectCode, String type) {
		List<VisitorReportVo> list = new ArrayList<VisitorReportVo>();
		
		//first Day = Monday
		Date monday = DateUtil.getThisWeekMonday(new Date());//Monday in this week
		Date sunday = DateUtil.getDateAfterDays(monday, "6");//Sunday in this week
		String mondayStr = DateUtil.formatDate(monday, "yyyyMMdd");
		String sundayStr = DateUtil.formatDate(sunday, "yyyyMMdd");
		
		if(type.equals("MEDIA")) {
			list = visitorService.summarizeMediaBySla10002AndSla10013Between(projectCode, mondayStr, sundayStr);
		}else if(type.equals("AREA")) {
			list = visitorService.sumAreaBySla10002AndSla10013Between(projectCode, mondayStr, sundayStr);
		}else if(type.equals("CAREER")) {
			list = visitorService.sumCareerBySla10002AndSla10013Between(projectCode, mondayStr, sundayStr);
		}else if(type.equals("MOTIVATION")) {
			list = visitorService.sumMotivationBySla10002AndSla10013Between(projectCode, mondayStr, sundayStr);
		}else if(type.equals("AGE")) {	
			list = visitorService.sumAgeBySla10002AndSla10013Between(projectCode, mondayStr, sundayStr);
		}
		
		
		return Rets.success(list);
	}

}
