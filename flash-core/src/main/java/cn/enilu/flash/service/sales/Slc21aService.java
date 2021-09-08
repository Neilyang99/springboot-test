package cn.enilu.flash.service.sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.sales.Slc21a;
import cn.enilu.flash.dao.sales.Slc21aRepository;
import cn.enilu.flash.service.BaseService;

@Service
public class Slc21aService extends BaseService<Slc21a,Long,Slc21aRepository>{
	
	@Autowired
	private Slc21aRepository slc21aRepository;
	
		
}
