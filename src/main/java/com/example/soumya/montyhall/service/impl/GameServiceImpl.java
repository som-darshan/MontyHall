package com.example.soumya.montyhall.service.impl;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.soumya.montyhall.domain.GameResultAggregate;
import com.example.soumya.montyhall.domain.GameResultDetails;
import com.example.soumya.montyhall.exception.GameException;
import com.example.soumya.montyhall.service.GameService;

@Service
public class GameServiceImpl implements GameService {

	@Value("${max.doors}")
	private int noOfDoors;
    private Map<Integer, String> availableDoors = new HashMap<>(noOfDoors);
    
    private final String GOAT_EMOJI_UTF8_STRING = "\u1f410";
    private final String CAR_EMOJI_UTF8_STRING = "\u1f3ce";

    private void initDoors() {
        List<String> doors = new ArrayList<>(noOfDoors);
        String door1 = CAR_EMOJI_UTF8_STRING;
        String door2 = GOAT_EMOJI_UTF8_STRING;
        String door3 = GOAT_EMOJI_UTF8_STRING;

        doors.add(door1);
        doors.add(door2);
        doors.add(door3);

        Collections.shuffle(doors);

        int i = 1;
        for (String door : doors) {
            availableDoors.put(i, door);
            i++;
        }
    }

	public Object playGame(int iterations, boolean isSwitch) throws GameException {
		try {
			if (iterations > 9999) {
				return playGameReturnAggregate(iterations, isSwitch);
			} else {
				return playGameReturnDetails(iterations, isSwitch);
			}
		} catch (Exception e) {
			throw new GameException(e.getMessage());
		}
	}
    
	public GameResultAggregate playGameReturnAggregate(int noOfIterations, boolean isSwitch)	{
		GameResultAggregate gameResultAggregate = new GameResultAggregate(noOfIterations, isSwitch);
		int noOfWins = 0;
		Integer selectedDoorNo = null;
		String selectedDoor = null;
		for (int i = 1; i <= noOfIterations; i++) {
			initDoors();
			selectedDoorNo = getSelectedDoorNo();
			selectedDoor = this.selectDoor(selectedDoorNo);
			if (isSwitch && !selectedDoor.equals(CAR_EMOJI_UTF8_STRING)) {
				noOfWins++;
			} else if (!isSwitch && selectedDoor.equals(CAR_EMOJI_UTF8_STRING)) {
				noOfWins++;
			}
		}
		gameResultAggregate.setNumberOfWins(noOfWins);
		gameResultAggregate.setPercentage((noOfWins * 100.0f) / noOfIterations);
		return gameResultAggregate;
	}

	public List<GameResultDetails> playGameReturnDetails(int noOfIterations, boolean isSwitch)	{
		List<GameResultDetails> gameResultDetailsList = new ArrayList<GameResultDetails>();
		Integer selectedDoorNo = null;
		String selectedDoor = null;

		for (int i = 1; i <= noOfIterations; i++) {
			initDoors();
			selectedDoorNo = getSelectedDoorNo();
			selectedDoor = this.selectDoor(selectedDoorNo);
			if (isSwitch) {
				gameResultDetailsList.add(new GameResultDetails(i, new ArrayList<String>(availableDoors.values()),
						selectedDoorNo, ! selectedDoor.equals(CAR_EMOJI_UTF8_STRING), isSwitch));
			} else {
				gameResultDetailsList.add(new GameResultDetails(i, new ArrayList<String>(availableDoors.values()),
						selectedDoorNo, selectedDoor.equals(CAR_EMOJI_UTF8_STRING), isSwitch));
			}
		}
		return gameResultDetailsList;
	}

    private int getSelectedDoorNo() {
        int max = 3;
        int min = 1;
        Random random = new Random();
        return random.nextInt(max - min + 1) + 1;
    }

    private String selectDoor(int position) {
        String selectedDoor = this.availableDoors.get(position);
        return selectedDoor;
    }
}
