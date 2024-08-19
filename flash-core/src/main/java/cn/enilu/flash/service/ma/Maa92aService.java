package cn.enilu.flash.service.ma;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa92a;
import cn.enilu.flash.bean.vo.ma.Maa92aVo;
import cn.enilu.flash.dao.ma.Maa92aRepository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa92aService extends BaseService<Maa92a,Long,Maa92aRepository>{
	
	@Autowired
	private Maa92aRepository maa92aDao;
	
	public List<Maa92aVo> queryByItemId(Long budgetItemId){
		
		List<Maa92aVo> list = new ArrayList<Maa92aVo>();
		List<Object[]> objs =  maa92aDao.findByMaa92a002(budgetItemId);
		for(Object[] ary : objs) {
			Maa92aVo vo = new Maa92aVo();
			vo.setId(Integer.parseInt(""+ary[0]));
			vo.setMaa92a002(Integer.parseInt(""+ary[1]));
			vo.setMaa92a003(Integer.parseInt(""+ary[2]));
			vo.setMaa92a004(""+ary[3]);
			vo.setMaa92a005(Double.parseDouble(""+ary[4]));
			vo.setMaa92a006(""+ary[5]);
			vo.setMaa92a007(Integer.parseInt(""+ary[6]));
			vo.setMaa92a008(""+ary[7]);
			vo.setMaa92a009(Integer.parseInt(""+ary[8]));
			vo.setBudgetItemName(""+ary[9]);
			vo.setWorkItemName(""+ary[10]);
			vo.setWorkItemUnit(""+ary[11]);
			
			list.add(vo);
		}
		
		return list;
	}
	
	/**
	 * 檢查施作項目是否重複
	 * @param id 預算子項目
	 * @param itemId 預算項目
	 * @param workItemId 施作項目
	 * @param companyId
	 * @return >0: 重複
	 */
	public int checkDuplicateWorkItem(Long subId, Long itemId, Long workItemId, Long companyId) {
		int count = maa92aDao.checkDuplicateWorkItem(subId, itemId, workItemId, companyId);
		return count;
	}
}
