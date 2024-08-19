package cn.enilu.flash.api.controller.ma;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.enilu.flash.api.controller.BaseController;
import cn.enilu.flash.bean.constant.factory.PageFactory;
import cn.enilu.flash.bean.entity.ma.Maa92a;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.ma.Maa92aVo;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.service.ma.Maa92aService;
import cn.enilu.flash.utils.BeanUtil;
import cn.enilu.flash.utils.StringUtil;
import cn.enilu.flash.utils.factory.Page;


@RestController
@RequestMapping("/maa92a")
public class Maa92aController extends BaseController{

	@Autowired
    private Maa92aService maa92aService;
	
	
	@RequestMapping(value = "/listByPage",method = RequestMethod.GET)
	public Object list(@RequestParam(required = false) String name) {
		Page<Maa92a> page = new PageFactory<Maa92a>().defaultPage();
		
		page.setSort(Sort.by(Sort.Direction.ASC,"maa92a007"));
		page = maa92aService.queryPage(page);
		List list = BeanUtil.objectsToMaps(page.getRecords());
        page.setRecords(list);
        
		return Rets.success(page);
	}
	
	@RequestMapping(value = "/list",method = RequestMethod.GET)
	public Object list(@RequestParam(required = false) Long itemId) {
		List<Maa92aVo> list = maa92aService.queryByItemId(itemId);
        
		return Rets.success(list);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Object add(@ModelAttribute @Valid Maa92aVo vo) {
		
		int cnt = maa92aService.checkDuplicateWorkItem(vo.getId(), vo.getMaa92a002(), vo.getMaa92a003(), vo.getMaa92a009());
		if(cnt > 0) {
			
			return Rets.failure("此筆 施作項目 已經重複了，請變更挑選!");
		}else {
			Maa92a obj = new Maa92a();
			
			obj.setMaa92a002(vo.getMaa92a002());
			obj.setMaa92a003(vo.getMaa92a003());
			obj.setMaa92a004(vo.getMaa92a004());
			obj.setMaa92a005(vo.getMaa92a005());
			obj.setMaa92a006(vo.getMaa92a006());
			obj.setMaa92a007(vo.getMaa92a007());
			obj.setMaa92a008(vo.getMaa92a008());
			obj.setMaa92a009(vo.getMaa92a009());
			
			if(vo.getId() == 0) {
				obj.setId(null);
				maa92aService.insert(obj);
			}else {
				obj.setId(vo.getId());
				
				maa92aService.update(obj);
			}
			
			return Rets.success();
		}
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
    public Object remove(Long id) {
		maa92aService.delete(id);
        return Rets.success();
    }
	
	
}
