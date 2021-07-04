package cn.enilu.flash.bean.vo.sales;

import javax.persistence.Column;

import lombok.Data;

@Data
public class VisitorSummaryVo {
	
	@Column
	private String projectCode;
	private String projectName;
	private String visitorType; //來人/來電
	private String itemCode; //媒體,年齡,區域,職業...
	private Integer totalCount;//累加
	private Integer weeklyCount;//本週
	

}
