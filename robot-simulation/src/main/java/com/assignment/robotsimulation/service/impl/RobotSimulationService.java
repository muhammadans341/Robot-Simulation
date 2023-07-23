package com.assignment.robotsimulation.service.impl;

import com.assignment.robotsimulation.actions.MovementStrategy;
import com.assignment.robotsimulation.command.Command;
import com.assignment.robotsimulation.command.CommandParser;
import com.assignment.robotsimulation.domain.response.SimulationResponse;
import com.assignment.robotsimulation.enums.Direction;
import com.assignment.robotsimulation.actions.MovementStrategyFactory;
import com.assignment.robotsimulation.domain.Coordinates;
import com.assignment.robotsimulation.domain.Robot;
import com.assignment.robotsimulation.exceptions.ActionNotFoundException;
import com.assignment.robotsimulation.service.SimulationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RobotSimulationService implements SimulationService {

    private static final int DIRECTION_POSITION = 2;
    private static final int X_POSITION = 0;
    private static final int Y_POSITION = 1;


    private final MovementStrategyFactory movementStrategyFactory;

    @Override
    public SimulationResponse simulateObject(String simulationRound) {
            Robot robot = buildRobot();
            executeScript(robot,simulationRound);
            return buildSimulationResponse(robot);
    }

    private Robot buildRobot() {
       return Robot.builder()
               .direction(Direction.EAST)
               .coordinates(new Coordinates(0, 0))
               .build();
    }
    private void executeScript(Robot robot, String simulationRound){
        simulationRound.lines().forEach(command -> {
                Command parsedCommand = CommandParser.parseCommand(command);
                executeCommand(robot,parsedCommand);
        });
    }
    private void executeCommand(Robot robot, Command command) {
        MovementStrategy strategy = movementStrategyFactory.getStrategy(command.getAction());
        if (strategy == null) {
            throw new ActionNotFoundException("Invalid action provided: " + command);
        }
        strategy.execute(robot, command.getArguments());
    }
    private SimulationResponse buildSimulationResponse(Robot robot) {
        return SimulationResponse.builder()
                .coordinateX(robot.getCoordinates().getX())
                .coordinateY(robot.getCoordinates().getY())
                .direction(robot.getDirection().toString())
                .build();
    }
}
