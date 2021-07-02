package cn.enilu.flash.service.sales;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.sales.Slb10;
import cn.enilu.flash.bean.entity.sales.Slb11;
import cn.enilu.flash.dao.sales.Slb10Repository;
import cn.enilu.flash.service.BaseService;

@Service
public class Slb10Service extends BaseService<Slb10,Long,Slb10Repository>{
	
	@Autowired
	private Slb10Repository slb10Repository;
	
	public Optional<Slb10> findById(Long id) {
		return slb10Repository.findById(id);
	}
//	public List<Slb11> findBySlb11002(Integer slb11002){
//		return slb10Repository.findBySlb11002(slb11002);
//	}
	
	public int updateAmountById(Long id) {
		return this.slb10Repository.updateAmountById(id);
	}
	
	public int updateCountAmountById(Long id, String cntField, String amtField) {
		return this.slb10Repository.updateCountAmountById(id, cntField, amtField);
	}
	
	public int updateTotalAmountByIdAndProjectNo(Long id, String projectNo) {
		return this.slb10Repository.updateTotalAmountByIdAndProjectNo(id, projectNo);
	}
	
	public int updateAgainCountById(Long id) {
		return this.slb10Repository.updateAgainCountById(id);
	}
}
