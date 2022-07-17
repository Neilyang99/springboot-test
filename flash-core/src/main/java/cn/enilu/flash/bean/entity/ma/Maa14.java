package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa14")
@Table(appliesTo = "maa14",comment = "工地臨時工上工紀錄")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa14 extends BaseEntity {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5230011853826877055L;
	
	private Long maa14002; //工程案基本資料唯一識別碼
	private String maa14003; //臨時工姓名
	private String maa14004; //出工日期
	private String maa14005; //出工日期_年
	private String maa14006; //出工日期_月
	private String maa14007; //工地區別
	private String maa14008; //備註
	private String maa14009; //資料狀態
	
}
