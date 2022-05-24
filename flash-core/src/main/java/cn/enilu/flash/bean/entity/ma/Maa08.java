package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa08")
@Table(appliesTo = "maa08",comment = "出工人數統計表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa08 extends BaseEntity {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7959537690958608432L;
	
	private Long maa08002; //工程案基本資料唯一識別碼
	private String maa08003; //出工日期
	private String maa08004; //出工日期_年月
	private Long maa08005; //工種
	private String maa08006; //工地區別
	private String maa08007; //天氣
	private String maa08008; //人數
	private String maa08009; //備註
	private int maa08010; //資料狀態
	
}
