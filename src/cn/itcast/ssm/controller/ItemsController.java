package cn.itcast.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.service.ItemsService;

@Controller
@RequestMapping("/items")
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;
	
	@RequestMapping("/queryItems")
	public ModelAndView queryItems() throws Exception{
		
		List<ItemsCustom> itemsList=itemsService.findItemsList(null);
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("items/itemsList");
		modelAndView.addObject("itemsList",itemsList);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/editItem",method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView editItems() throws Exception{
		
		ItemsCustom itemsCustom =itemsService.findItemsById(1);
		
		ModelAndView modelAndView=new ModelAndView();
		
		modelAndView.addObject("item",itemsCustom);
		modelAndView.setViewName("items/editItem");
		
		return modelAndView;
	}
	
	

}
