package cn.enilu.flash.dao.sales;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import cn.enilu.flash.bean.entity.sales.Slb11;
import cn.enilu.flash.dao.BaseRepository;

public interface Slb11Repository  extends BaseRepository<Slb11,Long>{
	
	//@Query("SELECT slb11.id,slb11002,slb11003,slb10.id,slb10002,slb10003,slb10004 FROM slb11 a inner join slb10 b")
	//List<Slb11> queryWithSlb10();
	
	List<Slb11> findBySlb11002(Long slb11002);
	Optional<Slb11> findById(Long id);
}
