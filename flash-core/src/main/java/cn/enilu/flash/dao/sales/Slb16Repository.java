package cn.enilu.flash.dao.sales;

import java.util.List;
import java.util.Optional;

import cn.enilu.flash.bean.entity.sales.Slb16;
import cn.enilu.flash.dao.BaseRepository;

public interface Slb16Repository  extends BaseRepository<Slb16,Long>{
	
	
	List<Slb16> findBySlb16002(Long slb16002);
	Optional<Slb16> findById(Long id);
}
