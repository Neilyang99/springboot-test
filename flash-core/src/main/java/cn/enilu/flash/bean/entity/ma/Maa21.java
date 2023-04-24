package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa21")
@Table(appliesTo = "maa21",comment = "合約主檔")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa21 extends BaseEntity {
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8865722491151611688L;
	
	private Long id; //資料表唯一識別碼
	private String maa21002; //合約編號
	private Long maa21003; //工程案唯一識別碼
	private Long maa21004; //承包商唯一識別碼
	private int maa21005; //版本
	private String maa21006; //合約日期
	private int maa21007; //請款%
	private int maa21008; //稅率
	private int maa21009; //現金付款%
	private int maa21010; //支票付款%
	private int maa21011; //匯款付款%
	private int maa21012; //其他付款%
	private String maa21013; //幣別
	private float maa21014; //匯率
	private double maa21015; //合約金額
	private double maa21016; //保固金
	private int maa21017; //訂金%
	private int maa21018; //期款%
	private int maa21019; //尾款%
	private int maa21020; //資料狀態
	private String maa21021; //發出者工號
	private String maa21022; //發出日期時間
	
	
}
