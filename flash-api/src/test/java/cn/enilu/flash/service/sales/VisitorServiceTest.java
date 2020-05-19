package cn.enilu.flash.service.sales;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.enilu.flash.BaseApplicationStartTest;

public class VisitorServiceTest extends BaseApplicationStartTest {
	
	@Autowired
    private VisitorService visitorService;
	@Test
	public void showList() {
		//visitorService.findByVisitorName("SS");
	}
	
}
