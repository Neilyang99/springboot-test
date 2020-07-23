package cn.enilu.flash.dao.sales;

import java.util.List;


import cn.enilu.flash.bean.entity.sales.Sla11;
import cn.enilu.flash.dao.BaseRepository;

public interface Sla11Repository extends BaseRepository<Sla11,Long>{

	Sla11 findBySla11004(String str);
	List<Sla11> findBySla11002(String visitorId);
	
}
