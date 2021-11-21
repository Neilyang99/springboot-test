package cn.enilu.flash.bean.vo.sales;

import javax.persistence.Column;

import lombok.Data;

@Data
public class WeeklyReportVo {
	
	@Column
	private String period;//銷售期間
	private int totalHouse;//總銷售戶數
	private int totalAmt;//總銷售金額
	private int actualHouse;//實際銷售戶數
	private int actualAmt;//實際銷售金額
	private int weeklyAgain;//本週回籠
	private int weeklyDealAgain;//本週回籠成交
	private int accAgain;//累計回籠
	private int accDeal;//累計成交
	private int accCancel;//累計退戶
	private int accActDeal;//累計實際成交
	private String wellSalesCause;//順銷原因
	private String badSalesCause;//滯銷原因
	private String suggestion;//建議對策
	private String weeklyMedia;//本週媒體
	
	private String date1;//日期
	private String week1;//星期
	private String media;//廣告媒體
	private int personCnt;//來人
	private int telCnt;//來電
	private int againCnt;//回籠
	
	private int dealHouse;//成交戶數
	private int dealAmt;//成交金額
	private int dealCar;//成交車數
	private int dealCarAmt;//成交車金額
	
	private int depositHouse;//小訂戶數
	private int depositAmt;//小訂金額
	private int depositCar;//小訂車數
	private int depositCarAmt;//小訂車金額

	private int fillHouse;//補足戶數
	private int fillAmt;//補足金額
	private int fillCar;//補足車數
	private int fillCarAmt;//補足車金額

	private int orderHouse;//簽約戶數
	private int orderAmt;//簽約金額
	private int orderCar;//簽約車數
	private int orderCarAmt;//簽約車金額

	private int cancelHouse;//退戶戶數
	private int cancelAmt;//退戶金額
	private int cancelCar;//退戶車數
	private int cancelCarAmt;//退戶車金額
	
	
}
