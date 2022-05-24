package cn.enilu.flash.bean.entity.ma;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "maa05")
@Table(appliesTo = "maa05",comment = "混凝土強度品質表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Maa05 extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6338495289277339043L;
	
	private Long maa05002; //工程案基本資料唯一識別碼
	private String maa05003; //品質表類別
	private String maa05004; //澆置位置
	private String maa05005; //澆置日期
	private String maa05006; //設計強度
	private Long maa05007; //供料廠商PK
	private double maa05008; //數量
	private int maa05009; //試體組數
	private String maa05010; //7天試驗_試驗日期
	private int maa05011; //7天試驗_試驗日期_天
	private double maa05012; //7天試驗_試體1強度
	private double maa05013; //7天試驗_試體1強度%
	private String maa05014; //7天試驗_試體1合格判定
	private double maa05015; //7天試驗_試體2強度
	private double maa05016; //7天試驗_試體2強度%
	private String maa05017; //7天試驗_試體2合格判定
	private String maa05018; //28天試驗_試驗日期
	private int maa05019; //28天試驗_試驗日期_天
	private double maa05020; //28天試驗_試體1強度
	private double maa05021; //28天試驗_試體1強度%
	private String maa05022; //28天試驗_試體1養生條件
	private String maa05023; //28天試驗_試體1合格判定
	private double maa05024; //28天試驗_試體2強度
	private double maa05025; //28天試驗_試體2強度%
	private String maa05026; //28天試驗_試體2養生條件
	private String maa05027; //28天試驗_試體2合格判定
	private double maa05028; //28天試驗_試體3強度
	private double maa05029; //28天試驗_試體3強度%
	private String maa05030; //28天試驗_試體3養生條件
	private String maa05031; //28天試驗_試體3合格判定
	private double maa05032; //28天試驗_試體4強度
	private double maa05033; //28天試驗_試體4強度%
	private String maa05034; //28天試驗_試體4養生條件
	private String maa05035; //28天試驗_試體4合格判定
	private String maa05036; //備註
	private String maa05037; //資料狀態
}
