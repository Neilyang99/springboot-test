package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa93c")
@Table(appliesTo = "maa93c",comment = "承包商施工項目基本資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa93c extends BaseEntity {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8583037375738847903L;

	private Long id; //資料表唯一識別碼
	
	private Long maa93c002; //承包商唯一識別碼
	private Long maa93c003; //施作項目唯一識別碼
	
}
