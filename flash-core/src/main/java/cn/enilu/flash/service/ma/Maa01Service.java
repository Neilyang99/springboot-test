package cn.enilu.flash.service.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa01;
import cn.enilu.flash.dao.ma.Maa01Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa01Service extends BaseService<Maa01,Long,Maa01Repository>{
	
	@Autowired
	private Maa01Repository dao;
	
	/**
	 * 檢查資料是否重複
	 * @param projectId
	 * @param lv1Id
	 * @param lv2Id
	 * @return 0=無重複
	 */
	public int checkLevel2Data(Long projectId, Long lv1Id, Long lv2Id) {
		
		return dao.checkLevel2Data(projectId, lv1Id, lv2Id);
		
	}
	
	/**
	 * 更新小類別的預算金額
	 * @param lv2Id
	 * @return
	 */
	public int updateBudgeAmountByMaa01004(Long lv2Id) {
		return dao.updateBudgeAmountByMaa01004(lv2Id);
	}
	
	/**
	 * 根據工程案更新預算金額
	 * @param Project Id
	 * @return
	 */
	public int updateBudgeAmountByProject(Long projectId) {
		return dao.updateBudgeAmountByProject(projectId);
	}
	
	//新工程案從預算項目(maa91)新增該工程的預算項目
	public int insertByNewProject(Long projectId) {
		return dao.insertByNewProject(projectId);
	}
}
