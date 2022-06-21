package cn.enilu.flash.warpper;

import cn.enilu.flash.bean.vo.ma.MaaVo;
import cn.enilu.flash.service.ma.Maa94Service;
import cn.enilu.flash.service.system.impl.ConstantFactory;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * 材料庫存
 * @author YWG
 */
public class Maa10Wrapper extends BaseControllerWarpper {
	
	
    private List<MaaVo> itemList;

    public Maa10Wrapper(List<Map<String, Object>> list) {
        super(list);
    }
    
    public Maa10Wrapper(List<MaaVo> items, List<Map<String, Object>> list) {
        super(list);
        this.itemList = items;
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
    	Long pk = (Long) map.get("maa10006");
    	String name = getValueName(""+pk);
        map.put("maa10006Name", name);
    }
    
    private String getValueName(String pk) {
    	String name = "";
    	for(MaaVo vo : itemList) {
    		if(vo.getKey().equals(pk)) {
    			name = vo.getName();
    			break;
    		}
    	}
    	
    	return name;
    }

}
