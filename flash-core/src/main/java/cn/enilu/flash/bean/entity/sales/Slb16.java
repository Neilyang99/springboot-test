package cn.enilu.flash.bean.entity.sales;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "slb16")
@Table(appliesTo = "slb16",comment = "業務專案日報簽約明細資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Slb16 extends BaseEntity {


	/**
	 * 
	 */
	private static final long serialVersionUID = -9105424711903313621L;
	
	
	@Column
	private Long slb16002; //業務專案日報基本資料唯一識別碼
	private String slb16003; //簽約編號
	private String slb16004; //棟別
	private String slb16005; //戶號
	private Integer slb16006; //總金額
	private Integer slb16007; //簽約金額
	private String slb16008; //備註
	private String slb16009; //資料狀態
	private Long slb16010; //可售房屋資料唯一識別碼

}
