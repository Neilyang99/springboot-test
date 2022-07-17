package cn.enilu.flash.service.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa15;
import cn.enilu.flash.dao.ma.Maa15Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa15Service extends BaseService<Maa15,Long,Maa15Repository>{
	
	@Autowired
	private Maa15Repository repository;
	
	
	
}
