package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa09")
@Table(appliesTo = "maa09",comment = "個人工地重要紀事")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa09 extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5400477687516778220L;
	
	private Long maa09002; //工程案基本資料唯一識別碼
	private String maa09003; //填表日期
	private String maa09004; //工地區別
	private String maa09005; //填表人
	private String maa09006; //工作Memo
	private String maa09007; //重要事項
	private String maa09008; //備註
	private int maa09009; //資料狀態
	
}
