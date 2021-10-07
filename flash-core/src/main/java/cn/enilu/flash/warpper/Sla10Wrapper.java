package cn.enilu.flash.warpper;

import cn.enilu.flash.service.system.impl.ConstantFactory;

import java.util.List;
import java.util.Map;

/**
 * 來人來電
 * @author YWG
 */
public class Sla10Wrapper extends BaseControllerWarpper {

    public Sla10Wrapper(List<Map<String, Object>> list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        map.put("sla10004Name", ConstantFactory.me().getDictsByName("來人來電",(String)map.get("sla10004")));
    }

}
