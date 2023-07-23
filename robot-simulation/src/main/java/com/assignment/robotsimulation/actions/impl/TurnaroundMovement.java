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
public class TurnaroundMovement extends MovementStrategy {
    private static final Logger LOGGER= LoggerFactory.getLogger(TurnaroundMovement.class);

    @Override
    public String getActionName() {
        return "TURNAROUND";
    }
    @Override
    public void execute(Robot robot, List<String> argsList){
        LOGGER.info("Started executing Turnaround Movement");
        robot.turn(robot.getDirection().turnaround());
        LOGGER.info("Finished executing Turnaround Movement");
    }
}
