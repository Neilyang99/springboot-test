package cn.enilu.flash.service.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa04;
import cn.enilu.flash.dao.ma.Maa04Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa04Service extends BaseService<Maa04,Long,Maa04Repository>{
	
	@Autowired
	private Maa04Repository repository;
	
	
	
}
