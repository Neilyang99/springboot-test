package cn.enilu.flash.bean.vo.ma;

import java.util.List;

import lombok.Data;

@Data
/**
 * PaymentReport
 * 請款明細表
 * @author YWG
 */
public class PaymentReportVo {
	private Long vendorId;
    private String vendorCode;
    private String vendorName;
    //private String payDate;//放款日期
    //private List<PaymentReportDetailVo> detail;
    private String itemName;
    private String value1;
    private String value2;
    private String value3;
    private String value4;
    private String value5;
    private String value6;
    
    private String total;

}

