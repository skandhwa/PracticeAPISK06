package TestData;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import POJOMapper.CreateUserNew;

public class POJOImplementation {
	
	
	
	public static String createUserData() throws JsonProcessingException
	{
		CreateUserNew emp=new CreateUserNew();
		emp.setUsername("Harry");
		emp.setId(12345);
		emp.setMarried(true);
		emp.setAddress("Florida");
		
		ObjectMapper obj=new ObjectMapper();
	String empJSON=	obj.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		
		return empJSON;
		
	}
	
	
	
	
	

}
