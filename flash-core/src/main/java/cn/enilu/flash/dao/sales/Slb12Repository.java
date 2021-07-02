package cn.enilu.flash.dao.sales;

import java.util.List;
import java.util.Optional;

import cn.enilu.flash.bean.entity.sales.Slb12;
import cn.enilu.flash.dao.BaseRepository;

public interface Slb12Repository  extends BaseRepository<Slb12,Long>{
	
	
	List<Slb12> findBySlb12002(Long slb12002);
	Optional<Slb12> findById(Long id);
}
