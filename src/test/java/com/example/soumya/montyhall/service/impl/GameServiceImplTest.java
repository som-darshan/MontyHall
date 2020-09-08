package com.example.soumya.montyhall.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.soumya.montyhall.domain.GameResultAggregate;
import com.example.soumya.montyhall.domain.GameResultDetails;
import com.example.soumya.montyhall.exception.GameException;

@RunWith(MockitoJUnitRunner.class)
public class GameServiceImplTest {
	
	private final String CAR_EMOJI_STR = "\u1f3ce";
	
	@InjectMocks
	GameServiceImpl gameService;
	
	@Before
	public void setUp() throws Exception {
		// Method annotated with `@Before` will execute before each test method in this
		// class is executed.

		// If you find that several tests need similar objects created before they can
		// run this method could be used to do set up those objects (aka test-fixtures).
	}

	@After
	public void tearDown() throws Exception {

		// Method annotated with `@After` will execute after each test method in this
		// class is executed.

		// If you allocate external resources in a Before method you must release them
		// in this method.
	}

	@Test
	public void testPlayGameSuccessWhenIterationsMoreThan9999() throws GameException {
		boolean switchFlagMock = true;
		int iterationsMock = 10000;
		assertTrue(gameService.playGame(iterationsMock, switchFlagMock) instanceof GameResultAggregate);
	}

	@Test
    public void testPlayGameSuccessWhenIterationsLessThan10000() throws GameException{
		boolean switchFlagMock = true;
		int iterationsMock = 9999;
		assertTrue(gameService.playGame(iterationsMock, switchFlagMock) instanceof List);
	}
	
	@Test
    public void testPlayGameReturnAggregateWhenStrategySwitch() throws GameException	{
		boolean switchFlagMock = true;
		int iterationsMock = 100;
		assertTrue(gameService.playGameReturnAggregate(iterationsMock, switchFlagMock) instanceof GameResultAggregate);
		GameResultAggregate actualObjectReturned = gameService.playGameReturnAggregate(iterationsMock, switchFlagMock);
		assertEquals(iterationsMock, actualObjectReturned.getNumberOfIterations());
		assertEquals(switchFlagMock, actualObjectReturned.isSwitchFlag());
	}
	
	@Test
    public void testPlayGameReturnAggregateWhenStrategyKeep() throws GameException	{
		boolean switchFlagMock = false;
		int iterationsMock = 100;
		assertTrue(gameService.playGameReturnAggregate(iterationsMock, switchFlagMock) instanceof GameResultAggregate);
		GameResultAggregate actualObjectReturned = gameService.playGameReturnAggregate(iterationsMock, switchFlagMock);
		assertEquals(iterationsMock, actualObjectReturned.getNumberOfIterations());
		assertEquals(switchFlagMock, actualObjectReturned.isSwitchFlag());
	}
	
	@Test
    public void testPlayGameReturnDetailsWhenStrategySwitch()	{
		boolean switchFlagMock = true;
		int iterationsMock = 100;
		assertTrue(gameService.playGameReturnDetails(iterationsMock, switchFlagMock) instanceof List);
		assertTrue(gameService.playGameReturnDetails(iterationsMock, switchFlagMock).get(0) instanceof GameResultDetails);
		List<GameResultDetails> actualObjectReturned = gameService.playGameReturnDetails(iterationsMock, switchFlagMock);
		assertEquals(iterationsMock, actualObjectReturned.size());
		assertEquals(switchFlagMock, actualObjectReturned.get(0).isSwitchFlag());
		long noOfTimescarAtDoor1 = actualObjectReturned.stream().filter((gRDtl) -> gRDtl.getDoors().get(0).equals(CAR_EMOJI_STR)).count();
		long noOfTimescarAtDoor2 = actualObjectReturned.stream().filter((gRDtl) -> gRDtl.getDoors().get(1).equals(CAR_EMOJI_STR)).count();
		long noOfTimescarAtDoor3 = actualObjectReturned.stream().filter((gRDtl) -> gRDtl.getDoors().get(2).equals(CAR_EMOJI_STR)).count();
		assertTrue(noOfTimescarAtDoor1 > 0);
		assertTrue(noOfTimescarAtDoor2 > 0);
		assertTrue(noOfTimescarAtDoor3 > 0);
	}
	
	@Test
    public void testPlayGameReturnDetailsWhenStrategyKeep()	{
		boolean switchFlagMock = false;
		int iterationsMock = 100;
		assertTrue(gameService.playGameReturnDetails(iterationsMock, switchFlagMock) instanceof List);
		assertTrue(gameService.playGameReturnDetails(iterationsMock, switchFlagMock).get(0) instanceof GameResultDetails);
		List<GameResultDetails> actualObjectReturned = gameService.playGameReturnDetails(iterationsMock, switchFlagMock);
		assertEquals(iterationsMock, actualObjectReturned.size());
		assertEquals(switchFlagMock, actualObjectReturned.get(0).isSwitchFlag());
		long noOfTimescarAtDoor1 = actualObjectReturned.stream().filter((gRDtl) -> gRDtl.getDoors().get(0).equals(CAR_EMOJI_STR)).count();
		long noOfTimescarAtDoor2 = actualObjectReturned.stream().filter((gRDtl) -> gRDtl.getDoors().get(1).equals(CAR_EMOJI_STR)).count();
		long noOfTimescarAtDoor3 = actualObjectReturned.stream().filter((gRDtl) -> gRDtl.getDoors().get(2).equals(CAR_EMOJI_STR)).count();
		assertTrue(noOfTimescarAtDoor1 > 0);
		assertTrue(noOfTimescarAtDoor2 > 0);
		assertTrue(noOfTimescarAtDoor3 > 0);
	}
}
