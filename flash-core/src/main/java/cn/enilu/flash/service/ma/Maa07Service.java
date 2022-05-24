package cn.enilu.flash.service.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa07;
import cn.enilu.flash.dao.ma.Maa07Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa07Service extends BaseService<Maa07,Long,Maa07Repository>{
	
	@Autowired
	private Maa07Repository repository;
	
	
	
}
