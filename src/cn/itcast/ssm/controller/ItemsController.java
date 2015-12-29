package cn.itcast.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.service.ItemsService;

@Controller
@RequestMapping("/items")
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request) throws Exception{
		
		System.out.println(request.getParameter("id"));
		
		List<ItemsCustom> itemsList=itemsService.findItemsList(null);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("items/itemsList");
		modelAndView.addObject("itemsList",itemsList);
		
		return modelAndView;
	}
	@RequestMapping("/queryItemsJSON")
	public void queryItemsJSON(HttpServletRequest request ,HttpServletResponse response) throws Exception{
		
		List<ItemsCustom> itemsList=itemsService.findItemsList(null);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write("{\"id\":1}");
	}
	
	
	
	
	@RequestMapping(value="/editItem",method={RequestMethod.GET,RequestMethod.POST})
	public String editItems(Model model,@RequestParam(value="id",required=true,defaultValue="1") Integer items_id) throws Exception{
		
		ItemsCustom itemsCustom =itemsService.findItemsById(items_id);
		
		model.addAttribute("item",itemsCustom);
		 
		return "items/editItem";
	}
	
	@RequestMapping(value="/editItemsSubmit")
	public String editItemsSubmit(HttpServletRequest request,int id,ItemsCustom itemsCustom) throws Exception{
		
		// 保存数据
		itemsService.updateItems(id, itemsCustom);
		 
		
		// 重定向 
//		return "redirect:queryItems.action";
		// 页面转发 request可以共享
		return "forward:queryItems.action";
		
//		return "success";
	}
	
	

}
