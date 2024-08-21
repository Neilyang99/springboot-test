package cn.enilu.flash.service.ma;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa93c;
import cn.enilu.flash.bean.vo.ma.Maa93cVo;
import cn.enilu.flash.dao.ma.Maa93cRepository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa93cService extends BaseService<Maa93c,Long,Maa93cRepository>{
	
	@Autowired
	private Maa93cRepository dao;
	
	/**
	 * 刪除承包商所有施工項目的資料
	 * @param vendorId
	 * @return
	 */
	public int deleteByVendor(Long vendorId) {
		return dao.deleteByVendorId(vendorId);
	}
	
	/**
	 * 取出承包商所屬的施工項目
	 * @param vendorId
	 * @return Maa93cVo list
	 */
	public List<Maa93cVo> getWorkItemByVendor(Long vendorId){
		List<Maa93cVo> list = new ArrayList<Maa93cVo>();
		
		List<Object[]> objList = dao.getWorkItemListByVendor(vendorId);
		for(Object[] obj : objList) {
			Maa93cVo vo = new Maa93cVo();
			
			vo.setWorkItemId(Integer.parseInt(""+obj[1]));
			vo.setWorkItemName(""+obj[2]);
			vo.setWorkItemUnit(""+obj[3]);
			vo.setRemark(""+obj[4]);
			
			if(obj[0] == null ) {
				vo.setId(0);
				vo.setVendorId(0);
				vo.setIsActive(0);
			}else {
				vo.setId(Integer.parseInt(""+obj[0]));
				vo.setVendorId(Integer.parseInt(""+obj[5]));
				vo.setIsActive(1);
			}
			
			list.add(vo);
		}
		
		return list;
	}
	
}
