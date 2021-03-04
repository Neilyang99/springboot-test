package cn.enilu.flash.dao.sales;

import cn.enilu.flash.bean.entity.sales.Sla30;
import cn.enilu.flash.dao.BaseRepository;

public interface Sla30Repository  extends BaseRepository<Sla30,Long>{
	
	Sla30 findBySla30004(String code);
}
