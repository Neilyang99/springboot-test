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
    private String vendorCode;
    private String vendorName;
    private String payDate;//放款日期
    private List<PaymentReportDetailVo> detail;

}

