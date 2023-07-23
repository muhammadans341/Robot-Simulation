package com.assignment.robotsimulation.actions.impl;

import com.assignment.robotsimulation.actions.MovementStrategy;
import com.assignment.robotsimulation.domain.Coordinates;
import com.assignment.robotsimulation.domain.Robot;
import com.assignment.robotsimulation.exceptions.InvalidGridPositionException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ForwardMovement extends MovementStrategy {
    @Override
    public void execute(Robot robot, List<String> argsList) {
        if (argsList.size() != 1) {
            throw new IllegalArgumentException("Invalid number of arguments for Forward command");
        }
        try {
            int steps = Integer.parseInt(argsList.get(0));
            Coordinates nextCoordinates = robot.move(steps);
            if (!isValidPosition(nextCoordinates)) {
                throw new InvalidGridPositionException("Coordinates became invalid trying to move forward");
            }
            robot.setCoordinates(nextCoordinates);
        }
        catch (NumberFormatException ex){
            throw new IllegalArgumentException("invalid coordinate param provided for forward movement");
        }
    }
    @Override
    public String getActionName() {
        return "FORWARD";
    }
}
