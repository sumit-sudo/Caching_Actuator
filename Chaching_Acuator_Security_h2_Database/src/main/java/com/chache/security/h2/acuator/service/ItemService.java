package com.chache.security.h2.acuator.service;




import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.chache.security.h2.acuator.dao.ItemDaoRepo;
import com.chache.security.h2.acuator.entity.Item;






@Service
public class ItemService {

	@Autowired
	ItemDaoRepo repo;


	@Cacheable(value="ten-second-cache", key="'Item in Cache'+#id", condition = "#isCacheable !=null && #isCacheable")
	public Item getItem(int id, boolean isCacheable) {
		
		System.out.println("hi");
		Optional<Item> item = repo.findById(id);
		if(item.isPresent()) {
			System.out.println(item);
			return item.get();
		}
		else {
			return null;
		}
	}


	public Item saveItem(Item item){
		
			
		
		DateTimeFormatter format=null;
		String parsedate=null;
		System.out.println("HIi"+item.getDate().length());
		if(item.getDate().length()==11)
		{
			System.out.println("HIIIIIIIIIIII");
			parsedate=item.getDate();
		}
		else
		{
			LocalDate date=LocalDate.parse(item.getDate());
			 format=DateTimeFormatter.ofPattern("yyyy-MMM-dd");
			  parsedate = date.format(format);
		}
		
		
		item.setDate(parsedate);
		return repo.save(item);
		

		
	}
}