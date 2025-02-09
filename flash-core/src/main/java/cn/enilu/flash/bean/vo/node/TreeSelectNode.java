package cn.enilu.flash.bean.vo.node;

import java.util.List;

import lombok.Data;

@Data
public class TreeSelectNode {
	private String id;
    private String label;
    private List<TreeSelectNode> children;

}
