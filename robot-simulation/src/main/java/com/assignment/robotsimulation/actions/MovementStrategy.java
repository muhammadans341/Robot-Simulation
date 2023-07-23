package com.assignment.robotsimulation.actions;

import com.assignment.robotsimulation.domain.Coordinates;
import com.assignment.robotsimulation.domain.Robot;

import java.util.List;

public abstract class MovementStrategy {
    private final static int GRID_HEIGHT = 5;
    private final static int GRID_WIDTH = 5;
    private static final int COORDINATE_MIN_VALUE = 0;
    public abstract void execute(Robot robot, List<String> argsList);

    protected boolean isRobotNotPositioned(Robot robot) {
        return robot.getCoordinates() == null;
    }

    protected boolean isValidPosition(Coordinates coordinates) {
        int x=coordinates.getX(),y=coordinates.getY();
        return  x >= 0 && x < 5 && y >= 0 && y < 5;
    }

    public abstract String getActionName();
}
