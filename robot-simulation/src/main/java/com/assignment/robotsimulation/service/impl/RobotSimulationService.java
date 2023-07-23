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
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RobotSimulationService implements SimulationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RobotSimulationService.class);
    private static final int DIRECTION_POSITION = 2;
    private static final int X_POSITION = 0;
    private static final int Y_POSITION = 1;


    private final MovementStrategyFactory movementStrategyFactory;

    @Override
    public SimulationResponse simulateObject(String simulationRound) {
        LOGGER.info("Initializing Robot");
        Robot robot = buildRobot();
        LOGGER.info("Now executing simulation for robot");
        executeScript(robot,simulationRound);
        LOGGER.info("Building robot simulation response");
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
                LOGGER.debug("Processing {} command.",command);
                executeCommand(robot,parsedCommand);
        });
    }
    private void executeCommand(Robot robot, Command command) {
        MovementStrategy strategy = movementStrategyFactory.getStrategy(command.getAction());
        if (strategy == null) {
            LOGGER.error("Invalid action provided: {}",command.getAction());
            throw new ActionNotFoundException("Invalid action provided: " + command.getAction());
        }
        LOGGER.info("Started robot movement for action: {}",command.getAction());
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
