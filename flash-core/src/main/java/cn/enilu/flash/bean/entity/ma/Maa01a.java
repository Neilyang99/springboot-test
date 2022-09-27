package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa01a")
@Table(appliesTo = "maa01a",comment = "工程預算/結算書明細資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa01a extends BaseEntity {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7908781928108017364L;

	private Long id; //資料表唯一識別碼
	
	private Long maa01a002; //工程案基本資料唯一識別碼
	private Long maa01a003; //工程預算大類別基本資料表唯一識別碼
	private Long maa01a004; //工程預算小類別基本資料表唯一識別碼
	private Long maa01a005; //工程預算項目基本資料表唯一識別碼
	private int maa01a006; //項次
	private String maa01a007; //工程編號
	private String maa01a008; //工程案代號
	private String maa01a009; //工程案名稱
	private String maa01a010; //工程預算大類別名稱
	private String maa01a011; //工程預算小類別名稱
	private String maa01a012; //工程預算項目代號
	private String maa01a013; //工程預算項目名稱
	private String maa01a014; //單位
	private int maa01a015; //預算數量
	private int maa01a016; //預算單價
	private int maa01a017; //預算複價
	private String maa01a018; //預算備註1
	private String maa01a019; //預算備註2
	private int maa01a020; //結算數量
	private int maa01a021; //結算單價
	private int maa01a022; //結算複價
	private String maa01a023; //結算備註1
	private String maa01a024; //結算備註2
	private String maa01a025; //預算編訂狀態碼
	private String maa01a026; //結算狀態碼
	private String maa01a027; //進度狀態碼
	private String maa01a028; //結案狀態碼
	private String maa01a029; //保留欄位1
	private String maa01a030; //保留欄位2
	private String maa01a031; //保留欄位3
	private String maa01a032; //保留欄位4
	private String maa01a033; //保留欄位5
	private String maa01a034; //資料狀態
	private String maa01a035; //預算編訂人工號
	private String maa01a036; //預算編訂日期時間
	private String maa01a037; //結算人工號
	private String maa01a038; //結算日期時間
	
}
