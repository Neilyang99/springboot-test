package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa12")
@Table(appliesTo = "maa12",comment = "鋼筋數量使用統計表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa12 extends BaseEntity {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7020032679067966999L;
	private Long maa12002; //工程案基本資料唯一識別碼
	private String maa12003; //報表分類
	private String maa12004; //表單編號
	private String maa12005; //預計進貨日期
	private String maa12006; //實際進貨日期
	private Long maa12007; //供料廠商PK
	private Long maa12008; //加工廠商PK
	private String maa12009; //SD280_施作位置
	private double maa12010; //SD280_預進數#3
	private double maa12011; //SD280_實進數#3
	private double maa12012; //SD280_預進數#4
	private double maa12013; //SD280_實進數#4
	private double maa12014; //SD280_預進數#5
	private double maa12015; //SD280_實進數#5
	private double maa12016; //SD280_預進數#6
	private double maa12017; //SD280_實進數#6
	private double maa12018; //SD280_預進數#7
	private double maa12019; //SD280_實進數#7
	private double maa12020; //SD280_預進數#8
	private double maa12021; //SD280_實進數#8
	private double maa12022; //SD280_預進數#9
	private double maa12023; //SD280_實進數#9
	private double maa12024; //SD280_預進數#10
	private double maa12025; //SD280_實進數#10
	private double maa12026; //SD280_預進數#11
	private double maa12027; //SD280_實進數#11
	private double maa12028; //SD280_預進數#12
	private double maa12029; //SD280_實進數#12
	private String maa12030; //SD420水粹_施作位置
	private double maa12031; //SD420水粹_預進數#3
	private double maa12032; //SD420水粹_實進數#3
	private double maa12033; //SD420水粹_預進數#4
	private double maa12034; //SD420水粹_實進數#4
	private double maa12035; //SD420水粹_預進數#5
	private double maa12036; //SD420水粹_實進數#5
	private double maa12037; //SD420水粹_預進數#6
	private double maa12038; //SD420水粹_實進數#6
	private double maa12039; //SD420水粹_預進數#7
	private double maa12040; //SD420水粹_實進數#7
	private double maa12041; //SD420水粹_預進數#8
	private double maa12042; //SD420水粹_實進數#8
	private double maa12043; //SD420水粹_預進數#9
	private double maa12044; //SD420水粹_實進數#9
	private double maa12045; //SD420水粹_預進數#10
	private double maa12046; //SD420水粹_實進數#10
	private double maa12047; //SD420水粹_預進數#11
	private double maa12048; //SD420水粹_實進數#11
	private double maa12049; //SD420水粹_預進數#12
	private double maa12050; //SD420水粹_實進數#12
	private String maa12051; //SD420_施作位置
	private double maa12052; //SD420_預進數#3
	private double maa12053; //SD420_實進數#3
	private double maa12054; //SD420_預進數#4
	private double maa12055; //SD420_實進數#4
	private double maa12056; //SD420_預進數#5
	private double maa12057; //SD420_實進數#5
	private double maa12058; //SD420_預進數#6
	private double maa12059; //SD420_實進數#6
	private double maa12060; //SD420_預進數#7
	private double maa12061; //SD420_實進數#7
	private double maa12062; //SD420_預進數#8
	private double maa12063; //SD420_實進數#8
	private double maa12064; //SD420_預進數#9
	private double maa12065; //SD420_實進數#9
	private double maa12066; //SD420_預進數#10
	private double maa12067; //SD420_實進數#10
	private double maa12068; //SD420_預進數#11
	private double maa12069; //SD420_實進數#11
	private double maa12070; //SD420_預進數#12
	private double maa12071; //SD420_實進數#12
	private String maa12072; //SD420W_施作位置
	private double maa12073; //SD420W_預進數#3
	private double maa12074; //SD420W_實進數#3
	private double maa12075; //SD420W_預進數#4
	private double maa12076; //SD420W_實進數#4
	private double maa12077; //SD420W_預進數#5
	private double maa12078; //SD420W_實進數#5
	private double maa12079; //SD420W_預進數#6
	private double maa12080; //SD420W_實進數#6
	private double maa12081; //SD420W_預進數#7
	private double maa12082; //SD420W_實進數#7
	private double maa12083; //SD420W_預進數#8
	private double maa12084; //SD420W_實進數#8
	private double maa12085; //SD420W_預進數#9
	private double maa12086; //SD420W_實進數#9
	private double maa12087; //SD420W_預進數#10
	private double maa12088; //SD420W_實進數#10
	private double maa12089; //SD420W_預進數#11
	private double maa12090; //SD420W_實進數#11
	private double maa12091; //SD420W_預進數#12
	private double maa12092; //SD420W_實進數#12
	private String maa12093; //SD490_施作位置
	private double maa12094; //SD490_預進數#3
	private double maa12095; //SD490_實進數#3
	private double maa12096; //SD490_預進數#4
	private double maa12097; //SD490_實進數#4
	private double maa12098; //SD490_預進數#5
	private double maa12099; //SD490_實進數#5
	private double maa12100; //SD490_預進數#6
	private double maa12101; //SD490_實進數#6
	private double maa12102; //SD490_預進數#7
	private double maa12103; //SD490_實進數#7
	private double maa12104; //SD490_預進數#8
	private double maa12105; //SD490_實進數#8
	private double maa12106; //SD490_預進數#9
	private double maa12107; //SD490_實進數#9
	private double maa12108; //SD490_預進數#10
	private double maa12109; //SD490_實進數#10
	private double maa12110; //SD490_預進數#11
	private double maa12111; //SD490_實進數#11
	private double maa12112; //SD490_預進數#12
	private double maa12113; //SD490_實進數#12
	private String maa12114; //誤差情形
	private double maa12115; //誤差比率
	private String maa12116; //原因分析
	private String maa12117; //備註
	private String maa12118; //資料狀態
	private String maa12119; //核對人工號
	private String maa12120; //核對日期時間
	
}
