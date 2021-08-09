package cn.enilu.flash.bean.entity.sales;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "sla23")
@Table(appliesTo = "sla23",comment = "銷售訂單收款記錄資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Sla23 extends BaseEntity {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4342426905096432045L;
	
	
	@Column
	private int sla23002; //訂單主資料唯一識別碼
	private String sla23003; //訂單號
	private int sla23004; //收款次數
	private String sla23005; //收款日期
	private String sla23006; //收款類別
	private String sla23007; //其他收款方式
	private int sla23008; //收款金額
	private String sla23009; //收款人工號
	private String sla23010; //收款人姓名
	private String sla23011; //收款確認人工號
	private String sla23012; //收款確認人姓名
	private String sla23013; //入帳銀行代號
	private String sla23014; //入帳銀行名稱
	private String sla23015; //銀行入帳單號
	private String sla23016; //銀行入帳帳號
	private String sla23017; //銀行入帳帳戶名稱
	private String sla23018; //銀行入帳日期
	private int sla23019; //銀行入帳金額
	private String sla23020; //入款銀行代號
	private String sla23021; //入款銀行名稱
	private String sla23022; //銀行入帳確認人工號
	private String sla23023; //銀行入帳確認人姓名
	private String sla23024; //銀行入款單號
	private String sla23025; //銀行入款帳號
	private String sla23026; //銀行入款單號
	private String sla23027; //銀行入款帳號
	private String sla23028; //銀行入款帳戶名稱
	private String sla23029; //銀行入款日期
	private int sla23030; //銀行入款金額
	private String sla23031; //銀行入款確認人工號
	private String sla23032; //銀行入款確認人姓名
	private String sla23033; //收款類別
	private int sla23034; //期款次數
	private String sla23035; //期款名稱
	private String sla23036; //立帳日期
	private String sla23037; //立帳人工號
	private String sla23038; //立帳人姓名
	private String sla23039; //退款識別
	private String sla23040; //退款人工號
	private String sla23041; //退款人姓名
	private String sla23042; //退款銀行代號
	private String sla23043; //退款銀行名稱
	private String sla23044; //退款單號
	private String sla23045; //退款帳號
	private String sla23046; //退款帳戶名稱
	private String sla23047; //保留欄位1
	private String sla23048; //保留欄位2
	private String sla23049; //保留欄位3
	private String sla23050; //保留欄位4
	private String sla23051; //保留欄位5
	private String sla23052; //資料狀態

}
