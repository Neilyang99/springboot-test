package cn.enilu.flash.dao.sales;

import java.util.List;
import java.util.Optional;

import cn.enilu.flash.bean.entity.sales.Slb13;
import cn.enilu.flash.dao.BaseRepository;

public interface Slb13Repository  extends BaseRepository<Slb13,Long>{
	
	
	List<Slb13> findBySlb13002(Long slb13002);
	Optional<Slb13> findById(Long id);
}
