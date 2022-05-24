package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa03")
@Table(appliesTo = "maa03",comment = "混凝土抽磅管制表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa03 extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3785132877888257164L;
	
	private Long maa03002; //工程案基本資料唯一識別碼
	private String maa03003; //澆置位置
	private String maa03004; //澆置日期
	private Long maa03005; //供料廠商PK
	private String maa03006; //抽磅車號
	private String maa03007; //抽磅時間_小時
	private String maa03008; //抽磅時間_分鐘
	private String maa03009; //供料完成時間_小時
	private String maa03010; //供料完成時間_分鐘
	private double maa03011; //總重量
	private double maa03012; //空車重量
	private double maa03013; //實際重量
	private double maa03014; //該車出貨量
	private double maa03015; //檢驗標準值
	private String maa03016; //檢驗結果
	private String maa03017; //備註
	private String maa03018; //工區主管PK
	private String maa03019; //工區主管簽核日期時間
	private int maa03020; //資料狀態
}
