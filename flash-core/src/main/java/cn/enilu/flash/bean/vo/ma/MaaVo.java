package cn.enilu.flash.bean.vo.ma;

import lombok.Data;

@Data
/**
 * MaaVo
 *
 * @author YWG
 */
public class MaaVo {
    private String key;
    private String value;
    private String name;

    public MaaVo() {
    }
    public MaaVo(String key, String value) {
        this.key = key;
        this.value = value;
    }
    public MaaVo(String key, String value, String name) {
        this.key = key;
        this.value = value;
        this.name = name;
    }
}
