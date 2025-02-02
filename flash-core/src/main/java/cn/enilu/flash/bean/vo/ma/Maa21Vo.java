package cn.enilu.flash.bean.vo.ma;

import lombok.Data;

@Data
/**
 * Maa21 value object
 *
 * @author YWG
 */
public class Maa21Vo {
	
   
	private Long id;
	private String maa21002; //合約編號
	private Long maa21003; //工程案唯一識別碼
	private Long maa21004; //請款公司唯一識別碼
	private Long maa21005; //付款公司唯一識別碼
	private int maa21006; //版本
	private String maa21007; //合約日期
	private int maa21008; //請款%
	private int maa21009; //稅率
	private int maa21010; //現金付款%
	private int maa21011; //支票付款%
	private int maa21012; //匯款付款%
	private int maa21013; //其他付款%
	private String maa21014; //幣別
	private double maa21015; //匯率
	private double maa21016; //合約金額
	private double maa21017; //保固金
	private int maa21018; //訂金%
	private int maa21019; //期款%
	private int maa21020; //尾款%
	private int maa21021; //資料狀態
	private int maa21022; //付款條件
	private String maa21023; //主要工程項目
	private String maa21024; //發出者工號
	private String maa21025; //發出日期時間
	private String maa21026; //確認者工號
	private String maa21027; //確認日期時間
	
	private String maa22String;// maa22data 

}
