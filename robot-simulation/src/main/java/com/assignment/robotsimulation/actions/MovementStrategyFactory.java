package com.assignment.robotsimulation.actions;

import com.assignment.robotsimulation.actions.MovementStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class MovementStrategyFactory {
    private final Map<String, MovementStrategy> movementStrategyMap;
    public MovementStrategyFactory(List<MovementStrategy> movementStrategies) {
        this.movementStrategyMap = movementStrategies.stream()
                .collect(Collectors.toMap(MovementStrategy::getActionName, Function.identity()));
    }
    public MovementStrategy getStrategy(String command) {
        return movementStrategyMap.get(command);
    }
}