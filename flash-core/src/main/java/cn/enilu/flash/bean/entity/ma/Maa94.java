package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa94")
@Table(appliesTo = "maa94",comment = "類別項目定義資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa94 extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -562732682148793314L;
	
	
	private Long id; //唯一識別碼
	
	private int maa94002; //項目類別
	private String maa94003; //項目名稱
	private String maa94004; //項目代號
	private int maa94005; //項目排序
	private int maa94006; //父階層項目PK
	private int maa94007; //階層數
	private String maa94008; //參數1
	private String maa94009; //參數2
	private String maa94010; //資料狀態
	
}
