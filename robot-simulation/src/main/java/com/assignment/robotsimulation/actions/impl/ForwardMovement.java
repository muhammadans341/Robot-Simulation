package com.assignment.robotsimulation.actions.impl;

import com.assignment.robotsimulation.actions.MovementStrategy;
import com.assignment.robotsimulation.domain.Coordinates;
import com.assignment.robotsimulation.domain.Robot;
import com.assignment.robotsimulation.exceptions.InvalidGridPositionException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class ForwardMovement extends MovementStrategy {
    private static final Logger LOGGER= LoggerFactory.getLogger(ForwardMovement.class);
    @Value("${movement.strategy.forward:FORWARD}")
    private String actionName;

    @Override
    public void execute(Robot robot, List<String> argsList) {
        LOGGER.info("Started executing Forward Movement");
        if (argsList.size() != 1) {
            LOGGER.error("Invalid number of arguments provided for Forward command");
            throw new IllegalArgumentException("Invalid number of arguments for Forward command");
        }
        try {
            int steps = Integer.parseInt(argsList.get(0));
            Coordinates nextCoordinates = robot.move(steps);
            if (!isValidPosition(nextCoordinates)) {
                LOGGER.error("Coordinates became invalid trying to move forward");
                throw new InvalidGridPositionException("Coordinates became invalid trying to move forward");
            }
            robot.setCoordinates(nextCoordinates);
        }
        catch (NumberFormatException ex){
            LOGGER.error("invalid coordinate param provided for forward movement");
            throw new IllegalArgumentException("invalid coordinate param provided for forward movement");
        }
        LOGGER.info("Finished executing Forward Movement");
    }
    @Override
    public String getActionName() {
        return actionName;
    }
}
