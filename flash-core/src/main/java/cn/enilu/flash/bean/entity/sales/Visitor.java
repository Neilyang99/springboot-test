package cn.enilu.flash.bean.entity.sales;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "sla10")
@Table(appliesTo = "sla10",comment = "客戶基本資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Visitor extends BaseEntity {
	
	@Column
	private String sla10002;
	
	@Column
	private String sla10003;

	@Column
	private String sla10004;
	
	@Column
	private String sla10005;
	
	@Column
	@NotBlank(message = "客戶姓名不能為空白")
	private String sla10006;
	
	@Column
	private String sla10007;
	
	@Column
	private String sla10008;
	
	@Column
	private String sla10009;
	
	@Column
	@NotBlank(message = "行動電話不能為空白")
	private String sla10010;
	
	@Column
	private String sla10011;
	
	@Column
	private String sla10012;
	
	@Column
	private String sla10013;
	
	@Column
	private String sla10014;
	
	@Column
	private String sla10015;
	
	@Column
	private String sla10016;
	
	@Column
	private String sla10017;
	
	@Column
	private String sla10018;
	
	@Column
	private String sla10019;
	
	@Column
	private String sla10020;
	
	@Column
	private String sla10021;
	
	@Column
	private String sla10022;
	
	@Column
	private String sla10023;
	
	@Column
	private String sla10024;
	
	@Column
	private String sla10025;
	
	@Column
	private String sla10026;
	
	@Column
	private String sla10027;
	
	@Column
	private String sla10028;
	
	@Column
	private String sla10029;
	
	@Column
	private String sla10030;

	@Column
	private String sla10031;

	@Column
	private String sla10032;

	@Column
	private String sla10033;

	@Column
	private String sla10034;

	
}
