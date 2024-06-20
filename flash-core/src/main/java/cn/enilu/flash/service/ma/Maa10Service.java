package cn.enilu.flash.service.ma;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa10;
import cn.enilu.flash.bean.vo.ma.MaaStockVo;
import cn.enilu.flash.dao.ma.Maa10Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa10Service extends BaseService<Maa10,Long,Maa10Repository>{
	
	@Autowired
	private Maa10Repository repository;
	
	public List<MaaStockVo> getStock(Long projectId){
		
		List<MaaStockVo> list = new ArrayList<MaaStockVo>();
		
		List<Object[]> dataList = repository.getStock(projectId);
		
		for(Object[] obj : dataList) {
			MaaStockVo vo = new MaaStockVo();
			vo.setMaterialName(""+obj[0]);
			vo.setAmount(Double.parseDouble(obj[1].toString()));
			vo.setQty(Double.parseDouble(obj[2].toString()));
			
			list.add(vo);
		}
		return list;
	}
	
}
