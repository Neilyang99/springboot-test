package cn.enilu.flash.service.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa05;
import cn.enilu.flash.dao.ma.Maa05Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa05Service extends BaseService<Maa05,Long,Maa05Repository>{
	
	@Autowired
	private Maa05Repository repository;
	
	
	
}
