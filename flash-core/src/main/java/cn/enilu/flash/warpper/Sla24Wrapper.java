package cn.enilu.flash.warpper;

import cn.enilu.flash.service.system.impl.ConstantFactory;

import java.util.List;
import java.util.Map;

/**
 * 房屋驗收
 * @author YWG
 */
public class Sla24Wrapper extends BaseControllerWarpper {

    public Sla24Wrapper(List<Map<String, Object>> list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        map.put("sla24004Name", ConstantFactory.me().getDictsByName("驗收類別",(String)map.get("sla24004")));
        map.put("sla24006Name", ConstantFactory.me().getDictsByName("項目分類",(String)map.get("sla24006")));
    }

}
