package com.assignment.robotsimulation.actions.impl;

import com.assignment.robotsimulation.actions.MovementStrategy;
import com.assignment.robotsimulation.domain.Robot;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class WaitMovement extends MovementStrategy {
    private static final Logger LOGGER= LoggerFactory.getLogger(WaitMovement.class);
    @Value("${movement.strategy.wait:WAIT}")
    private String actionName;
    @Override
    public void execute(Robot robot, List<String> argsList) {
        LOGGER.info("Started executing Wait Movement");
        LOGGER.info("Finished executing Wait Movement");

    }
    @Override
    public String getActionName() {
        return "WAIT";
    }
}
