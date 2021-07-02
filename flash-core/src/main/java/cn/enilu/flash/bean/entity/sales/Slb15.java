package cn.enilu.flash.bean.entity.sales;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "slb15")
@Table(appliesTo = "slb15",comment = "業務專案日報訂金補足明細資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Slb15 extends BaseEntity {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5103135220607219299L;
	
	
	@Column
	private Long slb15002; //業務專案日報基本資料唯一識別碼
	private String slb15003; //訂金補足編號
	private String slb15004; //棟別
	private String slb15005; //戶號
	private Integer slb15006; //總金額
	private Integer slb15007; //補足金額
	private String slb15008; //備註
	private String slb15009; //資料狀態
	private Long slb15010; //可售房屋資料唯一識別碼

	
}
