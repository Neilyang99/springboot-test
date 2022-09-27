package cn.enilu.flash.service.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa16;
import cn.enilu.flash.dao.ma.Maa16Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa16Service extends BaseService<Maa16,Long,Maa16Repository>{
	
	@Autowired
	private Maa16Repository repository;
	
	public int getMaxPeriod(Long projectId) {
		
		int count = 0;
		
		String v = repository.getMaxPeriod(projectId);
		
		if(v != null && !v.isEmpty()) {
			count = Integer.parseInt(repository.getMaxPeriod(projectId));
		}
		
		return count;
	}
	
	/**
	 * 更新本期收入與支出合計
	 * @param pk
	 */
	public void updateAmt(Long pk) {
		repository.updateAmt(pk);
	}
	
}
