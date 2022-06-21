package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa10")
@Table(appliesTo = "maa10",comment = "材料入庫紀錄表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa10 extends BaseEntity {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8424431166934491200L;
	
	
	private Long maa10002; //工程案基本資料唯一識別碼
	private String maa10003; //報表類別
	private String maa10004; //使用位置
	private String maa10005; //進料日期
	private Long maa10006; //料號PK
	private Long maa10007; //供料廠商PK
	private double maa10008; //數量
	private int maa10009; //單價
	private String maa10010; //單位
	private String maa10011; //使用區簽收人PK
	private String maa10012; //備註
	private String maa10013; //資料狀態
	
}
