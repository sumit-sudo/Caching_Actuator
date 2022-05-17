package com.chache.security.h2.acuator.controller;





import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chache.security.h2.acuator.entity.Item;
import com.chache.security.h2.acuator.service.ItemService;





@RestController
@RequestMapping("/api")
public class ItemController {

	@Autowired
	ItemService service;
	

	

	@GetMapping("/item/{itemid}")
	public Item getOneItem(@PathVariable("itemid") int  itemid) 
	//public Item getOneItem() 
	{
		Item item;
		int a=10;
		try {
		System.out.println(itemid);
		System.out.println("HIIIIIII");
		item= service.getItem(itemid,true);
		}
		catch(Exception e)
		{
			return null;
		}
		return item;
	}
	
	@PostMapping("/save")
	public Item saveItem(@RequestBody Item item) 
	{
		Item saveItem = service.saveItem(item);	
	return saveItem;
	}
	
	
	
	
	
	
	
}
