package cn.enilu.flash.service.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa93;
import cn.enilu.flash.dao.ma.Maa93Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa93Service extends BaseService<Maa93,Long,Maa93Repository>{
	
	@Autowired
	private Maa93Repository repository;
	
	/**
	 * 檢查外包商統一編號(新增資料檢查)
	 * @param ma93011
	 * @return
	 */
	public int checkVendorIdByNew(String ma93011) {
		int count = repository.checkMaa93011ForNew(ma93011);
		return count;
	}
	
	/**
	 * 檢查外包商統一編號(更新資料檢查)
	 * @param ma93011
	 * @return
	 */
	public int checkVendorIdByUpdate(Long id, String ma93011) {
		int count = repository.checkMaa93011ForUpdate(id, ma93011);
		return count;
	}
	
}
