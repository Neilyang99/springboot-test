package cn.enilu.flash.bean.entity.sales;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "sla02")
@Table(appliesTo = "sla02",comment = "房屋銷售案可售車位資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Sla02 extends BaseEntity {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3214561880887030497L;
	
	@Column
	private String sla02002; //房屋銷售案資料唯一識別碼
	private String sla02003; //房屋銷售案代號
	private String sla02004; //車位編號
	private String sla02005; //車位類別
	private String sla02006; //車位類型
	private String sla02007; //層數
	private String sla02008; //購買類別
	private String sla02009; //地坪數
	private String sla02010; //建坪數
	private String sla02011; //地號
	private String sla02012; //房屋銷售案可售房屋資料唯一識別碼
	private String sla02013; //房屋編號
	private String sla02014; //銷售表價
	private String sla02015; //業務員底價
	private String sla02016; //業務員超價
	private String sla02017; //特殊折扣底價
	private String sla02018; //裝潢費用
	private String sla02019; //仲人費用
	private String sla02020; //裝潢工程費用
	private String sla02021; //超價
	private String sla02022; //低底價
	private String sla02023; //銷售狀態碼
	private String sla02024; //保留欄位1
	private String sla02025; //保留欄位2
	private String sla02026; //保留欄位3
	private String sla02027; //保留欄位4
	private String sla02028; //保留欄位5
	private String sla02029; //資料狀態
	
}
