package com.cts.sample.utility;


import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;





public class TestCustomProperty {
	
		  public static Properties loadProperty(){
			  
			  String resourceName = "db.properties";
			  ClassLoader loader = Thread.currentThread().getContextClassLoader();
			  Properties props = new Properties();
			  try(InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
			      props.load(resourceStream);
			  }catch(IOException e){
				  System.out.println(e);
			  }
			  
			  return props;
		  }

		  
		  
		  
		  @Test
			public void getCustomerDetails(){
				assertEquals(CustomProperty.loadProperty().getProperty("USER"), CustomProperty.loadProperty().getProperty("USER"));
				
			}
}

	
	
