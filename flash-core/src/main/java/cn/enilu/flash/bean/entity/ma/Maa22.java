package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa22")
@Table(appliesTo = "maa22",comment = "合約明細檔")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa22 extends BaseEntity {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6739300324928942072L;
	
	private Long id; //資料表唯一識別碼
	private Long maa22002; //合約唯一識別碼
	private int maa22003; //項次
	private Long maa22004; //工程預算類別明細資料唯一識別碼
	private String maa22005; //預算項目名稱
	private String maa22006; //預算單位
	private double maa22007; //預算數量
	private double maa22008; //預算單價
	private String maa22009; //是否現價
	private String maa22010; //合約單位
	private double maa22011; //合約數量
	private double maa22012; //合約單價
	private double maa22013; //合約複價
	private String maa22014; //備註
	private double maa22015; //已請款金額
	private Long maa22016; //關聯工程預算明細資料唯一識別碼
	private int maa22017; //資料狀態
	private String maa22018; //確認者工號
	private String maa22019; //確認日期時間
	
}
