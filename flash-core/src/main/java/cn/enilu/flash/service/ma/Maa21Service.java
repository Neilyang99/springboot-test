package cn.enilu.flash.service.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa21;
import cn.enilu.flash.dao.ma.Maa21Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa21Service extends BaseService<Maa21,Long,Maa21Repository>{
	
	@Autowired
	private Maa21Repository repository;
	
	
	
}
