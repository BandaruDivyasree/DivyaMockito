package com.mobileapp.service;

import java.util.List;



import com.mobileapp.exceptions.MobileNotFoundExceptions;
import com.mobileapp.model.Mobile;


	public interface IMobileService {
		 
		 
		 //return null,emptylist,
		public Mobile  getById(int Id) throws MobileNotFoundExceptions;
		//return null,empty arrayList,list of mobiles,exception
		public List<Mobile> getByBrand(String brand) throws MobileNotFoundExceptions;

	}



