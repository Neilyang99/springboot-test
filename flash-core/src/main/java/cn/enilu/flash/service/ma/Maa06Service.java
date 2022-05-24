package cn.enilu.flash.service.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa06;
import cn.enilu.flash.dao.ma.Maa06Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa06Service extends BaseService<Maa06,Long,Maa06Repository>{
	
	@Autowired
	private Maa06Repository repository;
	
	
	
}
