package cn.enilu.flash.bean.entity.sales;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "slb10")
@Table(appliesTo = "slb10",comment = "業務專案日報基本資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Slb10 extends BaseEntity {
	 
	@Column
	private String slb10002; //日期
	private String slb10003; //天氣
	private String slb10004; //銷售案代號
	private String slb10005; //銷售案名
	private Double slb10006; //銷售成數
	private Double slb10007; //簽約成數
	private String slb10008; //媒體方向
	private Integer slb10009; //工地來人數
	private Integer slb10010; //工地來電數
	private Integer slb10011; //回籠人數
	private String slb10012; //出勤狀態碼
	private Integer slb10013; //今日成交戶數
	private Integer slb10014; //今日成交金額
	private Integer slb10015; //累計成交戶數
	private Integer slb10016; //累計成交金額
	private String slb10017; //成交備註
	private String slb10018; //已購原因分析
	private Integer slb10019; //今日退戶數
	private Integer slb10020; //今日退戶金額
	private Integer slb10021; //累計退戶戶數
	private Integer slb10022; //累計退戶金額
	private String slb10023; //退戶備註
	private Integer slb10024; //今日換戶數
	private Integer slb10025; //今日換戶金額
	private String slb10026; //換戶備註
	private Integer slb10027; //今日訂金補足戶數
	private Integer slb10028; //今日訂金補足金額
	private Integer slb10029; //實際補足戶數
	private Integer slb10030; //實際補足金額
	private String slb10031; //訂金補足備註
	private Integer slb10032; //今日簽約戶數
	private Integer slb10033; //今日簽約金額
	private Integer slb10034; //累計簽約戶數
	private Integer slb10035; //累計簽約金額
	private String slb10036; //簽約備註
	private String slb10037; //未購原因分析
	private String slb10038; //回籠未成交原因分析
	private String slb10039; //本週檢討修正方向
	private String slb10040; //下週媒體計劃
	private String slb10041; //建議業主配合事項
	private String slb10042; //其他事項備註
	private String slb10043; //保留欄位1
	private String slb10044; //保留欄位2
	private String slb10045; //保留欄位3
	private String slb10046; //保留欄位4
	private String slb10047; //保留欄位5
	private String slb10048; //主管意見
	private String slb10049; //主管員工號
	private String slb10050; //主管覆核日期
	private String slb10051; //審核人意見
	private String slb10052; //審核人員工號
	private String slb10053; //審核日期
	private String slb10054; //核定人意見
	private String slb10055; //核定人員工號
	private String slb10056; //核定日期
	private String slb10057; //資料狀態
	
//	@OneToMany(mappedBy = "slb10" ,cascade=CascadeType.ALL, fetch=FetchType.EAGER, orphanRemoval=true)
//	private List<Slb11> slb11List;
	
}
