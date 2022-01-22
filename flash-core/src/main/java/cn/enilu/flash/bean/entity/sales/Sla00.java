package cn.enilu.flash.bean.entity.sales;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "sla00")
@Table(appliesTo = "sla00",comment = "房屋銷售案基本資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Sla00 extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4861203534917509625L;

	@Column(unique = true)
	private String sla00002;//房屋銷售案代號
	
	@Column
	private String sla00003;//房屋銷售案名稱
	private String sla00004; //基地地號
	private String sla00005; //工地開工日期
	private String sla00006; //工地完工日期
	private String sla00007; //進場日期
	private String sla00008; //開始銷售日期
	private String sla00009; //結案日期
	private String sla00010; //銷售日數
	private Integer sla00011; //可售透天店面數
	private Integer sla00012; //可售透天住家數
	private Integer sla00013; //可售大樓店面數
	private Integer sla00014; //可售大樓住家數
	private Integer sla00015; //可售平面汽車停車位數
	private Integer sla00016; //可配平面機車停車位數
	private Integer sla00017; //可售機械汽車停車位數
	private Integer sla00018; //售出透天店面數
	private Integer sla00019; //售出透天住家數
	private Integer sla00020; //售出大樓店面數
	private Integer sla00021; //售出大樓住家數
	private Integer sla00022; //售出平面汽車停車位數
	private Integer sla00023; //已配平面機車停車位數
	private Integer sla00024; //售出機械汽車停車位數
	private Integer sla00025; //累計來人數
	private Integer sla00026; //累計來電數
	private Integer sla00027; //可銷總金額
	private Integer sla00028; //底價總銷
	private Integer sla00029; //表價總綃
	private Integer sla00030; //廣告預算
	private Integer sla00031; //完簽總銷
	private Integer sla00032; //底銷-扣超價
	private Integer sla00033; //超價-扣退戶
	private Integer sla00034; //裝潢費用-總銷
	private Integer sla00035; //仲人費用
	private Integer sla00036; //裝潢工程費用-超價
	private Integer sla00037; //累計開銷金額
	private Integer sla00038; //價差金額
	private Double sla00039; //總超價%
	private Double sla00040; //比例
	
	@Column
	private String sla00041;//銷售狀態
	
	@Column
	private String sla00042;//結案狀態
	
	@Column
	private String sla00048;//資料狀態
	private String sla00043; //車位價格
	private String sla00044; //保留欄位2
	private String sla00045; //保留欄位3
	private String sla00046; //保留欄位4
	private String sla00047; //保留欄位5
}
