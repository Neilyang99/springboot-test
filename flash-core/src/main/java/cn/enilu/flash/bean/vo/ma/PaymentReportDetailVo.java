package cn.enilu.flash.bean.vo.ma;

import lombok.Data;

@Data
/**
 * PaymentReportDetail
 * 請款明細表
 * @author YWG
 */
public class PaymentReportDetailVo {
	private String payDate;//放款日期
	int advancePayment;//代墊款
    int payment; //本期請款
    int retentionMoney;//保留款
    String payStatus;//發票條件:無/超出/符合/不足
}
