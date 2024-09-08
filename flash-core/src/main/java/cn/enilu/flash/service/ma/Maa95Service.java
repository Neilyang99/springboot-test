package cn.enilu.flash.service.ma;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa95;
import cn.enilu.flash.bean.vo.ma.MaaVo;
import cn.enilu.flash.dao.ma.Maa95Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa95Service extends BaseService<Maa95,Long,Maa95Repository>{
	
	@Autowired
	private Maa95Repository dao;
	
	/**
	 * 作廢資料
	 * @param id
	 */
	public void CancelById(Long id) {
		dao.UpdateStatusById(id, "N");
	}	
	
	/**
	 * 檢查施作項目名稱是否重複
	 * @param id 
	 * @param workItemName 施作項目名稱
	 * @return 
	 */
	public int checkWorkItemName(Long id, String workItemName) {
		return dao.checkWorkItemName(id, workItemName);
	}
	
	/**
	 * 取出有效的清單:下拉選單用
	 * @return MaaVo List
	 */
	public List<MaaVo> getValueList() {
		
		List<Maa95> workItemList = dao.findByMaa95013("Y");
		
		List<MaaVo> list = new ArrayList<MaaVo>();
		for(Maa95 obj : workItemList) {
			MaaVo vo = new MaaVo();
			
			vo.setKey(""+obj.getId());
			vo.setValue(obj.getMaa95003());//單位
			vo.setName(obj.getMaa95002());//名稱
			
			list.add(vo);
		}
		
		return list;
	}
	
}
