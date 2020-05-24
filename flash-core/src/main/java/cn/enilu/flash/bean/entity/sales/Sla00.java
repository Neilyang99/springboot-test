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

	@Column
	private String sla00002;
	
	@Column
	private String sla00003;
	
	@Column
	private String sla00041;//銷售狀態
	
	@Column
	private String sla00042;//結案狀態
	
	@Column
	private String sla00048;//資料狀態
}
