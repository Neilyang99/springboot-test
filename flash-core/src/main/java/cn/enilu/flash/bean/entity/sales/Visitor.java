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
	private Integer sla10001;
	
	@Column
	private String sla10002;

	@Column
	private String sla10004;
	
	@Column
	private String sla10005;
	
	@Column
	@NotBlank(message = "客戶姓名不能為空白")
	private String sla10006;
	
	@Column
	@NotBlank(message = "電話不能為空白")
	private String sla10009;
	
	@Column
	private String sla10013;
	
	@Column
	private String sla10014;
	
}
