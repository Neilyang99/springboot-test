package cn.enilu.flash.service.ma;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa93;
import cn.enilu.flash.bean.vo.ma.PaymentReportDetailVo;
import cn.enilu.flash.bean.vo.ma.PaymentReportVo;
import cn.enilu.flash.dao.ma.Maa93Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class MaaReportService extends BaseService<Maa93,Long,Maa93Repository>{
	
	@Autowired
	private Maa93Repository repository;
	
	@Autowired
	private Maa93Service maa93Service;
	
	
	public List<PaymentReportVo> paymentReport() {
		
		List<PaymentReportVo> aryList = new ArrayList<PaymentReportVo>();
		
		List<Maa93> list = maa93Service.queryAll();
		for(Maa93 maa93 : list) {
			PaymentReportVo vo = new PaymentReportVo();
			List<PaymentReportDetailVo> detail = new ArrayList<PaymentReportDetailVo>();
			
			vo.setVendorCode(maa93.getMaa93003());
			vo.setVendorName(maa93.getMaa93004());
			vo.setPayDate("1110801");
			
			PaymentReportDetailVo vo1 = new PaymentReportDetailVo();
			vo1.setPayDate("1110801");
			vo1.setAdvancePayment(350);
			vo1.setPayment(1832);
			vo1.setRetentionMoney(148);
			vo1.setPayStatus("不足");
			detail.add(vo1);
			
			PaymentReportDetailVo vo2 = new PaymentReportDetailVo();
			vo2.setPayDate("1110901");
			vo2.setAdvancePayment(550);
			vo2.setPayment(2950);
			vo2.setRetentionMoney(188);
			vo2.setPayStatus("無");
			detail.add(vo2);
			
			vo.setDetail(detail);
			
			aryList.add(vo);
		}
		
		return aryList;
	}
}
