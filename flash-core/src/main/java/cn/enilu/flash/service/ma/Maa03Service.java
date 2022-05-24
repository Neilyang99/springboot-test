package cn.enilu.flash.service.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa03;
import cn.enilu.flash.dao.ma.Maa03Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa03Service extends BaseService<Maa03,Long,Maa03Repository>{
	
	@Autowired
	private Maa03Repository repository;
	
	
	
}
