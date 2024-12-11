package cn.enilu.flash.api.controller.ma;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.constant.factory.PageFactory;
import cn.enilu.flash.bean.entity.ma.Maa00;
import cn.enilu.flash.bean.entity.ma.Maa01b;
import cn.enilu.flash.bean.entity.system.FileInfo;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.ma.BudgetDataVo;
import cn.enilu.flash.bean.vo.ma.BudgetExcelVo;
import cn.enilu.flash.bean.vo.query.DynamicSpecifications;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.service.ma.Maa00Service;
import cn.enilu.flash.service.ma.Maa01Service;
import cn.enilu.flash.service.ma.Maa01aService;
import cn.enilu.flash.service.ma.Maa01bService;
import cn.enilu.flash.service.system.FileService;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.Maps;
import cn.enilu.flash.utils.StringUtil;
import cn.enilu.flash.utils.factory.Page;


@RestController
@RequestMapping("/maa01b")
public class Maa01bController extends BaseController{

	@Autowired
    private Maa00Service maa00Service;
	
	@Autowired
    private Maa01aService maa01aService;
	
	@Autowired
    private Maa01Service maa01Service;
	
	@Autowired
    private Maa01bService maa01bService;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(Long budgetItemId) {
		Page<Maa01b> page = new PageFactory<Maa01b>().defaultPage();
		if(StringUtil.isNullOrEmpty(budgetItemId)) {
			
		}else {
			page.addFilter( "maa01b007", SearchFilter.Operator.EQ, budgetItemId);
		}
		page.setSort(Sort.by(Sort.Direction.ASC,"maa01b020"));
		page = maa01bService.queryPage(page);
		List list = BeanUtil.objectsToMaps(page.getRecords());
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	@RequestMapping(value = "/selectlist",method = RequestMethod.GET)
	public Object selectlist(Long projectId, Long vendorId, String filterWord) {
		
		//System.out.println("-------------- PROJ="+projectId+" vendor="+vendorId+" filter="+filterWord);
		Page<Maa01b> page = new PageFactory<Maa01b>().defaultPage();
		
		List list = maa01bService.getBudgetData(projectId, vendorId);
		
        
		return Rets.success(list);
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Maa01b maa01b) {
		if(maa01b.getId() == null) {
			maa01bService.insert(maa01b);
		}else {
			maa01bService.update(maa01b);
		}
		
		//更新mma01a的預算項目金額
		maa01aService.updateAmountByProjectAndItem(maa01b.getMaa01b002(), maa01b.getMaa01b007());
		//更新mma01的小類別預算金額
		maa01Service.updateBudgeAmountByMaa01004(maa01b.getMaa01b002(), maa01b.getMaa01b004());
		//更新工程案總預算
		maa00Service.updateBudgeAmountByProject(maa01b.getMaa01b002());
		
		return Rets.success();
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id, Long projectId, Long lv2Id, Long lv3Id) {
		maa01bService.delete(id);
		
		
		//更新mma01a的預算項目金額
		maa01aService.updateAmountByProjectAndItem(projectId, lv3Id);
		//更新mma01的小類別預算金額
		maa01Service.updateBudgeAmountByMaa01004(projectId, lv2Id);
		//更新工程案總預算
		maa00Service.updateBudgeAmountByProject(projectId);
		
		//更新是否有施工項目 (必須更新maa01a金額後再更新狀態)
		maa01aService.updateWorkItemFlag(projectId, lv3Id);
						
				
        return Rets.success();
    }
	
}
