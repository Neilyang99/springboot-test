package cn.enilu.flash.warpper;

import cn.enilu.flash.bean.vo.ma.MaaVo;

import java.util.List;
import java.util.Map;


/**
 * 請款公司/付款公司
 * @author YWG
 */
public class Maa21Wrapper extends BaseControllerWarpper {
	
	
    private List<MaaVo> itemList;

    public Maa21Wrapper(List<Map<String, Object>> list) {
        super(list);
    }
    
    public Maa21Wrapper(List<MaaVo> items, List<Map<String, Object>> list) {
        super(list);
        this.itemList = items;
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
    	Long pk = (Long) map.get("maa21004");
    	String name = getValueName(""+pk);
        map.put("maa21004Name", name);
        
        Long pk1 = (Long) map.get("maa21005");
        String name1 = getValueName(""+pk1);
        map.put("maa21005Name", name1);
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
