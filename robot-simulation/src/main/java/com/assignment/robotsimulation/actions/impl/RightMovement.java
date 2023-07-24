package com.assignment.robotsimulation.actions.impl;

import com.assignment.robotsimulation.actions.MovementStrategy;
import com.assignment.robotsimulation.enums.Direction;
import com.assignment.robotsimulation.domain.Robot;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class RightMovement extends MovementStrategy {
    private static final Logger LOGGER= LoggerFactory.getLogger(RightMovement.class);
    @Value("${movement.strategy.right:RIGHT}")
    private String actionName;
    @Override
    public void execute(Robot robot, List<String> argsList) {
        LOGGER.info("Started executing Right Movement");
        robot.turn(robot.getDirection().right());
        LOGGER.info("Finished executing Right Movement");
    }
    @Override
    public String getActionName() {
        return actionName;
    }
}
