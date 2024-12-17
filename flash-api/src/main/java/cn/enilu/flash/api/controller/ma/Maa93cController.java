package cn.enilu.flash.api.controller.ma;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = "/getVendorWorkItem",method = RequestMethod.GET)
	public Object getVendorWorkItem(Long vendorId) {
		return Rets.success(maa93cService.getVendorWorkItem(vendorId));
	}
	
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@RequestParam Long vendorId, @RequestParam String workItemIdList) {
		//1.delete data by maa93c002
		//2.insert data
		
		maa93cService.deleteByVendor(vendorId);
		// workItem id 前端用, 分隔傳入
		String[] idList = workItemIdList.split(",");
		for(String s : idList) {
			if(!s.equals("")) {
				Maa93c obj = new Maa93c();
				obj.setMaa93c002(vendorId);
				obj.setMaa93c003((long) Integer.parseInt(s));
				
				maa93cService.insert(obj);
			}
		}
		
		return Rets.success();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id) {
		maa93cService.delete(id);
        return Rets.success();
    }
	
}
