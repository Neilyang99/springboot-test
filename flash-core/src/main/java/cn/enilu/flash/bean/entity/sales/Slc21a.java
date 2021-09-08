package cn.enilu.flash.bean.entity.sales;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import org.hibernate.annotations.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import cn.enilu.flash.bean.entity.BaseEntity;
import lombok.Data;

@Entity(name = "slc21a")
@Table(appliesTo = "slc21a",comment = "日統計資料-區域分析資料表")
@Data
@EntityListeners(AuditingEntityListener.class)
public class Slc21a extends BaseEntity {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2848097767215283298L;
	
	@Column
	private int slc21a002; //房屋銷售案基本資料唯一識別碼
	private String slc21a003; //房屋銷售案代號
	private String slc21a004; //房屋銷售案名稱
	private int slc21a005; //年
	private int slc21a006; //月
	private int slc21a007; //日
	private int slc21a008; //年度的週數
	private int slc21a009; //週幾
	private String slc21a010; //大區域代碼
	private String slc21a011; //大區域名稱
	private String slc21a012; //小區域代碼
	private String slc21a013; //小區域名稱
	private int slc21a014; //來人數量
	private int slc21a015; //來電數量
	private int slc21a016; //回籠數量
	private int slc21a017; //已購數量
	private int slc21a018; //來人%
	private int slc21a019; //來電%
	private int slc21a020; //回籠%
	private int slc21a021; //已購%
	private int slc21a022; //保留欄位1
	private int slc21a023; //保留欄位2
	private int slc21a024; //保留欄位3
	private int slc21a025; //保留欄位4
	private int slc21a026; //保留欄位5
	private int slc21a027; //保留欄位6
	private int slc21a028; //保留欄位7
	private int slc21a029; //保留欄位8
	private int slc21a030; //保留欄位9
	private int slc21a031; //保留欄位10
	private int slc21a032; //排序
	private String slc21a033; //資料狀態
	private String slc21a034; //資料確認人工號
	private String slc21a035; //資料確認日期時間
	
}
