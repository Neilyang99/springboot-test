package cn.enilu.flash.service.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa12;
import cn.enilu.flash.dao.ma.Maa12Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa12Service extends BaseService<Maa12,Long,Maa12Repository>{
	
	@Autowired
	private Maa12Repository repository;
	
	
	
}
