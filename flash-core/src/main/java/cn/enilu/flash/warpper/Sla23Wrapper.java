package cn.enilu.flash.warpper;

import cn.enilu.flash.service.system.impl.ConstantFactory;

import java.util.List;
import java.util.Map;

/**
 * 房屋收款
 * @author YWG
 */
public class Sla23Wrapper extends BaseControllerWarpper {

    public Sla23Wrapper(List<Map<String, Object>> list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        map.put("sla23006Name", ConstantFactory.me().getDictsByName("收款方式",(String)map.get("sla23006")));
        map.put("sla23031Name", ConstantFactory.me().getDictsByName("收款類別",(String)map.get("sla23031")));
    }

}
