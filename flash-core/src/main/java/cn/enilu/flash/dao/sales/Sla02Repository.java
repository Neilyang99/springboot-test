package cn.enilu.flash.dao.sales;

import java.util.List;


import cn.enilu.flash.bean.entity.sales.Sla02;
import cn.enilu.flash.dao.BaseRepository;

public interface Sla02Repository  extends BaseRepository<Sla02,Long>{
	
	List<Sla02> findBySla02003(String sla02003);
	
}
