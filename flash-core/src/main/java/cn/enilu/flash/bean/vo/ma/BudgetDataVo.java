package cn.enilu.flash.bean.vo.ma;

import lombok.Data;

@Data
/**
 * BudgetDataVo
 *
 * @author YWG
 */
public class BudgetDataVo {
    private int maa01aId;
    private String firstName;
    private String secondName;
    private String itemName;
    private String itemUnit;
    private double itemQty;
    private double itemUnitPrice;
    private double itemAmount;
    private int maa01bId;
    private String workItemName;
    private String workItemUnit;
    private double workItemQty;
    private double workItemUnitPrice;
    private double workItemAmount;

}
