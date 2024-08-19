package cn.enilu.flash.bean.vo.ma;

import lombok.Data;

@Data
/**
 * Maa92a value object
 *
 * @author YWG
 */
public class Maa92aVo {
	
	private long id;
    private long maa92a002;
    private long maa92a003;
    private String maa92a004;
    private double maa92a005;
    private String maa92a006;
    private int maa92a007;
    private String maa92a008;
    private long maa92a009;
    private String budgetItemName;//預算項目名稱
    private String workItemName;//施作項目名稱
    private String workItemUnit;//施作項目計算單位
    //private String create_by; //建立人工號
	//private String create_time; //建立日期時間
	//private String modify_by; //異動人工號
	//private String modify_time; //異動日期時間

}
