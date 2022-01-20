package cn.enilu.flash.service.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa92;
import cn.enilu.flash.dao.ma.Maa92Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa92Service extends BaseService<Maa92,Long,Maa92Repository>{
	
	@Autowired
	private Maa92Repository repository;
	
	
	
}
