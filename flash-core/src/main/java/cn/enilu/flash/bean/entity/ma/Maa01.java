package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa01")
@Table(appliesTo = "maa01",comment = "工程預算類別金額資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa01 extends BaseEntity {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4201824095900763988L;

	private Long id; //資料表唯一識別碼
	
	private Long maa01002; //工程案基本資料唯一識別碼
	private Long maa01003; //工程預算大類別基本資料表唯一識別碼
	private Long maa01004; //工程預算小類別基本資料表唯一識別碼
	private String maa01005; //工程編號
	private String maa01006; //工程案代號
	private String maa01007; //工程案名稱
	private String maa01008; //工程預算大類別代號
	private String maa01009; //工程預算小類別代號
	private String maa01010; //工程預算大類別名稱
	private String maa01011; //工程預算小類別名稱
	private int maa01012; //預算金額
	private int maa01013; //結算金額
	private int maa01014; //累計請款金額
	private int maa01015; //保留款金額
	private int maa01016; //累計估驗金額
	private int maa01017; //排序
	private String maa01018; //狀態碼
	private String maa01019; //資料狀態
	
}
