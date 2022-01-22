package cn.enilu.flash.bean.entity.sales;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "sla20")
@Table(appliesTo = "sla20",comment = "銷售訂單主資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Sla20 extends BaseEntity {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7695564286329926498L;
	
	
	@Column
	private Long sla20002; //房屋銷售案代號
	private String sla20003; //訂單號
	private String sla20004; //訂單日期
	private String sla20005; //訂單狀態
	private Long sla20006; //看屋人客戶基本資料唯一識別碼
	private String sla20007; //看屋人客戶編號
	private String sla20008; //看屋人客戶姓名
	private Long sla20009; //承購人客戶基本資料唯一識別碼
	private String sla20010; //承購人姓名
	private String sla20011; //承購人客戶編號
	private String sla20012; //承購人姓名
	private String sla20013; //性別代碼
	private String sla20014; //年齡
	private String sla20015; //電話號碼
	private String sla20016; //行動電話
	private String sla20017; //聯絡地址
	private String sla20018; //E-mail
	private String sla20019; //負責業務員工號
	private String sla20020; //負責業務員姓名
	private String sla20021; //區域代碼
	private String sla20022; //年齡區間代碼
	private String sla20023; //職業代碼
	private String sla20024; //需求產品代碼
	private String sla20025; //購買用途代碼
	private String sla20026; //現住狀況代碼
	private String sla20027; //車位需求代碼
	private String sla20028; //媒體代碼
	private String sla20029; //詢問重點代碼
	private String sla20030; //需求房數代碼
	private String sla20031; //需求坪數代碼
	private String sla20032; //需求價位代碼
	private String sla20033; //洽詢戶別代碼
	private String sla20034; //已購原因代碼
	private String sla20035; //未購原因代碼
	private String sla20036; //承購人備註1
	private String sla20037; //承購人備註2
	private Long sla20038; //房屋銷售案可售房屋資料唯一識別碼
	private String sla20039; //房屋銷售案代號
	private String sla20040; //區別
	private String sla20041; //棟別
	private String sla20042; //戶號
	private String sla20043; //屋型
	private String sla20044; //格局
	private String sla20045; //樓層數
	private String sla20046; //地坪數
	private String sla20047; //建坪數
	private String sla20048; //公設建坪數
	private String sla20049; //地號
	private String sla20050; //地址
	private String sla20051; //建照取得日期
	private String sla20052; //建照號碼
	private String sla20053; //使用執照取得日期
	private String sla20054; //使用執照號碼
	private int sla20055; //附贈汽車車位數量
	private int sla20056; //自購汽車車位數量
	private int sla20057; //附贈機車車位數量
	private int sla20058; //自購機車車位數量
	private int sla20059; //銷售表價
	private int sla20060; //業務員底價
	private int sla20061; //業務員超價
	private int sla20062; //特殊折扣底價
	private int sla20063; //裝潢費用
	private int sla20064; //仲人費用
	private int sla20065; //裝潢工程費用
	private int sla20066; //超價
	private int sla20067; //低底價
	private int sla20068; //成交總價
	private int sla20069; //訂金
	private String sla20070; //下訂日期
	private String sla20071; //訂金收款人
	private int sla20072; //簽約金
	private String sla20073; //簽約日期
	private String sla20074; //簽約收款人
	private double sla20075; //自備款%
	private int sla20076; //自備款
	private int sla20077; //已繳自備款
	private String sla20078; //自備款繳清日期
	private String sla20079; //自備款繳清確認人
	private double sla20080; //銀行貸款%
	private int sla20081; //銀行貸款
	private String sla20082; //貸款銀行
	private String sla20083; //貸款撥款單號
	private int sla20084; //貸款撥款金額
	private String sla20085; //貸款撥款日期
	private String sla20086; //銀行貸款收款人
	private String sla20087; //交易備註1
	private String sla20088; //交易備註2
	private String sla20089; //交易備註3
	private String sla20090; //交易備註4
	private String sla20091; //交易備註5
	private String sla20092; //交易備註6
	private String sla20093; //交易備註7
	private String sla20094; //交易備註8
	private String sla20095; //交易備註9
	private String sla20096; //交易備註10
	private String sla20097; //資料狀態
	private String sla20098; //業績歸屬人1
	private String sla20099; //業績歸屬人2
	private String sla20100; //業績歸屬人3
	private String sla20101; //業績歸屬人4
	private String sla20102; //業績歸屬人5

}
