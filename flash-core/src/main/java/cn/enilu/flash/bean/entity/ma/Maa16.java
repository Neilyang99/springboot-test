package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa16")
@Table(appliesTo = "maa16",comment = "零用金主檔")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa16 extends BaseEntity {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 3113434485114467938L;
	private Long maa16002; //工程案基本資料唯一識別碼
	private int maa16003; //期別
	private String maa16004; //本期年月
	private int maa16005; //本期收入合計
	private int maa16006; //本期支出合計
	private String maa16007; //申請人工號
	private String maa16008; //申請日期
	private int maa16009; //放款期別
	private String maa16010; //放款日期
	private String maa16011; //備註
	private String maa16012; //資料狀態
	private String maa16013; //確認人工號
	private String maa16014; //確認日期時間

}
