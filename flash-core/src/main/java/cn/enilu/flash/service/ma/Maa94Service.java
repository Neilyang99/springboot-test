package cn.enilu.flash.service.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa94;
import cn.enilu.flash.dao.ma.Maa94Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa94Service extends BaseService<Maa94,Long,Maa94Repository>{
	
	@Autowired
	private Maa94Repository repository;
	
	
	
}
