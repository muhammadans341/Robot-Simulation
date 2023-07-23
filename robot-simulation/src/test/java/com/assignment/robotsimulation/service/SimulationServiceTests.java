package com.assignment.robotsimulation.service;

import com.assignment.robotsimulation.actions.MovementStrategyFactory;
import com.assignment.robotsimulation.domain.response.SimulationResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SimulationServiceTests {

    @Autowired
    SimulationService simulationService;

    @Autowired
    MovementStrategyFactory movementStrategyFactory;
    @Test
    @DisplayName("RobotSimulation_ValidScriptTest")
    public void test_SimulateRobot_WhenValidScriptIsPassed_ShouldReturnExpectedCoordinates(){
        //Given
        String simulationRound = "POSITION 0 3 EAST\n" +
                "WAIT\n" +
                "RIGHT\n" +
                "FORWARD 1";
        //When
        SimulationResponse expectedResponse = SimulationResponse.builder()
                .direction("SOUTH")
                .coordinateX(0)
                .coordinateY(4)
                .build();
        SimulationResponse response=simulationService.simulateObject(simulationRound);

        //Then
        Assertions.assertEquals(expectedResponse, response, "Coordinates or direction don't match"
        );
    }
    @Test
    @DisplayName("RobotSimulation_InValidScriptTest")
    public void test_SimulateRobot_WhenInValidScriptIsPassed_ShouldReturnNotEquals(){
        //Given
        String simulationRound = "POSITION 0 3 EAST\n" +
                "WAIT\n" +
                "RIGHT\n" +
                "FORWARD 1";
        //When
        SimulationResponse expectedResponse = SimulationResponse.builder()
                .direction("SOUTH")
                .coordinateX(0)
                .coordinateY(2)
                .build();
        SimulationResponse response=simulationService.simulateObject(simulationRound);

        //Then
        Assertions.assertNotEquals(expectedResponse, response, "Coordinates or direction match"
        );
    }

    @Test
    @DisplayName("RobotSimulation_InValidScriptTest")
    public void test_SimulateRobot_WhenInValidScriptIsPassed_ShouldThrowException(){
        //Given
        String simulationRound = "POSITION 0 3 EAST\n" +
                "WAIT\n" +
                "RIGHT\n" +
                "FORWARD 4";
        //When and then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SimulationResponse response = simulationService.simulateObject(simulationRound);
        });

    }

}
