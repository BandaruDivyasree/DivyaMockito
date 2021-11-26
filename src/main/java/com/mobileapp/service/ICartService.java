package com.mobileapp.service;

import java.util.List;

import com.mobileapp.exceptions.EmptyCartException;

import com.mobileapp.exceptions.MobileNotFoundExceptions;
import com.mobileapp.model.Mobile;

public interface ICartService {
	List<Mobile> showCart() throws EmptyCartException;
	void addtoCart(Mobile mobile) throws MobileNotFoundExceptions; //return nothing or throw exception
	boolean removeFromCart(Mobile mobile) throws MobileNotFoundExceptions;

}