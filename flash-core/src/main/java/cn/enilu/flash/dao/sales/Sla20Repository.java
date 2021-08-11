package cn.enilu.flash.dao.sales;

import java.util.List;
import java.util.Optional;

import cn.enilu.flash.bean.entity.sales.Sla20;
import cn.enilu.flash.dao.BaseRepository;

public interface Sla20Repository  extends BaseRepository<Sla20,Long>{
	
	public Sla20 findBySla20002AndSla20006(Long projectUID, Long customerUID);
	
	
}
