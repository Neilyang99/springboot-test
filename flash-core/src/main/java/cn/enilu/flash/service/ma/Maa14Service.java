package cn.enilu.flash.service.ma;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa14;
import cn.enilu.flash.bean.entity.ma.Maa94;
import cn.enilu.flash.bean.vo.ma.MaaVo;
import cn.enilu.flash.dao.ma.Maa14Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa14Service extends BaseService<Maa14,Long,Maa14Repository>{
	
	@Autowired
	private Maa14Repository repository;
	
	public List<MaaVo> findWorkerName() {
		List<String> workerList = repository.findWorkerName();
		
		List<MaaVo> list = new ArrayList<MaaVo>();
		
		for(String obj : workerList) {
			MaaVo vo = new MaaVo();
			
			vo.setKey(obj);
			vo.setValue(obj);
			vo.setName(obj);
			
			list.add(vo);
		}
		
		return list;
		
	}
	
}
