package cn.enilu.flash.dao.sales;

import java.util.List;
import java.util.Optional;

import cn.enilu.flash.bean.entity.sales.Slb15;
import cn.enilu.flash.dao.BaseRepository;

public interface Slb15Repository  extends BaseRepository<Slb15,Long>{
	
	
	List<Slb15> findBySlb15002(Long slb15002);
	Optional<Slb15> findById(Long id);
}
