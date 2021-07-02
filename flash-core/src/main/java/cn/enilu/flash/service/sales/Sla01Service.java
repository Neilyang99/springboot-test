package cn.enilu.flash.service.sales;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.sales.Sla01;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.sales.SalesVo;
import cn.enilu.flash.dao.sales.Sla01Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Sla01Service extends BaseService<Sla01,Long,Sla01Repository>{
	
	@Autowired
	private Sla01Repository sla01Repository;
	
	public List<Sla01> findBySla01002(Integer sla01002){
		return sla01Repository.findBySla01002(sla01002);
	}
	
	public List<Sla01> findBySla01003(String sla01003){
		return sla01Repository.findBySla01003(sla01003);
	}
	
	public List<Sla01> findNotSaleHouse(String sla01003){
		return sla01Repository.findNotSaleHouse(sla01003);
	}
	
	public void updateStatusBySla01ID(Long id, String status) {
		sla01Repository.updateStatusBySla01ID(id, status);
	}
	
	/**
	 * 根據房屋銷售代號取的可售房屋清單
	 * @param projectNo 房屋銷售代號
	 * @return List<SalesVo>
	 */
	public List<SalesVo> findNotSaleHouseByProjectNo(String projectNo) {
		List<SalesVo> list = new ArrayList<SalesVo>();
		
		List<Sla01> sla01s = this.findNotSaleHouse(projectNo);
		
		for(Sla01 sla01 : sla01s) {
			SalesVo vo = new SalesVo(""+sla01.getId(),sla01.getSla01005()+"<>"+sla01.getSla01006());//(id, 棟別<>戶號)
			list.add(vo);
		}
		return list;
	}
	
}
