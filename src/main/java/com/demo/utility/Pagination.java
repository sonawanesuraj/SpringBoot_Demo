package com.demo.utility;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class Pagination {

	public Pagination() {
		super(); 
		//TODO Auto-generated constructor stub
	}
	
	public Pageable getPegination(String pageNo,String pageSize) {
		
		return PageRequest.of(Integer.parseInt(pageNo)-1, Integer.parseInt(pageSize));
	}	

}
