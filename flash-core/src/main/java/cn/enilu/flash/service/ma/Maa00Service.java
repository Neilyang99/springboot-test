package cn.enilu.flash.service.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa00;
import cn.enilu.flash.dao.ma.Maa00Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa00Service extends BaseService<Maa00,Long,Maa00Repository>{
	
	@Autowired
	private Maa00Repository dao;
	
	/**
	 * 根據工程案更新預算金額
	 * @param Project Id
	 * @return
	 */
	public int updateBudgeAmountByProject(Long projectId) {
		return dao.updateBudgeAmountByProject(projectId);
	}
	
}
