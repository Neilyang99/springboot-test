package cn.enilu.flash.bean.entity.sales;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "slb13")
@Table(appliesTo = "slb13",comment = "業務專案日報退戶明細資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Slb13 extends BaseEntity {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8532303327303159975L;
	
	@Column
	private Long slb13002; //業務專案日報基本資料唯一識別碼
	private String slb13003; //退戶編號
	private String slb13004; //棟別
	private String slb13005; //戶號
	private Integer slb13006; //總金額
	private Integer slb13007; //退還金額
	private String slb13008; //備註
	private String slb13009; //資料狀態
	private Long slb13010; //可售房屋資料唯一識別碼

}
