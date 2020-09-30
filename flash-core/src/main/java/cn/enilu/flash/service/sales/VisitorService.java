package cn.enilu.flash.service.sales;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.sales.Visitor;
import cn.enilu.flash.dao.sales.VisitorRepository;
import cn.enilu.flash.service.BaseService;

@Service
public class VisitorService extends BaseService<Visitor,Long,VisitorRepository>{
	private static final Logger logger = LoggerFactory.getLogger(VisitorService.class);
	@Autowired
	private VisitorRepository visitorDao;
	
	public List<Visitor> findBySla10006(String name){
		System.out.println("find visitor name AVVVA -----------");
		return visitorDao.findBySla10006(name);
	}
	
	public List<Object[]> queryGridList(){
		return visitorDao.queryGridList();
	}
}
