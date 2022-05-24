package cn.enilu.flash.service.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa08;
import cn.enilu.flash.dao.ma.Maa08Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa08Service extends BaseService<Maa08,Long,Maa08Repository>{
	
	@Autowired
	private Maa08Repository repository;
	
	
	
}
