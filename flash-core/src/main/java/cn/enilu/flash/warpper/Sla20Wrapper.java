package cn.enilu.flash.warpper;

import cn.enilu.flash.service.system.impl.ConstantFactory;

import java.util.List;
import java.util.Map;

/**
 * 訂單狀態
 * @author YWG
 */
public class Sla20Wrapper extends BaseControllerWarpper {

    public Sla20Wrapper(List<Map<String, Object>> list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        map.put("sla20005Name", ConstantFactory.me().getDictsByName("訂單狀態",(String)map.get("sla20005")));
    }

}
