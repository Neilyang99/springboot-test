package cn.enilu.flash.service.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa90;
import cn.enilu.flash.dao.ma.Maa90Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa90Service extends BaseService<Maa90,Long,Maa90Repository>{
	
	@Autowired
	private Maa90Repository repository;
	
	
	
}
