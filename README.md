# Monty Hall Game Test - Spring Boot Rest Web Service

Runs on Java 11 and builds on Maven 3.6

This Monty Hall Game application simulates a sequence of a given no of Monty Hall games with a particular strategy.
If the no of games in the sequence is less than 10,000, the details of each game is returned as a list of objects.
If the no of games in the sequence is more than or equal to 10,000, the summary of the entire sequence is returned as the no of wins and win %.
The response of the web service is returned as application/json with utf8 emoji strings depicting the contents of each door.
The no of doors are externalized in the application.yml file, however, the game cannot be played if the no is anything other than 3.
As the logic of this application is relatively simple, I have not made use of Lambdas for computing the core logic.
However, lambdas with stream have been used in one of the JUnit Test cases to demonstrate their use.
Care has been taken to keep the code and the logic as simple as possibe for the sake of understanding and readability. 

To package the application run the following command: 

    mvn clean install  
    

To run the application - use the jar file created in the target folder of the workspace.  

    java -jar target/montyhall.jar

To access the application, go to your browser or postman: 

    http://localhost:8080/play/{no_of_iterations}/{if_strategy_is_switch} 
   	 no_of_iterations is an integer value representing the no of time the game is played
   	 if_strategy_is_switch is a boolean value representing if the starategy is switch or keep

