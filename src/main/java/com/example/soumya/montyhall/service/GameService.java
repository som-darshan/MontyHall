package com.example.soumya.montyhall.service;

import org.springframework.http.ResponseEntity;

import com.example.soumya.montyhall.exception.GameException;

public interface GameService {
	
	public Object playGame(int numberOfIterations, boolean isStrategyToSwitch) throws GameException ;

}
