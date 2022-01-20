package cn.enilu.flash.service.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa93a;
import cn.enilu.flash.dao.ma.Maa93aRepository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa93aService extends BaseService<Maa93a,Long,Maa93aRepository>{
	
	@Autowired
	private Maa93aRepository repository;
	
	
	
}
