package com.assignment.robotsimulation.actions.impl;

import com.assignment.robotsimulation.actions.MovementStrategy;
import com.assignment.robotsimulation.enums.Direction;
import com.assignment.robotsimulation.domain.Coordinates;
import com.assignment.robotsimulation.domain.Robot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PositionMovement extends MovementStrategy {
    @Override
    public void execute(Robot robot, List<String> argsList) {
        if (argsList.size() != 3) {
            throw new IllegalArgumentException("Invalid number of arguments for POSITION command");
        }
        Coordinates coordinates=getCoordinatesFromArguments(argsList);

        if(isValidPosition(coordinates)) {
            robot.setCoordinates(coordinates);
            robot.setDirection(Direction.fromString(argsList.get(2)));
        }
        else{
            throw new IllegalArgumentException("Coordinates leaving grid while positioning robot");
        }
    }
    @Override
    public String getActionName() {
        return "POSITION";
    }
    private static Coordinates getCoordinatesFromArguments(List<String> params) {
        int x,y;
        try {
            x = Integer.parseInt(params.get(0));
            y = Integer.parseInt(params.get(1));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("invalid coordinate param provided for positioning");
        }
        return new Coordinates(x, y);
    }


}
