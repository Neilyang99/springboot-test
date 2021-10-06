package cn.enilu.flash.service.sales;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.sales.Sla24;
import cn.enilu.flash.dao.sales.Sla24Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Sla24Service extends BaseService<Sla24,Long,Sla24Repository>{
	
	@Autowired
	private Sla24Repository Sla24Repository;
	
	public void updateFinishDate(Long id, String date) {
		Sla24Repository.updateFinishDate(id, date);
	}
	
	
}
