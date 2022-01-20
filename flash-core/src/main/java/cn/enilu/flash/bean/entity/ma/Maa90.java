package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa90")
@Table(appliesTo = "maa90",comment = "工程預算大類別基本資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa90 extends BaseEntity {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5837142037901501686L;
	
	private Long id; //工程預算大類別基本資料表唯一識別碼
	private String maa90002; //工程預算大類別代號
	private String maa90003; //工程預算大類別名稱
	private int maa90004; //排序
	private String maa90005; //狀態碼
	private String maa90006; //資料狀態
	
}
