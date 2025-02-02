package cn.enilu.flash.service.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa22;
import cn.enilu.flash.dao.ma.Maa22Repository;
import cn.enilu.flash.service.BaseService;
import cn.enilu.flash.service.ma.Maa21Service.StatusEnum;

@Service
public class Maa22Service extends BaseService<Maa22,Long,Maa22Repository>{
	
	@Autowired
	private Maa22Repository repository;
	
	
	/**
	 * 作廢資料
	 * @param id
	 */
	public void CancelByMaa22002(Long maa22002) {
		repository.UpdateStatusByMaa22002(maa22002, StatusEnum.VOID.getValue());
	}
	
	public enum StatusEnum {
		
		CREATE(0),
		CONFIRM(1),
		POISSUE(2),
		StopTrade(3),
		VOID(9);

		private int value;
		
		StatusEnum(int value) {
			this.value = value;
		}
		
		public int getValue() {
	        return value;
	    }
		
	}
}
