package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa92a")
@Table(appliesTo = "maa92a",comment = "工程預算子項目基本資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa92a extends BaseEntity {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9078107562897985716L;

	private Long id; //資料表唯一識別碼
	
	private Long maa92a002; //工程預算項目基本資料表唯一識別碼
	private Long maa92a003; //工程施作項目資料表唯一識別碼
	private String maa92a004; //單位
	private double maa92a005; //數量
	private String maa92a006; //備註
	private int maa92a007; //排序
	private String maa92a008; //狀態碼
	private Long maa92a009; //所屬公司別
	
	
}
