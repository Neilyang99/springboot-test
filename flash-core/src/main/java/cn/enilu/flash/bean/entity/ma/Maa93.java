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
	
	private String maa93002; //類型
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
	private String maa93021; //公司地址
	private String maa93022; //發票地址
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
	private int maa93033; //累計已請款金額
	private int maa93034; //累計已付款金額
	private int maa93035; //累計未請款金額
	private int maa93036; //最近請款金額
	private int maa93037; //最近付款金額
	private int maa93038; //累計保留款未付款金額
	private int maa93039; //最近保留款付款金額
	private int maa93040; //尚餘保留款未付款金額
	private int maa93041; //最近產生保留款金額
	private String maa93042; //首次請款日期
	private String maa93043; //最近一次請款日期
	private String maa93044; //首次付款日期
	private String maa93045; //最近一次付款日期
	private String maa93046; //開始放款日期
	private String maa93047; //最後放款日期
	private String maa93048; //尾款結清日期
	private int maa93049; //進行中工程合約金額
	private int maa93050; //保固金
	private String maa93051; //備註1
	private String maa93052; //備註2
	private String maa93053; //備註3
	private String maa93054; //備註4
	private String maa93055; //備註5
	private String maa93056; //信用等級
	private String maa93057; //配合度等級
	private int maa93058; //排序
	private String maa93059; //狀態碼
	private String maa93060; //資料狀態
}
