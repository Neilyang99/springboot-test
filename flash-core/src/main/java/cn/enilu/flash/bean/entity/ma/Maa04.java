package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa04")
@Table(appliesTo = "maa04",comment = "混凝土試體取樣管制表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa04 extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4391468874331169191L;
	private Long maa04002; //工程案基本資料唯一識別碼
	private String maa04003; //澆置位置
	private String maa04004; //澆置日期
	private String maa04005; //強度
	private Long maa04006; //供料廠商PK
	private String maa04007; //取樣車號
	private String maa04008; //取樣時間_小時
	private String maa04009; //取樣時間_分鐘
	private int maa04010; //取樣組數
	private String maa04011; //出貨坍度
	private String maa04012; //試驗坍度
	private String maa04013; //氯離子檢測1
	private String maa04014; //氯離子檢測2
	private String maa04015; //氯離子檢測3
	private String maa04016; //氯離子檢測4
	private String maa04017; //氯離子檢測5
	private String maa04018; //備註
	private String maa04019; //工區主管PK
	private String maa04020; //工區主管簽核日期時間
	private int maa04021; //資料狀態
}
