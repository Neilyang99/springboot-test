package cn.enilu.flash.api.controller.ma;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.constant.factory.PageFactory;
import cn.enilu.flash.bean.entity.ma.Maa00;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.service.ma.Maa00Service;
import cn.enilu.flash.service.ma.Maa01Service;
import cn.enilu.flash.service.ma.Maa01aService;
import cn.enilu.flash.service.ma.Maa01bService;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.StringUtil;
import cn.enilu.flash.utils.factory.Page;


@RestController
@RequestMapping("/maa00")
public class Maa00Controller extends BaseController{

	@Autowired
    private Maa00Service maa00Service;
	@Autowired
	private Maa01Service maa01Service;
	@Autowired
	private Maa01aService maa01aService;
	@Autowired
	private Maa01bService maa01bService;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(String selMaa00004) {
		Page<Maa00> page = new PageFactory<Maa00>().defaultPage();
		if(StringUtil.isNullOrEmpty(selMaa00004)) {
			
		}else {
			page.addFilter( "maa00004", SearchFilter.Operator.LIKE, selMaa00004);
		}
		page = maa00Service.queryPage(page);
		List list = BeanUtil.objectsToMaps(page.getRecords());
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	@RequestMapping(value = "/budgetConfirmList",method = RequestMethod.GET)
	public Object budgetConfirmList(String selMaa00004) {
		Page<Maa00> page = new PageFactory<Maa00>().defaultPage();
		if(StringUtil.isNullOrEmpty(selMaa00004)) {
			
		}else {
			page.addFilter( "maa00004", SearchFilter.Operator.LIKE, selMaa00004);
		}
		
		page.addFilter( "maa00040", SearchFilter.Operator.EQ, "Y");//預算書確認
		
		page = maa00Service.queryPage(page);
		List list = BeanUtil.objectsToMaps(page.getRecords());
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	@RequestMapping(value = "/selectList",method = RequestMethod.GET)
	public Object selectList() {
		//TODO: 有效工程案才可以挑選
		return Rets.success(maa00Service.queryAll());
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Maa00 maa00) {
		if(maa00.getId() == null) {
			maa00Service.insert(maa00);
		}else {
			maa00Service.update(maa00);
		}
		
		return Rets.success();
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id) {
		maa00Service.delete(id);
		
		maa01Service.deleteByMaa01002(id);
		
		maa01aService.deleteByMaa01a002(id);
		
		maa01bService.deleteByMaa01b002(id);
		
        return Rets.success();
    }
	
	@Transactional
	@RequestMapping(value="/budgetConfirm",method = RequestMethod.GET)
    public Object budgetConfirm(Long id,String status) {
		
		Maa00 obj = maa00Service.get(id);
		if(obj.getMaa00027() > 0) {
			obj.setMaa00040(status);
			maa00Service.update(obj);
			
			maa01Service.updateBudgeConfirmByProject(id,status);
			maa01aService.updateBudgeConfirmByProject(id,status);
			maa01bService.updateBudgeConfirmByProject(id,status);
			
			return Rets.success();
		}else {
			return Rets.failure("尚未編訂預算，無法確認。");
		}
	}
	
	
}
