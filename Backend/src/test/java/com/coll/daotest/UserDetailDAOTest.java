package com.coll.daotest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.UserDetailDAO;
import com.coll.sections.UserDetail;

public class UserDetailDAOTest {
	static UserDetailDAO userdetailDAO;
	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		userdetailDAO=(UserDetailDAO)context.getBean("userdetailDAO");
	}
    @Ignore
	@Test
	public void addusertest() {
		UserDetail user=new UserDetail();
		user.setUsername("admin");
		user.setFirstname("gowsi");
		user.setLastname("gan");
		user.setPassword("lol");
		user.setEmailId("gowsigan30@gmail.com");
		assertTrue("problem in adding user",userdetailDAO.addUser(user));
	
	}
	
	@Test
	public void getusertest() {
		assertNotNull("problem in getting user",userdetailDAO.getUser("admin"));
	}
	
	@Test
	public void updateusertest() {
		UserDetail user=userdetailDAO.getUser("Gowsigan");
		user.setRole("ROLE_ADMIN");
		assertTrue("problem in updating user",userdetailDAO.updateUser(user));
	}
	@Test
	public void listusertest() {
		List<UserDetail> listUsers=userdetailDAO.getUsers();
		for(UserDetail userDetail:listUsers) {
			System.out.println("username:"+userDetail.getUsername());
		}
	}
	@Test
	public void checkusertest() {
		UserDetail userDetail=userdetailDAO.getUser("Gowsigan");
		assertNotNull("problem in checking user",userdetailDAO.checkUser(userDetail));
	}

}
