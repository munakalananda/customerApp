package com.cts.sample.dao;



import static org.junit.Assert.*;

import java.sql.Connection;


import org.junit.Test;

import junit.framework.Assert;

public class TestCustomerDBUtil {
	
	@Test
	public void testPrintHelloWorld() {

		Assert.assertEquals(CustomerDBUtil.getHelloWorld(), "Hello World");

	}

	
	@Test
	public void getCustomerDetails(){
		assertEquals(new Customer("Krishna Chaitanya", "202890", "Hyderabad"), CustomerDBUtil.getCustomerDetails("202890"));
		
	}
	
	
	Connection connection;

    @Test
    public void before() {
        connection = CustomerDBUtil.getConnection();
    }

    @Test
    public void after() {
    	CustomerDBUtil.connectionClose(connection);;
    }

   
	
}
