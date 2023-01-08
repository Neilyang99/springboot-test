package cn.enilu.flash.service.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa02;
import cn.enilu.flash.dao.ma.Maa02Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa02Service extends BaseService<Maa02,Long,Maa02Repository>{
	
	@Autowired
	private Maa02Repository repository;
	
	
	
}
