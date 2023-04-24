package cn.enilu.flash.service.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.enilu.flash.bean.entity.ma.Maa01a;
import cn.enilu.flash.dao.ma.Maa01aRepository;
import cn.enilu.flash.service.BaseService;

@Service
public class Maa01aService extends BaseService<Maa01a,Long,Maa01aRepository>{
	
	@Autowired
	private Maa01aRepository repository;
	
	public List<Maa01a> findByMaa01a002(Long projectId){
		return repository.findByMaa01a002(projectId);
	}
	
	/**
	 * 根據工程案與小類別ID取出所有資料
	 * @param projectId
	 * @param lv2
	 * @return
	 */
	public List<Maa01a> findByMaa01a002And004(Long projectId, Long lv2){
		return repository.findByMaa01a002AndMaa01a004(projectId,lv2);
	}
	
	public List<Maa01a> exportToXlsx(Long projectId){
		//TODO: 要加入資料狀態
		return repository.findByMaa01a002(projectId);
	}
}
