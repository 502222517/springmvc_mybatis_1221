package cn.itcast.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.ssm.mapper.ItemsMapper;
import cn.itcast.ssm.mapper.ItemsMapperCustom;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;

public class ItemsServiceImpl implements ItemsService {
	
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo queryVo) throws Exception {
	 
		return itemsMapperCustom.findItemsList(queryVo);
	}
	 
	@Override
	public ItemsCustom findItemsById(int id) throws Exception{
		
		Items items=itemsMapper.selectByPrimaryKey(id);
		
		ItemsCustom itemsCustom =new ItemsCustom();
		
		BeanUtils.copyProperties(items, itemsCustom);
		
		return itemsCustom;
	}
	
	@Override
	public void updateItems(int id,ItemsCustom itemsCustom) throws Exception {
		
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
		
	}

}
