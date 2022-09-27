package cn.enilu.flash.api.controller.ma;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.constant.factory.PageFactory;
import cn.enilu.flash.bean.entity.ma.Maa93;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.service.ma.Maa93Service;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.StringUtil;
import cn.enilu.flash.utils.factory.Page;


@RestController
@RequestMapping("/maa93")
public class Maa93Controller extends BaseController{

	@Autowired
    private Maa93Service maa93Service;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(String name) {
		Page<Maa93> page = new PageFactory<Maa93>().defaultPage();
		if(StringUtil.isNullOrEmpty(name)) {
			
		}else {
			page.addFilter( "maa93004", SearchFilter.Operator.LIKE, name);
		}
		page = maa93Service.queryPage(page);
		List list = BeanUtil.objectsToMaps(page.getRecords());
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Maa93 maObj) {
		
		String msg = "";
		
		if(maObj.getId() == null) {
			int cnt = maa93Service.checkVendorIdByNew(maObj.getMaa93011());
			if(cnt > 0) {
				msg = "統一編號:"+maObj.getMaa93011()+" 已經存在，請變更。";
			}else {
				maa93Service.insert(maObj);
			}
			
		}else {
			int cnt = maa93Service.checkVendorIdByUpdate(maObj.getId(), maObj.getMaa93011());
			if(cnt > 0) {
				msg = "統一編號:"+maObj.getMaa93011()+" 已經存在，請變更。";
			}else {
				maa93Service.update(maObj);
			}
		}
		
		if(msg == "") {
			return Rets.success();
		}else {
			return Rets.failure(msg);
		}
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id) {
		maa93Service.delete(id);
        return Rets.success();
    }
	
	
}
