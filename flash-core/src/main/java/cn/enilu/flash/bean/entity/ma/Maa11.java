package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa11")
@Table(appliesTo = "maa11",comment = "混凝土使用量統計表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa11 extends BaseEntity {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2488296785731199324L;
	private Long maa11002; //工程案基本資料唯一識別碼
	private String maa11003; //報表類別
	private String maa11004; //使用位置
	private String maa11005; //進料日期
	private String maa11006; //混凝土強度(PSI)
	private Long maa11007; //供料廠商PK
	private double maa11008; //實際使用數量
	private double maa11009; //預計進貨數量
	private String maa11010; //誤差情形
	private double maa11011; //誤差比率
	private String maa11012; //原因分析
	private String maa11013; //資料狀態
	
}
