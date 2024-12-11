package cn.enilu.flash.api.controller.ma;

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
import cn.enilu.flash.bean.entity.ma.Maa01;
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
@RequestMapping("/maa01")
public class Maa01Controller extends BaseController{

	@Autowired
    private Maa01Service maa01Service;
	@Autowired
    private Maa01aService maa01aService;
	@Autowired
    private Maa00Service maa00Service;
	@Autowired
    private Maa01bService maa01bService;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(@RequestParam(required = false)  String prjId) {
		Page<Maa01> page = new PageFactory<Maa01>().defaultPage();
		
		if(!StringUtil.isNullOrEmpty(prjId)) {
			page.addFilter( "maa01002", SearchFilter.Operator.EQ, prjId);
		}
		page.setSort(Sort.by(Sort.Direction.ASC,"maa01017"));
		page = maa01Service.queryPage(page);
		List list = BeanUtil.objectsToMaps(page.getRecords());
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Maa01 maa01) {
		if(maa01.getId() == null) {
			int count = maa01Service.checkLevel2Data(maa01.getMaa01002(), maa01.getMaa01003(), maa01.getMaa01004());
			if(count == 0) {
				maa01Service.insert(maa01);
				return Rets.success();
			}else {
				return Rets.failure("此資料已經存在，不可以新增!!");
			}
			
		}else {
			maa01Service.update(maa01);
			return Rets.success();
		}
		
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id,Long projectId,Long lv1,Long lv2) {
		maa01Service.delete(id);
		
		maa01aService.delByMaa01(projectId, lv1, lv2);
		maa01bService.delByMaa01(projectId, lv1, lv2);
		//更新工程案總預算
		maa00Service.updateBudgeAmountByProject(projectId);
		
        return Rets.success();
    }
	
	
	
}
