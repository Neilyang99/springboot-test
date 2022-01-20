package cn.enilu.flash.service.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa93;
import cn.enilu.flash.dao.ma.Maa93Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa93Service extends BaseService<Maa93,Long,Maa93Repository>{
	
	@Autowired
	private Maa93Repository repository;
	
	
	
}
