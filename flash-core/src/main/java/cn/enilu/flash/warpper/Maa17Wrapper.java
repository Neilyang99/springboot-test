package cn.enilu.flash.warpper;

import cn.enilu.flash.service.system.impl.ConstantFactory;

import java.util.List;
import java.util.Map;

/**
 * 零用金項目
 * @author YWG
 */
public class Maa17Wrapper extends BaseControllerWarpper {

    public Maa17Wrapper(List<Map<String, Object>> list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        map.put("maa17006Name", ConstantFactory.me().getDictsByName("零用金項目來源",(String)map.get("maa17006")));
    }

}
