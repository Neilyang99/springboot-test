package cn.enilu.flash.api.controller.ma;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.constant.factory.PageFactory;
import cn.enilu.flash.bean.entity.ma.Maa00;
import cn.enilu.flash.bean.entity.ma.Maa01a;
import cn.enilu.flash.bean.entity.system.FileInfo;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.ma.BudgetExcelVo;
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
@RequestMapping("/maa01a")
public class Maa01aController extends BaseController{

	@Autowired
    private Maa00Service maa00Service;
	
	@Autowired
    private Maa01aService maa01aService;
	
	@Autowired
    private Maa01Service maa01Service;
	
	@Autowired
    private FileService fileService;
	
	@Autowired
    private Maa01bService maa01bService;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(String name) {
		Page<Maa01a> page = new PageFactory<Maa01a>().defaultPage();
		if(StringUtil.isNullOrEmpty(name)) {
			
		}else {
			page.addFilter( "maa01a009", SearchFilter.Operator.LIKE, name);
		}
		page = maa01aService.queryPage(page);
		List list = BeanUtil.objectsToMaps(page.getRecords());
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	@RequestMapping(value = "/listByProject",method = RequestMethod.GET)
	public Object listByProject(Long projectId) {
		List<Maa01a> list = maa01aService.findByMaa01a002(projectId);
		
		return Rets.success(list);
	}
	
	@RequestMapping(value = "/listByPrjLv2",method = RequestMethod.GET)
	public Object listByPrjLv2(Long projectId, Long lv1, Long lv2) {
		Page<Maa01a> page = new PageFactory<Maa01a>().defaultPage();
		page.addFilter( "maa01a002", SearchFilter.Operator.EQ, projectId);
		page.addFilter( "maa01a003", SearchFilter.Operator.EQ, lv1);
		page.addFilter( "maa01a004", SearchFilter.Operator.EQ, lv2);
		page.setSort(Sort.by(Sort.Direction.ASC,"maa01a006"));
		page = maa01aService.queryPage(page);
		
		List list = BeanUtil.objectsToMaps(page.getRecords());
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Maa01a maa01a) {
		if(maa01a.getId() == null) {
			maa01aService.insert(maa01a);
		}else {
			maa01aService.update(maa01a);
		}
		
		//更新mma01的小類別預算金額
		maa01Service.updateBudgeAmountByMaa01004(maa01a.getMaa01a002(), maa01a.getMaa01a004());
		
		//更新工程案總預算
		maa00Service.updateBudgeAmountByProject(maa01a.getMaa01a002());
		
		return Rets.success();
	}
	
	@Transactional
	@RequestMapping(value = "/inertByNewProject", method = RequestMethod.GET)
	public Object insertByNewProject(Long projectId, String buildTypeList) {
		int count = maa01aService.checkByMaa01a002(projectId);
		if(count == 0) {
			
			int cnt1 = 0; 
			int cnt2 = 0;
			int cnt3 = 0;
			//新增 maa01 from maa90&maa91
			cnt1 = maa01Service.insertByNewProject(projectId, buildTypeList);
			//新增 maa01a from maa92
			cnt2 = maa01aService.insertByNewProject(projectId, buildTypeList);
			//新增 maa01b from maa92a
			cnt3 = maa01bService.insertByNewProject(projectId, buildTypeList);
			
			//更新 maa01a 的預算金額
			maa01aService.updateBudgeAmountByProject(projectId);
			//更新 maa01的預算金額
			maa01Service.updateBudgeAmountByProject(projectId);
			//更新工程案總預算
			maa00Service.updateBudgeAmountByProject(projectId);
			
			if(cnt1 == 0 && cnt2 == 0) {
				return Rets.failure("預算項目新增失敗，請再次新增。");
			}else {
				return Rets.success("預算項目新增成功。");
			}
			
		}else {
			return Rets.failure("此工程案已經有預算項目，不可以新增!!");
		}
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id, Long projectId, Long lv2Id) {
		maa01aService.delete(id);
		maa01bService.delByMaa01a(id);//第三階刪除，同步刪除底下的施作項目
		
		//更新mma01的小類別預算金額
		maa01Service.updateBudgeAmountByMaa01004(projectId, lv2Id);
		
		//更新工程案總預算
		maa00Service.updateBudgeAmountByProject(projectId);
				
        return Rets.success();
    }
	
	@RequestMapping(value = "/export",method = RequestMethod.GET)
	public Object export(@RequestParam(required = true) Long prjId) {
		
		List<BudgetExcelVo> list = maa01aService.exportToXlsx(prjId);
        
		return Rets.success(list);
	}
}
