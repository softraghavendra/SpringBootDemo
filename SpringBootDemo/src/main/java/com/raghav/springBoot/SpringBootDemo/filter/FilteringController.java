package com.raghav.springBoot.SpringBootDemo.filter;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public SomeBean filtering(){
		return new SomeBean("field1", "field2", "field3");
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> filteringList(){
		return Arrays.asList(new SomeBean("field1", "field2", "field3"),
				new SomeBean("field12", "field22", "field33"));
	}
	
	//o/p only field1 and field2
	@GetMapping("/filtering1")
	public MappingJacksonValue filtering2(){
		SomeBean someBean = new SomeBean("field1", "field2", "field3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filterProvider);
		return mapping;
	}
	
	// only field2 and field3 will display
	@GetMapping("/filtering-list2")
	public MappingJacksonValue filteringList2(){
		List<SomeBean> list = Arrays.asList(new SomeBean("field1", "field2", "field3"),
				new SomeBean("field12", "field22", "field33"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filterProvider);
		return mapping;
	}

}
