package cn.enilu.flash.service.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa01;
import cn.enilu.flash.dao.ma.Maa01Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa01Service extends BaseService<Maa01,Long,Maa01Repository>{
	
	@Autowired
	private Maa01Repository repository;
	
	
	
}
