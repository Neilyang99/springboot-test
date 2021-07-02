package cn.enilu.flash.bean.entity.sales;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "slb14")
@Table(appliesTo = "slb14",comment = "業務專案日報換戶明細資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Slb14 extends BaseEntity {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1739426298926358000L;
	
	
	@Column
	private Long slb14002; //業務專案日報基本資料唯一識別碼
	private String slb14003; //換戶編號
	private Long slb14004; //原可售房屋資料唯一識別碼
	private String slb14005; //原訂棟別
	private String slb14006; //原訂戶號
	private Long slb14007; //新可售房屋資料唯一識別碼
	private String slb14008; //新棟別
	private String slb14009; //新戶號
	private String slb14010; //備註
	private String slb14011; //資料狀態

}
