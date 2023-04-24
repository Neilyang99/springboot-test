package cn.enilu.flash.service.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa22;
import cn.enilu.flash.dao.ma.Maa22Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa22Service extends BaseService<Maa22,Long,Maa22Repository>{
	
	@Autowired
	private Maa22Repository repository;
	
	
	
}
