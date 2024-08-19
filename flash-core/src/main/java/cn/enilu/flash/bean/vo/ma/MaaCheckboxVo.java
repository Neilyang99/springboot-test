package cn.enilu.flash.bean.vo.ma;

import lombok.Data;

@Data
/**
 * MaaVo
 *
 * @author YWG
 */
public class MaaCheckboxVo {
    private String key;
    private String value;
    private String name;
    private boolean active;

    public MaaCheckboxVo() {
    }
    
    public MaaCheckboxVo(String key, String value, String name, boolean active) {
        this.key = key;
        this.value = value;
        this.name = name;
        this.active = active;
    }
}
