package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa01b")
@Table(appliesTo = "maa01b",comment = "工程案施作項目明細表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa01b extends BaseEntity {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3343513100049861208L;

	private Long id; //資料表唯一識別碼
	private Long maa01b002; //工程案基本資料唯一識別碼
	private Long maa01b003; //工程預算大類別基本資料表唯一識別碼
	private Long maa01b004; //工程預算小類別基本資料表唯一識別碼
	private Long maa01b005; //工程預算/結算書明細資料唯一識別碼
	private Long maa01b006; //工程施作項目資料表唯一識別碼
	private Long maa01b007; //工程預算/結算書明細資料唯一識別碼
	private String maa01b008; //單位
	private double maa01b009; //數量
	private double maa01b010; //單價
	private double maa01b011; //複價
	private String maa01b012; //備註
	private double maa01b013; //最大數量
	private double maa01b014; //最小數量
	private String maa01b015; //規格
	private double maa01b016; //損耗率
	private String maa01b017; //項目名稱
	private String maa01b018; //狀態碼
	private String maa01b019; //資料狀態
	private int maa01b020; //項次
}
