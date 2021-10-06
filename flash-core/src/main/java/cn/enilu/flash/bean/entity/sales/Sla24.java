package cn.enilu.flash.bean.entity.sales;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "sla24")
@Table(appliesTo = "sla24",comment = "銷售訂單驗收記錄資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Sla24 extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -241213172460206954L;
	
	
	@Column
	private Long id; //訂單驗收資料唯一識別碼
	private Long sla24002; //訂單主資料唯一識別碼
	private String sla24003; //訂單號
	private String sla24004; //驗收類別
	private String sla24005; //驗收日期
	private String sla24006; //項目分類
	private String sla24007; //驗收內容
	private String sla24008; //完成日期
	private String sla24009; //備註


}
