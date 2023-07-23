package com.assignment.robotsimulation.service;

import com.assignment.robotsimulation.domain.response.SimulationResponse;

public interface SimulationService {
    SimulationResponse simulateObject(String simulationRound);
}
