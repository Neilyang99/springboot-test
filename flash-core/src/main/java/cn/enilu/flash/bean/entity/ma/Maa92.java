package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa92")
@Table(appliesTo = "maa92",comment = "工程預算項目基本資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa92 extends BaseEntity {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2107448082360082963L;

	private Long id; //資料表唯一識別碼
	
	private Long maa92002; //工程預算大類別基本資料表唯一識別碼
	private Long maa92003; //工程預算小類別基本資料表唯一識別碼
	private String maa92004; //工程預算大類別代號
	private String maa92005; //工程預算小類別代號
	private String maa92006; //工程預算項目代號
	private String maa92007; //工程預算項目名稱
	private String maa92008; //單位
	private int maa92009; //預設數量
	private int maa92010; //預設單價
	private String maa92011; //備註
	private int maa92012; //排序
	private String maa92013; //狀態碼
	private String maa92014; //資料狀態
	
}
