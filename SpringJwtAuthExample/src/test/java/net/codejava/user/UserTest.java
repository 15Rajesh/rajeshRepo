package net.codejava.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {
	
	User user;
	
	@BeforeEach
	void setup()
	{
	 user=getUser();
	}
	
	
	
	
	
	

	private User getUser() {

		User user = new User();
		user.setId(111);
		user.setEmail("rajesh@gmail.com");
		user.setPassword("raj20");
		return user;

	}

}
