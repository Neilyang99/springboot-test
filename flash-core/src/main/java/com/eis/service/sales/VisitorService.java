package com.eis.service.sales;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eis.bean.entity.sales.Visitor;
import com.eis.dao.sales.VisitorDao;

import cn.enilu.flash.service.BaseService;

@Service
public class VisitorService extends BaseService<Visitor,Long,VisitorDao>{
	private static final Logger logger = LoggerFactory.getLogger(VisitorService.class);
	@Autowired
	private VisitorDao visitorDao;
	
	public List<Visitor> findByVisitorName(String name){
		return visitorDao.findByVisitorName(name);
	}
}
