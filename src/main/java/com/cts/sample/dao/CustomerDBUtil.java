package com.cts.sample.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.cts.sample.utility.CustomProperty;




public class CustomerDBUtil {

	public static Connection con=null;
	public static Statement stmt=null;
	public static void main(String[] args) {
		
		 InsertCustomer(new Customer("Krishna Chaitanya", "202890", "Hyderabad")); 
		 System.out.println(getCustomerDetails("06541I"));
	     System.out.println(getCustomerList());
	   
		 
			}  


	public static Properties prop= CustomProperty.loadProperty();
	
	public static Customer getCustomerDetails(String customerId){
		Customer customer = new Customer();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=getConnection().prepareStatement("SELECT C_NAME,C_ID,C_ADDRESS FROM CUSTOMER WHERE C_ID=?");
			pstmt.setString(1, customerId);
			rs=pstmt.executeQuery();
			while(rs.next()){
				customer.setCustomerId(rs.getString("C_ID"));
				customer.setCustomerName(rs.getString("C_NAME"));
				customer.setCustomerAddress(rs.getString("C_ADDRESS"));
			}
			connectionClose(con);
			} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(pstmt!=null){
				try {
					pstmt.close();
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return customer;
	}
	
	
	
	public static List<Customer> getCustomerList(){
		List<Customer> customerList= new ArrayList<Customer>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=getConnection().prepareStatement("SELECT C_NAME,C_ID,C_ADDRESS FROM CUSTOMER");
			rs=pstmt.executeQuery();
			while(rs.next()){
				Customer customer = new Customer();
				customer.setCustomerId(rs.getString("C_ID"));
				customer.setCustomerName(rs.getString("C_NAME"));
				customer.setCustomerAddress(rs.getString("C_ADDRESS"));
				customerList.add(customer);
			}
			
			connectionClose(con);
			} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(pstmt!=null){
				try {
					pstmt.close();
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return customerList;
	}
	
	
	
	
	public static Connection getConnection(){
		try{  
			Class.forName(prop.getProperty("DRIVER"));  
			con=DriverManager.getConnection(prop.getProperty("URL")+":"
			+prop.getProperty("PORT")+"/"
			+prop.getProperty("DATABASE"),
			prop.getProperty("USER"),
			prop.getProperty("PASSWORD")); 
			
			
		}catch(SQLException e){
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 return con;
		}

	
	
	public static void connectionClose(Connection con){
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
	public static void InsertCustomer(Customer customer){
		PreparedStatement pstmt=null;
	
		try {
			pstmt=getConnection().prepareStatement("INSERT INTO CUSTOMER(C_NAME,C_ID,C_ADDRESS) VALUES(?,?,?)");
			pstmt.setString(1,customer.getCustomerName());
			pstmt.setString(2,customer.getCustomerId());
			pstmt.setString(3,customer.getCustomerAddress());
			pstmt.execute();
			connectionClose(con);
			} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(pstmt!=null){
				try {
					pstmt.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	public static void InsertCustomer(String name,String Id,String address,Connection con){
		PreparedStatement pstmt=null;
	
		try {
			pstmt=con.prepareStatement("INSERT INTO CUSTOMER(C_NAME,C_ID,C_ADDRESS) VALUES(?,?,?)");
			pstmt.setString(1,name);
			pstmt.setString(2,Id);
			pstmt.setString(3,address);
			pstmt.execute();
			} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(pstmt!=null){
				try {
					pstmt.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	
	
	public static String getHelloWorld() {

		return "Hello World";

	}
	
	
}
