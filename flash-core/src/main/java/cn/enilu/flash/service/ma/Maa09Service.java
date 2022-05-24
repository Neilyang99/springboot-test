package cn.enilu.flash.service.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa09;
import cn.enilu.flash.dao.ma.Maa09Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa09Service extends BaseService<Maa09,Long,Maa09Repository>{
	
	@Autowired
	private Maa09Repository repository;
	
	
	
}
