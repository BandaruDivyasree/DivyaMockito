package com.mobileapp.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.mobileapp.exceptions.EmptyCartException;
import com.mobileapp.exceptions.MobileNotFoundExceptions;
import com.mobileapp.model.Mobile;

public class CartDetails {
    ICartService cartService;
	
	/**
	 * @return the cartService
	 */
	public ICartService getCartService() {
		return cartService;
	}
	/**
	 * @param cartService the cartService to set
	 */
	public void setCartService(ICartService cartService) {
		this.cartService = cartService;
	}


	public List<Mobile> showCart() throws EmptyCartException {
		List<Mobile> mobileList;
		
		try {
			mobileList = cartService.showCart();
		} catch (EmptyCartException e) {
			throw e;
		}
		
		
		if (mobileList!=null) {
			return mobileList.stream().sorted(Comparator.comparing(Mobile::getBrand)).collect(Collectors.toList());

		}
		else {
			return mobileList;
		}
		
	}	
	public String addtoCart(Mobile mobile) throws MobileNotFoundExceptions {
		cartService.addtoCart(mobile);
		return "added successfully";
		
	}
	public boolean removeFromCart(Mobile mobile) throws MobileNotFoundExceptions {
		Boolean result = false;
		try {
			result = cartService.removeFromCart(mobile);
		} catch (MobileNotFoundExceptions e) {
			throw e;
		}

		return result;
	}
}