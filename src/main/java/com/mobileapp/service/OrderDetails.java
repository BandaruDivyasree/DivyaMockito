package com.mobileapp.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.mobileapp.exceptions.MobileNotFoundExceptions;
import com.mobileapp.model.Mobile;

public class OrderDetails {
	IMobileService mobileService;
	
	public void setMobileService(IMobileService mobileService) {
		this.mobileService = mobileService;
	}

	public String orderMobile(int mobileId) {
	Mobile mobile=null;
		   try {
			    mobile=mobileService.getById(mobileId);
		   }catch(MobileNotFoundExceptions e) {
			   System.out.println(e.getMessage());
		   }
		   System.out.println(mobile.toString());
		   if(mobile==null || (mobile.getBrand()==null&&mobile.getMobileId()==null))
		   return "mobile not ordered";
		   else
			   return "mobile not ordered";
	   }

	public List<Mobile> showMobiles(String brand) throws MobileNotFoundExceptions{
		List<Mobile> mobileList = new ArrayList<>();
		try {
			mobileList=mobileService.getByBrand(brand);//returning null
			
		}catch (MobileNotFoundExceptions e) {
			System.out.println(e.getMessage());
			throw e;//use assertThrows
		}
		if(mobileList!=null) 
		return mobileList.stream().sorted(Comparator.comparing(Mobile::getModel)).collect(Collectors.toList());
		else
			return null;
	}
	
}


