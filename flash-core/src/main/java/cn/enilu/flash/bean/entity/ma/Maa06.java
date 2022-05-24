package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa06")
@Table(appliesTo = "maa06",comment = "混凝土氯離子品質紀錄")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa06 extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3999777191548712454L;
	
	private Long maa06002; //工程案基本資料唯一識別碼
	private String maa06003; //澆置位置
	private String maa06004; //澆置日期
	private Long maa06005; //供料廠商PK
	private double maa06006; //數量
	private int maa06007; //試樣組數
	private String maa06008; //試樣編號
	private double maa06009; //氯離子檢測1
	private double maa06010; //氯離子檢測2
	private double maa06011; //氯離子檢測3
	private double maa06012; //檢測平均值
	private String maa06013; //檢測合格判定
	private String maa06014; //備註
	private int maa06015; //資料狀態
}
