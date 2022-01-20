package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa01")
@Table(appliesTo = "maa01",comment = "工程案基本資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa00 extends BaseEntity {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4008032978627078528L;
	
	
	private Long id; //工程案基本資料唯一識別碼
	private String maa00002; //工程編號
	private String maa00003; //工程案代號
	private String maa00004; //工程案名稱
	private String maa00005; //工程案地點
	private String maa00006; //基地地號
	private String maa00007; //預計開工日期
	private String maa00008; //實際開工日期
	private String maa00009; //預計完工日期
	private String maa00010; //實際完工日期
	private int maa00011; //工期
	private int maa00012; //施工天數
	private String maa00013; //結案日期
	private String maa00014; //工地主任工號
	private String maa00015; //工地主任姓名
	private String maa00016; //工地主任連絡電話
	private String maa00017; //工地主任行動電話
	private String maa00018; //工地助理工號
	private String maa00019; //工地助理姓名
	private String maa00020; //工地助理連絡電話
	private String maa00021; //工地助理行動電話
	private String maa00022; //會計科目
	private String maa00023; //會計科目名稱
	private String maa00024; //建物構造
	private String maa00025; //總樓地板面積
	private float maa00026; //進度分析(權重百分比)
	private int maa00027; //預算總工程款
	private int maa00028; //結算總工程款
	private int maa00029; //至本期總工程款估驗累計
	private int maa00030; //總工程款累計請領
	private int maa00031; //總工程款保留款
	private int maa00032; //總工程款累計估驗
	private String maa00033; //進度狀態碼
	private String maa00034; //結案狀態碼
	private String maa00035; //保留欄位1
	private String maa00036; //保留欄位2
	private String maa00037; //保留欄位3
	private String maa00038; //保留欄位4
	private String maa00039; //保留欄位5
	private String maa00040; //資料狀態
}
