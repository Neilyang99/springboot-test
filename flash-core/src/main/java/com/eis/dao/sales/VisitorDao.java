package com.eis.dao.sales;

import java.util.List;

import com.eis.bean.entity.sales.Visitor;

import cn.enilu.flash.dao.BaseRepository;

public interface VisitorDao extends BaseRepository<Visitor, Long>{

	 List findByVisitorName(String visitorName);
}
