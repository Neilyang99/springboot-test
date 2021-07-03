package cn.enilu.flash.warpper;

import cn.enilu.flash.service.system.impl.ConstantFactory;

import java.util.List;
import java.util.Map;

/**
 * 車位
 * @author YWG
 */
public class Sla02Wrapper extends BaseControllerWarpper {

    public Sla02Wrapper(List<Map<String, Object>> list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        map.put("sla02005Name", ConstantFactory.me().getDictsByName("汽機車類別",(String)map.get("sla02005")));
        map.put("sla02006Name", ConstantFactory.me().getDictsByName("車位類型",(String)map.get("sla02006")));
        map.put("sla02008Name", ConstantFactory.me().getDictsByName("車位購買類別",(String)map.get("sla02008")));
    }

}
