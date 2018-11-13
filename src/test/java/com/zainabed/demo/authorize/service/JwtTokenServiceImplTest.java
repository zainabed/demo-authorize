package com.zainabed.demo.authorize.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.zainabed.demo.authorize.entity.UserDetail;

import io.jsonwebtoken.Claims;

@RunWith(SpringRunner.class)
// @SpringBootTest
// @TestPropertySource(properties={"jwt.secret.key=dksjflkdsjfkldjsklfjdslkjflkdsjfkldsjk"})
public class JwtTokenServiceImplTest {

	@Autowired
	JwtTokenService jwtTokenService;

	@Configuration
	@Import(JwtTokenServiceImpl.class)
	public static class Config {

	}

	String token;
	Claims claims;

	@MockBean
	UserDetail userDetail;
	String username;
	List<String> roles;

	@Before
	public void setup(){
		username = "testusername";
		roles = new ArrayList<String>();
		roles.add("ADMIN");
		Mockito.when(userDetail.getUsername()).thenReturn(username);
		Mockito.when(userDetail.getRoles()).thenReturn(roles);
	}

	@BeforeClass
	public static void beforeClass() {
		// org.springframework.test.util.ReflectionTestUtils.setField(JwtTokenServiceImplTest.class,
		// "jwt.token.secret", "fjdsklfjdslkfjdsklfdsfdsfdsf");
	}

	@Test
	public void shouldReturnValidJWTtoken(){
		token = jwtTokenService.build(userDetail);
		System.out.println("--------------------------------:" + token);
		String[] tokenParts = token.split(".");
		System.out.println("--------------------------------:" + tokenParts);
		assertEquals(tokenParts.length, 2);
	}
	
	@Test
	public void shouldPraseTokenString() {
		token = jwtTokenService.build(userDetail);
		claims = jwtTokenService.parse(token);
		assertNotNull(claims);
	}
}
