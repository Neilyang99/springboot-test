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
		int aa = 0;
		for(Maa93 maa93 : list) {
			PaymentReportVo vo = new PaymentReportVo();
			//List<PaymentReportDetailVo> detail = new ArrayList<PaymentReportDetailVo>();
			
			
			vo.setVendorId(maa93.getId());
			vo.setVendorCode(maa93.getMaa93003());
			vo.setVendorName(maa93.getMaa93004());
			vo.setItemName("放款日期");
			vo.setValue1("1110801");
			vo.setValue2("1110901");
			vo.setValue3("1111001");
			vo.setValue4("1111101");
			vo.setValue5("1111201");
			vo.setValue6("1120101");
			vo.setTotal("---");
			
			PaymentReportVo v1 = new PaymentReportVo();
			v1.setVendorId(maa93.getId());
			v1.setVendorCode(maa93.getMaa93003());
			v1.setVendorName(maa93.getMaa93004());
			v1.setItemName("代墊扣款");
			v1.setValue1(aa==0?"350":"480");
			v1.setValue2("0");
			v1.setValue3(aa==0?"0":"50");
			v1.setValue4(aa==0?"0":"20");
			v1.setValue5("0");
			v1.setValue6("0");
			v1.setTotal(aa==0?"350":"550");
			
			PaymentReportVo v2 = new PaymentReportVo();
			v2.setVendorId(maa93.getId());
			v2.setVendorCode(maa93.getMaa93003());
			v2.setVendorName(maa93.getMaa93004());
			v2.setItemName("本期請款");
			v2.setValue1(aa==0?"1832":"1500");
			v2.setValue2(aa==0?"135":"180");
			v2.setValue3(aa==0?"0":"500");
			v2.setValue4(aa==0?"0":"120");
			v2.setValue5("0");
			v2.setValue6("0");
			v2.setTotal(aa==0?"1967":"2300");
			
			PaymentReportVo v3 = new PaymentReportVo();
			v3.setVendorId(maa93.getId());
			v3.setVendorCode(maa93.getMaa93003());
			v3.setVendorName(maa93.getMaa93004());
			v3.setItemName("本期保留");
			v3.setValue1(aa==0?"148":"100");
			v3.setValue2(aa==0?"15":"100");
			v3.setValue3("0");
			v3.setValue4("0");
			v3.setValue5("0");
			v3.setValue6("0");
			v3.setTotal(aa==0?"163":"200");
			
			PaymentReportVo v4 = new PaymentReportVo();
			v4.setVendorId(maa93.getId());
			v4.setVendorCode(maa93.getMaa93003());
			v4.setVendorName(maa93.getMaa93004());
			v4.setItemName("發票條件");
			v4.setValue1(aa==0?"不足":"不足");
			v4.setValue2(aa==0?"無":"不足");
			v4.setValue3(aa==0?"":"不足");
			v4.setValue4(aa==0?"":"不足");
			v4.setValue5("");
			v4.setValue6("");
			v4.setTotal("");
			
			aryList.add(vo);
			aryList.add(v1);
			aryList.add(v2);
			aryList.add(v3);
			aryList.add(v4);
			
			aa++;
		}
		
		return aryList;
	}
	
	/**
	 * 廠商各期請款
	 * @return
	 */
	public List<PaymentReportVo> paymentVendor(Long projectId, Long vendorId) {
		
		List<PaymentReportVo> aryList = new ArrayList<PaymentReportVo>();
		
		
		Maa93 maa93 = maa93Service.get(vendorId);
		
		PaymentReportVo vo = new PaymentReportVo();
		vo.setVendorId(maa93.getId());
		vo.setVendorCode(maa93.getMaa93003());
		vo.setVendorName(maa93.getMaa93004());
		vo.setItemName("第1期");
		vo.setValue1("1110801");//放款日
		vo.setValue2("350");//代墊扣款
		vo.setValue3("1832");//本期扣款
		vo.setValue4("148");//本期保留
		vo.setValue5("不足");//發票條件
		vo.setValue6("");
		vo.setTotal("");
		
		aryList.add(vo);
		
		
		PaymentReportVo v1 = new PaymentReportVo();
		v1.setVendorId(maa93.getId());
		v1.setVendorCode(maa93.getMaa93003());
		v1.setVendorName(maa93.getMaa93004());
		v1.setItemName("第2期");
		v1.setValue1("1110901");//放款日
		v1.setValue2("0");//代墊扣款
		v1.setValue3("135");//本期扣款
		v1.setValue4("15");//本期保留
		v1.setValue5("無");//發票條件
		v1.setValue6("");
		v1.setTotal("");
		
		aryList.add(v1);

		PaymentReportVo v2 = new PaymentReportVo();
		v2.setVendorId(maa93.getId());
		v2.setVendorCode(maa93.getMaa93003());
		v2.setVendorName(maa93.getMaa93004());
		v2.setItemName("第3期");
		v2.setValue1("1111001");//放款日
		v2.setValue2("0");//代墊扣款
		v2.setValue3("0");//本期扣款
		v2.setValue4("0");//本期保留
		v2.setValue5("");//發票條件
		v2.setValue6("");
		v2.setTotal("");
		
		aryList.add(v2);

		PaymentReportVo v3 = new PaymentReportVo();
		v3.setVendorId(maa93.getId());
		v3.setVendorCode(maa93.getMaa93003());
		v3.setVendorName(maa93.getMaa93004());
		v3.setItemName("第4期");
		v3.setValue1("1111101");//放款日
		v3.setValue2("0");//代墊扣款
		v3.setValue3("0");//本期扣款
		v3.setValue4("0");//本期保留
		v3.setValue5("");//發票條件
		v3.setValue6("");
		v3.setTotal("");
		
		aryList.add(v3);

		PaymentReportVo v4 = new PaymentReportVo();
		v4.setVendorId(maa93.getId());
		v4.setVendorCode(maa93.getMaa93003());
		v4.setVendorName(maa93.getMaa93004());
		v4.setItemName("第5期");
		v4.setValue1("1111201");//放款日
		v4.setValue2("0");//代墊扣款
		v4.setValue3("0");//本期扣款
		v4.setValue4("0");//本期保留
		v4.setValue5("");//發票條件
		v4.setValue6("");
		v4.setTotal("");
		
		aryList.add(v4);

		PaymentReportVo v5 = new PaymentReportVo();
		v5.setVendorId(maa93.getId());
		v5.setVendorCode(maa93.getMaa93003());
		v5.setVendorName(maa93.getMaa93004());
		v5.setItemName("第6期");
		v5.setValue1("1120101");//放款日
		v5.setValue2("0");//代墊扣款
		v5.setValue3("0");//本期扣款
		v5.setValue4("0");//本期保留
		v5.setValue5("");//發票條件
		v5.setValue6("");
		v5.setTotal("");
		
		aryList.add(v5);
		
		return aryList;
	}
	
	/**
	 * 當期對帳表
	 * @return
	 */
	public List<PaymentReportVo> paymentMonthly(Long projectId) {
		
		List<PaymentReportVo> aryList = new ArrayList<PaymentReportVo>();
		
		
		List<Maa93> list = maa93Service.queryAll();
		int aa = 0;
		for(Maa93 maa93 : list) {
			
			PaymentReportVo vo = new PaymentReportVo();
			vo.setVendorId(maa93.getId());
			vo.setVendorCode(maa93.getMaa93003());
			vo.setVendorName(maa93.getMaa93004());
			vo.setItemName("");
			vo.setValue1("1110801");//放款日
			
			if(aa == 0) {
				vo.setValue2("350");//代墊扣款
				vo.setValue3("1832");//本期扣款
				vo.setValue4("148");//本期保留
				vo.setValue5("不足");//發票條件
				vo.setValue6("");
				vo.setTotal("");
			}else {
				vo.setValue2("480");//代墊扣款
				vo.setValue3("1500");//本期扣款
				vo.setValue4("100");//本期保留
				vo.setValue5("不足");//發票條件
				vo.setValue6("");
				vo.setTotal("");
				
			}
			
			aa++;
			
			aryList.add(vo);
			
			
		}
		
		
		
		return aryList;
	}
}
