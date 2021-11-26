package com.mobileapp.testcases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mobileapp.exceptions.EmptyCartException;

import com.mobileapp.exceptions.MobileNotFoundExceptions;
import com.mobileapp.model.Mobile;
import com.mobileapp.service.CartDetails;
import com.mobileapp.service.ICartService;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
class CartDetailsTest {

	@Mock
	ICartService cartService;
	@InjectMocks
	CartDetails  cartDetails;
	Mobile mobile1, mobile2, mobile3, mobile4, mobile5;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		mobile1 = new Mobile(1, "Samsung", "M32", 1);
		mobile2 = new Mobile(2, "Apple", "11 max Pro", 2);
		mobile3 = new Mobile(3, "Xiomi", "A32", 3);
		mobile4 = new Mobile(4, "Samsung", "F52", 4);
		mobile5 = new Mobile(5, "vivo", "M31", 5);

		List<Mobile> mobileList = Arrays.asList(mobile1, mobile2, mobile3, mobile4, mobile5);
	}

	@AfterEach
	void tearDown() throws Exception {
	}
 @Test
 @DisplayName("add cart")
  void testAddCart() throws MobileNotFoundExceptions {
	 //passing the object inside when
	 //calling caertService using mock
	 doNothing().when(cartService).addtoCart(mobile1); //this return nothing
	 String actual=cartDetails.addtoCart(mobile1);
	 String expected="added succesfully";
	 assertEquals(expected,actual,"invalid");
	 
 }
 
 @Test
 @DisplayName("check exception")
 void testAddCartException() throws MobileNotFoundExceptions {
	 //passing the object inside when
	 //calling caertService using mock
	 doThrow(new MobileNotFoundExceptions("invalid")).when(cartService).addtoCart(mobile1); //this return nothing
	
	 
	 assertThrows(MobileNotFoundExceptions.class,()->cartDetails.addtoCart(mobile1));
	 
}
 @Test
 void testShowCart() throws EmptyCartException {
	 List<Mobile> expectedmobile=Arrays.asList(mobile2,mobile1,mobile3);
	 doReturn(Arrays.asList(mobile1,mobile2,mobile3)).when(cartService).showCart();
     List<Mobile> actualMobiles=cartDetails.showCart();
     assertEquals(expectedmobile,actualMobiles,"Not valid");
 }
 
@Test
@DisplayName("check cart empty")
void testShowCartEmpty() throws EmptyCartException {
	
	 when(cartService.showCart()).thenThrow(new EmptyCartException());
	 assertThrows(EmptyCartException.class,()->cartDetails.showCart());
}

@Test
@DisplayName("check cart null")
	void testShowCartNull() throws MobileNotFoundException, EmptyCartException {
	    doReturn(null).when(cartService).showCart();
	    assertNull(cartDetails.showCart());
		
	}
@Test
@DisplayName("removecart")
void testRemoveCart() throws EmptyCartException, MobileNotFoundException {
	doReturn(true).when(cartService).removeFromCart(mobile1);
	assertEquals(true, cartDetails.removeFromCart(mobile1));
}

@Test
@DisplayName("cartempty")
void testRemoveCartEmpty() throws EmptyCartException, MobileNotFoundException {
	doThrow(new MobileNotFoundException()).when(cartService).removeFromCart(mobile3);
	assertThrows(MobileNotFoundException.class, () -> cartDetails.removeFromCart(mobile3));
}

  
	
}
