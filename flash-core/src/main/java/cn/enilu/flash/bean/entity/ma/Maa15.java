package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa15")
@Table(appliesTo = "maa15",comment = "廠商代墊款紀錄")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa15 extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7890757150408488819L;
	
	private Long maa15002; //工程案基本資料唯一識別碼
	private String maa15003; //計價截止日
	private String maa15004; //責任歸屬
	private String maa15005; //扣款種類
	private double maa15006; //數量
	private String maa15007; //單位
	private String maa15008; //內容
	private int maa15009; //單價
	private String maa15010; //扣款日期
	private int maa15011; //請款金額
	private String maa15012; //備註
	private String maa15013; //資料狀態
	private String maa15014; //會計確認人工號
	private String maa15015; //會計確認日期時間
	private String maa15016; //扣款確認人工號
	private String maa15017; //扣款確認日期時間
	
}
