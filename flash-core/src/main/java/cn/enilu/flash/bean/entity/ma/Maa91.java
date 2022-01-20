package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa91")
@Table(appliesTo = "maa91",comment = "工程預算小類別基本資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa91 extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4863693045487736884L;

	private Long id; //資料表唯一識別碼
	
	private Long maa91002; //工程預算大類別基本資料表唯一識別碼
	private String maa91003; //工程預算大類別代號
	private String maa91004; //工程預算小類別代號
	private String maa91005; //工程預算小類別名稱
	private int maa91006; //排序
	private String maa91007; //狀態碼
	private String maa91008; //資料狀態
	
}
