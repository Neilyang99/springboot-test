package cn.enilu.flash.service.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa01a;
import cn.enilu.flash.dao.ma.Maa01aRepository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa01aService extends BaseService<Maa01a,Long,Maa01aRepository>{
	
	@Autowired
	private Maa01aRepository repository;
	
	
	
}
