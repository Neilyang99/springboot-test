package cn.enilu.flash.bean.entity.sales;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "slb11")
@Table(appliesTo = "slb11",comment = "業務專案日報成交明細資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Slb11 extends BaseEntity {


	@Column
	private Long slb11002; //業務專案日報基本資料唯一識別碼
	private String slb11003; //成交編號
	private String slb11004; //棟別
	private String slb11005; //戶號
	private String slb11006; //總金額
	private String slb11007; //定金金額
	private String slb11008; //備註
	private String slb11009; //資料狀態
	private Long slb11010; //棟別唯一識別碼
	
//	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
//	@JoinColumn(name="slb11002", insertable=false, updatable = false)
//	private Slb10 slb10;
	
}
