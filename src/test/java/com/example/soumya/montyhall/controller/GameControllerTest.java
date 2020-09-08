package com.example.soumya.montyhall.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.soumya.montyhall.domain.GameResultAggregate;
import com.example.soumya.montyhall.exception.GameException;
import com.example.soumya.montyhall.service.impl.GameServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class GameControllerTest {

	@InjectMocks
	GameController gameController;

	@Mock
	GameServiceImpl gameServiceMock;

	@Test
	public void testPlayGameSuccessIterationsMoreThan10000AndStrategySwitch() throws GameException {
		boolean switchFlagMock = true;
		int iterationsMock = 10000;
		assertEquals(HttpStatus.OK, gameController.playGame(iterationsMock, switchFlagMock).getStatusCode());
		Mockito.verify(gameServiceMock).playGame(iterationsMock, switchFlagMock);
	}
	
	@Test
    public void testPlayGameSuccessIterationsMoreThan10000AndStrategyKeep() throws GameException{
		boolean switchFlagMock = false;
		int iterationsMock = 10000;
		assertEquals(HttpStatus.OK, gameController.playGame(iterationsMock, switchFlagMock).getStatusCode());
		Mockito.verify(gameServiceMock).playGame(iterationsMock, switchFlagMock);
	}

	@Test
    public void testPlayGameSuccessIterationsLessThan10000AndStrategySwitch() throws GameException{
		boolean switchFlagMock = true;
		int iterationsMock = 9999;
		assertEquals(HttpStatus.OK, gameController.playGame(iterationsMock, switchFlagMock).getStatusCode());
		Mockito.verify(gameServiceMock).playGame(iterationsMock, switchFlagMock);
	}

	@Test
    public void testPlayGameSuccessIterationsLessThan10000AndStrategyKeep() throws GameException{
		boolean switchFlagMock = false;
		int iterationsMock = 9999;
		assertEquals(HttpStatus.OK, gameController.playGame(iterationsMock, switchFlagMock).getStatusCode());
		Mockito.verify(gameServiceMock).playGame(iterationsMock, switchFlagMock);
	}

}






