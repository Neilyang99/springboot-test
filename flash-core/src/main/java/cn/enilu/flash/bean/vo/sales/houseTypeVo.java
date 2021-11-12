package cn.enilu.flash.bean.vo.sales;

import javax.persistence.Column;

import lombok.Data;

@Data
public class houseTypeVo {
	
	@Column
	
	private String houseType;//房型類別 
	private int planQty;//規劃
	private int weeklyQty;//本週售出
	private int accQty;//售出累計
	private int weeklyCancelQty;//本週退戶
	private int weeklyCancelAccQty;//退戶累積
	private int remainQty;//剩餘戶數
}
