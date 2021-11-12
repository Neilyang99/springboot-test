package cn.enilu.flash.bean.vo.sales;

import javax.persistence.Column;

import lombok.Data;

@Data
public class VisitorReportVo {
	
	@Column
	private String projectCode;
	private String projectName;
	private String itemName;
	private Integer countWeeklyByVisitor;
	private Double countPercentByVisitor;
	private Integer countAccByVisitor;
	private Double countAccPercentByVisitor;
	private Integer countWeeklyByTel;
	private Double countPercentByTel;
	private Integer countAccByTel;
	private Double countAccPercentByTel;
	private Integer countWeeklyByAgain;
	private Double countPercentByAgain;
	private Integer countAccByAgain;
	private Double countAccPercentByAgain;
	private Integer countWeeklyByOrder;
	private Double countPercentByOrder;
	private Integer countAccByOrder;
	private Double countAccPercentByOrder;

}
