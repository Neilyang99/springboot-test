package cn.enilu.flash.bean.vo.ma;

import lombok.Data;

@Data
/**
 * Maa22 value object
 *
 * @author YWG
 */
public class Maa22Vo {
	
   
private Long id; //資料表唯一識別碼
	
	private Long maa22002; //合約唯一識別碼
	private int maa22003; //項次
	private Long maa22004; //工程預算明細資料唯一識別碼
	private String maa22005; //預算項目名稱
	private String maa22006; //合約項目名稱
	private String maa22007; //預算單位
	private double maa22008; //預算數量
	private double maa22009; //預算單價
	private String maa22010; //是否現價
	private String maa22011; //合約單位
	private double maa22012; //合約數量
	private double maa22013; //合約單價
	private double maa22014; //合約複價
	private String maa22015; //備註
	private double maa22016; //已請款金額
	private Long maa22017; //關聯工程預算明細資料唯一識別碼
	private int maa22018; //資料狀態
	private String maa22019; //確認者工號
	private String maa22020; //確認日期時間
	private Long maa22021; //工程預算子項目資料唯一識別碼
	private String createBy; //建立人工號
	private String createTime; //建立日期時間
	private String modifyBy; //異動人工號
	private String modifyTime; //異動日期時間

}
