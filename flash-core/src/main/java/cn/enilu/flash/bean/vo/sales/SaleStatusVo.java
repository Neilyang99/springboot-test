package cn.enilu.flash.bean.vo.sales;

import javax.persistence.Column;

import lombok.Data;

@Data
public class SaleStatusVo {
	
	@Column
	private int totalAmt_under;
	private int totalAmt_form;
	private int soldQty;
	private int remainQty;//剩餘戶數
	private int weeklySoldQty;//本週售出
	private int weeklyCancelQty;//本週退戶
	private int weeklyChangeQty;//換戶
	private int weeklyDealQty;//實際成交
	private int weeklyOrderQty;//簽約成交
	private int weeklySoldAmt;//本週售出金額
	private int weeklyCancelAmt;
	private int weeklyChangeAmt;//換戶
	private int weeklyDealAmt;//實際成交
	private int weeklyOrderAmt;//簽約成交
	
	private int accSoldQty;//累計售出
	private int accCancelQty;//累計退戶
	private int accChangeQty;//換戶
	private int accDealQty;//實際成交
	private int accOrderQty;//簽約成交
	private int accSoldAmt;//累計售出金額
	private int accCancelAmt;
	private int accChangeAmt;//換戶
	private int accDealAmt;//實際成交
	private int accOrderAmt;//簽約成交
}
