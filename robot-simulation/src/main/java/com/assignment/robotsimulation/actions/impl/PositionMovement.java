package com.assignment.robotsimulation.actions.impl;

import com.assignment.robotsimulation.actions.MovementStrategy;
import com.assignment.robotsimulation.enums.Direction;
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
public class PositionMovement extends MovementStrategy {
    private static final Logger LOGGER= LoggerFactory.getLogger(PositionMovement.class);
    @Value("${movement.strategy.position:POSITION}")
    private String actionName;
    @Override
    public void execute(Robot robot, List<String> argsList) {
        LOGGER.info("Started executing Position Movement");
        if (argsList.size() != 3) {
            LOGGER.error("Invalid number of arguments provided for POSITION command");
            throw new IllegalArgumentException("Invalid number of arguments for POSITION command");
        }
        Coordinates coordinates=getCoordinatesFromArguments(argsList);

        if(isValidPosition(coordinates)) {
            robot.setCoordinates(coordinates);
            robot.setDirection(Direction.findDirection(argsList.get(2)));
        }
        else{
            LOGGER.error("Coordinates leaving grid while positioning robot");
            throw new InvalidGridPositionException("Coordinates leaving grid while positioning robot");
        }
        LOGGER.info("Finished executing Position Movement");
    }
    @Override
    public String getActionName() {
        return actionName;
    }
    private static Coordinates getCoordinatesFromArguments(List<String> params) {
        int x,y;
        try {
            x = Integer.parseInt(params.get(0));
            y = Integer.parseInt(params.get(1));
        } catch (NumberFormatException e) {
            LOGGER.error("invalid coordinate param provided for positioning");
            throw new IllegalArgumentException("invalid coordinate param provided for positioning");
        }
        return new Coordinates(x, y);
    }
}
