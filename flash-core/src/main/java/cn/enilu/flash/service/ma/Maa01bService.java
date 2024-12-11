package cn.enilu.flash.service.ma;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa01b;
import cn.enilu.flash.bean.vo.ma.BudgetDataVo;
import cn.enilu.flash.bean.vo.ma.BudgetExcelVo;
import cn.enilu.flash.dao.ma.Maa01bRepository;
import cn.enilu.flash.dao.ma.Maa93cRepository;
import cn.enilu.flash.service.BaseService;
import cn.enilu.flash.utils.StringUtil;

@Service
public class Maa01bService extends BaseService<Maa01b,Long,Maa01bRepository>{
	
	@Autowired
	private Maa01bRepository repository;
	
	@Autowired
	private Maa93cRepository daoMaa93c;
	
	public List<Maa01b> findByMaa01b002(Long projectId){
		return repository.findByMaa01b002(projectId);
	}
	
	/**
	 * 查詢預算書資料
	 * @param projectId
	 * @return
	 */
	public List<BudgetDataVo> getBudgetData(Long projectId, Long vendorId){
		
		List<BudgetDataVo> list = new ArrayList<BudgetDataVo>();
		
		List<Object[]> objs = null;
		
		//規則:
		//vendorId=0 : 顯示全部
		//vendorId>0 : 有定義工作細項:顯示有工作細項的預算項目
		//             沒有定義工作細項: 顯示全部
		if(StringUtil.isNullOrEmpty(vendorId) || vendorId == 0 ) {
			objs = repository.getBudgetData(projectId);
		}else {
			int count = daoMaa93c.getWorkItemCountByVendor(vendorId);//取得廠商定義的工作細項
			
			if(count == 0) {
				objs = repository.getBudgetData(projectId);
			}else {//有工作細項
				objs = repository.getBudgetData(projectId, vendorId);
			}
		}
		
		
		for(Object[] ary : objs) {
			
			BudgetDataVo vo = new BudgetDataVo();
			vo.setMaa01aId(Integer.parseInt(""+ary[0]));
			vo.setFirstName(""+ary[1]);
			vo.setSecondName(""+ary[2]);
			vo.setItemName(""+ary[3]);
			vo.setItemUnit(""+ary[4]);
			if(StringUtil.isNullOrEmpty(ary[5])) {
				vo.setItemQty(0);
			}else {
				vo.setItemQty(Double.parseDouble(""+ary[5]));
			}
			if(StringUtil.isNullOrEmpty(ary[6])) {
				vo.setItemUnitPrice(0);
			}else {
				vo.setItemUnitPrice(Double.parseDouble(""+ary[6]));
			}
			if(StringUtil.isNullOrEmpty(ary[7])) {
				vo.setItemAmount(0);
			}else {
				vo.setItemAmount(Double.parseDouble(""+ary[7]));
			}
			if(StringUtil.isNullOrEmpty(ary[8])) {
				vo.setMaa01bId(0);
				vo.setWorkItemName("");
				vo.setWorkItemUnit("");
				vo.setWorkItemQty(0);
				vo.setWorkItemUnitPrice(0);
				vo.setWorkItemAmount(0);
			}else {
				vo.setMaa01bId(Integer.parseInt(""+ary[8]));
				vo.setWorkItemName(""+ary[9]);
				vo.setWorkItemUnit(""+ary[10]);
				if(StringUtil.isNullOrEmpty(ary[11])) {
					vo.setWorkItemQty(0);
				}else {
					vo.setWorkItemQty(Double.parseDouble(""+ary[11]));
				}
				if(StringUtil.isNullOrEmpty(ary[12])) {
					vo.setWorkItemUnitPrice(0);
				}else {
					vo.setWorkItemUnitPrice(Double.parseDouble(""+ary[12]));
				}
				if(StringUtil.isNullOrEmpty(ary[13])) {
					vo.setWorkItemAmount(0);
				}else {
					vo.setWorkItemAmount(Double.parseDouble(""+ary[13]));
				}
			}
			
			list.add(vo);
		}
		
		return list;
	}
	
	//新工程案從預算項目(maa92)新增該工程的預算項目
	public int insertByNewProject(Long projectId, String buildTypeList) {
		int cnt = 0;
		if(buildTypeList.trim().equals("")) {
			//全部的營建分類都要產生
			cnt = repository.insertByNewProject(projectId);
		}else {
			//部分的營建分類要產生
			String[] aryStr =buildTypeList.trim().split(",");
			List<String> list = new ArrayList<String>();
			for(String v : aryStr){
				list.add(v);
			}
			cnt = repository.insertByNewProject(projectId, list);
		}
		return cnt;
	}
	
	/**
	 * 更新資料狀態
	 * @param 工程案ID
	 * @param 資料狀態
	 * @return
	 */
	public int updateBudgeConfirmByProject(Long projectId, String status) {
		return repository.updateBudgeConfirmByProject(projectId, status);
	}
	
	/**
	 * Maa01a刪除時，同步刪除maa01b資料
	 * @param project Level3 Id
	 * @return
	 */
	public int delByMaa01a(Long projectLV3Id) {
		return repository.deleteByMaa01a(projectLV3Id);
	}
	
	/**
	 * Maa01刪除時，同步刪除maa01b資料
	 * @param projectId
	 * @param lv1
	 * @param lv2
	 * @return
	 */
	public int delByMaa01(Long projectId, Long lv1, Long lv2) {
		return repository.deleteByMaa01(projectId,lv1,lv2);
	}
	
	/**
	 * 刪除所有工程案資料
	 * @param projectId
	 * @return
	 */
	public int deleteByMaa01b002(Long projectId) {
		return repository.deleteByMaa01b002(projectId);
	}
}

