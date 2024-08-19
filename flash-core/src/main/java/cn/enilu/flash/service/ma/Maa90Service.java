package cn.enilu.flash.service.ma;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa90;
import cn.enilu.flash.bean.vo.ma.MaaCheckboxVo;
import cn.enilu.flash.dao.ma.Maa90Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa90Service extends BaseService<Maa90,Long,Maa90Repository>{
	
	@Autowired
	private Maa90Repository repository;
	
	/**
	 * 取得預算大類別的資料(下拉選單用)
	 * @return
	 */
	public List<MaaCheckboxVo> getDataForSelection() {
		
		List<MaaCheckboxVo> list = new ArrayList<MaaCheckboxVo>();
		
		List<Object[]> dataList = repository.getFirstType();
		for(Object[] obj : dataList) {
			MaaCheckboxVo vo = new MaaCheckboxVo();
			vo.setKey(""+obj[0]);
			vo.setValue(obj[1].toString());
			vo.setName(obj[2].toString());
			vo.setActive(true);//default = true
			
			list.add(vo);
		}
		
		return list;
	}
	
}
