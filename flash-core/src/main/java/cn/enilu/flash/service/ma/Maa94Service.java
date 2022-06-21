package cn.enilu.flash.service.ma;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa94;
import cn.enilu.flash.bean.vo.ma.MaaVo;
import cn.enilu.flash.dao.ma.Maa94Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa94Service extends BaseService<Maa94,Long,Maa94Repository>{
	
	@Autowired
	private Maa94Repository repository;
	
	/**
	 * 取得工種項目
	 * @return
	 */
	public List<MaaVo> getWorkJobItem (){
		//10=工種，20=材料，30=混凝土檢驗項目，40=鋼筋品質項目，50=零用金項目
		List<Maa94> maList = repository.getItemList(10);
		List<MaaVo> list = this.getValueList(maList);
		
		return list;
	}
	
	/**
	 * 取得材料項目
	 * @return
	 */
	public List<MaaVo> getMaterialItem (){
		//10=工種，20=材料，30=混凝土檢驗項目，40=鋼筋品質項目，50=零用金項目
		List<Maa94> maList = repository.getItemList(20);
		
		List<MaaVo> list = this.getValueList(maList);
		
		return list;
	}
	
	private List<MaaVo> getValueList(List<Maa94> maList) {
		
		List<MaaVo> list = new ArrayList<MaaVo>();
		for(Maa94 obj : maList) {
			MaaVo vo = new MaaVo();
			
			vo.setKey(""+obj.getId());
			vo.setValue(obj.getMaa94004());
			vo.setName(obj.getMaa94003());
			
			list.add(vo);
		}
		
		return list;
	}
	
	
	/**
	 * 取得項目的名稱
	 * @param id
	 * @return
	 */
	public String getItemNameById(Long id) {
		
		return repository.findItemNameById(id);
	}
}
