package cn.enilu.flash.bean.entity.sales;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "slb12")
@Table(appliesTo = "slb12",comment = "業務專案日報回籠明細資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Slb12 extends BaseEntity {


	private static final long serialVersionUID = -6633789343187423292L;
	
	@Column
	private Long slb12002; //業務專案日報基本資料唯一識別碼
	private String slb12003; //回籠編號
	private String slb12004; //棟別
	private String slb12005; //戶號
	private String slb12006; //備註
	private String slb12007; //資料狀態
	private Long slb12008; //可售房屋資料唯一識別碼

}
