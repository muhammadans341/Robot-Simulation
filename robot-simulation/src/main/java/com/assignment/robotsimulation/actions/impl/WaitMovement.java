package com.assignment.robotsimulation.actions.impl;

import com.assignment.robotsimulation.actions.MovementStrategy;
import com.assignment.robotsimulation.domain.Robot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WaitMovement extends MovementStrategy {
    @Override
    public void execute(Robot robot, List<String> argsList) {

    }
    @Override
    public String getActionName() {
        return "WAIT";
    }
}
