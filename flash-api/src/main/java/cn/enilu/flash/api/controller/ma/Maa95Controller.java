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
import cn.enilu.flash.bean.entity.ma.Maa95;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.service.ma.Maa95Service;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.StringUtil;
import cn.enilu.flash.utils.factory.Page;


@RestController
@RequestMapping("/maa95")
public class Maa95Controller extends BaseController{

	@Autowired
    private Maa95Service maa95Service;
	
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(@RequestParam(required = false) String name) {
		Page<Maa95> page = new PageFactory<Maa95>().defaultPage();
		if(!StringUtil.isNullOrEmpty(name)) {
			page.addFilter( "maa95002", SearchFilter.Operator.LIKE, name);
		}
		page.addFilter( "maa95013", SearchFilter.Operator.EQ, "Y");//狀態=啟用
		
		page.setSort(Sort.by(Sort.Direction.ASC,"maa95012"));
		page = maa95Service.queryPage(page);
		List list = BeanUtil.objectsToMaps(page.getRecords());
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	@RequestMapping(value = "/selectList",method = RequestMethod.GET)
	public Object selectList() {
		return Rets.success(maa95Service.getValueList());
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Maa95 maObj) {
		String msg = "";
		
		if(maObj.getId() == null) {
			int count = maa95Service.checkWorkItemName((long) 0, maObj.getMaa95002());
			if(count > 0) {
				msg = "此施作項目: "+maObj.getMaa95002()+" ，已經存在，請變更施作項目。";
			}else {
				maa95Service.insert(maObj);
			}
			
		}else {
			int count = maa95Service.checkWorkItemName(maObj.getId(), maObj.getMaa95002());
			if(count > 0) {
				msg = "此施作項目: "+maObj.getMaa95002()+" ，已經存在，請變更施作項目。";
			}else {
				maa95Service.update(maObj);
			}
		}
		if(msg == "") {
			return Rets.success();
		}else {
			return Rets.failure(msg);
		}
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id) {
		maa95Service.CancelById(id);//作廢此筆資料
		
        return Rets.success();
    }
	
}
