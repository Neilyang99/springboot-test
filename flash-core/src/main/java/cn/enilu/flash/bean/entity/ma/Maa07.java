package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa07")
@Table(appliesTo = "maa07",comment = "結構體鋼筋試驗表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa07 extends BaseEntity {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5570974843880272573L;
	
	private Long maa07002; //工程案基本資料唯一識別碼
	private String maa07003; //報表類別
	private String maa07004; //使用位置
	private String maa07005; //收件日期
	private String maa07006; //試驗日期
	private Long maa07007; //供料廠商PK
	private double maa07008; //數量
	private int maa07009; //試樣組數
	private String maa07010; //規格
	private String maa07011; //直徑(mm)
	private String maa07012; //降伏強度
	private String maa07013; //降伏強度合格判定
	private String maa07014; //抗拉強度
	private String maa07015; //抗拉強度合格判定
	private String maa07016; //伸長率
	private String maa07017; //伸長率合格判定
	private String maa07018; //外觀試驗報告
	private String maa07019; //外觀試驗報告合格判定
	private String maa07020; //備註
	private int maa07021; //資料狀態
	
}
