package cn.enilu.flash.bean.vo.sales;

import javax.persistence.Column;

import lombok.Data;

@Data
public class NotDealAgainVo {
	
	@Column
	private String occurDate; 
	private String customerName;
	private String houseNo;
	private String causeName;
	private String salesName;
}
