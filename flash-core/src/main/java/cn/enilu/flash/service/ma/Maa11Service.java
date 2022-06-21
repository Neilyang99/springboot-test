package cn.enilu.flash.service.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa11;
import cn.enilu.flash.dao.ma.Maa11Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa11Service extends BaseService<Maa11,Long,Maa11Repository>{
	
	@Autowired
	private Maa11Repository repository;
	
	
	
}
