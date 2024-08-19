package cn.enilu.flash.api.controller.ma;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.entity.ma.Maa93c;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.service.ma.Maa93cService;


@RestController
@RequestMapping("/maa93c")
public class Maa93cController extends BaseController{

	@Autowired
    private Maa93cService maa93cService;
	
	
	@RequestMapping(value = "/getWorkItemListByVendor",method = RequestMethod.GET)
	public Object getWorkItemListByVendor(Long vendorId) {
		return Rets.success(maa93cService.getWorkItemByVendor(vendorId));
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Maa93c maObj) {
		
		return Rets.success();
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id) {
		maa93cService.delete(id);
        return Rets.success();
    }
	
}
