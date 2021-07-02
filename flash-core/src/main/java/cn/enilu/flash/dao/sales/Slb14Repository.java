package cn.enilu.flash.dao.sales;

import java.util.List;
import java.util.Optional;

import cn.enilu.flash.bean.entity.sales.Slb14;
import cn.enilu.flash.dao.BaseRepository;

public interface Slb14Repository  extends BaseRepository<Slb14,Long>{
	
	
	List<Slb14> findBySlb14002(Long slb14002);
	Optional<Slb14> findById(Long id);
}
