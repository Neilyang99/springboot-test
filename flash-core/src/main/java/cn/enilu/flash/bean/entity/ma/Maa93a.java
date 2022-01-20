package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa93a")
@Table(appliesTo = "maa93a",comment = "工程包商可配合類別資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa93a extends BaseEntity {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2501781246507455883L;

	private Long id; //資料表唯一識別碼
	
	private Long maa93a002; //工程包商基本資料唯一識別碼
	private Long maa93a003; //工程預算大類別基本資料表唯一識別碼
	private Long maa93a004; //工程預算小類別基本資料表唯一識別碼
	private Long maa93a005; //工程預算項目基本資料表唯一識別碼
	private String maa93a006; //包商編號
	private String maa93a007; //工程預算大類別代號
	private String maa93a008; //工程預算小類別代號
	private String maa93a009; //工程預算項目代號
	private int maa93a010; //工程包商配合排序
	private int maa93a011; //工程預算大類別配合排序
	private int maa93a012; //工程預算小類別配合排序
	private int maa93a013; //工程預算項目配合排序
	private String maa93a014; //狀態碼
	private String maa93a015; //資料狀態
	
}
