package com.cts.sample.utility;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class CustomProperty {
	
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

}

	
	
