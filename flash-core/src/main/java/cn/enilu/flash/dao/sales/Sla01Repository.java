package cn.enilu.flash.dao.sales;

import java.util.List;

import cn.enilu.flash.bean.entity.sales.Sla01;
import cn.enilu.flash.dao.BaseRepository;

public interface Sla01Repository  extends BaseRepository<Sla01,Long>{
	
	List<Sla01> findBySla01002(Integer sla01002);
	
}
