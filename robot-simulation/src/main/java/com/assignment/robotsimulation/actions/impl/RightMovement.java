package com.assignment.robotsimulation.actions.impl;

import com.assignment.robotsimulation.actions.MovementStrategy;
import com.assignment.robotsimulation.enums.Direction;
import com.assignment.robotsimulation.domain.Robot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RightMovement extends MovementStrategy {
    @Override
    public void execute(Robot robot, List<String> argsList) {
        robot.turn(robot.getDirection().right());
    }
    @Override
    public String getActionName() {
        return "RIGHT";
    }
}
