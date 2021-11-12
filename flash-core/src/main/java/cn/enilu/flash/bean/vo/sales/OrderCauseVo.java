package cn.enilu.flash.bean.vo.sales;

import javax.persistence.Column;

import lombok.Data;

@Data
public class OrderCauseVo {
	
	@Column
	private String itemCode; //已購或未購原因
	private String itemName;
	private Integer count1;//本週
	private Integer count2;//上週累加
	private Integer count3;
	private Double count4;
}
