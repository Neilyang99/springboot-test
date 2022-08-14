package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa17")
@Table(appliesTo = "maa17",comment = "零用金明細檔")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa17 extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5246792253128059549L;
	private Long maa17002; //零用金主檔唯一識別碼
	private String maa17003; //零用金類別
	private String maa17004; //項目日期
	private int maa17005; //金額
	private String maa17006; //來源/證明
	private String maa17007; //內容說明
}
