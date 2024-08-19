package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa95")
@Table(appliesTo = "maa95",comment = "工程施作項目資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa95 extends BaseEntity {
	

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6655260456381296003L;

	private Long id; //資料表唯一識別碼
	
	private String maa95002; //項目名稱
	private String maa95003; //單位
	private double maa95004; //數量
	private double maa95005; //單價
	private String maa95006; //備註
	private double maa95007; //最大數量
	private double maa95008; //最小數量
	private String maa95009; //規格
	private double maa95010; //損耗率
	private String maa95011; //項目分類
	private int maa95012; //排序
	private String maa95013; //狀態碼
	private Long maa95014; //所屬公司別
}
