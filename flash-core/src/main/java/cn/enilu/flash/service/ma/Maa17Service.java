package cn.enilu.flash.service.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa17;
import cn.enilu.flash.dao.ma.Maa17Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa17Service extends BaseService<Maa17,Long,Maa17Repository>{
	
	@Autowired
	private Maa17Repository repository;
	
	
	
}
