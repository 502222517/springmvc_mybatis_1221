package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;

public interface ItemsService {

	public List<ItemsCustom> findItemsList(ItemsQueryVo queryVo) throws Exception;
	
	// 根据id查询商品信息
	public ItemsCustom findItemsById(int id) throws Exception;
	
	// 修改商品信息
	public void updateItems(int id,ItemsCustom itemsCustom) throws Exception;
	
	
}
