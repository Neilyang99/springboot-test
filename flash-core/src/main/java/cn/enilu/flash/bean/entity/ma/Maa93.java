package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa93")
@Table(appliesTo = "maa93",comment = "工程包商基本資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa93 extends BaseEntity {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4223172400481373619L;

	private Long id; //資料表唯一識別碼
	
	private String maa93002; //包商類型
	private String maa93003; //包商編號
	private String maa93004; //包商名稱
	private String maa93005; //負責人姓名
	private String maa93006; //負責人連絡電話
	private String maa93007; //負責人行動電話
	private String maa93008; //連絡人姓名
	private String maa93009; //連絡人連絡電話
	private String maa93010; //連絡人行動電話
	private String maa93011; //統一編號
	private String maa93012; //公司地址
	private String maa93013; //公司電話1
	private String maa93014; //公司電話2
	private String maa93015; //公司傳真
	private String maa93016; //公司地址
	private String maa93017; //通訊地址
	private String maa93018; //發票地址
	private String maa93019; //工程類型1代號
	private String maa93020; //工程類型2代號
	private int maa93021; //進場次數
	private String maa93022; //介紹人
	private String maa93023; //初次進場日期
	private String maa93024; //初次進場工程案代號
	private String maa93025; //初次進場工程案名稱
	private String maa93026; //最近進場日期
	private String maa93027; //最近進場工程案代號
	private String maa93028; //最近進場工程案名稱
	private int maa93029; //配合工程案件數
	private int maa93030; //配合上手工程包商基本資料唯一識別碼
	private int maa93031; //累計已完工配合工程案數
	private int maa93032; //未完工配合工程案數
	private int maa93033; //累計應付款金額
	private int maa93034; //累計已請款金額
	private int maa93035; //累計已付款金額
	private int maa93036; //累計扣款金額
	private int maa93037; //累計借款金額
	private int maa93038; //累計還款金額
	private int maa93039; //累計代墊金額
	private int maa93040; //累計代墊還款金額
	private int maa93041; //最近一次應付款金額
	private int maa93042; //最近一次請款金額
	private int maa93043; //最近一次付款金額
	private int maa93044; //最近一次扣款金額
	private int maa93045; //最近一次借款金額
	private int maa93046; //最近一次還款金額
	private int maa93047; //最近一次代墊金額
	private int maa93048; //最近一次代墊還款金額
	private int maa93049; //累計保留款金額
	private int maa93050; //累計保留款請款金額
	private int maa93051; //累計保留款付款金額
	private int maa93052; //累計保留款扣款金額
	private int maa93053; //最近一次保留款金額
	private int maa93054; //最近一次保留款請款金額
	private int maa93055; //最近一次保留款付款金額
	private int maa93056; //最近一次保留款扣款金額
	private String maa93057; //首次應付款日期
	private String maa93058; //首次請款日期
	private String maa93059; //首次付款日期
	private String maa93060; //首次扣款日期
	private String maa93061; //首次借款日期
	private String maa93062; //首次還款日期
	private String maa93063; //首次代墊日期
	private String maa93064; //首次代墊還款日期
	private String maa93065; //最近一次應付款日期
	private String maa93066; //最近一次請款日期
	private String maa93067; //最近一次付款日期
	private String maa93068; //最近一次扣款日期
	private String maa93069; //最近一次借款日期
	private String maa93070; //最近一次還款日期
	private String maa93071; //最近一次代墊日期
	private String maa93072; //最近一次代墊還款日期
	private String maa93073; //首次保留款日期
	private String maa93074; //首次保留款請款日期
	private String maa93075; //首次保留款付款日期
	private String maa93076; //首次保留款扣款日期
	private String maa93077; //最近一次保留款日期
	private String maa93078; //最近一次保留款請款日期
	private String maa93079; //最近一次保留款付款日期
	private String maa93080; //最近一次保留款扣款日期
	private String maa93081; //開始放款日期
	private String maa93082; //最後放款日期
	private String maa93083; //尾款結清日期
	private String maa93084; //工程合約編號
	private int maa93085; //工程合約金額
	private int maa93086; //保固金
	private String maa93087; //信用等級
	private String maa93088; //配合度等級
	private String maa93089; //備註1
	private String maa93090; //備註2
	private String maa93091; //備註3
	private String maa93092; //備註4
	private String maa93093; //備註5
	private String maa93094; //保留欄位1
	private String maa93095; //保留欄位2
	private String maa93096; //保留欄位3
	private String maa93097; //保留欄位4
	private String maa93098; //保留欄位5
	private String maa93099; //保留欄位6
	private String maa93100; //保留欄位7
	private String maa93101; //保留欄位8
	private String maa93102; //保留欄位9
	private String maa93103; //保留欄位10
	private int maa93104; //排序
	private String maa93105; //狀態碼
	private String maa93106; //資料狀態
	
}
