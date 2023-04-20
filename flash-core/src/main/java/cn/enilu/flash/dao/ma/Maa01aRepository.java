package cn.enilu.flash.dao.ma;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import cn.enilu.flash.bean.entity.ma.Maa01a;
import cn.enilu.flash.dao.BaseRepository;

public interface Maa01aRepository  extends BaseRepository<Maa01a,Long>{
	
	public List<Maa01a> findByMaa01a002(Long projectId);
	
	public List<Maa01a> findByMaa01a002AndMaa01a004(Long projectId, Long lv2Id);
}
