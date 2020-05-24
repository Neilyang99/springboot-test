package cn.enilu.flash.dao.sales;

import cn.enilu.flash.bean.entity.sales.Sla00;
import cn.enilu.flash.dao.BaseRepository;

public interface Sla00Repository  extends BaseRepository<Sla00,Long>{
	
	Sla00 findBySla00002(String code);
}
