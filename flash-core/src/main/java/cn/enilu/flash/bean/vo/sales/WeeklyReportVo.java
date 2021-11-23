package cn.enilu.flash.bean.vo.sales;

import javax.persistence.Column;

import lombok.Data;

@Data
public class WeeklyReportVo {
	
	@Column
	private String period;//銷售期間
	private int totalHouse;//總銷售戶數
	private int totalAmt;//總銷售金額
	private int totalCar;//總銷售汽車數
	private int totalCarAmt;//總銷售汽車金額
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
	private String media1;//廣告媒體
	private int personCnt1;//來人
	private int telCnt1;//來電
	private int againCnt1;//回籠
	
	private int dealHouse1;//成交戶數
	private int dealAmt1;//成交金額
	private int dealCar1;//成交車數
	private int dealCarAmt1;//成交車金額
	
	private int depositHouse1;//小訂戶數
	private int depositAmt1;//小訂金額
	private int depositCar1;//小訂車數
	private int depositCarAmt1;//小訂車金額

	private int fillHouse1;//補足戶數
	private int fillAmt1;//補足金額
	private int fillCar1;//補足車數
	private int fillCarAmt1;//補足車金額

	private int orderHouse1;//簽約戶數
	private int orderAmt1;//簽約金額
	private int orderCar1;//簽約車數
	private int orderCarAmt1;//簽約車金額

	private int cancelHouse1;//退戶戶數
	private int cancelAmt1;//退戶金額
	private int cancelCar1;//退戶車數
	private int cancelCarAmt1;//退戶車金額
	
	//----------------------------------------
	private String date2;//日期
	private String week2;//星期
	private String media2;//廣告媒體
	private int personCnt2;//來人
	private int telCnt2;//來電
	private int againCnt2;//回籠
	
	private int dealHouse2;//成交戶數
	private int dealAmt2;//成交金額
	private int dealCar2;//成交車數
	private int dealCarAmt2;//成交車金額
	
	private int depositHouse2;//小訂戶數
	private int depositAmt2;//小訂金額
	private int depositCar2;//小訂車數
	private int depositCarAmt2;//小訂車金額

	private int fillHouse2;//補足戶數
	private int fillAmt2;//補足金額
	private int fillCar2;//補足車數
	private int fillCarAmt2;//補足車金額

	private int orderHouse2;//簽約戶數
	private int orderAmt2;//簽約金額
	private int orderCar2;//簽約車數
	private int orderCarAmt2;//簽約車金額

	private int cancelHouse2;//退戶戶數
	private int cancelAmt2;//退戶金額
	private int cancelCar2;//退戶車數
	private int cancelCarAmt2;//退戶車金額
	//----------------------------------------
	private String date3;//日期
	private String week3;//星期
	private String media3;//廣告媒體
	private int personCnt3;//來人
	private int telCnt3;//來電
	private int againCnt3;//回籠
	
	private int dealHouse3;//成交戶數
	private int dealAmt3;//成交金額
	private int dealCar3;//成交車數
	private int dealCarAmt3;//成交車金額
	
	private int depositHouse3;//小訂戶數
	private int depositAmt3;//小訂金額
	private int depositCar3;//小訂車數
	private int depositCarAmt3;//小訂車金額

	private int fillHouse3;//補足戶數
	private int fillAmt3;//補足金額
	private int fillCar3;//補足車數
	private int fillCarAmt3;//補足車金額

	private int orderHouse3;//簽約戶數
	private int orderAmt3;//簽約金額
	private int orderCar3;//簽約車數
	private int orderCarAmt3;//簽約車金額

	private int cancelHouse3;//退戶戶數
	private int cancelAmt3;//退戶金額
	private int cancelCar3;//退戶車數
	private int cancelCarAmt3;//退戶車金額	
	//----------------------------------------
	private String date4;//日期
	private String week4;//星期
	private String media4;//廣告媒體
	private int personCnt4;//來人
	private int telCnt4;//來電
	private int againCnt4;//回籠
	
	private int dealHouse4;//成交戶數
	private int dealAmt4;//成交金額
	private int dealCar4;//成交車數
	private int dealCarAmt4;//成交車金額
	
	private int depositHouse4;//小訂戶數
	private int depositAmt4;//小訂金額
	private int depositCar4;//小訂車數
	private int depositCarAmt4;//小訂車金額

	private int fillHouse4;//補足戶數
	private int fillAmt4;//補足金額
	private int fillCar4;//補足車數
	private int fillCarAmt4;//補足車金額

	private int orderHouse4;//簽約戶數
	private int orderAmt4;//簽約金額
	private int orderCar4;//簽約車數
	private int orderCarAmt4;//簽約車金額

	private int cancelHouse4;//退戶戶數
	private int cancelAmt4;//退戶金額
	private int cancelCar4;//退戶車數
	private int cancelCarAmt4;//退戶車金額
	//--5--------------------------------------
	private String date5;//日期
	private String week5;//星期
	private String media5;//廣告媒體
	private int personCnt5;//來人
	private int telCnt5;//來電
	private int againCnt5;//回籠
	
	private int dealHouse5;//成交戶數
	private int dealAmt5;//成交金額
	private int dealCar5;//成交車數
	private int dealCarAmt5;//成交車金額
	
	private int depositHouse5;//小訂戶數
	private int depositAmt5;//小訂金額
	private int depositCar5;//小訂車數
	private int depositCarAmt5;//小訂車金額

	private int fillHouse5;//補足戶數
	private int fillAmt5;//補足金額
	private int fillCar5;//補足車數
	private int fillCarAmt5;//補足車金額

	private int orderHouse5;//簽約戶數
	private int orderAmt5;//簽約金額
	private int orderCar5;//簽約車數
	private int orderCarAmt5;//簽約車金額

	private int cancelHouse5;//退戶戶數
	private int cancelAmt5;//退戶金額
	private int cancelCar5;//退戶車數
	private int cancelCarAmt5;//退戶車金額	
	//---6-------------------------------------
	private String date6;//日期
	private String week6;//星期
	private String media6;//廣告媒體
	private int personCnt6;//來人
	private int telCnt6;//來電
	private int againCnt6;//回籠
	
	private int dealHouse6;//成交戶數
	private int dealAmt6;//成交金額
	private int dealCar6;//成交車數
	private int dealCarAmt6;//成交車金額
	
	private int depositHouse6;//小訂戶數
	private int depositAmt6;//小訂金額
	private int depositCar6;//小訂車數
	private int depositCarAmt6;//小訂車金額

	private int fillHouse6;//補足戶數
	private int fillAmt6;//補足金額
	private int fillCar6;//補足車數
	private int fillCarAmt6;//補足車金額

	private int orderHouse6;//簽約戶數
	private int orderAmt6;//簽約金額
	private int orderCar6;//簽約車數
	private int orderCarAmt6;//簽約車金額

	private int cancelHouse6;//退戶戶數
	private int cancelAmt6;//退戶金額
	private int cancelCar6;//退戶車數
	private int cancelCarAmt6;//退戶車金額
	//---7-------------------------------------
	private String date7;//日期
	private String week7;//星期
	private String media7;//廣告媒體
	private int personCnt7;//來人
	private int telCnt7;//來電
	private int againCnt7;//回籠
	
	private int dealHouse7;//成交戶數
	private int dealAmt7;//成交金額
	private int dealCar7;//成交車數
	private int dealCarAmt7;//成交車金額
	
	private int depositHouse7;//小訂戶數
	private int depositAmt7;//小訂金額
	private int depositCar7;//小訂車數
	private int depositCarAmt7;//小訂車金額

	private int fillHouse7;//補足戶數
	private int fillAmt7;//補足金額
	private int fillCar7;//補足車數
	private int fillCarAmt7;//補足車金額

	private int orderHouse7;//簽約戶數
	private int orderAmt7;//簽約金額
	private int orderCar7;//簽約車數
	private int orderCarAmt7;//簽約車金額

	private int cancelHouse7;//退戶戶數
	private int cancelAmt7;//退戶金額
	private int cancelCar7;//退戶車數
	private int cancelCarAmt7;//退戶車金額
	//---本週累計-------------------------------------
	private int personCntWeek;//來人
	private int telCntWeek;//來電
	private int againCntWeek;//回籠
	
	private int dealHouseWeek;//成交戶數
	private int dealAmtWeek;//成交金額
	private int dealCarWeek;//成交車數
	private int dealCarAmtWeek;//成交車金額
	
	private int depositHouseWeek;//小訂戶數
	private int depositAmtWeek;//小訂金額
	private int depositCarWeek;//小訂車數
	private int depositCarAmtWeek;//小訂車金額

	private int fillHouseWeek;//補足戶數
	private int fillAmtWeek;//補足金額
	private int fillCarWeek;//補足車數
	private int fillCarAmtWeek;//補足車金額

	private int orderHouseWeek;//簽約戶數
	private int orderAmtWeek;//簽約金額
	private int orderCarWeek;//簽約車數
	private int orderCarAmtWeek;//簽約車金額

	private int cancelHouseWeek;//退戶戶數
	private int cancelAmtWeek;//退戶金額
	private int cancelCarWeek;//退戶車數
	private int cancelCarAmtWeek;//退戶車金額	
	//---上週累計-------------------------------------
	private int personCntWeekAcc;//來人
	private int telCntWeekAcc;//來電
	private int againCntWeekAcc;//回籠
	
	private int dealHouseWeekAcc;//成交戶數
	private int dealAmtWeekAcc;//成交金額
	private int dealCarWeekAcc;//成交車數
	private int dealCarAmtWeekAcc;//成交車金額
	
	private int depositHouseWeekAcc;//小訂戶數
	private int depositAmtWeekAcc;//小訂金額
	private int depositCarWeekAcc;//小訂車數
	private int depositCarAmtWeekAcc;//小訂車金額

	private int fillHouseWeekAcc;//補足戶數
	private int fillAmtWeekAcc;//補足金額
	private int fillCarWeekAcc;//補足車數
	private int fillCarAmtWeekAcc;//補足車金額

	private int orderHouseWeekAcc;//簽約戶數
	private int orderAmtWeekAcc;//簽約金額
	private int orderCarWeekAcc;//簽約車數
	private int orderCarAmtWeekAcc;//簽約車金額

	private int cancelHouseWeekAcc;//退戶戶數
	private int cancelAmtWeekAcc;//退戶金額
	private int cancelCarWeekAcc;//退戶車數
	private int cancelCarAmtWeekAcc;//退戶車金額
	//---總累計-------------------------------------
	private int personCntTotal;//來人
	private int telCntTotal;//來電
	private int againCntTotal;//回籠
	
	private int dealHouseTotal;//成交戶數
	private int dealAmtTotal;//成交金額
	private int dealCarTotal;//成交車數
	private int dealCarAmtTotal;//成交車金額
	
	private int depositHouseTotal;//小訂戶數
	private int depositAmtTotal;//小訂金額
	private int depositCarTotal;//小訂車數
	private int depositCarAmtTotal;//小訂車金額

	private int fillHouseTotal;//補足戶數
	private int fillAmtTotal;//補足金額
	private int fillCarTotal;//補足車數
	private int fillCarAmtTotal;//補足車金額

	private int orderHouseTotal;//簽約戶數
	private int orderAmtTotal;//簽約金額
	private int orderCarTotal;//簽約車數
	private int orderCarAmtTotal;//簽約車金額

	private int cancelHouseTotal;//退戶戶數
	private int cancelAmtTotal;//退戶金額
	private int cancelCarTotal;//退戶車數
	private int cancelCarAmtTotal;//退戶車金額	
	//---總累計%-------------------------------------
	private float dealHouseTTP;//成交戶數
	private float dealAmtTTP;//成交金額
	private float dealCarTTP;//成交車數
	private float dealCarAmtTTP;//成交車金額
	
	private float depositHouseTTP;//小訂戶數
	private float depositAmtTTP;//小訂金額
	private float depositCarTTP;//小訂車數
	private float depositCarAmtTTP;//小訂車金額

	private float fillHouseTTP;//補足戶數
	private float fillAmtTTP;//補足金額
	private float fillCarTTP;//補足車數
	private float fillCarAmtTTP;//補足車金額

	private float orderHouseTTP;//簽約戶數
	private float orderAmtTTP;//簽約金額
	private float orderCarTTP;//簽約車數
	private float orderCarAmtTTP;//簽約車金額

	private float cancelHouseTTP;//退戶戶數
	private float cancelAmtTTP;//退戶金額
	private float cancelCarTTP;//退戶車數
	private float cancelCarAmtTTP;//退戶車金額		
}
