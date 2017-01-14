package com.crossover.project.application.implementations;

import static com.crossover.project.domain.enumerations.UserStatusEnum.LOGGED;
import static com.crossover.project.domain.enumerations.UserStatusEnum.NOT_LOGGED;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.crossover.project.application.interfaces.ICredentialsApplication;
import com.crossover.project.application.interfaces.ILoginApplication;
import com.crossover.project.domain.entities.User;
import com.crossover.project.domain.enumerations.UserStatusEnum;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/applicationContext.xml" })
public class LoginApplicationTest extends TestCase {

	@InjectMocks
	ILoginApplication loginApplication = new LoginApplication();

	@Mock
	ICredentialsApplication credentialsApplication;

	@Before
	public void before() {

		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void userShouldNotBeLoggedWhenCredentialsAreNotFound() {

		User user = new User();

		Mockito.when(credentialsApplication.checkCredentials(user)).thenReturn(null);

		UserStatusEnum statusEnum = loginApplication.login(user);

		assertEquals(NOT_LOGGED, statusEnum);
	}

	@Test
	public void userShouldNotBeLoggedWhenLoginIsDuplicated() {

		User user = new User();

		Mockito.when(credentialsApplication.checkCredentials(user)).thenReturn(Arrays.asList(new User(), new User()));

		UserStatusEnum statusEnum = loginApplication.login(user);

		assertEquals(NOT_LOGGED, statusEnum);
	}

	@Test
	public void userShouldBeLoggedWhenCredentialsAreFound() {

		User user = new User();

		Mockito.when(credentialsApplication.checkCredentials(user)).thenReturn(Arrays.asList(new User()));

		UserStatusEnum statusEnum = loginApplication.login(user);

		assertEquals(LOGGED, statusEnum);
	}

}
