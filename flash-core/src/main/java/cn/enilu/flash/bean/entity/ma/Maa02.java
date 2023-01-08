package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa02")
@Table(appliesTo = "maa02",comment = "工程案施工包商資料表資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa02 extends BaseEntity {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4850288982749937274L;
	
	
	private Long maa02002; //工程案基本資料唯一識別碼
	private Long maa02003; //工程預算大類別基本資料表唯一識別碼
	private Long maa02004; //工程預算小類別基本資料表唯一識別碼
	private Long maa02005; //工程預算項目基本資料表唯一識別碼
	private Long maa02006; //工程包商基本資料唯一識別碼
	private String maa02007; //工程編號
	private String maa02008; //工程案代號
	private String maa02009; //工程預算大類別代號
	private String maa02010; //工程預算小類別代號
	private String maa02011; //工程預算項目代號
	private String maa02012; //包商編號
	private String maa02013; //包商類型
	private String maa02014; //包商編號
	private String maa02015; //包商名稱
	private String maa02016; //負責人姓名
	private String maa02017; //負責人連絡電話
	private String maa02018; //負責人行動電話
	private String maa02019; //連絡人姓名
	private String maa02020; //連絡人連絡電話
	private String maa02021; //連絡人行動電話
	private String maa02022; //統一編號
	private String maa02023; //公司地址
	private String maa02024; //公司電話1
	private String maa02025; //公司電話2
	private String maa02026; //公司傳真
	private String maa02027; //公司地址
	private String maa02028; //通訊地址
	private String maa02029; //發票地址
	private String maa02030; //工程類型1代號
	private String maa02031; //工程類型2代號
	private int maa02032; //進場次數
	private String maa02033; //介紹人
	private String maa02034; //進場日期
	private Long maa02035; //配合上手工程包商基本資料唯一識別碼
	private int maa02036; //累計應付款金額
	private int maa02037; //累計已請款金額
	private int maa02038; //累計已付款金額
	private int maa02039; //累計扣款金額
	private int maa02040; //累計借款金額
	private int maa02041; //累計還款金額
	private int maa02042; //累計代墊金額
	private int maa02043; //累計代墊還款金額
	private int maa02044; //最近一次應付款金額
	private int maa02045; //最近一次請款金額
	private int maa02046; //最近一次付款金額
	private int maa02047; //最近一次扣款金額
	private int maa02048; //最近一次借款金額
	private int maa02049; //最近一次還款金額
	private int maa02050; //最近一次代墊金額
	private int maa02051; //最近一次代墊還款金額
	private int maa02052; //累計保留款金額
	private int maa02053; //累計保留款請款金額
	private int maa02054; //累計保留款付款金額
	private int maa02055; //累計保留款扣款金額
	private int maa02056; //最近一次保留款金額
	private int maa02057; //最近一次保留款請款金額
	private int maa02058; //最近一次保留款付款金額
	private int maa02059; //最近一次保留款扣款金額
	private String maa02060; //首次應付款日期
	private String maa02061; //首次請款日期
	private String maa02062; //首次付款日期
	private String maa02063; //首次扣款日期
	private String maa02064; //首次借款日期
	private String maa02065; //首次還款日期
	private String maa02066; //首次代墊日期
	private String maa02067; //首次代墊還款日期
	private String maa02068; //最近一次應付款日期
	private String maa02069; //最近一次請款日期
	private String maa02070; //最近一次付款日期
	private String maa02071; //最近一次扣款日期
	private String maa02072; //最近一次借款日期
	private String maa02073; //最近一次還款日期
	private String maa02074; //最近一次代墊日期
	private String maa02075; //最近一次代墊還款日期
	private String maa02076; //首次保留款日期
	private String maa02077; //首次保留款請款日期
	private String maa02078; //首次保留款付款日期
	private String maa02079; //首次保留款扣款日期
	private String maa02080; //最近一次保留款日期
	private String maa02081; //最近一次保留款請款日期
	private String maa02082; //最近一次保留款付款日期
	private String maa02083; //最近一次保留款扣款日期
	private String maa02084; //開始放款日期
	private String maa02085; //最後放款日期
	private String maa02086; //尾款結清日期
	private String maa02087; //工程合約編號
	private int maa02088; //工程合約金額
	private int maa02089; //保固金
	private String maa02090; //信用等級
	private String maa02091; //配合度等級
	private String maa02092; //備註1
	private String maa02093; //備註2
	private String maa02094; //備註3
	private String maa02095; //備註4
	private String maa02096; //備註5
	private String maa02097; //保留欄位1
	private String maa02098; //保留欄位2
	private String maa02099; //保留欄位3
	private String maa02100; //保留欄位4
	private String maa02101; //保留欄位5
	private String maa02102; //保留欄位6
	private String maa02103; //保留欄位7
	private String maa02104; //保留欄位8
	private String maa02105; //保留欄位9
	private String maa02106; //保留欄位10
	private int maa02107; //排序
	private String maa02108; //狀態碼
	private String maa02109; //資料狀態
	
}
