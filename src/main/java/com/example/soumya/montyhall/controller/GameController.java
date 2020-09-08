package com.example.soumya.montyhall.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.soumya.montyhall.exception.GameException;
import com.example.soumya.montyhall.service.GameService;

@RestController
//@EnableAutoConfiguration
class GameController {
	
	@Autowired
	GameService gameService;

    @RequestMapping(value= "/play/{iterations}/{switch}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Object> playGame(@PathVariable(value="iterations") int iterations, 
    		@PathVariable(value="switch") boolean isSwitch) throws GameException {
    	return new ResponseEntity<>(gameService.playGame(iterations, isSwitch), HttpStatus.OK);
    }
}

