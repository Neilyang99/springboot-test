package cn.enilu.flash.bean.vo.ma;

import lombok.Data;

@Data
/**
 * Maa92a value object
 *
 * @author YWG
 */
public class Maa93cVo {
	
	private long id; // maa93c.id, 承包商所屬施工項目Id
	private long vendorId; //承包商id
	private long workItemId; //施工項目id
    private String workItemName; //項目名稱
	private String workItemUnit; //單位
	private String remark; //備註
	private int isActive; //是否存在

}
