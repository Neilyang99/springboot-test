package cn.enilu.flash.bean.entity.sales;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "sla30")
@Table(appliesTo = "sla30",comment = "市調資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Sla30 extends BaseEntity {

	@Column
	private String sla30002; //填表日期
	private String sla30003; //填寫人工號
	private String sla30004; //行政區-縣市別代碼
	private String sla30005; //行政區-區別郵遞區號
	private String sla30006; //土地區分
	private String sla30007; //投資興建
	private Integer sla30008; //土地面積
	private Double sla30009; //總銷金額-起
	private Double sla30010; //總銷金額-迄
	private String sla30011; //廣企公司
	private String sla30012; //建築規劃
	private String sla30013; //推出日期-起
	private String sla30014; //推出日期-迄
	private String sla30015; //公開日期-起
	private String sla30016; //公開日期-迄
	private Integer sla30017; //樓層數-起
	private Integer sla30018; //樓層數-迄
	private Integer sla30019; //總建坪-起
	private Integer sla30020; //總建坪-迄
	private Double sla30021; //土地價格-起
	private Double sla30022; //土地價格-迄
	private String sla30023; //銷售公司
	private String sla30024; //承造人
	private String sla30025; //工地位置
	private String sla30026; //產品規劃
	private String sla30027; //面臨道路
	private Integer sla30028; //建蔽率
	private Integer sla30029; //公設比
	private String sla30030; //預計完工-起
	private String sla30031; //預計完工-迄
	private String sla30032; //景觀設計
	private String sla30033; //產品規劃-店舖-1F
	private Integer sla30034; //產品規劃-店舖-1F-坪數範圍-起
	private Integer sla30035; //產品規劃-店舖-1F-坪數範圍-迄
	private Integer sla30036; //產品規劃-店舖-1F-戶數
	private Integer sla30037; //產品規劃-店舖-1F-比例
	private String sla30038; //產品規劃-店舖-1+2F
	private Integer sla30039; //產品規劃-店舖-1+2F-坪數範圍-起
	private Integer sla30040; //產品規劃-店舖-1+2F-坪數範圍-迄
	private Integer sla30041; //產品規劃-店舖-1+2F-戶數
	private Integer sla30042; //產品規劃-店舖-1+2F-比例
	private String sla30043; //產品規劃-住宅-套房
	private Integer sla30044; //產品規劃-住宅-套房-坪數範圍-起
	private Integer sla30045; //產品規劃-住宅-套房-坪數範圍-迄
	private Integer sla30046; //產品規劃-住宅-套房-戶數
	private Integer sla30047; //產品規劃-住宅-套房-比例
	private String sla30048; //產品規劃-住宅-1+1房
	private Integer sla30049; //產品規劃-住宅-1+1房-坪數範圍-起
	private Integer sla30050; //產品規劃-住宅-1+1房-坪數範圍-迄
	private Integer sla30051; //產品規劃-住宅-1+1房-戶數
	private Integer sla30052; //產品規劃-住宅-1+1房-比例
	private String sla30053; //產品規劃-住宅-2房
	private Integer sla30054; //產品規劃-住宅-2房-坪數範圍-起
	private Integer sla30055; //產品規劃-住宅-2房-坪數範圍-迄
	private Integer sla30056; //產品規劃-住宅-2房-戶數
	private Integer sla30057; //產品規劃-住宅-2房-比例
	private String sla30058; //產品規劃-住宅-2+1房
	private Integer sla30059; //產品規劃-住宅-2+1房-坪數範圍-起
	private Integer sla30060; //產品規劃-住宅-2+1房-坪數範圍-迄
	private Integer sla30061; //產品規劃-住宅-2+1房-戶數
	private Integer sla30062; //產品規劃-住宅-2+1房-比例
	private String sla30063; //產品規劃-住宅-3房
	private Integer sla30064; //產品規劃-住宅-3房-坪數範圍-起
	private Integer sla30065; //產品規劃-住宅-3房-坪數範圍-迄
	private Integer sla30066; //產品規劃-住宅-3房-戶數
	private Integer sla30067; //產品規劃-住宅-3房-比例
	private String sla30068; //產品規劃-住宅-3+1房
	private Integer sla30069; //產品規劃-住宅-3+1房-坪數範圍-起
	private Integer sla30070; //產品規劃-住宅-3+1房-坪數範圍-迄
	private Integer sla30071; //產品規劃-住宅-3+1房-戶數
	private Integer sla30072; //產品規劃-住宅-3+1房-比例
	private String sla30073; //產品規劃-住宅-4房
	private Integer sla30074; //產品規劃-住宅-4房-坪數範圍-起
	private Integer sla30075; //產品規劃-住宅-4房-坪數範圍-迄
	private Integer sla30076; //產品規劃-住宅-4房-戶數
	private Integer sla30077; //產品規劃-住宅-4房-比例
	private String sla30078; //產品規劃-住宅-4+1房
	private Integer sla30079; //產品規劃-住宅-4+1房-坪數範圍-起
	private Integer sla30080; //產品規劃-住宅-4+1房-坪數範圍-迄
	private Integer sla30081; //產品規劃-住宅-4+1房-戶數
	private Integer sla30082; //產品規劃-住宅-4+1房-比例
	private Integer sla30083; //規劃總戶數
	private String sla30084; //目前各案進度
	private Double sla30085; //店舖單價平均約-起
	private Double sla30086; //店舖單價平均約-迄
	private Integer sla30087; //店舖主力坪數-起
	private Integer sla30088; //店舖主力坪數-迄
	private Double sla30089; //店舖主力總價-起
	private Double sla30090; //店舖主力總價-迄
	private Double sla30091; //住家單價平均約-起
	private Double sla30092; //住家單價平均約-迄
	private Integer sla30093; //住家主力坪數-起
	private Integer sla30094; //住家主力坪數-迄
	private Double sla30095; //住家主力總價-起
	private Double sla30096; //住家主力總價-迄
	private Double sla30097; //廣告戶透天總價
	private Double sla30098; //廣告戶透天單價
	private Integer sla30099; //廣告戶透天議價空間
	private Integer sla300100; //付款方式-簽訂開
	private Integer sla300101; //付款方式-期款
	private Integer sla300102; //付款方式-貸款
	private Integer sla300103; //付款方式-自備款
	private Double sla300104; //停車位-平面
	private Double sla300105; //停車位-機上
	private Double sla300106; //停車位-機下
	private String sla300107; //公共設施
	private String sla300108; //媒體訴求
	private Integer sla300109; //銷售狀況-每週來客
	private Integer sla300110; //銷售狀況-銷售較佳坪數
	private Double sla300111; //銷售狀況-銷售較佳價位
	private Double sla300112; //銷售狀況-區域行情-起
	private Double sla300113; //銷售狀況-區域行情-迄
	private String sla300114; //銷售狀況-競爭個案
	private String sla300115; //備註1
	private String sla300116; //備註2
	private String sla300117; //保留欄位1
	private String sla300118; //保留欄位2
	private String sla300119; //保留欄位3
	private String sla300120; //保留欄位4
	private String sla300121; //保留欄位5
	private String sla300122; //資料狀態
	private String sla300127; //資料確認人工號
	private String sla300128; //資料確認日期時間
}
