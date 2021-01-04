package cn.enilu.flash.bean.entity.sales;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "sla01")
@Table(appliesTo = "sla01",comment = "房屋銷售案可售房屋資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Sla01 extends BaseEntity {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5473170669263561044L;
	
	private int sla01002; //房屋銷售案資料唯一識別碼
	private String sla01003; //房屋銷售案代號
	private String sla01004; //區別
	private String sla01005; //棟別
	private String sla01006; //戶號
	private String sla01007; //屋型
	private String sla01008; //格局
	private String sla01009; //樓層數
	private String sla01010; //地坪數
	private String sla01011; //建坪數
	private String sla01012; //公設建坪數
	private String sla01013; //地號
	private String sla01014; //地址
	private String sla01015; //車位類別
	private int sla01016; //房屋銷售案可售車位資料唯一識別碼
	private String sla01017; //車位編號
	private int sla01018; //銷售表價
	private int sla01019; //業務員底價
	private int sla01020; //業務員超價
	private int sla01021; //特殊折扣底價
	private int sla01022; //裝潢費用
	private int sla01023; //仲人費用
	private int sla01024; //裝潢工程費用
	private int sla01025; //超價
	private int sla01026; //低底價
	private String sla01027; //銷售狀態碼
	private String sla01028; //保留欄位1
	private String sla01029; //保留欄位2
	private String sla01030; //保留欄位3
	private String sla01031; //保留欄位4
	private String sla01032; //保留欄位5
	private String sla01033; //資料狀態
}
